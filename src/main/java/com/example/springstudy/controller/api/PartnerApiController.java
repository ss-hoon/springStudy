package com.example.springstudy.controller.api;

import com.example.springstudy.controller.CrudController;
import com.example.springstudy.model.entity.Partner;
import com.example.springstudy.model.network.request.PartnerApiRequest;
import com.example.springstudy.model.network.response.PartnerApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController extends CrudController<PartnerApiRequest, PartnerApiResponse, Partner> {

}
