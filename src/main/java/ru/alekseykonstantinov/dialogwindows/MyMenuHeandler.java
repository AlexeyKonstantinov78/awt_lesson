package ru.alekseykonstantinov.dialogwindows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MyMenuHeandler implements ActionListener, ItemListener {
    private DialogDemo dialogDemo;

    public MyMenuHeandler(DialogDemo dialogDemo) {
        this.dialogDemo = dialogDemo;
    }

    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        dialogDemo.msg = "You selected "; // Выбран пункт меню
        String arg = e.getActionCommand();

        if (arg.equals("New.")) {
            dialogDemo.msg += "New.";
            dialogDemo.myDialog.setVisible(true);
        } else if (arg.equals("Open.")) dialogDemo.msg += "Open.";
        else if (arg.equals("Close")) dialogDemo.msg += "Close.";
        else if (arg.equals("Edit")) dialogDemo.msg += "Edit. ";
        else if (arg.equals("Cut")) dialogDemo.msg += "Cut.";
        else if (arg.equals("Copy")) dialogDemo.msg += "Сору. ";
        else if (arg.equals("Paste")) dialogDemo.msg += "Paste.";
        else if (arg.equals("First")) dialogDemo.msg += "First.";
        else if (arg.equals("Second")) dialogDemo.msg += "Second.";
        else if (arg.equals("Third")) dialogDemo.msg += "Third.";
        else if (arg.equals("Debug")) dialogDemo.msg += "Debug.";
        else if (arg.equals("Test")) dialogDemo.msg += "Test.";
        System.out.println(arg);
        dialogDemo.repaint();
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
        dialogDemo.repaint();
    }
}
