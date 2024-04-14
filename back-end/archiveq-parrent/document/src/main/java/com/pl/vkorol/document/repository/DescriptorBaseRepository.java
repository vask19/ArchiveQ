package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.DescriptorImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptorBaseRepository extends JpaRepository<DescriptorImpl, String> {


}
