package com.wspa.vask.archiveservice.controller;

import com.wspa.vask.archiveservice.document.model.DescriptorImpl;
import com.wspa.vask.archiveservice.document.model.request.CreateDescriptorRequest;
import com.wspa.vask.archiveservice.document.model.response.DescriptorDto;
import com.wspa.vask.archiveservice.document.model.response.GetDescriptorsResponse;
import com.wspa.vask.archiveservice.document.service.DocumentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController()
public class DocumentController {

    @Autowired
    private DocumentServiceImpl documentService;

    @PostMapping("/descriptors")
    public ResponseEntity<Void> addNewDescriptor(@RequestBody DescriptorDto descriptorDto) {
        System.out.println(descriptorDto);
        documentService.addNewDescriptor(descriptorDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/descriptors")
    public ResponseEntity<List<DescriptorDto>> getDescriptors() {
        System.out.println("ok");
        return ResponseEntity.ok(documentService.getDescriptors());
    }
}
