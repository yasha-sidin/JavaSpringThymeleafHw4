package ru.overthantutor.JavaSpringThymeleafSemi4Task3.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.overthantutor.JavaSpringThymeleafSemi4Task3.domain.Product;
import ru.overthantutor.JavaSpringThymeleafSemi4Task3.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * Spring product service which control all products
 */
@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;

    /**
     * Adding product
     * @param product product
     * @return        true or false in dependence of insertion result
     */
    public boolean addProduct(Product product) {
        return productRepository.insertData(product);
    }

    /**
     * Getting product by id
     * @param id product id
     * @return   Optional product
     */
    public Optional<Product> getProductById(long id) {
        return productRepository.readData(id, Product.class);
    }

    /**
     * Getting all products
     * @return Optional list of products
     */
    public Optional<List<Product>> getAllProducts() {
        return productRepository.readAllData(Product.class);
    }
}
