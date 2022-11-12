package hopkq.store.services.impl;

import hopkq.store.entities.Product;
import hopkq.store.models.ProductModel;
import hopkq.store.models.ShoppingCart;
import hopkq.store.repositories.ProductRepository;
import hopkq.store.services.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ShoppingCart AddProductToCart(int id, ShoppingCart cart) {
        List<ProductModel> listProductModel = new ArrayList<>();
        Product product = productRepository.getProductById(id);
        ProductModel productModel = modelMapper.map(product, ProductModel.class);
        productModel.setQuantity(1);
        listProductModel.add(productModel);
        cart.setListProduct(listProductModel);

        return cart;
    }
}
