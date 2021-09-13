package ua.com.alevel.crud;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class IOFileCrudService implements FileCrudService {

    @Override
    public void createFile(String pathToFile) {
        File file = new File(pathToFile);
        try {
            file.createNewFile();
            if (file.getName().startsWith(".")) {
                setHiddenAttrib(file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateFile(String pathToFile) {

    }

    @Override
    public void deleteFile(String pathToFile) {
        File file = new File(pathToFile);
        boolean delete = file.delete();
        System.out.println("delete = " + delete);
    }

    @Override
    public void readFile(String pathToFile) {
        File file = new File(pathToFile);
        boolean hidden = file.isHidden();
        System.out.println("hidden = " + hidden);
    }

    @Override
    public void createDir(String pathToDir) {
        File file = new File(pathToDir);
        file.mkdir();
    }

    @Override
    public void createDirs(String pathToDir) {
        File file = new File(pathToDir);
        file.mkdirs();
    }

    @Override
    public void updateDir(String pathToDir) {

    }

    @Override
    public void deleteDir(String pathToDir) {
        File file = new File(pathToDir);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readDir(String pathToDir) {
        File file = new File(pathToDir);
        readDir(file);
    }

    private void readDir(File file) {
        if (file.isDirectory()) {
            System.out.println("file dir = " + file.getAbsolutePath());
            for (File listFile : file.listFiles()) {
                readDir(listFile);
            }
        } else {
            System.out.println("file text = " + file.getAbsolutePath());
        }
    }

    // only for windows
    private static void setHiddenAttrib(File file) {
        try {
            Process p = Runtime.getRuntime().exec("attrib +H " + file.getPath());
            p.waitFor();
            if (file.isHidden()) {
                System.out.println(file.getName() + " hidden attribute is set to true");
            } else {
                System.out.println(file.getName() + " hidden attribute not set to true");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
