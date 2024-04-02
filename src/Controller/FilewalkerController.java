package Controller;

import Model.FilewalkerModel;
import View.FilewalkerView;

import javax.swing.*;

public class FilewalkerController {
    private FilewalkerModel model;
    private FilewalkerView view;

    public FilewalkerController(FilewalkerModel model, FilewalkerView view) {
        this.model = model;
        this.view = view;
    }

    public void updateView() {
        JTree tree = new JTree(model.getRoot());
        view.getTextArea().setText("Display additional information here if needed.");
        // Add any other necessary logic for updating the view
    }
}


