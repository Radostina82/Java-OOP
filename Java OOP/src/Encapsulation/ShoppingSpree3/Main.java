package Encapsulation.ShoppingSpree3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String [] arrPerson = input.split(";");
        LinkedHashMap<String, Person> personList = new LinkedHashMap<>();
        for (String person : arrPerson) {
            String name = person.split("=")[0];
            double money = Double.parseDouble(person.split("=")[1]);
            try {
                Person person1 = new Person(name, money);
                personList.put(name, person1);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                return;
            }
        }
        input = scanner.nextLine();
        String [] arrProduct = input.split(";");
        HashMap<String, Product> productList = new HashMap<>();
        for (String product : arrProduct) {
            String name = product.split("=")[0];
            double cost = Double.parseDouble(product.split("=")[1]);
            try {
                Product product1 = new Product(name, cost);
                productList.put(name, product1);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
                return;
            }
        }
        input = scanner.nextLine();
        while (!input.equals("END")){
            String personName = input.split("\\s+")[0];
            String productName = input.split("\\s+")[1];
            Person person = personList.get(personName);
            Product product = productList.get(productName);
            try {
                person.buyProduct(product);
                System.out.println(personName + " bought " + productName);
            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Person> entry : personList.entrySet()) {
            System.out.println(entry.getValue().getName());

        }
    }
}
