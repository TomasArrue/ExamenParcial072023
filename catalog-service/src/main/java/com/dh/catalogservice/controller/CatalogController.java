package com.dh.catalogservice.controller;


import com.dh.catalogservice.cliente.IMovieClient;
import com.dh.catalogservice.model.Movie;
import com.dh.catalogservice.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * @author TomasArrue
 */

@RestController
@RequestMapping("/api/v1/catalog")
public class CatalogController {

    @Autowired
    private CatalogService catalogService;

    @Autowired
    private IMovieClient iMovieClient;

    public CatalogController(CatalogService catalogService){ this.catalogService = catalogService; }

    @GetMapping("/catalogo/{genre}")
    public ResponseEntity<List<Movie>> getCatalogByGenre(@PathVariable String genre){
        return iMovieClient.getMovieByGenre(genre);
    }

    @GetMapping("/saluda")
    public ResponseEntity<String> saludar(){
        return ResponseEntity.ok().body(catalogService.saludar());
    }

    @GetMapping("/saluda/movie")
    public ResponseEntity<String> saludarMovie(){
        return iMovieClient.saludar();
    }
}
