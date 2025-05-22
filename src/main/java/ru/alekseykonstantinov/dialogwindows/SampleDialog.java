package ru.alekseykonstantinov.dialogwindows;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class SampleDialog extends Dialog {
    /**
     * Constructs an initially invisible, modeless {@code Dialog} with
     * the specified owner {@code Frame} and title.
     *
     * @param owner the owner of the dialog or {@code null} if
     *              this dialog has no owner
     * @param title the title of the dialog or {@code null} if this dialog
     *              has no title
     * @throws IllegalArgumentException if the {@code owner}'s
     *                                  {@code GraphicsConfiguration} is not from a screen device
     * @throws HeadlessException        when
     *                                  {@code GraphicsEnvironment.isHeadless()} returns {@code true}
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     */
    public SampleDialog(Frame owner, String title) {
        super(owner, title, false);

        setLayout(new FlowLayout());
        setSize(300, 200);
        add(new Label("Press this button: ")); // Нажмите на эту кнопку
        Button b;
        add(b = new Button("Cancel"));
        b.addActionListener((ae) -> dispose());
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
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
        g.drawString("This is in the dialog bох", 20, 80);
    }
}
