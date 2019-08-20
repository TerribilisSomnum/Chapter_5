package by.etc.somnum;

//Создать класс Payment с внутренним классом, с помощью объектов которого можно сформировать покупку из
//нескольких товаров.

import java.util.Scanner;

class Payment {

    private String name;
    private Product[] productsArray;
    private int cost;

    private class Product {

        private String productName;
        private int productCost;

        public Product() {

            productName = "";
            productCost = 0;
        }

        public Product(String productName, int productCost) {

            this.productName = productName;
            this.productCost = productCost;
        }

        public String getProductName() { return this.productName; }

        public int getProductCost() { return this.productCost; }

        public String setProductName(String productName) { return this.productName = productName; }

        public int setProductCost(int productCost) { return this.productCost = productCost; }
    }

    public Payment() {

        this.name = "";
        this.cost = 0;
    }

    public Payment(String name) { this.name = name; }

    public void setPayment() {

        this.cost = 0;
        System.out.print("Введите количество товаров, которое Вы хотите приобрести: ");

        Scanner reader = new Scanner(System.in);
        int userInput = reader.nextInt();

        productsArray = new Product[userInput];

        for (int i = 0; i < userInput; i++) {

            System.out.println("Товар " + (i + 1) + ": ");
            System.out.print("Наименование: ");
            String nameProduct = reader.next();
            System.out.print("Цена: ");
            int costProduct = reader.nextInt();

            productsArray[i] = new Product(nameProduct, costProduct);
            this.cost += productsArray[i].productCost;
        }
    }

    public void printCheque() {

        if (this.productsArray.length != 0) {

            System.out.println("============================");
            System.out.println(" " + this.name);
            System.out.println("____________________________");

            for (int i = 0; i < this.productsArray.length; i++) {

                System.out.format("%3d", i + 1);
                System.out.format("%15s", this.productsArray[i].productName);
                System.out.format("%10d", this.productsArray[i].productCost);
                System.out.println("");
            }

            System.out.println("____________________________");
            System.out.print("Общая стоимость: ");
            System.out.format("%11d", this.cost);
            System.out.println();
            System.out.println("============================" + "\n");
        } else {
            System.out.println();
            System.out.println("Массив не создан");
        }
    }
}

public class OOP_exe_2 {

    public static void main(String[] args) {

        Payment paymentOne = new Payment("Первая покупка");
        paymentOne.setPayment();
        Payment paymentTwo = new Payment("Вторая покупка");
        paymentTwo.setPayment();
        paymentOne.printCheque();
        paymentTwo.printCheque();
    }
}
