package com.Group3tatastrive.VetPawtner.Service;

import com.Group3tatastrive.VetPawtner.Entity.Product;
import com.Group3tatastrive.VetPawtner.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllData() {
        return productRepository.findAll();
    }

    public Product insertdata(Product product) {
        return productRepository.save(product);
    }

    public Product updatedata(Long id, Product product) {
        Product product1 = productRepository.findById(id).orElse(null);
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setStock(product.getStock());
        product1.setCategory(product.getCategory());
        product1.setImage_url(product.getImage_url());
        return productRepository.save(product1);
    }

    public Product deletedata(Long id) {
        Product product2=productRepository.findById(id).orElse(null);
        if (product2!=null){
            productRepository.delete(product2);
        }
        return product2;
    }
}
