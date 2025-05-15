package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LabelDemo extends Frame {

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
    public LabelDemo() throws HeadlessException {
        // Использовать поточную компоновку.
        // setLayout -> Container
        // new FlowLayout()-> диспетчер компоновки с стандартным поведением в построчно, слева направо, сверху вниз и по центру
        setLayout(new FlowLayout());
        Label one = new Label("One");
        Label two = new Label("Two");
        Label three = new Label("Three");

        // Добавить метки во фрейм.
        add(one);
        add(two);
        add(three);


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
//
    }

    public static void main(String[] args) {
        LabelDemo appwin = new LabelDemo();
        appwin.setSize(new Dimension(500, 500));
        appwin.setTitle("ExAddRemoveElements");
        appwin.setVisible(true);
    }
}
