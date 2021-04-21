package com.example.photography_shop.service.impl;

import com.example.photography_shop.entity.Basket;
import com.example.photography_shop.entity.Product;
import com.example.photography_shop.repository.BasketRepository;
import com.example.photography_shop.repository.ProductRepository;
import com.example.photography_shop.repository.UserRepository;
import com.example.photography_shop.service.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class BasketServiceImpl implements BasketService {

    private final BasketRepository basketRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Autowired
    public BasketServiceImpl(BasketRepository basketRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.basketRepository = basketRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public List<Basket> getUserBasket() {
//        String name = SecurityContextHolder.getContext().getAuthentication().getName();
//        return basketRepository.getBasketByUserName(name);
        return null;
    }

//    @Override
//    public List<Product> getProductBasket() {
//        return basketRepository.get;
//    }

    @Override
    public Basket addToBasket(Product product) {
//        String login = SecurityContextHolder.getContext().getAuthentication().getName();
//        return userRepository.findByLogin(login)
//                .map(user -> productRepository.findById(String.valueOf(product.getId()))
//                        .map(productDb -> {
//                            Optional<Basket> optionalBasket
//                                    = basketRepository.findByProductIdAndUserId(productDb.getId(), user.getId());
//
//                            if (optionalBasket.isPresent()) {
//                                return updateQuantityProduct(optionalBasket.get());
//                            }
//                            Basket basket = new Basket();
//                            basket.setProduct(productDb);
//                            basket.setUser(user);
//
//                            return basketRepository.save(basket);
//                        }).orElseThrow(() -> new EntityNotFoundException("Product doesn't exit"))
//                ).orElseThrow(() -> new EntityNotFoundException("User doesn't exist"));
return null;
    }

    @Override
    public void deleteProductFromBasket(Long id) {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
//        basketRepository.deleteByUserLoginAndProductId(login, id);
    }

    @Override
    public void deleteUserBasket() {
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
      //  basketRepository.deleteByUserLogin(login);
    }

    private Basket updateQuantityProduct(Basket basket) {
        return basketRepository.save(basket);

    }
}
