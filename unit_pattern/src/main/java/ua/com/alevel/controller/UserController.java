package ua.com.alevel.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.com.alevel.dto.ResponseContainer;
import ua.com.alevel.dto.UserRequestDto;
import ua.com.alevel.dto.UserResponseDto;
import ua.com.alevel.facade.UserFacade;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping
    public ResponseEntity<ResponseContainer<Boolean>> create(@RequestBody UserRequestDto dto) {
        userFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseContainer<>(true));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> update(@RequestBody UserRequestDto dto, @PathVariable String id) {
        userFacade.update(dto, id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseContainer<Boolean>> delete(@PathVariable String id) {
        userFacade.delete(id);
        return ResponseEntity.ok(new ResponseContainer<>(true));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseContainer<UserResponseDto>> findById(@PathVariable String id) {
        return ResponseEntity.ok(new ResponseContainer<>(userFacade.findById(id)));
    }

    @GetMapping
    public ResponseEntity<ResponseContainer<List<UserResponseDto>>> findAll() {
        return ResponseEntity.ok(new ResponseContainer<>(userFacade.findAll()));
    }
}
