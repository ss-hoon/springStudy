package com.example.springstudy.controller.api;

import com.example.springstudy.ifs.CrudInterface;
import com.example.springstudy.model.network.Header;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {

    // CRUD 작성

    @Override
    @PostMapping("") // /api/user
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}") // /api/user/{id}
    public Header read(@PathVariable Long id) { // Mapping한 매개변수와 메소드 매개변수가 다른경우에는 @PathVariable(name= "ids") 이렇게 명시
        return null;
    }

    @Override
    @PutMapping("") // /api/user
    public Header update() {
        return null;
    }

    @Override
    @DeleteMapping("{id}") // /api/user/{id}
    public Header delete(@PathVariable Long id) {
        return null;
    }
}

