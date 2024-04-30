package com.pl.vkorol.document.controller;


import com.pl.vkorol.document.model.entity.ProductFormDTO;
import com.pl.vkorol.document.model.entity.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/product")
@RequiredArgsConstructor
public class DocumentController {


    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> get(@RequestParam(required = false) String name_like,
                                 @RequestParam(required = false) String data,
                                 @RequestParam(required = false) String _category,
                                 @RequestParam(required = false) Float price_min,
                                 @RequestParam(required = false) Float price_max,
                                 @RequestParam(required = false,defaultValue = "1") int _page,
                                 @RequestParam(required = false,defaultValue = "10") int _limit,
                                 @RequestParam(required = false,defaultValue = "price") String _sort,
                                 @RequestParam(required = false,defaultValue = "asc") String _order){
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Response> save(@RequestBody ProductFormDTO productFormDTO){
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Response> delete(@RequestParam String uuid){
        return null;
    }

    @RequestMapping(value = "getExternal",method = RequestMethod.GET)
    public ResponseEntity<?> getProduct(@RequestParam String uuid){
        return null;
    }

}
