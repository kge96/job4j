package ru.job4j.crudservlet;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 * Class for connecting to database.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 31.10.2017.
 */
public class UsersDBConnector {
    /**
     * URL.
     */
    private static final String URL = "jdbc:postgresql://localhost:5432/users";
    /**
     * User name for db.
     */
    private static final String USER_NAME = "postgres";
    /**
     * Password for db.
     */
    private static final String PASSWORD = "qazar";
    /**
     * Connection.
     */
    private Connection cn;
    /**
     * Statement.
     */
    private Statement st;
    /**
     * Prepared statement.
     */
    private PreparedStatement pst;
    /**
     * Result set.
     */
    private ResultSet rs;

    /**
     * UserDBConnector constructor.
     */
    public UsersDBConnector() {
        initStorage();
    }

    /**
     * Default constructor.
     */
    public void initStorage() {
        try {
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            st = cn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS personal_data(name VARCHAR(100),login VARCHAR(100)primary key not null, email VARCHAR(100),created bigint)");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add new item to data base.
     * @param user - user.
     */
    public void add(User user) {
        try {
            pst = cn.prepareStatement("INSERT INTO personal_data(name, login, email, created) values(?, ?, ?, ?)");
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getEmail());
            pst.setLong(4, user.getCreated());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete item from data base.
     * @param login - user login.
     */
    public void delete(String login) {
        try {
            pst = cn.prepareStatement("DELETE FROM personal_data where login = ?");
            pst.setString(1, login);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update item into data base.
     * @param user - user.
     */
    public void update(User user) {
        try {
            pst = cn.prepareStatement("UPDATE personal_data SET name = ?, login = ?, email = ?, created = ? where login = ?");
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getEmail());
            pst.setLong(4, user.getCreated());
            pst.setString(5, user.getLogin());
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Find all items by specified param.
     * @param login - searching param.
     * @return ArrayList.
     */
    public User getUser(String login) {
        User result = null;
        try {
            pst = cn.prepareStatement("SELECT * FROM personal_data WHERE login  = ?");
            pst.setString(1, login);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String userLogin = rs.getString("login");
                String email = rs.getString("email");
                long created = rs.getLong("created");
                result = new User(name, userLogin, email, created);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Close all connections.
     */
    public void closeConnections() {
        if (cn != null) {
            try {
                cn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (pst != null) {
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Delete all items from table.
     */
    public void clearTable() {
        try {
            st.execute("delete from personal_data");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }
}
