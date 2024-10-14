package ie.atu.week4.jpa;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

    public List<Product> add(Product product) {
        productRepository.save(product);

        return productRepository.findAll();
    }

    public Product delete(Long id) {
        Product existingProduct = findProductById(id);
        productRepository.deleteById(existingProduct.getId());
        return existingProduct;
    }

    public Product update(Long id, Product product) {
        Product existingProduct = findProductById(id);

        existingProduct.setProductName(product.getProductName());
        existingProduct.setProductDescription(product.getProductDescription());
        existingProduct.setProductPrice(product.getProductPrice());
        return productRepository.save(existingProduct);
    }

    private Product findProductById(Long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find product."));
    }
}
