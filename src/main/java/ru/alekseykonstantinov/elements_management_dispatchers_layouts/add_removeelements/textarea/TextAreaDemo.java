package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.textarea;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextAreaDemo extends Frame {
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
    public TextAreaDemo() throws HeadlessException {
        setLayout(new FlowLayout());
        String val = " JDK 17 is the latest version of опе of the most\n" +
                "widely-used computer languages for Internet programming . \n" +
                "Bui lding on а rich heri tage, Java has advanced both\n" +
                "the art and science of computer language design. \n\n" +
                "One of the reasons for Java 's ongoing зuссезз is its\n" +
                "constant, steady rate of evolution . Java has never stood\n" +
                "still. Instead, Java has consistently adapted to the\n" +
                "rapidly changing l andscape of the networked world. \n" +
                "Moreover, Java has often led the way, charting the\n" +
                "course for others to follow.";
        TextArea textArea = new TextArea(val, 10, 30);
        add(textArea);

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

    }

    public static void main(String[] args) {
        TextAreaDemo appwin = new TextAreaDemo();
        appwin.setSize(new Dimension(380, 220));
        appwin.setTitle("TextFieldDemo");
        appwin.setVisible(true);
    }
}
