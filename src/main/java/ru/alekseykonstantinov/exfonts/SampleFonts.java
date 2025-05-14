package ru.alekseykonstantinov.exfonts;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SampleFonts extends Frame {
    int next = 0;
    Font f;
    String msg;

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
    public SampleFonts() throws HeadlessException {
        f = new Font("Dialog", Font.PLAIN, 14);
        msg = "Dialog";
        setFont(f);

        addMouseListener(new MyMouseAdapter(this));

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
        g.drawString(msg, 10, 60);
    }

    public static void main(String[] args) {
        SampleFonts appwin = new SampleFonts();
        appwin.setSize(new Dimension(200, 100));
        appwin.setTitle("Samplefonts");
        appwin.setVisible(true);
    }
}
