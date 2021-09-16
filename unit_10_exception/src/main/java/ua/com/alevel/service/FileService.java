package ua.com.alevel.service;

import ua.com.alevel.model.FileModel;

import java.util.List;

public interface FileService {

    void create(FileModel fileModel);
    void delete(String file);
    List<String> allFiles(String fileType);
    String read(String file);
}
