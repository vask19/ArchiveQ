package com.pl.vkorol.document.service;

import com.pl.vkorol.document.model.ArchiveDescriptor;
import com.pl.vkorol.document.model.Descriptor;
import com.pl.vkorol.document.repository.ArchiveDescriptorRepository;
import com.pl.vkorol.document.repository.PostgresDescriptorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DescriptorService {

    private final ArchiveDescriptorRepository archiveDescriptorRepository;
    private final PostgresDescriptorRepository descriptorRepository;

    public void createArchiveDescriptor(ArchiveDescriptor archiveDescriptor) {
        archiveDescriptorRepository.findByName(archiveDescriptor.getName())
                .ifPresent(desc -> {
                    throw new RuntimeException("Already exts");
                });
        archiveDescriptorRepository.save(archiveDescriptor);
    }

    public void addDescriptor(Descriptor descriptor) {
        descriptorRepository.getDescriptorByName(descriptor.getName())
                .ifPresent(desc -> {
                    throw new RuntimeException("Descriptor exist in DB with this name");
                });
        descriptorRepository.createDescriptor(descriptor);

    }
}
