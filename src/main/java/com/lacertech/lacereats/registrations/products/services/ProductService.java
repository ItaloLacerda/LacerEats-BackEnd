package com.lacertech.lacereats.registrations.products.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lacertech.lacereats.database.model.ProductModel;
import com.lacertech.lacereats.database.repository.ProductGroupRepository;
import com.lacertech.lacereats.database.repository.ProductRepository;
import com.lacertech.lacereats.dto.productDTO.ProductDTO;

@Service
public class ProductService {
    
    @Autowired
    private ProductRepository productRepository ;

    @Autowired
    private ProductGroupRepository productGroupRepository;

    public void create(ProductDTO productDTO) {

        if(productGroupRepository.existsById(productDTO.productGroup().getId())) {
            ProductModel productData = new ProductModel(
                productDTO.description(),
                productDTO.barCode(),
                productDTO.costPrice(),
                productDTO.salePrice(),
                productDTO.productGroup(),
                productDTO.status()
            );
            productRepository.save(productData);
        } else {
            System.out.println("Aprenda a fazer exeção");
        }
        return;
    }

    public List<ProductDTO> searchAll() {
        List<ProductModel> listProducts = productRepository.findAll();
        return listProducts.stream()
                               .map(ProductDTO::new)
                               .collect(Collectors.toList());
    }

    public ProductDTO searchById(Integer id) {
        
        return new ProductDTO(productRepository.findById(id).get());
    }

    public void update(ProductDTO product) {
        ProductModel productData = new ProductModel(
            product.id(),
            product.description(),
            product.ncm(),
            product.barCode(),
            product.costPrice(),
            product.salePrice(),
            product.productGroup(),
            product.status());
        productRepository.save(productData);
        return;
    }

    public void delete(Integer id) {
        productRepository.deleteById(id);
        return;
    }
}