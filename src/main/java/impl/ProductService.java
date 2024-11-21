package impl;



import model.Product;

import java.util.List;


public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Long id, Product productDetails);
    Product getProductById(Long id);
    List<Product> getAllProducts();
    void deleteProduct(Long id);
}












