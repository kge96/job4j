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
    public static synchronized UserStorage getInstance() {
       if (instanse == null) {
           instanse = new UserStorage();
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

            st.execute("CREATE TABLE IF NOT EXISTS countries(id serial primary key not null, country VARCHAR (100))");
            st.execute("CREATE OR REPLACE RULE countries AS  ON INSERT TO  countries WHERE EXISTS (SELECT 1 FROM countries WHERE id = NEW.id ) DO INSTEAD NOTHING;");
            st.execute("INSERT INTO countries(id, country) VALUES (1, 'Russia')");
            st.execute("INSERT INTO countries(id, country) VALUES (2, 'England')");
            st.execute("INSERT INTO countries(id, country) VALUES (3, 'France')");
            st.execute("INSERT INTO countries(id, country) VALUES (4, 'Germany')");
            st.execute("INSERT INTO countries(id, country) VALUES (5, 'USA')");

            st.execute("CREATE TABLE IF NOT EXISTS cities(id serial primary key not null, country_id INTEGER REFERENCES countries(id), city VARCHAR (100))");
            st.execute("CREATE OR REPLACE RULE cities AS  ON INSERT TO  cities WHERE EXISTS (SELECT 1 FROM cities WHERE id = NEW.id ) DO INSTEAD NOTHING;");
            st.execute("INSERT INTO cities(id, country_id, city) VALUES (1, 1, 'Moscow')");
            st.execute("INSERT INTO cities(id, country_id, city) VALUES (2, 1, 'Saratov')");
            st.execute("INSERT INTO cities(id, country_id, city) VALUES (3, 1, 'Irkutsk')");


            st.execute("CREATE TABLE IF NOT EXISTS personal_data(name VARCHAR(100),"
                    + "login VARCHAR(100)PRIMARY KEY NOT NULL , "
                    + "password VARCHAR(100), "
                    + "email VARCHAR(100), "
                    + "role_id INTEGER REFERENCES users_roles(id), "
                    + "country_id INTEGER REFERENCES countries(id),"
                    + "city_id INTEGER REFERENCES cities(id),"
                    + "created bigint)");

            st.execute("CREATE OR REPLACE RULE personal_data AS  ON INSERT TO  personal_data WHERE EXISTS (SELECT 1 FROM personal_data WHERE login = NEW.login ) DO INSTEAD NOTHING;");
            st.execute("INSERT INTO personal_data(name, login, password, email, role_id, country_id, city_id) VALUES ('admin', 'root', 'root', 'root@root.ru', 1, 1, 1)");

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
            int roleId = getRoleId(user);
            int countryId = getCountryId(user.getCountry());
            int cityId = getCityId(user.getCity());
            String userLogin = user.getLogin();

            pst = cn.prepareStatement("INSERT INTO personal_data(name, login, password, email, created) VALUES(?, ?, ?, ?, ?)");
            pst.setString(1, user.getName());
            pst.setString(2, user.getLogin());
            pst.setString(3, user.getPassword());
            pst.setString(4, user.getEmail());
            pst.setLong(5, user.getCreated());
            pst.executeUpdate();

            pst = cn.prepareStatement("UPDATE personal_data SET role_id = ? WHERE login = ?");
            pst.setInt(1, roleId);
            pst.setString(2, userLogin);
            pst.executeUpdate();

            pst = cn.prepareStatement("UPDATE personal_data SET city_id = ?, country_id = ? WHERE login = ?");
            pst.setInt(1, cityId);
            pst.setInt(2, countryId);
            pst.setString(3, user.getLogin());
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
            int cityId = getCityId(user.getCity());
            int countryId = getCountryId(user.getCountry());

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


            pst = cn.prepareStatement("UPDATE personal_data SET city_id = ?, country_id = ? WHERE login = ?");
            pst.setInt(1, cityId);
            pst.setInt(2, countryId);
            pst.setString(3, user.getLogin());
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
            pst = cn.prepareStatement(
                    "SELECT pd.name, pd.login, pd.password, pd.email, cy.city, co.country, pd.created, ur.role_name "
                            + "FROM  personal_data AS pd "
                            + "LEFT OUTER JOIN users_roles AS ur ON pd.role_id = ur.id "
                            + "LEFT OUTER JOIN cities AS cy on pd.city_id = cy.id "
                            + "LEFT OUTER JOIN countries AS co on pd.country_id = co.id WHERE pd.login = ?");

            pst.setString(1, login);
            rs = pst.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String userLogin = rs.getString("login");
                String email = rs.getString("email");
                String role = rs.getString("role_name");
                long created = rs.getLong("created");
                String city = rs.getString("city");
                String country = rs.getString("country");
                result = new User(name, userLogin, null, email, city, country, role, created);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
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
            pst = cn.prepareStatement("SELECT id FROM users_roles WHERE role_name  = ?");
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
     * Return country id.
     * @param country - country.
     * @return int.
     */
    private int getCountryId(String country) {
        int result = 0;
        try {
            pst = cn.prepareStatement("SELECT id FROM countries WHERE country = ?");
            pst.setString(1, country);
            rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Return city id.
     * @param city - city.
     * @return int.
     */
    private int getCityId(String city) {
        int result = 0;
        try {
            pst = cn.prepareStatement("SELECT id FROM cities WHERE city = ?");
            pst.setString(1, city);
            rs = pst.executeQuery();
            while (rs.next()) {
                result = rs.getInt("id");
            }

        } catch (SQLException e) {
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
            pst = cn.prepareStatement("SELECT pd.name, pd.login, pd.password, pd.email, cy.city, co.country, pd.created, ur.role_name"
                            + " FROM  personal_data AS pd"
                            + " LEFT OUTER JOIN users_roles AS ur ON pd.role_id = ur.id"
                            + " LEFT OUTER JOIN cities AS cy ON pd.city_id = cy.id"
                            + " LEFT OUTER JOIN countries AS co On pd.country_id = co.id");
            rs = pst.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String userLogin = rs.getString("login");
                String password = rs.getString("password");
                String email = rs.getString("email");
                long created = rs.getLong("created");
                String role = rs.getString("role_name");
                String city = rs.getString("city");
                String country = rs.getString("country");
                result.add(new User(name, userLogin, password, email, city, country, role, created));
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
     * Get all cities for specified country.
     * @param country - country from which need find cities.
     * @return ArrayList.
     */
    public ArrayList<String> getAllCities(String country) {
        ArrayList<String> results = new ArrayList<>();
        int countryId = getCountryId(country);
        try {
            pst = cn.prepareStatement("SELECT city FROM cities WHERE country_id = ?");
            pst.setInt(1, countryId);
            rs = pst.executeQuery();

            while (rs.next()) {
                results.add(rs.getString("city"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    /**
     * Return all countries.
     * @return ArrayList.
     */
    public ArrayList<String> getAllCountries() {
        ArrayList<String> results = new ArrayList<>();
        try {
            pst = cn.prepareStatement("SELECT country FROM countries");
            rs = pst.executeQuery();

            while (rs.next()) {
                results.add(rs.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
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
