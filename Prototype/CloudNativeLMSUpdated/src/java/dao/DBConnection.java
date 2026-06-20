package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    // Railway akan memberikan nilai-nilai ini secara automatik
    private static final String HOST = System.getenv("MYSQLHOST");
    private static final String PORT = System.getenv("MYSQLPORT");
    private static final String DB   = System.getenv("MYSQLDATABASE");
    private static final String USER = System.getenv("MYSQLUSER");
    private static final String PASS = System.getenv("MYSQLPASSWORD");

    public static Connection getConnection() {
        Connection con = null;
        try {
            // Membina URL sambungan secara dinamik menggunakan data dari Railway
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB;
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, USER, PASS);
        } catch (Exception e) {
            System.err.println("Gagal sambung ke database Railway: " + e.getMessage());
            e.printStackTrace();
        }
        return con;
    }
}
