package com.pl.vkorol.document.service;

import com.pl.vkorol.document.model.entity.ArchiveDescriptor;
import com.pl.vkorol.document.model.entity.Descriptor;
import com.pl.vkorol.document.repository.ArchiveDescriptorRepository;
import com.pl.vkorol.document.repository.PostgresDescriptorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DescriptorService {

    private final ArchiveDescriptorRepository archiveDescriptorRepository;

    public void createArchiveDescriptor(ArchiveDescriptor archiveDescriptor) {
        archiveDescriptorRepository.findByName(archiveDescriptor.getName())
                .ifPresent(desc -> {
                    throw new RuntimeException("Descriptor already exists");
                });
        archiveDescriptorRepository.save(archiveDescriptor);
    }

    public ArchiveDescriptor getDescriptorByName(String name) {
        return archiveDescriptorRepository.findByName(name)
                .orElseThrow(RuntimeException::new);
    }

    public List<ArchiveDescriptor> getAllArchiveDescriptors() {
        return archiveDescriptorRepository.findAll();
    }

}
