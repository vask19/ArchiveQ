package com.pl.vkorol.document.controller;

import com.pl.endpoint.entity.Response;
import com.pl.vkorol.document.mapper.ArchiveDescriptorMapper;
import com.pl.vkorol.document.mapper.DescriptorMapper;
import com.pl.vkorol.document.model.ArchiveDescriptor;
import com.pl.vkorol.document.model.request.ArchiveDescriptorDto;
import com.pl.vkorol.document.service.DescriptorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/descriptor/archive")
@RequiredArgsConstructor
public class DescriptorController {

    private final DescriptorService descriptorService;
    private final DescriptorMapper descriptorMapper;
    private final ArchiveDescriptorMapper archiveDescriptorMapper;

    @PostMapping
    public ResponseEntity<?> createArchiveDescriptor(@RequestBody ArchiveDescriptorDto archiveDescriptorDto) {
        try {
            ArchiveDescriptor archiveDescriptor = archiveDescriptorMapper.archiveDescriptorDtoToArchiveDescriptor(archiveDescriptorDto);
            descriptorService.createArchiveDescriptor(archiveDescriptor);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(new Response("Object already exist"));
        }
        return ResponseEntity.ok(new Response("Operation end Success"));
    }
}
