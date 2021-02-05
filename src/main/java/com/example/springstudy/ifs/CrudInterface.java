package com.example.springstudy.ifs;

import com.example.springstudy.model.network.Header;

public interface CrudInterface {
    Header create();
    Header read(Long id);
    Header update();
    Header delete(Long id);
}
