package ensa.sri.indexationcv.controller;

import ensa.sri.indexationcv.entity.CV;
import ensa.sri.indexationcv.entity.CVShort;
import ensa.sri.indexationcv.service.CVService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/api")
@Slf4j
@Validated
public class CVController {
    private final CVService cvService;
    @PostMapping("/cvs")
    public ResponseEntity<String> addCV(@NotNull(message = "The username cannot be null") @NotEmpty(message = "The username cannot be empty") String username ,
                                        @NotNull(message = "The file cannot be null") MultipartFile file) throws IOException {
        String id = cvService.save(username, file);
        return ResponseEntity.ok().body(id);
    }
    @GetMapping("/cvs")
    public ResponseEntity<List<CVShort>> getAllCV(){
        return ResponseEntity.ok().body(cvService.query());
    }
    @GetMapping("/cvs/search")
    public ResponseEntity<List<CVShort>> queryInContent(@RequestParam("keyword") @NotNull(message = "The keyword cannot be null") String keyword)throws IOException {
        return ResponseEntity.ok().body(cvService.queryInContent(keyword));
    }
    @GetMapping("/cvs/get")
    public ResponseEntity<CV> getCVbyId(@RequestParam("id") @NotNull(message = "The id cannot be null") @NotEmpty(message = "The id cannot be empty") String id)throws IOException {
        return ResponseEntity.ok().body(cvService.queryGetById(id));
    }
    @PutMapping("/cvs/update")
    public ResponseEntity<String> updateCV(@NotNull(message = "The username cannot be null") @NotEmpty(message = "The username cannot be empty") String username ,
                                        @NotNull(message = "The file cannot be null") MultipartFile file,
                                           @RequestParam("id") @NotNull(message = "The keyword cannot be null") String id  ) throws IOException {
         cvService.updateCV(id, file,username);
        return ResponseEntity.ok().body(id);
    }
    @DeleteMapping("/cvs/{id}")
    public ResponseEntity<Void> deleteCV(@PathVariable String id){
        cvService.deleteCV(id);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/deleteAllCvs")
    public ResponseEntity<Void> deleteAllCvs(){
        cvService.deleteAll();
        return ResponseEntity.ok().build();
    }
}
