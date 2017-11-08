package ru.job4j.crudservlet;

import org.postgresql.ds.PGPoolingDataSource;
import javax.servlet.http.HttpServlet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Class for connecting to database.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 31.10.2017.
 */
public class UserStorage extends HttpServlet {
    /**
     * URL.
     */
    private static final String URL = "localhost:5432";
    /**
     * User name for db.
     */
    private static final String USER_NAME = "postgres";
    /**
     * Password for db.
     */
    private static final String PASSWORD = "qazar";
    /**
     * Database name.
     */
    private static final String DB_NAME = "users";
    /**
     * Connection pool.
     */
    private PGPoolingDataSource source;
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
     * Instance of user storage database.
     */
    private static volatile UserStorage instanse;

    /**
     * UserDBConnector constructor.
     */
    private UserStorage() {
        initStorage();
    }

    /**
     * Return instance of user storage database.
     * @return UserStorage.
     */
    public static UserStorage getInstance() {
        if (instanse == null) {
            synchronized (UserStorage.class) {
                if (instanse == null) {
                    instanse = new UserStorage();
                }
            }
        }
        return instanse;
    }

    /**
     * Default constructor.
     */
    public void initStorage() {
        try {
            source = new PGPoolingDataSource();
            source.setDataSourceName(DB_NAME);
            source.setServerName(URL);
            source.setDatabaseName(DB_NAME);
            source.setUser(USER_NAME);
            source.setPassword(PASSWORD);
            source.setMaxConnections(20);
            source.setInitialConnections(20);
            cn = source.getConnection();
            st = cn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS users_roles(id serial primary key not null, role_name VARCHAR (100))");

            st.execute("CREATE OR REPLACE RULE users_roles AS  ON INSERT TO  users_roles WHERE EXISTS (SELECT 1 FROM users_roles WHERE id = NEW.id ) DO INSTEAD NOTHING;");

            st.execute("INSERT INTO users_roles(id, role_name) VALUES (1, 'admin')");
            st.execute("INSERT INTO users_roles(id, role_name) VALUES (2, 'user')");

            st.execute("CREATE TABLE IF NOT EXISTS personal_data(name VARCHAR(100),login VARCHAR(100)primary key not null, password VARCHAR(100), email VARCHAR(100), role_id INTEGER REFERENCES users_roles(id), created bigint)");

            st.execute("CREATE OR REPLACE RULE personal_data AS  ON INSERT TO  personal_data WHERE EXISTS (SELECT 1 FROM personal_data WHERE login = NEW.login ) DO INSTEAD NOTHING;");
            st.execute("INSERT INTO personal_data(name, login, password, email, role_id) VALUES ('admin', 'root', 'root', 'root@root.ru', 1)");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Get role id from specified user.
     * @param user - user.
     * @return - int.
     */
    private int getRoleId(User user) {
        int result = 2;
        try {
            String userRole = user.getRole();
            pst = cn.prepareStatement("SELECT users_roles.id FROM users_roles WHERE role_name  = ?");
            pst.setString(1, userRole);
            rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt("id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Add new item to data base.
     * @param user - user.
     */
    public void add(User user) {
        try {
            int roleId = getRoleId(user);
            pst = cn.prepareStatement("INSERT INTO personal_data(name, login, password, email, created) VALUES(?, ?, ?, ?, ?)");
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getEmail());
            pst.setLong(5, user.getCreated());
            pst.executeUpdate();
            pst = cn.prepareStatement("UPDATE personal_data set role_id = ? WHERE login = ?");
            pst.setInt(1, roleId);
            pst.setString(2, user.getLogin());
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
     * @param oldLogin - old login.
     */
    public void update(User user, String oldLogin) {
        try {
            int roleId = getRoleId(user);
            pst = cn.prepareStatement("UPDATE personal_data SET name = ?, login = ?, password = ?, email = ?, created = ? where login = ?");
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getEmail());
            pst.setLong(5, user.getCreated());
            pst.setString(6, oldLogin);
            pst.executeUpdate();

            pst = cn.prepareStatement("UPDATE personal_data set role_id = ? WHERE login = ?");
            pst.setInt(1, roleId);
            pst.setString(2, user.getLogin());
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
            pst = cn.prepareStatement("SELECT pd.name, pd.login, pd.password, pd.email, pd.created, ur.role_name "
                    + "FROM personal_data AS pd INNER JOIN users_roles AS ur ON pd.role_id = ur.id WHERE login  = ?");
            pst.setString(1, login);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String userLogin = rs.getString("login");
                String email = rs.getString("email");
                String role = rs.getString("role_name");
                long created = rs.getLong("created");
                result = new User(name, userLogin, null, email, role, created);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Get all users from storage.
     * @return ArrayList.
     */
    public ArrayList<User> getAllUsers() {
        ArrayList<User> result = new ArrayList<>();
        try {
            pst = cn.prepareStatement("SELECT pd.name, pd.login, pd.password, pd.email, pd.created, ur.role_name "
                    + "FROM personal_data AS pd INNER JOIN users_roles AS ur ON pd.role_id = ur.id;");
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String userLogin = rs.getString("login");
                String password = rs.getString("password");
                String email = rs.getString("email");
                long created = rs.getLong("created");
                String role = rs.getString("role_name");
                result.add(new User(name, userLogin, password, email, role, created));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Return all users roles.
     * @return ArrayList.
     */
    public ArrayList<String> getAllRoles() {
        ArrayList<String> result = new ArrayList<>();
        try {
            pst = cn.prepareStatement("SELECT role_name FROM users_roles");
            rs = pst.executeQuery();
            while (rs.next()) {
                String roleName = rs.getString("role_name");
                result.add(roleName);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method for checkin user param for signin.
     * @param login - user login.
     * @param password - user password.
     * @return boolean.
     */
    public boolean isCoincided(String login, String password) {
        boolean result = false;
        ArrayList<User> users = getAllUsers();
        for (User usr : users) {
            if (usr.getLogin().equals(login) && usr.getPassword().equals(password)) {
                result = true;
                break;
            }
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
