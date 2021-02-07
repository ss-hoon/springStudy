package com.example.springstudy.controller.api;

import com.example.springstudy.ifs.CrudInterface;
import com.example.springstudy.model.network.Header;
import com.example.springstudy.model.network.request.PartnerApiRequest;
import com.example.springstudy.model.network.response.PartnerApiResponse;
import com.example.springstudy.service.PartnerApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/partner")
public class PartnerApiController implements CrudInterface<PartnerApiRequest, PartnerApiResponse> {

    @Autowired
    private PartnerApiLogicService partnerApiLogicService;

    @Override
    @PostMapping("")
    public Header<PartnerApiResponse> create(@RequestBody Header<PartnerApiRequest> request) {
        return partnerApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}")
    public Header<PartnerApiResponse> read(@PathVariable Long id) {
        return partnerApiLogicService.read(id);
    }

    @Override
    @PutMapping("")
    public Header<PartnerApiResponse> update(@RequestBody Header<PartnerApiRequest> request) {
        return partnerApiLogicService.update(request);
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return partnerApiLogicService.delete(id);
    }
}
