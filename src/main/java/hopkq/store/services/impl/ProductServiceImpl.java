package hopkq.store.services.impl;


import hopkq.store.entities.Product;
import hopkq.store.models.ProductModel;
import hopkq.store.repositories.ProductRepository;
import hopkq.store.services.ProductService;
import hopkq.store.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;


    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAllByStatusIn(new String[]{Common.Status.STATUS_PRODUCT_AVAILABLE, Common.Status.STATUS_PRODUCT_SALE});
    }

    @Override
    public List<Product> getProductsByCategoryID(int id) {
        return productRepository.getProductsByCategoryId(id);
    }

    @Override
    public List<Product> getProductsByCategoryIDAndSort(int id, boolean sort) {

        List<Product> listProduct = new ArrayList<>();
        if (id == 0) {
            listProduct = sort ? productRepository.sortAllProductByPriceAsc() : productRepository.sortAllProductByPriceDesc();
        } else {
            listProduct = sort ? productRepository.getProductsByCategoryIdAndOrderByPriceAsc(id) : productRepository.getProductsByCategoryIdAndOrderByPriceDesc(id);
        }
        return listProduct;
    }

    @Override
    public Product getProductByID(int id) {
        return productRepository.getProductById(id);
    }


}
