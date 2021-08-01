package com.kymdan.backend.services.product;

import com.kymdan.backend.entity.Cart;
import com.kymdan.backend.entity.CartDetail;
import com.kymdan.backend.entity.Product;
import com.kymdan.backend.model.MessageDTO;
import com.kymdan.backend.repository.AppAccountRepository;
import com.kymdan.backend.repository.CartDetailRepository;
import com.kymdan.backend.repository.CartRepository;
import com.kymdan.backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AppAccountRepository appAccountRepository;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Override
    public List<Product> findProductByType(Long typeID) {
        List<Product> result = new ArrayList<>();
        List<Product> allProduct = this.productRepository.findAll();

        for (Product product : allProduct) {
            if (product.getProductType().getId().equals(typeID)) {
                result.add(product);
            }
        }

        return result;
    }

    @Override
    public MessageDTO saveCart(String userName, Long productID, String productInformation) {
        MessageDTO messageDTO = new MessageDTO();
        String[] information = productInformation.split(",");

        Cart cart = this.cartRepository.findByAppAccount_Username(userName);
        if (cart == null) {
            cart = new Cart();
            cart.setAppAccount(this.appAccountRepository.findByUsername(userName));
            this.cartRepository.save(cart);
        }

        CartDetail cartDetail = new CartDetail();
        cartDetail.setAmount(information[0]);
        cartDetail.setRealPrice(information[1]);
        cartDetail.setProduct(this.productRepository.findById(productID).orElse(null));
        cartDetail.setCart(this.cartRepository.findByAppAccount_Username(userName));
        this.cartDetailRepository.save(cartDetail);

        messageDTO.setMessage("Lưu giỏ hàng thành công !");

        return messageDTO;
    }
}
