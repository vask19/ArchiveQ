package com.pl.vkorol.document.repository;

import com.pl.vkorol.document.model.entity.Descriptor;

import java.util.List;

public interface DescriptorRepository {

    public Descriptor getDescriptorById(String uuid);

    public Descriptor createDescriptor(Descriptor descriptor);

    public List<Descriptor> getDescriptors();

}
