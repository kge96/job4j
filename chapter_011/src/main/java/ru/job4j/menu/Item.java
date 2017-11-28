package ru.job4j.menu;

import ru.job4j.menu.interfaces.Actionable;
import ru.job4j.menu.interfaces.ChildGettable;
import ru.job4j.menu.interfaces.ChildSettable;
import ru.job4j.menu.interfaces.ItemManager;
import ru.job4j.menu.interfaces.NameGettable;

import java.util.LinkedList;
import java.util.List;

/**
 * Class for creation element of menu.
 *
 * @author gkuznetsov.
 * @version 0.1.
 * @since 28.11.2017.
 */
public class Item implements ItemManager, Actionable, ChildSettable, ChildGettable, NameGettable {
    /**
     * Item name.
     */
    private String name;
    /**
     * Item child.
     */
    private List<ItemManager> child = new LinkedList<>();

    @Override
    public void action() {
        System.out.println("Some action");
    }

    @Override
    public List<? extends ItemManager> getChild() {
        return this.child;
    }

    @Override
    public void setChild(ItemManager item) {
        this.child.add(item);
    }

    @Override
    public void setChild(ItemManager item, int position) {
        this.child.set(position, item);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
