package net.javaguides.ems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import net.javaguides.ems.repository.ProductRepository;
import net.javaguides.ems.entity.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/all")
    public List<Product> getAllProducts() {
        Product product = productRepository.findByName("cot");
        System.out.println(product.toString());
        List<Product> product2 = productRepository.findByNameOrDescription("cot", "cot");
        product2.forEach((p) -> System.out.println(p.toString()));
        List<Product> product3 = productRepository.findByNameAndDescription("cot", "cot");
        product3.forEach((p) -> System.out.println(p.toString()));
        List<Product> product4 = productRepository.findByNameContaining("co");
        product4.forEach((p) -> System.out.println(p.toString()));
        List<Product> product5 = productRepository.findByNameLike("%Ta%");
        product5.forEach((p) -> System.out.println(p.toString()));
        LocalDateTime startDate = LocalDateTime.of(2024,07,13,17,48,33);
        LocalDateTime endDate = LocalDateTime.of(2021,02,13,18,15,21);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });

        // Sorting practice
        String sortBy = "name";
        String sortByDesc = "description";
        String sortDir = "desc";

        Sort sortByName = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortBy).ascending(): Sort.by(sortBy).descending();
        Sort sortByDescription = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?
                Sort.by(sortByDesc).ascending(): Sort.by(sortByDesc).descending();
        Sort groupBySort = sortByName.and(sortByDescription);

        List<Product> productlists = productRepository.findAll(groupBySort);
        System.out.println("sorted list of products");
        productlists.forEach((p) ->{
            System.out.println(p);
        });
        return productRepository.findAll();
    }
}
