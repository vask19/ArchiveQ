package com.pl.vkorol.document.service;

import com.pl.vkorol.document.model.SearchDocumentInstanceQuery;
import com.pl.vkorol.document.model.entity.ArchiveDescriptor;
import com.pl.vkorol.document.model.entity.ArchiveDocument;
import com.pl.vkorol.document.model.entity.DocumentInstance;
import com.pl.vkorol.document.repository.ArchiveDescriptorRepository;
import com.pl.vkorol.document.repository.ArchiveDocumentRepository;
import com.pl.vkorol.document.repository.CustomDocumentRepository;
import com.pl.vkorol.document.repository.DescriptorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class DocumentServiceImpl implements DocumentService {

    private final ArchiveDocumentRepository archiveDocumentRepository;
    private final ArchiveDescriptorRepository archiveDescriptorRepository;
    private final DescriptorRepository descriptorRepository;
    private final CustomDocumentRepository documentRepository;

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

    @Override
    public List<DocumentInstance> searchDocumentInstanceByQuery(SearchDocumentInstanceQuery query) {
        List<DocumentInstance> documentInstances = documentRepository.findByDescriptorsAndArchiveDocumentName(query);
        log.info("Documents found: {}", documentInstances.size());
        return documentInstances;
    }

    @Override
    public Optional<DocumentInstance> getDocumentById(String documentUuid) {
        return documentRepository.findById(documentUuid);
    }
}
