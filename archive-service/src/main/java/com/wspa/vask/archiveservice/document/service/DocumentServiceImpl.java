package com.wspa.vask.archiveservice.document.service;

import com.wspa.vask.archiveservice.document.model.DescriptorImpl;
import com.wspa.vask.archiveservice.document.model.DocumentImpl;
import com.wspa.vask.archiveservice.document.model.request.CreateDescriptorRequest;
import com.wspa.vask.archiveservice.document.model.response.DescriptorDto;
import com.wspa.vask.archiveservice.document.model.response.GetDescriptorsResponse;
import com.wspa.vask.archiveservice.document.repository.DescriptorRepository;
import com.wspa.vask.archiveservice.kafka.DocumentMessage;
import com.wspa.vask.archiveservice.mapper.DocumentMapper;
import com.wspa.vask.archiveservice.document.model.Document;
import com.wspa.vask.archiveservice.document.repository.DocumentRepository;
import com.wspa.vask.archiveservice.storage.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DocumentServiceImpl implements DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private DescriptorRepository descriptorRepository;
    @Autowired
    private FileStorageService fileStorageService;
    @Autowired
    private DocumentMapper documentMapper;

    @Override
    public void addDocument(DocumentMessage documentMessage) {
        DocumentImpl document = documentMapper.documentMessageToDocument(documentMessage);
        try {
            documentRepository.addDocument(document.getDescriptors());
            fileStorageService.writeFiles(document.getFileRepresentation());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addNewDescriptor(DescriptorDto descriptorDto) {
        descriptorRepository.createDescriptor(new DescriptorImpl(descriptorDto.name(), descriptorDto.value()));
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
