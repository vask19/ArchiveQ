package com.pl.vkorol.document.repository;



import com.pl.vkorol.document.model.DescriptorImpl;

import java.util.List;

public interface DescriptorRepository {

    public DescriptorImpl getDescriptorById(String uuid);

    public DescriptorImpl createDescriptor(DescriptorImpl descriptor);

    public List<DescriptorImpl> getDescriptors();

}
