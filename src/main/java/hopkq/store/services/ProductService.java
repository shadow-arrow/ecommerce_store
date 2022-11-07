package hopkq.store.services;

import hopkq.store.entities.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    List<Product> getProductByCategoryID(int id);


}
