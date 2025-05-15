package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.button;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExButton extends Frame implements ActionListener {
    String msg = "";
    Button yes, no, maybe;

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
    public ExButton() {
        setLayout(new FlowLayout());

        yes = new Button("Yes");
        no = new Button("No");
        maybe = new Button("Undecided");

        // Добавить кнопки во фрейм.
        add(yes);
        add(no);
        add(maybe);

        // Добавить прослушиватели событий действий для кнопок.
        yes.addActionListener(this);
        no.addActionListener(this);
        maybe.addActionListener(this);

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

    // Обработать события действий для кнопок


    /**
     * Invoked when an action occurs.
     *
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        String comm = ae.getActionCommand();
        switch (comm) {
            case "Yes" -> msg = "You pressed Уеs.";
            case "No" -> msg = "You pressed No.";
            default -> msg = "You pressed Undecided.";
        }

        System.out.println(ae.toString());
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
        ExButton appwin = new ExButton();
        appwin.setSize(new Dimension(500, 500));
        appwin.setTitle("ExAddRemoveElements");
        appwin.setVisible(true);
    }
}
