package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.button;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ButtonList extends Frame implements ActionListener {
    String msg = "";
    Button[] bList = new Button[3];

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
    public ButtonList() throws HeadlessException {
        // Использовать поточную компоновку .
        setLayout(new FlowLayout());
        // Создать несколько кнопок.
        Button yes = new Button("Yes ");
        Button no = new Button("No");
        Button maybe = new Button("Undecided");

        // Сохранить ссЫJJки на добавленные кнопки.
        bList[0] = (Button) add(yes);
        bList[1] = (Button) add(no);
        bList[2] = (Button) add(maybe);

        // Зарегистрировать прослушиватели для получения событий действий.
        for (int i = 0; i < bList.length; i++) {
            bList[i].addActionListener(this);
        }

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
     * Обработать события действий для кнопок .
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        for (int i = 0; i < bList.length; i++) {
            if (ae.getSource() == bList[i]) {
                msg = "You pressed " + bList[i].getLabel();
                // Щелчок на кнопке ...
            }
        }
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
        g.drawString(msg, 20, 100);
    }

    public static void main(String[] args) {
        ButtonList appwin = new ButtonList();
        appwin.setSize(new Dimension(500, 500));
        appwin.setTitle("ExAddRemoveElements");
        appwin.setVisible(true);
    }
}
