package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.insets;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InsetsDemo extends Frame {
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
    public InsetsDemo() throws HeadlessException {
        // В данном случае BorderLayout применяется по умолчанию.
// Установить фоновый цвет, чтобы вставки было легко заметить.
        setBackground(Color.cyan);
        setLayout(new BorderLayout());

        add(new Button("This is across the top."), BorderLayout.NORTH);
        add(new Label("The footer message might go here . "), BorderLayout.SOUTH);
        add(new Button("Right11"), BorderLayout.EAST);
        add(new Button("Left11"), BorderLayout.WEST);
        String msg = "The reasonaЫe man adapts " +
                "himsel f to the world; \n                        " +
                "the unreasonaЫe one pers ists in " +
                "trying to adapt the world to himself.            \n" +
                "Therefore al l progress depends " +

                "On the unreasonaЫe man . \n\n" +
                "- George Bernard Shaw\n\n";
        add(new TextArea(msg), BorderLayout.CENTER);
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
     * Determines the insets of this container, which indicate the size
     * of the container's border.
     * <p>
     * A {@code Frame} object, for example, has a top inset that
     * corresponds to the height of the frame's title bar.
     *
     * @return the insets of this container.
     * @see Insets
     * @see LayoutManager
     * @since 1.1
     */
    @Override
    public Insets getInsets() {
        return new Insets(40, 20, 10, 20); // вставка
    }

    public static void main(String[] args) {
        InsetsDemo appwin = new InsetsDemo();
        appwin.setSize(new Dimension(300, 220));
        appwin.setTitle("InsetsDemo");
        appwin.setVisible(true);
    }
}
