package com.kubernetes.api.client;

import com.kubernetes.api.dto.CarroDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "api-carros", path = "/api/carros", url = "${kubernetes.url.api.carros:#{null}}")
public interface CarroClient {

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    ResponseEntity<CarroDto> getCarroById(@PathVariable("id") Long id);

}
