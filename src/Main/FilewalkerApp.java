package Main;

import Controller.FilewalkerController;
import Model.FilewalkerModel;
import View.FilewalkerView;

import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class FilewalkerApp {
    public static void main(String[] args) {
        FilewalkerModel model = new FilewalkerModel();
        FilewalkerView view = new FilewalkerView();
        FilewalkerController controller = new FilewalkerController(model, view);

        model.buildTree("D:\\");

        JFrame frame = new JFrame("Filewalker - JTree Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        frame.add(new JScrollPane(new JTree(model.getRoot())), BorderLayout.WEST);
        frame.add(new JScrollPane(view.getTextArea()), BorderLayout.CENTER);

        frame.setVisible(true);

        // Update the view (e.g., when user interacts with the application)
        controller.updateView();

        // Create a thread pool for background tasks
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Example: Execute a task in the background
        executor.submit(() -> {
            try (Stream<Path> fileStream = Files.walk(Path.of("D:\\"))) {
                fileStream
                        .filter(Files::isRegularFile) // Chỉ lấy các tệp (loại bỏ thư mục)
                        .forEach(file -> System.out.println(file.getFileName()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // Shutdown the executor when done
        executor.shutdown();
    }
}