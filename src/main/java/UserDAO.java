import java.sql.*;

public class UserDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement prstmt;
    private String SQL;

    public void create_users_table() {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            stmt = conn.createStatement();

            SQL = "CREATE TABLE IF NOT EXISTS companies (id INT PRIMARY KEY AUTO_INCREMENT, login TEXT, password TEXT, " +
                    "email TEXT, company_id INT, FOREIGN KEY (company_id) REFERENCES companies(id)";
            stmt.execute(SQL);
            System.out.println("Lentelė USERS sukurta sėkmingai...");

            stmt.close();
            conn.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    public void create_user(String login, String password, String email, int company_id) {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            SQL = "INSERT INTO users (login, password, email, company_id) VALUES (?,?,?,?)";
            prstmt = conn.prepareStatement(SQL);
            prstmt.setString(1, login);
            prstmt.setString(2, password);
            prstmt.setString(3, email);
            prstmt.setInt(4, company_id);

            prstmt.execute();
            System.out.println("Skelbimas įkeltas");

            stmt.close();
            conn.close();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

}
