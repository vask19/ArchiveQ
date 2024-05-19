package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.entity.Descriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PostgresDescriptorRepository implements DescriptorRepository {

    @Autowired
    private DescriptorBaseRepository descriptorBaseRepository;

    public Descriptor getDescriptorById(String uuid) {
        return descriptorBaseRepository.getReferenceById(uuid);
    }


    public Descriptor createDescriptor(Descriptor descriptor) {
        return descriptorBaseRepository.save(descriptor);
    }

    @Override
    public List<Descriptor> getDescriptors() {
        return descriptorBaseRepository.findAll();
    }

}
