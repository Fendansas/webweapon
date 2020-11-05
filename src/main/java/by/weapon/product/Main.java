package by.weapon.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        select();

    }
    private static String url = "jdbc:postgresql://localhost:5432/productdb";
    private static String username = "postgres";
    private static String password = "070809";

    public static ArrayList<Product> select() {

        ArrayList<Product> products = new ArrayList<Product>();
        try {
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM public.products");
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    int price = resultSet.getInt(3);
                    int idcalibre = resultSet.getInt(4);

                    Product product = new Product(id, name, price,idcalibre);
                    products.add(product);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return products;
    }
}
