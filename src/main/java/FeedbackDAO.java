import java.sql.*;

public class FeedbackDAO {

    private Connection conn;
    private Statement stmt;
    private PreparedStatement prstmt;
    private String SQL;

    public void create_feedbacks_table() {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            stmt = conn.createStatement();

            SQL = "CREATE TABLE IF NOT EXISTS feedbacks (id INT PRIMARY KEY AUTO_INCREMENT, rating INT, company_id INT, " +
                    "user_id INT, FOREIGN KEY (company_id) REFERENCES companies(id), FOREIGN KEY (user_id) REFERENCES users(id)";
            stmt.execute(SQL);
            System.out.println("Lentelė FEEDBACKS sukurta sėkmingai...");

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

    public void create_feedback(int rating, int company_id, int user_id) {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            SQL = "INSERT INTO feedbacks (rating, company_id, user_id) VALUES (?,?,?)";
            prstmt = conn.prepareStatement(SQL);
            prstmt.setInt(1, rating);
            prstmt.setInt(2, company_id);
            prstmt.setInt(3, user_id);


            prstmt.execute();
            System.out.println("Atsiliepimas įkeltas");

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
    public void delete_feedback(int feedback_id) {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            SQL = "DELETE FROM feedbacks WHERE id = ?";
            prstmt = conn.prepareStatement(SQL);
            prstmt.setInt(1, feedback_id);


            prstmt.execute();
            System.out.println("Komentaras ištrintas");

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
