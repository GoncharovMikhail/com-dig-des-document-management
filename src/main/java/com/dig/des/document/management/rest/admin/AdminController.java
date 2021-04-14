package com.dig.des.document.management.rest.admin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @PostMapping("alter/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> alter(@PathVariable("id") Long id) {
        return ResponseEntity.ok(new Object());
    }
}
