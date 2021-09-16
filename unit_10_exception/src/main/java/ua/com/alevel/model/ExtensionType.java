package ua.com.alevel.model;

import lombok.Getter;

@Getter
public enum ExtensionType {

    JSON("json"), CSV("csv"), TXT("txt");

    private final String extension;

    ExtensionType(String extension) {
        this.extension = extension;
    }
}
