package com.dig.des.document.management.model;

import javafx.scene.layout.Priority;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Data
public class SaveDocumentDto {
    @NotBlank
    private String title;
    private String description;
    @NotNull
    private Priority priority;
    // TODO: 14.04.2021 ??? как передавать файлы?
    private Set<byte[]> files;
}
