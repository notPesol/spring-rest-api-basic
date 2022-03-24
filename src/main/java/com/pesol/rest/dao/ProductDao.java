package com.pesol.rest.dao;

import com.pesol.rest.entity.Product;

import java.util.List;

public interface ProductDao {

    List<Product> findAll();

    Product findById(Integer id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(Integer id);
}
