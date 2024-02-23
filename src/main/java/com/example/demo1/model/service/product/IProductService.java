package com.example.demo1.model.service.product;


import com.example.demo1.dto.DTOProduct;
import com.example.demo1.model.Product;

import java.util.List;

public interface IProductService {
    List<DTOProduct> findAll();
    List<DTOProduct> sortByName();
    void create(Product product);
    Product findById (int id);
    void edit(Product product);
    void delete (int id);
    List<DTOProduct> findByName(String name);


}
