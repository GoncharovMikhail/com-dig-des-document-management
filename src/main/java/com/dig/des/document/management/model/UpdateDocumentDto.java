package com.dig.des.document.management.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false, of = {"id"})
public class UpdateDocumentDto extends SaveDocumentDto {
    @NotNull
    private Long id;
}
