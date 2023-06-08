import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductDB {
    
    private static Connection getConnection() throws SQLException {
        String dbUrl = "jdbc:sqlite:products.sqlite";
        Connection connection = DriverManager.getConnection(dbUrl);
        return connection;
    }
    
    public static ArrayList<Product> getAll() {
        String sql = "SELECT ProductCode, Description, Price "
                   + "FROM Products ORDER BY ProductCode ASC";
        var products = new ArrayList<Product>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String code = rs.getString("ProductCode");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");

                Product p = new Product(code, description, price);
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public static Product get(String code) {
        String sql = "SELECT ProductCode, Description, Price "
                   + "FROM Products "
                   + "WHERE ProductCode = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, code);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");
                Product p = new Product(code, description, price);
                rs.close();
                return p;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        }
    }

    public static boolean add(Product p) {
        String sql = "INSERT INTO Products (ProductCode, Description, Price) "
                   + "VALUES (?, ?, ?)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getCode());
            ps.setString(2, p.getDescription());
            ps.setDouble(3, p.getPrice());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public static boolean delete(Product p) {
        String sql = "DELETE FROM Products "
                   + "WHERE ProductCode = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getCode());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }

    public static boolean update(Product p) {
        String sql = "UPDATE Products SET "
                   + "  Description = ?, "
                   + "  Price = ? "
                   + "WHERE ProductCode = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, p.getDescription());
            ps.setDouble(2, p.getPrice());
            ps.setString(3, p.getCode());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e);
            return false;
        }
    }
}