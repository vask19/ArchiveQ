package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.ArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArchiveDescriptorRepository extends JpaRepository<ArchiveDescriptor, String> {

    Optional<ArchiveDescriptor> findByName(String name);
}
