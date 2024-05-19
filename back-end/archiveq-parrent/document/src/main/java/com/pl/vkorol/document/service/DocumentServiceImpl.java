package com.pl.vkorol.document.service;

import com.pl.vkorol.document.model.entity.ArchiveDescriptor;
import com.pl.vkorol.document.model.entity.ArchiveDocument;
import com.pl.vkorol.document.model.entity.DocumentInstance;
import com.pl.vkorol.document.repository.ArchiveDescriptorRepository;
import com.pl.vkorol.document.repository.ArchiveDocumentRepository;
import com.pl.vkorol.document.repository.DescriptorRepository;
import com.pl.vkorol.document.repository.DocumentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {

    private final ArchiveDocumentRepository archiveDocumentRepository;
    private final ArchiveDescriptorRepository archiveDescriptorRepository;
    private final DescriptorRepository descriptorRepository;
    private final DocumentRepository documentRepository;


    @Override
    public void createArchiveDocument(ArchiveDocument archiveDocument) {
        archiveDocumentRepository.findByDocumentName(archiveDocument.getDocumentName())
                .ifPresent(doc -> {
                    throw new RuntimeException("Archive doc already exists.");
                });
        List<ArchiveDescriptor> descriptors = new ArrayList<>();
        archiveDocument.getDescriptors()
                        .stream().map(ArchiveDescriptor::getName)
                .toList()
                .forEach(name -> {
                    archiveDescriptorRepository.findByName(name)
                            .ifPresent(descriptors::add);
                });
        archiveDocument.setDescriptors(descriptors);
        archiveDocumentRepository.save(archiveDocument);
    }

    @Override
    public List<ArchiveDocument> getAllDocuments() {
        return archiveDocumentRepository.findAll();
    }

    @Override
    public List<ArchiveDocument> getAllDocuments(int page, int pageSize) {
        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);

        Page<ArchiveDocument> archiveDocumentPage = archiveDocumentRepository.findAll(pageRequest);
        return archiveDocumentPage.getContent();
    }

    @Override
    public ArchiveDocument getDocumentByName(String name) {
        return archiveDocumentRepository.findByDocumentName(name)
                .orElseThrow(RuntimeException::new);
    }

    @Override
    @Transactional
    public void createDocument(DocumentInstance documentInstance) {
        documentRepository.save(documentInstance);

        documentInstance.getDescriptors()
                                .forEach(descriptorRepository::createDescriptor);
    }
}
