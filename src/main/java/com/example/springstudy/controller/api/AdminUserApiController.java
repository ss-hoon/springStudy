package com.example.springstudy.controller.api;

import com.example.springstudy.controller.CrudController;
import com.example.springstudy.model.entity.AdminUser;
import com.example.springstudy.model.network.request.AdminUserApiRequest;
import com.example.springstudy.model.network.response.AdminUserApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/adminUser")
public class AdminUserApiController extends CrudController<AdminUserApiRequest, AdminUserApiResponse, AdminUser> {

}
