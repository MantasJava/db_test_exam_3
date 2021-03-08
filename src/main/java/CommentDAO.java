import java.sql.*;

public class CommentDAO {


    private Connection conn;
    private Statement stmt;
    private PreparedStatement prstmt;
    private String SQL;

    public void create_comments_table() {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            stmt = conn.createStatement();

            SQL = "CREATE TABLE IF NOT EXISTS comments (id INT PRIMARY KEY AUTO_INCREMENT, feedback_id INT, user_id INT, " +
                    "comment TEXT, FOREIGN KEY (feedback_id) REFERENCES feedbacks(id)," +
                    " FOREIGN KEY (user_id) REFERENCES users(id)";
            stmt.execute(SQL);
            System.out.println("Lentelė COMMENTS sukurta sėkmingai...");

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

    public void create_comment(int feedback_id, int user_id, String comment) {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            SQL = "INSERT INTO comments (feedback_id, user_id, comment) VALUES (?,?,?)";
            prstmt = conn.prepareStatement(SQL);
            prstmt.setInt(1, feedback_id);
            prstmt.setInt(2, user_id);
            prstmt.setString(3, comment);


            prstmt.execute();
            System.out.println("Komentaras parašytas");

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
    public void edit_comment(int comment_id, String comment_text) {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            SQL = "UPDATE comments SET comment = ? WHERE id = ?";
            prstmt = conn.prepareStatement(SQL);
            prstmt.setString(1, comment_text);
            prstmt.setInt(2, comment_id);


            prstmt.execute();
            System.out.println("Komentaras redaguotas");

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
    public void delete_comment(int comment_id) {
        try {
            conn = DriverManager.getConnection(Constants.URL, Constants.login, Constants.passwd);
            SQL = "DELETE FROM comments WHERE id = ?";
            prstmt = conn.prepareStatement(SQL);
            prstmt.setInt(1, comment_id);


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
