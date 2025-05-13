package ru.alekseykonstantinov.exdemo;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExDemo extends Frame {
    String msg = "Hello world";

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
    public ExDemo() {
        addWindowListener(new WindowAdapter() {
            /**
             * Invoked when a window has been closed.
             *
             * @param e
             */
            /**
             * Invoked when a window is in the process of being closed.
             * The close operation can be overridden at this point.
             *
             * @param e
             */
            @Override
            public void windowClosing(WindowEvent e) {
                setVisible(false);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
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
        g.drawString(msg, 20, 80);
    }

    public static void main(String[] args) {
        ExDemo ed = new ExDemo();
        ed.setSize(new Dimension(200, 200));

        ed.setTitle("Demo AWT");
        ed.setBackground(Color.darkGray);
        ed.setForeground(Color.WHITE);
        ed.setVisible(true);
    }
}
