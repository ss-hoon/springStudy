package com.example.springstudy.ifs;

import com.example.springstudy.model.network.Header;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CrudInterface<Req, Res> {
    Header<Res> create(Header<Req> request);
    Header<Res> read(Long id);
    Header<Res> update(Header<Req> request);
    Header delete(Long id);
    Header <List<Res>> search(Pageable pageable);
}
