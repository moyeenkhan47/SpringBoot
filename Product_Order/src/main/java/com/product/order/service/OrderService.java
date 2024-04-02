package com.product.order.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.product.order.dto.OrderLineItemsDto;
import com.product.order.dto.OrderRequest;
import com.product.order.model.Order;
import com.product.order.model.OrderLineItems;
import com.product.order.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;
    
    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        if (orderRequest.getOrderLineItemsDtoList() == null) {
        	return ;
        }
        else {
        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
            .stream()
            .map(this::mapToEntity) // Using method reference
            .collect(Collectors.toList());
        
        order.setOrderLineItemsList(orderLineItems);
        
        // call inventory service and place order if product present in stock
       Boolean result = webClient.get().uri("http://localhost:8084/api/inventory").
        retrieve().bodyToMono(Boolean.class).block();
       if(result) {
        orderRepository.save(order);
        }
       else {
		throw new IllegalArgumentException("produc not in stock please try again later");
       }
        }
	
    }

    private OrderLineItems mapToEntity(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
        
}
