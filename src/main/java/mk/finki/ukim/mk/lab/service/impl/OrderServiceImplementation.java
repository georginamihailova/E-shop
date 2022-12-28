package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;

import mk.finki.ukim.mk.lab.model.User;
import mk.finki.ukim.mk.lab.model.exceptions.UserDoesNotExistException;
import mk.finki.ukim.mk.lab.repository.jpa.OrderRepository;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.OrderService;
import mk.finki.ukim.mk.lab.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImplementation implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderServiceImplementation(OrderRepository orderRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Optional<Order> placeOrder(String balloonColor, String balloonSize, String clientName) throws UserDoesNotExistException {

        User user=this.userRepository.findByUsername(clientName).orElseThrow(()->
                new UserDoesNotExistException());


        return Optional.of(this.orderRepository.save(new Order(balloonColor,balloonSize,user)));
    }

    @Override
    public List<Order> findAll() {
        return this.orderRepository.findAll();
    }
}
