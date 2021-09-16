package ua.com.alevel.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FileModel {

    private String name;

    @NotBlank(message = "Name may not be null")
    @NotNull(message = "Name may not be null")
    private String content;
    private ExtensionType extensionType;
}
