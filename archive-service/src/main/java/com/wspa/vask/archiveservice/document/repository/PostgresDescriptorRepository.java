package com.wspa.vask.archiveservice.document.repository;

import com.wspa.vask.archiveservice.document.model.DescriptorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostgresDescriptorRepository implements DescriptorRepository {

    @Autowired
    private DescriptorBaseRepository descriptorBaseRepository;

    public DescriptorImpl getDescriptorById(String uuid) {
        return descriptorBaseRepository.getReferenceById(uuid);
    }

    public DescriptorImpl createDescriptor(DescriptorImpl descriptor) {
        return descriptorBaseRepository.save(descriptor);
    }

    @Override
    public List<DescriptorImpl> getDescriptors() {
        return descriptorBaseRepository.findAll();
    }

}
