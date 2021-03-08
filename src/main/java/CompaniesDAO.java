import java.sql.*;

public class CompaniesDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement prstmt;
    private String SQL;

    public void create_companies_table() {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            stmt = conn.createStatement();

            SQL = "CREATE TABLE IF NOT EXISTS companies (id INT PRIMARY KEY AUTO_INCREMENT, name TEXT, description TEXT)";
            stmt.execute(SQL);
            System.out.println("Lentelė COMPANIES sukurta sėkmingai...");

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

    public void create_company(String name, String description) {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            SQL = "INSERT INTO companies (name, description) VALUES (?,?)";
            prstmt = conn.prepareStatement(SQL);
            prstmt.setString(1, name);
            prstmt.setString(2, description);

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
