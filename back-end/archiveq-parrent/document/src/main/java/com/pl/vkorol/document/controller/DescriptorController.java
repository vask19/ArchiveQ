package com.pl.vkorol.document.controller;

import com.pl.endpoint.entity.Response;
import com.pl.vkorol.document.mapper.ArchiveDescriptorMapper;
import com.pl.vkorol.document.model.entity.ArchiveDescriptor;
import com.pl.vkorol.document.model.payload.request.ArchiveDescriptorDto;
import com.pl.vkorol.document.service.DescriptorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/descriptor/archive")
@RequiredArgsConstructor
public class DescriptorController {

    private final DescriptorService descriptorService;
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

    @GetMapping
    public ResponseEntity<List<ArchiveDescriptorDto>> getDescriptors() {
        descriptorService.getAllArchiveDescriptors();
        List<ArchiveDescriptorDto> dtos = descriptorService.getAllArchiveDescriptors()
                .stream()
                .map(archiveDescriptorMapper::archiveDescriptorToArchiveDescriptorDto).toList();
        return ResponseEntity.ok(dtos);

    }
}
