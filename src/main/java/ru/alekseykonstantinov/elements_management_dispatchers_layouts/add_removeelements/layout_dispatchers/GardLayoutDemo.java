package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.layout_dispatchers;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GardLayoutDemo extends Frame {
    Checkbox windows10, windows7, windows8, android, linux, mac;
    Panel osCards;
    CardLayout cardLO;
    Button win, other;

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
    public GardLayoutDemo() throws HeadlessException {
//и класс CardLayout уникален тем,
//что в нем хранится несколько разных компоновок.
        setLayout(new FlowLayout());

        win = new Button("Windows");
        other = new Button("Other");
        add(win);
        add(other);

        // Обеспечить применение в панели osCards компоновки CardLayout.
        cardLO = new CardLayout();
        osCards = new Panel();
        osCards.setLayout(cardLO);

        windows7 = new Checkbox("Windows 7", true);
        windows8 = new Checkbox("Windows В");
        windows10 = new Checkbox("Windows 1 0 ");
        android = new Checkbox("Android");
        linux = new Checkbox("Linux");
        mac = new Checkbox("Mac OS");

        // Добавить в панель флажки для операционных систем семейства Windows.
        Panel winPan = new Panel();
        winPan.add(windows7);
        winPan.add(windows8);
        winPan.add(windows10);

        // Добавить в панель флажки для других операционных систем
        Panel otherPan = new Panel();
        otherPan.add(android);
        otherPan.add(linux);
        otherPan.add(mac);

        // Добавить панели в панель колоды карт .
        osCards.add(winPan, "Windows");
        osCards.add(otherPan, "Other");

        // Добавить карты в панель главного фрейма.
        add(osCards);

        /*--------------------------------*/

        // Использовать лямбда-выражения для обработки кнопочных событий.
        win.addActionListener(ae -> cardLO.show(osCards, "Windows"));
        other.addActionListener(ae -> cardLO.show(osCards, "Other"));

        // Зарегистрировать события нажатия кнопки мыши .
        addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                cardLO.next(osCards);
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
     * {@inheritDoc}
     *
     * @param g
     * @since 1.7
     */
    @Override
    public void paint(Graphics g) {

    }

    public static void main(String[] args) {
        GardLayoutDemo appwin = new GardLayoutDemo();
        appwin.setSize(new Dimension(300, 220));
        appwin.setTitle("CardLayoutDemo");
        appwin.setVisible(true);
    }
}
