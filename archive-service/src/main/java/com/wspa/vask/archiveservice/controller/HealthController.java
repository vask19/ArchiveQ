package com.wspa.vask.archiveservice.controller;

import com.wspa.vask.archiveservice.document.model.DescriptorImpl;
import com.wspa.vask.archiveservice.document.model.Document;
import com.wspa.vask.archiveservice.document.model.DocumentImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HealthController {

    @GetMapping("isAlive")
    public ResponseEntity<String> isAlive() {
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/documents")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<DocumentImpl>> getDocuments() {
        return ResponseEntity.ok(List.of(new DocumentImpl("UUID123",
                List.of(new DescriptorImpl("desc1", ""), new DescriptorImpl("desc2", "")))));
    }
}
