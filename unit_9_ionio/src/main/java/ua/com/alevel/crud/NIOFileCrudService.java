package ua.com.alevel.crud;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NIOFileCrudService implements FileCrudService {

    @Override
    public void createFile(String pathToFile) {
        Path path = Paths.get(pathToFile);
        try {
            boolean exists = Files.exists(path);
            if (!exists) {
                Files.createFile(path);
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
        Path path = Paths.get(pathToFile);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile(String pathToFile) {

    }

    @Override
    public void createDir(String pathToDir) {
        Path path = Paths.get(pathToDir);
        boolean exists = Files.exists(path);
        if (!exists) {
            try {
                Files.createDirectory(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void createDirs(String pathToDir) {
        Path path = Paths.get(pathToDir);
        boolean exists = Files.exists(path);
        if (!exists) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void updateDir(String pathToDir) {
        Path pathFrom = Paths.get(pathToDir);
        Path pathTo = Paths.get("dirTo");
        try {
            Files.move(pathFrom, pathTo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteDir(String pathToDir) {

    }

    @Override
    public void readDir(String pathToDir) {
        Path path = Paths.get(pathToDir);
        Set<String> files;
        try {
            Stream<Path> stream = Files.walk(path);
            files = stream
                    .map(Path::toFile)
                    .filter(File::isFile)
                    .map(File::getAbsolutePath)
                    .collect(Collectors.toSet());
            System.out.println("files = " + files);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
