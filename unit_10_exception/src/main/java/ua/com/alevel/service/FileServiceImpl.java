package ua.com.alevel.service;

import org.springframework.stereotype.Service;
import ua.com.alevel.exception.RestBadRequestException;
import ua.com.alevel.model.FileModel;
import ua.com.alevel.util.FileUtil;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {

    @Override
    public void create(FileModel fileModel) {
        File file = null;
        switch (fileModel.getExtensionType()) {
            case JSON : {
                file = generateFile(fileModel, FileUtil.JSON_PATH);
            } break;
            case CSV : {
                file = generateFile(fileModel, FileUtil.CSV_PATH);
            } break;
            case TXT : {
                file = generateFile(fileModel, FileUtil.TXT_PATH);
            } break;
        }
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            bufferedWriter.write(fileModel.getContent());
            bufferedWriter.flush();
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    @Override
    public void delete(String fileName) {
        String[] split = fileName.split("\\.");
        File file = new File(FileUtil.BASE_PATH + "/" + split[1] + "/" + fileName);
        file.deleteOnExit();
    }

    @Override
    public List<String> allFiles(String fileType) {
        File file = new File(FileUtil.BASE_PATH + "/" + fileType);
        return Arrays.asList(file.list());
    }

    @Override
    public String read(String fileName) {
        String[] split = fileName.split("\\.");
        File file = new File(FileUtil.BASE_PATH + "/" + split[1] + "/" + fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            return reader.readLine();
        } catch (FileNotFoundException e) {
            throw new RestBadRequestException(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File generateFile(FileModel fileModel, String path) {
        return new File(path + fileModel.getName() + "." + fileModel.getExtensionType().getExtension());
    }
}
