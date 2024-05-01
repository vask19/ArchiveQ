package com.pl.vkorol.document.controller;

import com.pl.endpoint.entity.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/archive")
@RequiredArgsConstructor
public class ArchiveController {
//
//    @RequestMapping(method = RequestMethod.GET)
//    public ResponseEntity<List<CategoryDTO>> getCategory(){
//        System.out.println(1112);
//
//        return ResponseEntity.ok(List.of(new CategoryDTO("123", "123"), new CategoryDTO("123", "123"),
//                new CategoryDTO("123", "123"), new CategoryDTO("123", "123")));
//    }
//
//    @RequestMapping(method = RequestMethod.POST)
//    public ResponseEntity<?> createCategory(@RequestBody CategoryDTO categoryDTO){
//        try {
//        } catch (RuntimeException e) {
//            return ResponseEntity.status(400).body(new Response("Object exist in DB"));
//        }
//        return ResponseEntity.ok(new Response("Operation end Success"));
//    }
}
