package ua.com.alevel.crud;

public interface FileCrudService {

    void createFile(String pathToFile);
    void updateFile(String pathToFile);
    void deleteFile(String pathToFile);
    void readFile(String pathToFile);
    void createDir(String pathToDir);
    void createDirs(String pathToDir);
    void updateDir(String pathToDir);
    void deleteDir(String pathToDir);
    void readDir(String pathToDir);
}
