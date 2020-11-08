package ru.ndg.practice.controller.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ndg.practice.controller.DefaultController;
import ru.ndg.practice.service.document.DocumentService;
import ru.ndg.practice.view.DocumentView;

import java.util.List;

@RestController
@RequestMapping(value = {"/api"})
public class CatalogController implements DefaultController {

    private final DocumentService documentService;

    @Autowired
    public CatalogController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping(value = {"/docs"})
    public ResponseEntity<Object> getAllDocuments() {
        List<DocumentView> allDocuments = documentService.getAllDocuments();
        return new ResponseEntity<>(putViewInBody("docs", allDocuments), HttpStatus.OK);
    }

    @GetMapping(value = {"/countries"})
    public ResponseEntity<Object> getDocumentById(@PathVariable(name = "id") Integer id) {
        DocumentView document = documentService.getDocument(id);
        return new ResponseEntity<>(putViewInBody("countries", document), HttpStatus.OK);
    }
}