package ie.atu.week4.jpa;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/getProducts")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getAll());
    }

    @PostMapping("/addProduct")
    public ResponseEntity<List<Product>> addProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.add(product));
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        return ResponseEntity.ok(productService.delete(id));
    }
}
