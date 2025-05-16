package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.choise;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ListDemo extends Frame implements ActionListener {
    List os, browser;
    String msg = "";

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
    public ListDemo() throws HeadlessException {
        setLayout(new FlowLayout());
        os = new List(4, true);
        browser = new List(4);

        os.add("Windows");
        os.add("Android ");
        os.add("Linux");
        os.add("Mac OS");

        browser.add("Edge");
        browser.add("Firefox");
        browser.add("Chrome");

        browser.select(1);
        os.select(0);

        add(os);
        add(browser);

        //про слушатели
        os.addActionListener(this);
        browser.addActionListener(this);

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
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
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
        int[] idx;

        msg = "Current OS: ";
// Текущая операционная система
        idx = os.getSelectedIndexes();
        for (int i = 0; i < idx.length; i++)
            msg += os.getItem(idx[i]) + " ";
        g.drawString(msg, 20, 120);
        msg = "Curr ent Brows er: ";
// Текущий браузер
        msg += browser.getSelectedItem();
        g.drawString(msg, 20, 140);
    }

    public static void main(String[] args) {
        ListDemo appwin = new ListDemo();
        appwin.setSize(new Dimension(500, 500));
        appwin.setTitle("ExAddRemoveElements");
        appwin.setVisible(true);
    }
}
