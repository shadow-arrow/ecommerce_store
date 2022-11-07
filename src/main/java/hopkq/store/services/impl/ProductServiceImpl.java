package hopkq.store.services.impl;


import hopkq.store.entities.Product;
import hopkq.store.repositories.ProductRepository;
import hopkq.store.utils.Common;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements hopkq.store.services.ProductService {

    @Autowired
    ProductRepository productRepositor;


    @Override
    public List<Product> getAllProduct() {
        List<Product> listProduct = new ArrayList<>();
        try {
            listProduct = productRepositor.findAllByStatusIn(new String[]{Common.Status.STATUS_PRODUCT_AVAILABLE, Common.Status.STATUS_PRODUCT_SALE});

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listProduct;
    }

    @Override
    public List<Product> getProductByCategoryID(int id) {
        List<Product> listProduct = new ArrayList<>();
        try {
            listProduct = productRepositor.getProductByCategoryId(id);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return listProduct;
    }
}
