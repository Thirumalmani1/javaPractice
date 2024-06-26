package net.javaguides.ems.repository;

import net.javaguides.ems.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Returns the found product entry by using its name as search
     * criteria. If no product entry is found, this method
     * returns null.
     */
    public Product findByName(String name);

    /**
     * Returns the found list of product entries whose name or description is given
     * as a method parameters. If no product entries is found, this method
     * returns an empty list.
     */
    List<Product> findByNameOrDescription(String name, String description);

    /**
     * Returns the found list of product entries whose name and description is given
     * as a method parameters. If no product entries is found, this method
     * returns an empty list.
     */
    List<Product> findByNameAndDescription(String name, String description);

    /**
     * Return the distinct product entry whose name is given as a method parameter
     *  If no product entry is found, this method returns null.
     */
    Product findDistinctByName(String name);

    /**
     * Return the filtered the product records that match the given text
     */
    List<Product> findByNameContaining(String name);

    /**
     * Return products based on SQL like condition
     */
    List<Product> findByNameLike(String name);

    /**
     * Returns a products whose price between start price and end price
     */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /**
     * Returns a products whose dateCreated between start date and end date
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

}
