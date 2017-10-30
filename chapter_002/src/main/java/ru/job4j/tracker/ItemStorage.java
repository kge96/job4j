package ru.job4j.tracker;


import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 * Class for creating item storage.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 25.10.2017.
 */
public class ItemStorage {
    /**
     * URL addres for connecting to data base.
     */
    private String url = "jdbc:postgresql://localhost:5432/tracker_db";
    /**
     * User name.
     */
    private String username = "postgres";
    /**
     * Password.
     */
    private String password = "qazar";
    /**
     * Connector.
     */
    private Connection conn = null;
    /**
     * Statement.
     */
    private Statement st = null;
    /**
     * PreparedStatement.
     */
    private PreparedStatement ps = null;
    /**
     * ResultSet.
     */
    private ResultSet rs = null;

    /**
     * Default constructor.
     */
    public ItemStorage() {
        initStorage();
    }

    /**
     * Constructor with another param.
     * @param url - url.
     * @param username - username.
     * @param password - password.
     */
    public ItemStorage(String url, String username, String password) {
        initStorage();
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Initialization. If table does not exist, this code create table into db.
     */
    public void initStorage() {
        try {
            conn = DriverManager.getConnection(url, username, password);
            st = conn.createStatement();
            st.execute("CREATE TABLE IF NOT EXISTS tracker("
                    + "id serial primary key not null, "
                    + "tracker_id VARCHAR(100), "
                    + "name VARCHAR(100),"
                    + "description VARCHAR(100),"
                    + "created bigint,"
                    + "comments VARCHAR(100))"
            );

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Add new item to data base.
     * @param item - item.
     */
    public void add(Item item) {
        try {
            ps = conn.prepareStatement("INSERT INTO tracker(tracker_id, name, description, created, comments) values(?, ?, ?, ?, ?)");
            ps.setString(1, item.getId());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDesc());
            ps.setLong(4, item.getCreated());
            ps.setString(5, item.getComments());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete item from data base.
     * @param item - item.
     */
    public void delete(Item item) {
        try {
            conn = DriverManager.getConnection(url, username, password);
            ps = conn.prepareStatement("DELETE FROM tracker where tracker_id = ?");
            ps.setString(1, item.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Update item into data base.
     * @param item - item.
     */
    public void update(Item item) {
        try {
            ps = conn.prepareStatement("UPDATE tracker SET name = ?, description = ?, created = ?, comments = ? where tracker_id = ?");

            ps.setString(1, item.getName());
            ps.setString(2, item.getDesc());
            ps.setLong(3, item.getCreated());
            ps.setString(4, item.getComments());
            ps.setString(5, item.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Find all items.
     * @return ArrayList.
     */
    public ArrayList<Item> findAll() {
        ArrayList<Item> result = new ArrayList<>();
        try {
            rs = st.executeQuery("SELECT  * FROM tracker");
            getResults(rs, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Find all items by specified param.
     * @param param - searching param.
     * @return ArrayList.
     */
    private ArrayList<Item> findByParam(String param) {
        ArrayList<Item> result = new ArrayList<>();
        try {
            ps = conn.prepareStatement("SELECT  * FROM tracker WHERE NAME  = ? OR tracker_id = ?");
            ps.setString(1, param);
            ps.setString(2, param);
            rs = ps.executeQuery();
            getResults(rs, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Find items by name.
     * @param tackerName - items name.
     * @return ArrayList.
     */
    public ArrayList<Item> findByName(String tackerName) {
        return findByParam(tackerName);
    }

    /**
     * Find item by Id.
     * @param tackerName - item id;
     * @return Item.
     */
    public Item findByID(String tackerName) {
        ArrayList<Item> collection = findByParam(tackerName);
        Item result = null;
        if (collection.size() != 0) {
            result = collection.get(0);
        }
        return result;
    }

    /**
     * Delete all items from table.
     */
    public void clearTable() {
        try {
            st.execute("delete from tracker");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Close all connections if they running.
     */
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
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
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Get data from data base, create Item and add it in specified result collection.
     * @param rs - ResultSet.
     * @param result - result collection.
     */
    private void getResults(ResultSet rs, ArrayList<Item> result) {
        try {
            while (rs.next()) {
                String trackerId = rs.getString("tracker_id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                String[] comments = rs.getString("comments").split(";");
                long created = rs.getLong("created");
                Item item = new Item(trackerId, name, desc, comments, created);
                result.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
