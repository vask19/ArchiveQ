package com.wspa.vask.archiveservice.document.repository;

import com.wspa.vask.archiveservice.document.model.DescriptorImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DescriptorBaseRepository extends JpaRepository<DescriptorImpl, String> {


}
