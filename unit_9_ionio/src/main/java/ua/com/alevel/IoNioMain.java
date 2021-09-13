package ua.com.alevel;

import ua.com.alevel.crud.FileCrudService;
import ua.com.alevel.crud.FileType;
import ua.com.alevel.crud.IOFileCrudService;
import ua.com.alevel.crud.NIOFileCrudService;

public class IoNioMain {

    public static void main(String[] args) {
//        FileCrudService service = new NIOFileCrudService();
//        service.createFile(FileType.FILE_TXT.getPath());
//        service.deleteFile(FileType.FILE_TXT.getPath());
//        service.readFile(FileType.FILE_HIDDEN_TXT.getPath());
//        service.createDirs(FileType.FILE_DIRS.getPath());
//        service.readDir(FileType.FILE_DIR.getPath());
//        service.updateDir(FileType.FILE_DIR.getPath());
//        service.deleteDir(FileType.FILE_DIR.getPath());
        ExceptionTest exceptionTest = new ExceptionTest();
        exceptionTest.run();
    }
}
