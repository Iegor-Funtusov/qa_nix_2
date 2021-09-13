package ua.com.alevel.crud;

public enum FileType {

    FILE_TXT("file.txt"),
    FILE_HIDDEN_TXT(".blabla.txt"),
    FILE_DIR("dir"),
    FILE_DIRS("dir/dir1/dir2/dir3");

    private final String path;

    FileType(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
