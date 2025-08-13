package com.Group3tatastrive.VetPawtner.Controller;

import com.Group3tatastrive.VetPawtner.Entity.Order;
import com.Group3tatastrive.VetPawtner.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("demo/orders")
public class OrderContrller {
    @Autowired
    private OrderService orderService;
    @GetMapping("Fetching")
    public ResponseEntity<List<Order>> getalldetails(){
        return ResponseEntity.ok(orderService.getalldetails());

    }
    @PostMapping
    public ResponseEntity<Order> insertalldetails(@RequestBody Order order){
        return ResponseEntity.ok(orderService.insertallorders(order));
    }
    @PutMapping("{id}")
    public ResponseEntity<Order> updatealldetails(@PathVariable Integer orderid,@RequestBody Order order){
        return ResponseEntity.ok(orderService.Updatealldetails(orderid,order));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Order> deletealldetails(@PathVariable Integer orderid){
        return ResponseEntity.ok(orderService.deletealldetails(orderid));
    }
}
