package ru.alekseykonstantinov.Introduction_windows_graphics_and_text.exdemo;

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
                    Thread.sleep(2000);
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
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawString(msg, 20, 80);
        g2d.draw3DRect(10, 80, 50, 50, true); // прямоуголник
        g2d.fillRoundRect(10, 150, 50, 50, 20, 10); // прямоугольник с кругленными углами запоненый
        g2d.drawRoundRect(10, 210, 50, 50, 20, 10); // прямоугольник с кругленными углами
        g2d.drawLine(10, 140, 200, 130); // чертим линию
        // Вычерчивание эллипсов и окружностей
        g2d.drawOval(10, 270, 50, 50); // окружность не заполненая
        g2d.fillOval(10, 330, 50, 40); // окружность заполненая

        //Вычерчивание дуг
        g2d.drawArc(10, 380, 50, 30, 90, -180);
        g2d.fillArc(10, 420, 50, 30, 90, 180);

        //Вычерчива ние многоугольников
        g2d.drawPolygon(new int[]{10, 20, 30, 40, 50, 60}, new int[]{450, 470, 450, 460, 480, 450}, 6);
        g2d.fillPolygon(new int[]{80, 100, 120, 140, 150, 160}, new int[]{450, 470, 450, 460, 480, 450}, 6);

    }

    public static void main(String[] args) {
        ExDemo ed = new ExDemo();
        ed.setSize(new Dimension(500, 500));
        ed.setTitle("Demo AWT");
        ed.setBackground(Color.darkGray); // утсановка цвета фона
        ed.setForeground(Color.WHITE); // установка цвета текста
        ed.setVisible(true);
    }
}
