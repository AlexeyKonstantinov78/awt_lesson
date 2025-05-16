package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.choise;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExChoise extends Frame implements ItemListener {
    String msg = "";
    Choice choice;

    /**
     * Constructs a new instance of {@code Frame} that is
     * initially invisible.  The title of the {@code Frame}
     * is empty.
     *
     * @throws HeadlessException when
     *                           {@code GraphicsEnvironment.isHeadless()} returns {@code true}
     * @see GraphicsEnvironment#isHeadless()
     * @see Component#setSize
     * @see Component#setVisible(boolean)
     */
    public ExChoise() throws HeadlessException {
        setLayout(new FlowLayout());

        choice = new Choice();
        choice.add("");
        choice.add("Windows");
        choice.add("Mac");
        choice.add("Linux");
        choice.add("Android");
        choice.select(2);
        add(choice);
        msg = choice.getSelectedItem();

        choice.addItemListener(this);

        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

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
        System.out.println(e.toString());
        System.out.println(e.getItem());
//        msg = e.getItem().toString();
        repaint();
    }

    /**
     * {@inheritDoc}
     *
     * @param g
     * @since 1.7
     */
    @Override
    public void paint(Graphics g) {
        g.drawString(getStr(choice.getSelectedItem()), 20, 100);
    }

    public String getStr(String choice) {
        return String.format("Current OS: %s", choice);
    }

    public static void main(String[] args) {
        ExChoise appwin = new ExChoise();
        appwin.setSize(new Dimension(500, 500));
        appwin.setTitle("ExAddRemoveElements");
        appwin.setVisible(true);
    }
}
