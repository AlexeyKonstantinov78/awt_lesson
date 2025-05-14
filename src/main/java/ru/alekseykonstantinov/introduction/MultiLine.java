package ru.alekseykonstantinov.introduction;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MultiLine extends Frame {
    int curX = 20, curY = 40; // текущая позиция

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
    public MultiLine() throws HeadlessException {
        Font f = new Font("SanSerif", Font.PLAIN, 12);
        setFont(f);

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
        FontMetrics fm = g.getFontMetrics();

        nextLine("This is оп line one. ", g);
        nextLine("This is оп line two. ", g);
        sameLine(" This is оп same line. ", g);
        sameLine(" This, too . ", g);
        nextLine("This is on line three . ", g);
        curX = 20;
        curY = 40; //сбрасывать координаты при кажд:::,м перерисовывании
    }

    // Advance to next line .
    void nextLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        curY += fm.getHeight(); // перейти на следующу� строку
        curX = 20;
        g.drawString(s, curX, curY);
        curX += fm.stringWidth(s); // перейти в конец строки
    }
// От:::,бразить в той же строке

    void sameLine(String s, Graphics g) {
        FontMetrics fm = g.getFontMetrics();
        g.drawString(s, curX, curY);
        curX += fm.stringWidth(s);
    }

    public static void main(String[] args) {
        MultiLine appwin = new MultiLine();
        appwin.setSize(new Dimension(300, 120));
        appwin.setTitle("MultiLine");
        appwin.setVisible(true);
        ;
    }
}
