package com.Group3tatastrive.VetPawtner.Controller;

import com.Group3tatastrive.VetPawtner.Entity.Product;
import com.Group3tatastrive.VetPawtner.Repository.ProductRepository;
import com.Group3tatastrive.VetPawtner.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("demo/product")
// Spring Boot example
@CrossOrigin(origins = "http://127.0.0.1:5500")

public class ProductController {
   /* @Autowired
    ProductRepository productRepository;
    @GetMapping
    public List<Product> GetAllData(){
        return productRepository.findAll();
    }

    @PostMapping
    public Product insertdata(@RequestBody Product product){
        return productRepository.save(product);
    }

    @GetMapping("{id}")
    public Product GetAllByData(@PathVariable Long id){
        return productRepository.findById(id).orElse(null);
    }

    @PutMapping("{id}")
    public Product updatedata(@PathVariable Long id, @RequestBody Product product){
        Product product1 = productRepository.findById(id).orElse(null);
        product1.setName(product.getName());
        product1.setDescription(product.getDescription());
        product1.setPrice(product.getPrice());
        product1.setStock(product.getStock());
        product1.setCategory(product.getCategory());
        product1.setImage_url(product.getImage_url());
        return productRepository.save(product1);
    }

    @DeleteMapping("{id}")
    public Product deletedata(@PathVariable Long id){
        Product product2=productRepository.findById(id).orElse(null);
        if (product2!=null){
            productRepository.delete(product2);
        }
        return product2;
    }*/

    @Autowired
    ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAllData(){
        return ResponseEntity.ok(productService.getAllData());
    }

    @PostMapping
    public ResponseEntity<Product> insertdata(@RequestBody Product product){
        return ResponseEntity.ok(productService.insertdata(product));
    }

    @PutMapping("{id}")
    public ResponseEntity<Product> updatedata(@PathVariable Long id,@RequestBody Product product){
        return ResponseEntity.ok(productService.updatedata(id,product));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Product> deletedata(@PathVariable Long id){
        return ResponseEntity.ok(productService.deletedata(id));
    }

}
