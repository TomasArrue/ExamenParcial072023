package com.dh.catalogservice.controller;


import com.dh.catalogservice.service.CatalogService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;

/**
 * @author TomasArrue
 */

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {
    private final CatalogService catalogService;

    public CatalogController(CatalogService catalogService){ this.catalogService = catalogService; }

    @GetMapping("/saluda")
    public ResponseEntity<String> saludar(){
        return ResponseEntity.ok().body(catalogService.saludar());
    }
}
