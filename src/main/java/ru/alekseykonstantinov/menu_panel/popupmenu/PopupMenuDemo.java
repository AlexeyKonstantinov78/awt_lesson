package ru.alekseykonstantinov.menu_panel.popupmenu;

import java.awt.*;
import java.awt.event.*;

public class PopupMenuDemo extends Frame implements ActionListener, ItemListener {


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
    public PopupMenuDemo() throws HeadlessException {
        // Создаем PopupMenu

        PopupMenu popup = new PopupMenu("Контекстное меню");
        add(popup);

        // Создаем элементы меню
        MenuItem item1 = new MenuItem("Копировать");
        MenuItem item2 = new MenuItem("Вставить");
        MenuItem item3 = new MenuItem("Вырезать");
        CheckboxMenuItem item4 = new CheckboxMenuItem("Опция");
        MenuItem item5 = new MenuItem("Выход");

        // Добавляем элементы в меню
        popup.add(item1);
        popup.add(item2);
        popup.addSeparator(); // разделитель
        popup.add(item3);
        popup.add(item4);
        popup.add(item5);

        // Добавляем обработчики событий
        item1.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addItemListener(this);
        item5.addActionListener(e -> System.exit(0));

        // Добавляем обработчик для отображения меню по правому клику
        addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    // правая кнопка
                    popup.show(getComponentAt(e.getX(), e.getY()), e.getX(), e.getY());
                }
            }
        });

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
        System.out.println(e.getActionCommand());
        repaint();
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

    }

    public static void main(String[] args) {
        PopupMenuDemo appwin = new PopupMenuDemo();
        appwin.setSize(new Dimension(250, 300));
        appwin.setTitle("MenuDemo ");
        appwin.setVisible(true);
    }
}
