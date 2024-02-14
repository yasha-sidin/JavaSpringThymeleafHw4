package ru.overthantutor.JavaSpringThymeleafSemi4Task3.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.overthantutor.JavaSpringThymeleafSemi4Task3.domain.Product;
import ru.overthantutor.JavaSpringThymeleafSemi4Task3.service.ProductService;

import java.util.List;
import java.util.Optional;

/**
 * Spring product controller
 */
@Controller
@AllArgsConstructor
public class ProductController {
    private ProductService productService;

    /**
     * Forming main panel with info about products and adding button
     * @param model html model
     * @return product-list.html
     */
    @GetMapping("/products")
    public String getProducts(Model model) {
        Optional<List<Product>> products = productService.getAllProducts();
        if (products.isPresent()) {
            if (products.get().isEmpty()) {
                model.addAttribute("products", null);
            } else {
                model.addAttribute("products", products.get());
            }
        } else {
            model.addAttribute("products", null);
        }
        return "product-list";
    }

    /**
     * Adding product
     * @param product product
     * @return        redirect:/products
     */
    @PostMapping("products")
    public String addProduct(Product product) {
        productService.addProduct(product);
        return "redirect:/products";
    }
}
