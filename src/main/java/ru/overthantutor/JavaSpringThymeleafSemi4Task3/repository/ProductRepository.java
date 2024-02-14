package ru.overthantutor.JavaSpringThymeleafSemi4Task3.repository;

import org.springframework.stereotype.Repository;
import ru.overthantutor.JavaSpringThymeleafSemi4Task3.domain.Product;

/**
 * Spring repository which extends DatabaseRepository and keeps products
 */
@Repository
public class ProductRepository extends DatabaseRepository<Product> {
}
