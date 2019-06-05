package com.codegym;

import java.util.ArrayList;

public interface ProductManager<E> {

    ArrayList<E> listProduct();
    int addproduct(Product product);
    boolean updateProduct(Product product);
    boolean removeProduct(int id);
    Product findProduct(int id);
    void sortPriceAscending();
    void sortPriceDecrease();
}
