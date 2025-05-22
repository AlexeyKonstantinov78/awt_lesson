package ru.alekseykonstantinov.dialogwindows;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DialogDemo extends Frame {
    String msg = "";
    CheckboxMenuItem debug, test;
    SampleDialog myDialog;

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
    public DialogDemo() throws HeadlessException {
        // Создать диалоговое окно.
        myDialog = new SampleDialog(this, "New Dialog Вох");

        // Создать панель меню и добавить ее во фрейм.
        MenuBar menuBar = new MenuBar();
        setMenuBar(menuBar);

        // Создать пункты меню.
        Menu file = new Menu("File");
        MenuItem item1, item2, item3, item4, item5;
        file.add(item1 = new MenuItem("New."));
        file.add(item2 = new MenuItem("Open."));
        file.add(item3 = new MenuItem("Close"));
        file.add(item4 = new MenuItem("_"));
        file.add(item5 = new MenuItem("Quit."));
        menuBar.add(file);

        Menu edit = new Menu("Edit");
        MenuItem item6, item7, item8, item9;
        edit.add(item6 = new MenuItem("Cut"));
        edit.add(item7 = new MenuItem("Copy"));
        edit.add(item8 = new MenuItem("Paste"));
        edit.add(item9 = new MenuItem("_"));

        Menu sub = new Menu("Special");
        MenuItem item10, item11, item12;
        sub.add(item10 = new MenuItem("Cut"));
        sub.add(item11 = new MenuItem("Copy"));
        sub.add(item12 = new MenuItem("Paste"));
        edit.add(sub);

        // Создать переключаемые пункты меню.
        debug = new CheckboxMenuItem("Debug");
        edit.add(debug);
        test = new CheckboxMenuItem("Test");
        edit.add(test);

        menuBar.add(edit);

        // Создать объект для обработки событий действий и элементов.
        MyMenuHeandler handler = new MyMenuHeandler(this);

        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        item4.addActionListener(handler);
        item6.addActionListener(handler);
        item7.addActionListener(handler);
        item8.addActionListener(handler);
        item9.addActionListener(handler);
        item10.addActionListener(handler);
        item11.addActionListener(handler);
        item12.addActionListener(handler);

        debug.addItemListener(handler);
        test.addItemListener(handler);

        item5.addActionListener(ae -> System.exit(0));

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
        g.drawString(msg, 10, 220);
        if (debug.getState()) {
            g.drawString("Debug is on.", 10, 240);
        } else {
            g.drawString("Debug is off.", 10, 240);
        }
        if (test.getState()) {
            g.drawString("Testing is on.", 10, 260);
        } else {
            g.drawString("Testing is off.", 10, 260);
        }
    }

    public static void main(String[] args) {
        DialogDemo appwin = new DialogDemo();
        appwin.setSize(new Dimension(250, 300));
        appwin.setTitle("DialogDemo");
        appwin.setVisible(true);
    }
}
