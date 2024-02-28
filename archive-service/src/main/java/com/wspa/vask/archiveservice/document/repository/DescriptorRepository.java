package com.wspa.vask.archiveservice.document.repository;


import com.wspa.vask.archiveservice.document.model.DescriptorImpl;

import java.util.List;

public interface DescriptorRepository {

    public DescriptorImpl getDescriptorById(String uuid);

    public DescriptorImpl createDescriptor(DescriptorImpl descriptor);

    public List<DescriptorImpl> getDescriptors();

}
