package br.com.chaves.desafio.services;

import br.com.chaves.desafio.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    public ShippingService shippingService;

    public Double total(Order order) {
        Double shippingValue = shippingService.shipment(order);
        Double discount = order.getBasic() * (order.getDiscount() / 100);
        Double discountedValue = order.getBasic() - discount;

        return discountedValue + shippingValue;
    }
}
