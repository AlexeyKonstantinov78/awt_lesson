package ru.alekseykonstantinov.elements_management_dispatchers_layouts.add_removeelements.layout_dispatchers;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutDemo extends Frame {
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
    public BorderLayoutDemo() throws HeadlessException {
        add(new Button("This is across the top."), BorderLayout.NORTH);
// Это располагается вверху.
        add(new Label("The footer message might go here . "), BorderLayout.SOUTH);
// Здесь может находиться нижний колонтитул .
        add(new Button("Right"), BorderLayout.EAST);
// Справа
        add(new Button("Left"), BorderLayout.WEST);
// Слева
        String msg = "The reasonaЫe man adapts " +
                "himsel f to the world;\n" +
                "the unreasonaЫe one persists iп " +
                "tryiпg to adapt the world to himself .\n" +
                "Therefore all progress depend s " +
                " on the unreasonaЫe man. \n\n" +
                " - G eorge B ernard Shaw\n\n";
// Рациональный человек приспосабливается к миру,
// безрассудный же упорно пытается приспособить мир к себе . // Поэтому весь прогресс зависит от безрассудных людей .
// - Джордж Бернард Шоу
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

    public static void main(String[] args) {
        BorderLayoutDemo appwin = new BorderLayoutDemo();
        appwin.setSize(new Dimension(300, 220));
        appwin.setTitle("B orderLayoutDemo");
        appwin.setVisible(true);

    }

}
