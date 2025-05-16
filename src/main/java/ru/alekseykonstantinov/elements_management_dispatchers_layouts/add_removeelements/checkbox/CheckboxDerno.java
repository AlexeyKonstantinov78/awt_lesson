package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.checkbox;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CheckboxDerno extends Frame implements ItemListener {
    String msg = "";
    Checkbox windows, android, linux, mac;

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
    public CheckboxDerno() throws HeadlessException {
        setLayout(new FlowLayout());
        windows = new Checkbox("Windows ", true);
        android = new Checkbox("Android");
        linux = new Checkbox("Linux");
        mac = new Checkbox("Мае OS ");

        add(windows);
        add(android);
        add(linux);
        add(mac);
        // Добавить прослушиватели событий элементов .
        windows.addItemListener(this);
        android.addItemListener(this);
        linux.addItemListener(this);
        mac.addItemListener(this);

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
        msg = " Current state : ";
        // Текущее состояние
        g.drawString(msg, 20, 120);
        msg = " Windows : " + windows.getState();
        g.drawString(msg, 20, 140);
        msg = " Android : " + android.getState();
        g.drawString(msg, 20, 160);
        msg = " Linux : " + linux.getState();
        g.drawString(msg, 20, 180);
        msg = " Мае OS : " + mac.getState();
        g.drawString(msg, 20, 200);
    }

    public static void main(String[] args) {
        CheckboxDerno appwin = new CheckboxDerno();
        appwin.setSize(new Dimension(500, 500));
        appwin.setTitle("ExAddRemoveElements");
        appwin.setVisible(true);
    }
}
