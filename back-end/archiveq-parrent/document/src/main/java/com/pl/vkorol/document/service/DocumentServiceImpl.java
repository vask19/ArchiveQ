package com.pl.vkorol.document.service;

import com.pl.vkorol.document.model.ArchiveDescriptor;
import com.pl.vkorol.document.model.Descriptor;
import com.pl.vkorol.document.model.Document;
import com.pl.vkorol.document.model.response.DescriptorDto;
import com.pl.vkorol.document.repository.DocumentRepository;
import com.pl.vkorol.document.repository.PostgresDescriptorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private PostgresDescriptorRepository descriptorRepository;

    @Override
    public void addDocument(String documentMessage) {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<DescriptorDto> getDescriptors() {
        return descriptorRepository.getDescriptors()
                .stream()
                .map(descriptor -> new DescriptorDto(descriptor.getName(), descriptor.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public Document getDocument(String documentId) {
        return null;
    }

}
