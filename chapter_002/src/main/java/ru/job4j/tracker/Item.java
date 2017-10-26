package ru.job4j.tracker;

import java.util.Random;

/**
 * Class for create item of application.
 * @author gkuznetsov.
 * @since 19.09.17.
 * @version 0.1.
 */

public class Item {
    /**
     * application id.
     */
    private String id;
    /**
     * application name.
     */
    private String name;
    /**
     * application description.
     */
    private String desc;
    /**
     * application create date.
     */
    private long created;
    /**
     * application comments.
     */
    private String[] comments;

    /**
     * Random number.
     */
    private static final Random RN = new Random();

    /**
     * Constructor.
     * @param name - application name.
     * @param desc - application description.
     * @param comments - comments.
     */
    public Item(String name, String desc, String[] comments) {
        this.name = name;
        this.desc = desc;
        this.comments = comments;
        this.created = System.currentTimeMillis();
        this.id = String.valueOf(this.generateId());
    }

    /**
     * Constructor.
     * @param id - id.
     * @param name - name.
     * @param desc - desc.
     * @param comments - comments.
     * @param created - created date.
     */
    public Item(String id, String name, String desc, String[] comments, long created) {
        this(name, desc, comments);
        this.created = created;
        this.id = id;
    }
    /**
     * This method set description.
     * @param id - application id.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method set description.
     * @param desc - application description.
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * This method add comments to application.
     * @param comments - comments.
     */
    public void setComments(String[] comments) {
        this.comments = comments;
    }

    /**
     * This method set new task name.
     * @param name - name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * THis method return application id.
     * @return String.
     */
    public String getId() {
        return this.id;
    }

    /**
     * This method return application name.
     * @return String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * This method return application description.
     * @return String.
     */
    public String getDesc() {
        return this.desc;
    }

    /**
     * This method return application create time ms.
     * @return long.
     */
    public long getCreated() {
        return this.created;
    }

    /**
     * This method return application comments.
     * @return String[].
     */
    public String getComments() {
        StringBuilder sb = new StringBuilder();
        for (String comment : this.comments) {
            sb.append(comment);
            sb.append('\n');
        }
        return sb.toString();
    }
    /**
     * Generate ID for item.
     * @return String.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
