package com.codegym;

import java.util.ArrayList;
import java.util.Collections;

public class ProductManagerImpl implements ProductManager {

    ArrayList<Product> listProduct = new ArrayList<>();

    {
        listProduct.add(new Product(1, "samsung", "dienthoai", 300, true));
        listProduct.add(new Product(2, "iphone", "dienthoai", 400, true));
        listProduct.add(new Product(3, "nokia", "dienthoai", 600, false));
    }

    @Override
    public ArrayList listProduct() {
        return listProduct;
    }

    @Override
    public int addproduct(Product product) {
        for (int i = 0; i < listProduct.size(); i++) {
            boolean duplicateName = product.getName().equals(listProduct.get(i).getName());
            boolean duplicatePrice = product.getPrice() == listProduct.get(i).getPrice();
            boolean duplicateDescription = product.getDescription().equals(listProduct.get(i).getDescription());
            boolean duplicateStatus = product.isStatus() == listProduct.get(i).isStatus();

            if (duplicateName && duplicatePrice && duplicateDescription && duplicateStatus) {
                return -1;
            }
        }

        listProduct.add(product);
        return 1;
    }

    @Override
    public boolean updateProduct(Product product) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (product.getId() == listProduct.get(i).getId()) {
                listProduct.get(i).setName(product.getName());
                listProduct.get(i).setPrice(product.getPrice());
                listProduct.get(i).setDescription(product.getDescription());
                listProduct.get(i).setStatus(product.isStatus());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean removeProduct(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id) {
                listProduct.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Product findProduct(int id) {
        for (int i = 0; i < listProduct.size(); i++) {
            if (listProduct.get(i).getId() == id) {
                return listProduct.get(i);
            }
        }
        return null;
    }

    @Override
    public void sortPriceAscending() {
        Collections.sort(listProduct, new sortAscending());
    }

    @Override
    public void sortPriceDecrease() {
        Collections.sort(listProduct, new sortDecrease());
    }
}
