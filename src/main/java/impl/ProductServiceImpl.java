package impl;



import java.util.List;

import exception.ResourceNotFoundException;
import model.Product;
import org.springframework.stereotype.Service;
import repo.ProductRepo;


@Service
public class ProductServiceImpl implements ProductService {




    private final ProductRepo productRepository;




    public ProductServiceImpl(ProductRepo productRepository) {
        this.productRepository = productRepository;
    }




    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }




    @Override
    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
        product.setName(productDetails.getName());
        product.setPrice(productDetails.getPrice());
        return productRepository.save(product);
    }




    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id));
    }




    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }




    @Override
    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}












