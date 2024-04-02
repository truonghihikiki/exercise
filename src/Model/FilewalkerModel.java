package Model;

import javax.swing.tree.DefaultMutableTreeNode;
import java.io.File;

public class FilewalkerModel {
    private DefaultMutableTreeNode root;

    public FilewalkerModel() {
        root = new DefaultMutableTreeNode("Ổ D:");
    }

    public void buildTree(String path) {
        File rootDir = new File(path);
        buildTree(root, rootDir);
    }

    private void buildTree(DefaultMutableTreeNode node, File file) {
        if (file.isDirectory()) {
            DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(file.getName());
            node.add(childNode);
            File[] fileList = file.listFiles();
            if (fileList != null) {
                for (File f : fileList) {
                    buildTree(childNode, f);
                }
            }
        } else {
            node.add(new DefaultMutableTreeNode(file.getName()));
        }
    }

    public DefaultMutableTreeNode getRoot() {
        return root;
    }
}