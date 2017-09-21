package ru.job4j.tracker;

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
     * Constructor.
     * @param desc - application id.
     * @param name - application name.
     */
    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
        this.created = System.currentTimeMillis();
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
    public String[] getComments() {
        return this.comments;
    }
}
