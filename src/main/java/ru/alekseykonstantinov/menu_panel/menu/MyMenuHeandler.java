package ru.alekseykonstantinov.menu_panel.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyMenuHeandler implements ActionListener, ItemListener {
    private MenuDemo menuDemo;

    public MyMenuHeandler(MenuDemo menuDemo) {
        this.menuDemo = menuDemo;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        menuDemo.msg = "You selected "; // Выбран пункт меню
        String arg = e.getActionCommand();

        if (arg.equals("New.")) menuDemo.msg += "New.";
        else if (arg.equals("Open.")) menuDemo.msg += "Open.";
        else if (arg.equals("Close")) menuDemo.msg += "Close.";
        else if (arg.equals("Edit")) menuDemo.msg += "Edit. ";
        else if (arg.equals("Cut")) menuDemo.msg += "Cut.";
        else if (arg.equals("Copy")) menuDemo.msg += "Сору. ";
        else if (arg.equals("Paste")) menuDemo.msg += "Paste.";
        else if (arg.equals("First")) menuDemo.msg += "First.";
        else if (arg.equals("Second")) menuDemo.msg += "Second.";
        else if (arg.equals("Third")) menuDemo.msg += "Third.";
        else if (arg.equals("Debug")) menuDemo.msg += "Debug.";
        else if (arg.equals("Test")) menuDemo.msg += "Test.";
        System.out.println(arg);
        menuDemo.repaint();
    }

    /**
     * Invoked when an item has been selected or deselected by the user.
     * The code written for this method performs the operations
     * that need to occur when an item is selected (or deselected).
     *
     * @param e the event to be processed
     */
    @Override
    public void itemStateChanged(ItemEvent e) {
        System.out.println(e.getItem());
        menuDemo.repaint();
    }
}
