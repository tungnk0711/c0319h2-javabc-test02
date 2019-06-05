package com.codegym;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int choice;
        Scanner input = new Scanner(System.in);
        ProductManagerImpl productManager = new ProductManagerImpl();
        do {
            menu();
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    Product product = inputProduct();
                    int result = productManager.addproduct(product);
                    if (result == 1) {
                        System.out.println("Them moi thanh cong");
                    } else {
                        System.out.println("Da ton tai");
                    }
                    break;
                }
                case 2: {
                    Product product = inputProduct();
                    boolean result = productManager.updateProduct(product);
                    if (result) {
                        System.out.println("Sua thanh cong");
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Nhap Id:");
                    int id = input.nextInt();
                    boolean result = productManager.removeProduct(id);
                    if (result) {
                        System.out.println("Xoa thanh cong");
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;

                }
                case 4: {
                    System.out.println("Nhap Id:");
                    int id = input.nextInt();
                    Product product = productManager.findProduct(id);
                    if (product != null) {
                        System.out.println("\nId: " + product.getId() + "\nName: " + product.getName() + "\nDescription: " + product.getDescription() + "\nPrice: " + product.getPrice() + "\nStatus: " + product.isStatus());
                    } else {
                        System.out.println("Khong tim thay");
                    }
                    break;
                }
                case 5: {
                    productManager.sortPriceAscending();
                    ArrayList<Product> listProduct = productManager.listProduct();
                    if (listProduct.size() != 0) {
                        for (Product product : listProduct) {
                            System.out.println("\nId: " + product.getId() + "\nName: " + product.getName() + "\nDescription: " + product.getDescription() + "\nPrice: " + product.getPrice() + "\nStatus: " + product.isStatus());
                        }
                    } else {
                        System.out.println("Khong co san pham nao");
                    }
                    break;
                }
                case 6: {
                    productManager.sortPriceDecrease();
                    ArrayList<Product> listProduct = productManager.listProduct();
                    if (listProduct.size() != 0) {
                        for (Product product : listProduct) {
                            System.out.println("\nId: " + product.getId() + "\nName: " + product.getName() + "\nDescription: " + product.getDescription() + "\nPrice: " + product.getPrice() + "\nStatus: " + product.isStatus());
                        }
                    } else {
                        System.out.println("Khong co san pham nao");
                    }
                    break;
                }
                case 7: {
                    ArrayList<Product> listProduct = productManager.listProduct();
                    if (listProduct.size() != 0) {
                        for (Product product : listProduct) {
                            System.out.println("\nId: " + product.getId() + "\nName: " + product.getName() + "\nDescription: " + product.getDescription() + "\nPrice: " + product.getPrice() + "\nStatus: " + product.isStatus());
                        }
                    } else {
                        System.out.println("Khong co san pham nao");
                    }
                    break;
                }
            }
        } while (choice != 0);

    }

    private static void menu() {
        System.out.println("\n-Quan ly san pham-");
        System.out.println("1.Them san pham");
        System.out.println("2.Sua san pham");
        System.out.println("3.Xoa san pham");
        System.out.println("4.Tim kiem san pham");
        System.out.println("5.Sap xep tang");
        System.out.println("6.Sap xep giam");
        System.out.println("7.Hien thi san pham");
        System.out.println("0.Thoat");
        System.out.println("Nhap vao chon lua:");
    }

    private static Product inputProduct() {
        Scanner input = new Scanner(System.in);
        System.out.println("Id:");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Name:");
        String name = input.nextLine();
        System.out.println("Price:");
        float price = input.nextFloat();
        input.nextLine();
        System.out.println("Description:");
        String description = input.nextLine();
        System.out.println("Status:");
        boolean status = input.nextBoolean();

        Product product = new Product(id, name, description, price, status);

        return product;

    }
}
