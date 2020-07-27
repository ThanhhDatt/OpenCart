/*
25/7/20
 */
package opencart.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.util.Set;

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@EntityScan( basePackages = {"opencart.Model"} )
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "brandid")
    private Brand brand;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "category-product", joinColumns = @JoinColumn(name = "productId"),
            inverseJoinColumns = @JoinColumn(name = "catetogoryId"))
    private Set<Category> categories;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "wishlist-product", joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "customerid"))
    private Set<WishList> wishLists;



    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "cart-product", joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "customerid"))
    private Set<Cart> carts;



    @OneToMany(cascade = CascadeType.ALL,mappedBy = "product", fetch = FetchType.LAZY)
    private Set<OrderDetail> orderDetails;



    @Column(name = "productname")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "dateadded")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate dateAdded;

    @Column(name = "datemodified")
    @DateTimeFormat(pattern = "yyyy/mm/dd")
    private LocalDate dateModified;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "priceunit")
    private double price;

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<WishList> getWishLists() {
        return wishLists;
    }

    public void setWishLists(Set<WishList> wishLists) {
        this.wishLists = wishLists;
    }

    public Set<Cart> getCarts() {
        return carts;
    }

    public void setCarts(Set<Cart> carts) {
        this.carts = carts;
    }

    public Set<OrderDetail> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(Set<OrderDetail> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(LocalDate dateAdded) {
        this.dateAdded = dateAdded;
    }

    public LocalDate getDateModified() {
        return dateModified;
    }

    public void setDateModified(LocalDate dateModified) {
        this.dateModified = dateModified;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}