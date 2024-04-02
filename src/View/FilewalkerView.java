package View;

import javax.swing.*;

public class FilewalkerView {
    private JTextArea textArea;

    public FilewalkerView() {
        textArea = new JTextArea(5, 30);
        textArea.setEditable(false);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}