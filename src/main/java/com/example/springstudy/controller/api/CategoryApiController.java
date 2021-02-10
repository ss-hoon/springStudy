package com.example.springstudy.controller.api;

import com.example.springstudy.controller.CrudController;
import com.example.springstudy.model.entity.Category;
import com.example.springstudy.model.network.request.CategoryApiRequest;
import com.example.springstudy.model.network.response.CategoryApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryApiController extends CrudController<CategoryApiRequest, CategoryApiResponse, Category> {

}
