package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.layout_dispatchers;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridВaqLayoutDemo extends Frame implements ItemListener {
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
    public GridВaqLayoutDemo() throws HeadlessException {
        // Использовать Gr idBagLayout .
        GridBagLayout gbag = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(gbag);

        // определить флажки
        windows = new Checkbox("Windows", true);
        android = new Checkbox("Android");
        linux = new Checkbox("Linux");
        mac = new Checkbox("Mac");

        // Определить гибкую сеточную компоновку.
        // Использовать стандартный вес строки , равный О, для первой строки .
        gbc.weightx = 1.0; // вес колонки , равный l
        gbc.ipadx = 200; // заполнение на 200 единиц
        gbc.insets = new Insets(0, 6, 0, 0); // вставка немного слева
        gbc.anchor = GridBagConstraints.NORTHEAST;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(windows, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(android, gbc);

        // Назначить второй строке вес, равный 1
        gbc.weighty = 1.0;
        gbc.gridwidth = GridBagConstraints.RELATIVE;
        gbag.setConstraints(linux, gbc);
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbag.setConstraints(mac, gbc);

        // Добавить компоненты.
        add(windows);
        add(android);
        add(linux);
        add(mac);

        // Зарегистрировать прослушиватели для получения событий элементов.
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
        msg = "Current state: ";
// Текущее состояние
        g.drawString(msg, 20, 100);
        msg = " Windows : " + windows.getState();
        g.drawString(msg, 30, 120);
        msg = "Android: " + android.getState();
        g.drawString(msg, 30, 140);
        msg = "Linux: " + linux.getState();
        g.drawString(msg, 30, 160);
        msg = "Маc OS : " + mac.getState();
        g.drawString(msg, 30, 180);
    }

    public static void main(String[] args) {
        GridВaqLayoutDemo appwin = new GridВaqLayoutDemo();
        appwin.setSize(new Dimension(250, 200));
        appwin.setTitle("GridВaqLayoutDemo");
        appwin.setVisible(true);
    }
}
