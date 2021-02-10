package com.example.springstudy.service;

import com.example.springstudy.model.entity.Category;
import com.example.springstudy.model.network.Header;
import com.example.springstudy.model.network.request.CategoryApiRequest;
import com.example.springstudy.model.network.response.CategoryApiResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CategoryApiLogicService extends BaseService<CategoryApiRequest, CategoryApiResponse, Category> {

    @Override
    public Header<CategoryApiResponse> create(Header<CategoryApiRequest> request) {

        CategoryApiRequest body = request.getData();

        Category category = Category.builder()
                .type(body.getType())
                .title(body.getTitle())
                .build();

        Category newCategory = this.baseRepository.save(category);

        return response(newCategory);
    }

    @Override
    public Header<CategoryApiResponse> read(Long id) {
        return this.baseRepository.findById(id)
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header<CategoryApiResponse> update(Header<CategoryApiRequest> request) {
        CategoryApiRequest body = request.getData();

        return this.baseRepository.findById(body.getId())
                .map(category -> {
                    category
                            .setType(body.getType())
                            .setTitle(body.getTitle())
                            .setUpdatedAt(LocalDateTime.now())
                            .setUpdatedBy("AdminServer");

                    return category;
                })
                .map(newCategory -> this.baseRepository.save(newCategory))
                .map(this::response)
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    @Override
    public Header delete(Long id) {
        return this.baseRepository.findById(id)
                .map(category -> {
                    this.baseRepository.delete(category);
                    return Header.OK();
                })
                .orElseGet(() -> Header.ERROR("데이터 없음"));
    }

    private Header<CategoryApiResponse> response(Category category){
        CategoryApiResponse body = CategoryApiResponse.builder()
                .id(category.getId())
                .type(category.getType())
                .title(category.getTitle())
                .build();

        return Header.OK(body);
    }
}
