package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.scrollbar;

import java.awt.*;
import java.awt.event.*;

public class ScrollBarDemo extends Frame implements AdjustmentListener {
    String msg = "";
    Scrollbar vertSB, horzSB;

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
    public ScrollBarDemo() throws HeadlessException {
        setLayout(new FlowLayout());

        vertSB = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, 200);
        vertSB.setPreferredSize(new Dimension(20, 100));

        horzSB = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 200);
        horzSB.setPreferredSize(new Dimension(100, 20));

        add(vertSB);
        add(horzSB);

        vertSB.addAdjustmentListener(this);
        horzSB.addAdjustmentListener(this);

        // Добавить прослушиватели событий движения мыши.
        addMouseMotionListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             * @since 1.6
             */
            @Override
            public void mouseDragged(MouseEvent me) {
                int x = me.getX();
                int y = me.getY();
                horzSB.setValue(x);
                vertSB.setValue(y);
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
     * Invoked when the value of the adjustable has changed.
     *
     * @param e the event to be processed
     */
    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {
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
        msg = "Vertical: " + vertSB.getValue();
        msg += ", Horizontal : " + horzSB.getValue();
        g.drawString(msg, 20, 160);

        // Отобразить текущую позицию указателя мыши при перетаскивании.
        g.drawString("*", horzSB.getValue(),
                vertSB.getValue());
    }

    public static void main(String[] args) {
        ScrollBarDemo appwin = new ScrollBarDemo();
        appwin.setSize(new Dimension(300, 180));
        appwin.setTitle("ExAddRemoveElements");
        appwin.setVisible(true);
    }
}
