package by.weapon.product;



import java.sql.*;
import java.util.ArrayList;

public class productBD {
//jdbc:postgresql://hostname:port/dbname
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
                    Product product = new Product(id, name, price, idcalibre );
                    products.add(product);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return products;
    }

    public static Product selectOne(int id) {

        Product product = null;
        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "SELECT * FROM public.products WHERE id=?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    if(resultSet.next()){

                        int prodId = resultSet.getInt(1);
                        String name = resultSet.getString(2);
                        int price = resultSet.getInt(3);
                        int idcalibre = resultSet.getInt(4);
                        product = new Product(prodId, name, price,idcalibre);
                    }
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return product;
    }
    public static int insert(Product product) {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "INSERT INTO public.products (name, price, idcalibre) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setInt(2, product.getPrice());
                    preparedStatement.setInt(3, product.getIdcalibre());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
    public static int update(Product product) {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "UPDATE public.products SET name = ?, price = ? WHERE id = ?, idcalibre = ? ";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setString(1, product.getName());
                    preparedStatement.setInt(2, product.getPrice());
                    preparedStatement.setInt(3, product.getId());
                    preparedStatement.setInt(4, product.getIdcalibre());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }

    public static int delete(int id) {

        try{
            Class.forName("org.postgresql.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)){

                String sql = "DELETE FROM public.products WHERE id = ?";
                try(PreparedStatement preparedStatement = conn.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }



}


