package Design;

import java.util.*;

/**
 * From: https://leetcode.com/problems/design-in-memory-file-system/
 * 588. Design In-Memory File System (Hard)
 */
public class FileSystem {
    class FileNode {
        boolean isFile = false;
        Map<String, FileNode> fileNodeMap = new HashMap<>();
        String content = "";
    }
    FileNode root;
    public FileSystem() {
        root = new FileNode();
    }

    public List<String> ls(String path) {
        FileNode point = root;
        if (!path.equals("/")) {
            String[] pathNodes = path.split("/");
            for (int i=1; i<pathNodes.length; i++) {
                point = point.fileNodeMap.get(pathNodes[i]);
            }
            if (point.isFile) {
                List<String> list = new ArrayList<>();
                list.add(pathNodes[pathNodes.length - 1]);
                return list;
            }
        }
        List<String> fileList = new ArrayList<>(point.fileNodeMap.keySet());
        Collections.sort(fileList);
        return fileList;
    }

    public void mkdir(String path) {
        FileNode point = root;
        String[] pathNodes = path.split("/");
        for (int i=1; i<pathNodes.length; i++) {
            if (!point.fileNodeMap.containsKey(pathNodes[i])) {
                point.fileNodeMap.put(pathNodes[i], new FileNode());
            }
            point = point.fileNodeMap.get(pathNodes[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        FileNode point = root;
        String[] pathNodes = filePath.split("/");
        for (int i=1; i<pathNodes.length-1; i++) {
            point = point.fileNodeMap.get(pathNodes[i]);
        }
        if (!point.fileNodeMap.containsKey(pathNodes[pathNodes.length - 1])) {
            point.fileNodeMap.put(pathNodes[pathNodes.length - 1], new FileNode());
        }
        point = point.fileNodeMap.get(pathNodes[pathNodes.length - 1]);
        point.isFile = true;
        point.content += content;
    }

    public String readContentFromFile(String filePath) {
        FileNode point = root;
        String[] pathNodes = filePath.split("/");
        for (int i=1; i<pathNodes.length-1; i++) {
            point = point.fileNodeMap.get(pathNodes[i]);
        }
        return point.fileNodeMap.get(pathNodes[pathNodes.length-1]).content;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */
