package hopkq.store.services;

import hopkq.store.entities.Product;
import hopkq.store.models.ProductModel;

import java.util.List;

public interface ProductService {

    List<Product> getAllProduct();

    List<Product> getProductsByCategoryID(int id);

    List<Product> getProductsByCategoryIDAndSort(int id, boolean sort);

    Product getProductByID(int id);


}
