package com.example.springstudy.controller.api;

import com.example.springstudy.controller.CrudController;
import com.example.springstudy.model.entity.OrderGroup;
import com.example.springstudy.model.network.request.OrderGroupApiRequest;
import com.example.springstudy.model.network.response.OrderGroupApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orderGroup")
public class OrderGroupApiController extends CrudController<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

}
