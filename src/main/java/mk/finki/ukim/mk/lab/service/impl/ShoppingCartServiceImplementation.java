package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.ShoppingCart;
import mk.finki.ukim.mk.lab.model.exceptions.ShoppingCartNotFoundException;
import mk.finki.ukim.mk.lab.repository.jpa.ShoppingCartRepository;
import mk.finki.ukim.mk.lab.repository.jpa.UserRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import mk.finki.ukim.mk.lab.service.ShoppingCartService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImplementation implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final BalloonService balloonService;

    public ShoppingCartServiceImplementation(ShoppingCartRepository shoppingCartRepository, UserRepository userRepository, BalloonService balloonService) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.userRepository = userRepository;
        this.balloonService = balloonService;
    }

    @Override
    public List<Balloon> listAllBalloonsInShoppingCart(Long cartId) {
        if(this.shoppingCartRepository.findById(cartId).isEmpty()){
            throw new ShoppingCartNotFoundException(cartId);
        }
        return shoppingCartRepository.findById(cartId).get().getBalloons();
    }


    @Override
    public ShoppingCart addBalloonToShoppingCart(Balloon balloon,Long shoppingCardId) {
        ShoppingCart shoppingCart = this.shoppingCartRepository.findById(shoppingCardId).orElseThrow(() -> new ShoppingCartNotFoundException(shoppingCardId));

        shoppingCart.getBalloons().add(balloon);
        return this.shoppingCartRepository.save(shoppingCart);
    }
}
