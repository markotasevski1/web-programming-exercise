package mk.finki.ukim.mk.lab.service.Interfaces;

import mk.finki.ukim.mk.lab.model.Order;

public interface OrderService {
    Order placeOrder(String balloonColor, String clientName, String address);
}
