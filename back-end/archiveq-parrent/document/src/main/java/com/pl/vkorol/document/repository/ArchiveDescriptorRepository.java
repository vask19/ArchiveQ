package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.entity.ArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArchiveDescriptorRepository extends JpaRepository<ArchiveDescriptor, String> {

    Optional<ArchiveDescriptor> findByName(String name);
}
