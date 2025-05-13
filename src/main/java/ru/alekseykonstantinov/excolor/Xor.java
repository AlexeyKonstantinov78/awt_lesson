package ru.alekseykonstantinov.excolor;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Xor extends Frame {
    int chsX = 100, chsY = 100;

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
    public Xor() {
        addMouseMotionListener(new MouseMotionAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             * @since 1.6
             */
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                chsX = x - 10;
                chsY = y - 10;
                repaint();
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
        g.setColor(Color.green);
        g.fillRect(20, 40, 60, 70);
        g.setColor(Color.blue);
        g.fillRect(110, 40, 60, 70);
        g.setColor(Color.black);
        g.fillRect(200, 40, 60, 70);
        g.setColor(Color.red);
        g.fillRect(60, 120, 160, 110);
// Объединить перекрестие с содержимым посредством
// операции исключающего ИЛИ .
        g.setXORMode(Color.black);
        g.drawLine(chsX - 10, chsY, chsX + 10, chsY);
        g.drawLine(chsX, chsY - 10, chsX, chsY + 10);
        g.setPaintMode();
    }

    public static void main(String[] args) {
        Xor appwin = new Xor();
        appwin.setSize(new Dimension(300, 260));
        appwin.setTitle("XOR Demo");
        appwin.setVisible(true);
        ;
    }
}


