package com.pesol.rest.controller;

import com.pesol.rest.ProductNotFoundException;
import com.pesol.rest.entity.Product;
import com.pesol.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.MessageSource;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Integer id) throws ProductNotFoundException {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product id: " + id + " not exist");
        }

        return product;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        productService.addProduct(product);
        return product;
    }

    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        Product product = productService.findById(id);
        if (product == null) {
            throw new ProductNotFoundException("Product id: " + id + " not exist");
        }

        productService.deleteProduct(id);
        return "Deleted product id: " + id;
    }
}
