package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.layout_dispatchers;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GridLayoutDemo extends Frame {
    static final int n = 4;

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
    public GridLayoutDemo() throws HeadlessException {
        setLayout(new GridLayout(n, n));

        setFont(new Font("SansSerif", Font.BOLD, 24));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int k = i * n + j;
                if (k > 0)
                    add(new Button("" + k));
            }
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

    public static void main(String[] args) {
        GridLayoutDemo appwin = new GridLayoutDemo();
        appwin.setSize(new Dimension(300, 220));
        appwin.setTitle("B orderLayoutDemo");
        appwin.setVisible(true);
    }
}
