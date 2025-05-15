package ru.alekseykonstantinov.Introduction_windows_graphics_and_text.exfonts;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FontInfo extends Frame {
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
    public FontInfo() throws HeadlessException {
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
        Font f = g.getFont();
        String fontName = f.getName();
        String fontFamily = f.getFamily();
        int fontSize = f.getSize();
        int fontStyle = f.getStyle();

        String msg = "Family: " + fontName; // Семейство
        msg += ", Font : " + fontFamily; // Шрифт
        msg += ", Size : " + fontSize + ", Style : "; // Размер Начертание
        if ((fontStyle & Font.BOLD) == Font.BOLD)
            msg += "Bold ";                             // Полужирное
        if ((fontStyle & Font.ITALIC) == Font.ITALIC)
            msg += "Italic ";                           // Курсивное
        if ((fontStyle & Font.PLAIN) == Font.PLAIN)
            msg += " Plain ";                               // Обычное
        g.drawString(msg, 10, 60);

    }

    public static void main(String[] args) {
        FontInfo appwin = new FontInfo();
        appwin.setSize(new Dimension(300, 100));
        appwin.setTitle("Font info");
        appwin.setVisible(true);
        ;
    }
}
