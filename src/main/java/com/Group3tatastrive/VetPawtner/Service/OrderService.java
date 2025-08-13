package com.Group3tatastrive.VetPawtner.Service;

import com.Group3tatastrive.VetPawtner.Entity.Order;
import com.Group3tatastrive.VetPawtner.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getalldetails() {
        return orderRepository.findAll();
    }

    public Order insertallorders(Order order) {
        return orderRepository.save(order);
    }

    public Order Updatealldetails(Integer orderid, Order order) {
        Order order1 = orderRepository.findById(orderid).orElse(null);
        order1.setOrderId(order.getOrderId());
        order1.setUser(order.getUser());
        order1.setProduct(order.getProduct());
        order1.setQuantity(order.getQuantity());
        order1.setTotalPrice(order.getTotalPrice());
        order1.setOrderDate(order.getOrderDate());
        order1.setStatus(order.getStatus());
        return orderRepository.save(order1);
    }
    public Order deletealldetails(Integer orderid){
        Order order = orderRepository.findById(orderid).orElse(null);
        if(order!=null){
           orderRepository.delete(order);
        }
        return order;
    }
}
