package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.Descriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DescriptorBaseRepository extends JpaRepository<Descriptor, String> {

    Optional<Descriptor> findByName(String name);


}
