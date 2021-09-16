package ua.com.alevel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.model.FileModel;
import ua.com.alevel.service.FileService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/file")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping
    public ResponseEntity<String> createFile(@Valid @RequestBody FileModel model) {
        fileService.create(model);
        return ResponseEntity.status(HttpStatus.CREATED).body("молодец");
    }

    @GetMapping
    public ResponseEntity<List<String>> allFiles(@RequestParam String fileType) {
        return ResponseEntity.ok(fileService.allFiles(fileType));
    }

    @GetMapping("/read")
    public ResponseEntity<String> readFile(@RequestParam String fileName) {
        return ResponseEntity.ok(fileService.read(fileName));
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteFile(@RequestParam String fileName) {
        fileService.delete(fileName);
        return ResponseEntity.ok("молодец");
    }
}
