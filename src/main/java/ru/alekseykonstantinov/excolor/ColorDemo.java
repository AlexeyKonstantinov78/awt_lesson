package ru.alekseykonstantinov.excolor;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ColorDemo extends Frame {
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
    public ColorDemo() {
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
        Color c1 = new Color(255, 100, 100);
        Color c2 = new Color(100, 255, 100);
        Color cЗ = new Color(100, 100, 255);
        g.setColor(c1);
        g.drawLine(20, 40, 100, 100);
        g.drawLine(20, 100, 100, 20);
        g.setColor(c2);
        g.drawLine(40, 45, 250, 180);
        g.drawLine(75, 90, 400, 400);
        g.setColor(cЗ);
        g.drawLine(20, 150, 400, 40);
        g.drawLine(25, 290, 80, 19);
        g.setColor(Color.red);
        g.drawOval(20, 40, 50, 50);
        g.fillOval(70, 90, 140, 100);
        g.setColor(Color.blue);
        g.drawOval(90, 40, 90, 60);
        g.drawRect(40, 40, 55, 50);
        g.setColor(Color.cyan);
        g.fillRect(100, 40, 60, 70);
        g.drawRoundRect(190, 40, 60, 60, 15, 15);
    }

    public static void main(String[] args) {
        ColorDemo colorDemo = new ColorDemo();
        colorDemo.setSize(new Dimension(340, 260));
        colorDemo.setTitle("ColorDemo");
        colorDemo.setVisible(true);
    }
}
