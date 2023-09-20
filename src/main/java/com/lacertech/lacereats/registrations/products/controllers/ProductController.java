package com.lacertech.lacereats.registrations.products.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacertech.lacereats.dto.productDTO.ProductDTO;
import com.lacertech.lacereats.registrations.products.services.ProductService;

@RestController
@RequestMapping(path = "/registrations/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<ProductDTO> searchAll(){
        return productService.searchAll();
    }

    @PostMapping
    public void register(@RequestBody ProductDTO product) {
        productService.create(product);
        return;
    }

    @GetMapping("/{id}")
    public ProductDTO searchById(@PathVariable Integer id) {
        return productService.searchById(id);
    }

    @PutMapping
    public void update(@RequestBody ProductDTO product) {
        productService.update(product);
        return;
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        productService.delete(id);
        return;
    }
}
