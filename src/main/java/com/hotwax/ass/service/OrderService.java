package com.hotwax.ass.service;

import com.hotwax.ass.dto.CreateOrderRequestDTO;
import com.hotwax.ass.dto.OrderItemRequestDTO;
import com.hotwax.ass.dto.OrderResponseDTO;
import com.hotwax.ass.dto.UpdateOrderItemDTO;
import com.hotwax.ass.mapper.OrderMapper;
import com.hotwax.ass.model.Customer;
import com.hotwax.ass.model.OrderHeader;
import com.hotwax.ass.model.OrderItem;
import com.hotwax.ass.repository.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderHeaderRepository orderRepo;
    private final OrderItemRepository itemRepo;
    private final CustomerRepository customerRepo;
    private final ContactMechRepository contactRepo;
    private final ProductRepository productRepo;

    // CREATE ORDER
    public Integer createOrder(CreateOrderRequestDTO dto) {

        Customer customer = customerRepo.findById(dto.customerId())
                .orElseThrow();

        OrderHeader order = new OrderHeader();
        order.setOrderDate(dto.orderDate());
        order.setCustomer(customer);
        order.setShippingContact(contactRepo.findById(dto.shippingContactMechId()).orElseThrow());
        order.setBillingContact(contactRepo.findById(dto.billingContactMechId()).orElseThrow());

        List<OrderItem> items = dto.orderItems().stream().map(i -> {
            OrderItem item = new OrderItem();
            item.setOrder(order);
            item.setProduct(productRepo.findById(i.productId()).orElseThrow());
            item.setQuantity(i.quantity());
            item.setStatus(i.status());
            return item;
        }).toList();

        order.setItems(items);
        return orderRepo.save(order).getOrderId();
    }

    // GET ORDER
    public OrderResponseDTO getOrder(Integer id) {
        return OrderMapper.toDto(
                orderRepo.findById(id).orElseThrow()
        );
    }

    // UPDATE ORDER
    public void updateOrder(Integer id, Integer shippingId, Integer billingId) {
        OrderHeader order = orderRepo.findById(id).orElseThrow();
        order.setShippingContact(contactRepo.findById(shippingId).orElseThrow());
        order.setBillingContact(contactRepo.findById(billingId).orElseThrow());
    }

    // DELETE ORDER
    public void deleteOrder(Integer id) {
        orderRepo.deleteById(id);
    }

    // ADD ITEM
    public void addItem(Integer orderId, OrderItemRequestDTO dto) {
        OrderHeader order = orderRepo.findById(orderId).orElseThrow();
        OrderItem item = new OrderItem();
        item.setOrder(order);
        item.setProduct(productRepo.findById(dto.productId()).orElseThrow());
        item.setQuantity(dto.quantity());
        item.setStatus(dto.status());
        itemRepo.save(item);
    }

    // UPDATE ITEM
    public void updateItem(Integer itemId, UpdateOrderItemDTO dto) {
        OrderItem item = itemRepo.findById(itemId).orElseThrow();
        if (dto.quantity() != null) item.setQuantity(dto.quantity());
        if (dto.status() != null) item.setStatus(dto.status());
    }

    // DELETE ITEM
    public void deleteItem(Integer itemId) {
        itemRepo.deleteById(itemId);
    }
}
