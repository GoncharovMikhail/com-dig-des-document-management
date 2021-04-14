package com.dig.des.document.management.rest.document;

import com.dig.des.document.management.entity.document.DocumentEntity;
import com.dig.des.document.management.model.SaveDocumentDto;
import com.dig.des.document.management.model.UpdateDocumentDto;
import com.dig.des.document.management.service.document.document.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

// TODO: 14.04.2021 (мне) переписать нормально, тут пока имплементация 'для галочки'
@RestController
@RequestMapping("/document/")
public class DocumentManagementController {
    private final DocumentService documentService;

    @Autowired
    public DocumentManagementController(DocumentService documentService) {
        this.documentService = documentService;
    }

    /* TODO: 14.04.2021 точно ли PutMapping?
        Какой лучше посылать ResponseEntity?
        Не уверен про isAuthenticated() */
    // TODO: 14.04.2021 (мне) переписать по-нормальному
    @PutMapping("save")
    @PreAuthorize("isAuthenticated()")
    private ResponseEntity<?> save(@RequestBody @Valid SaveDocumentDto documentDto,
        // TODO: 14.04.2021 не уверен про @CurrentSecurityContext. Как лучше сделать?
        @CurrentSecurityContext(expression = "authentication.name") String username) {
        documentService.saveDocument(new DocumentEntity());
        return ResponseEntity.ok(new Object());
    }

    @PostMapping("alter")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> alter(@RequestBody @Valid UpdateDocumentDto updateDocumentDto,
        @CurrentSecurityContext(expression = "authentication.name") String username) {
        return ResponseEntity.ok(new Object());
    }

    @DeleteMapping("delete/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        documentService.deleteById(id);
        return ResponseEntity.ok(new Object());
    }

    @GetMapping("view/{id}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<DocumentEntity> view(@PathVariable("id") Long id) {
        DocumentEntity document = documentService.findOneById(id);
        return ResponseEntity.ok(document);
    }
}
