package com.example.springstudy.controller.api;

import com.example.springstudy.controller.CrudController;
import com.example.springstudy.model.entity.Item;
import com.example.springstudy.model.network.request.ItemApiRequest;
import com.example.springstudy.model.network.response.ItemApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/item")
public class ItemApiController extends CrudController<ItemApiRequest, ItemApiResponse, Item> {

}
