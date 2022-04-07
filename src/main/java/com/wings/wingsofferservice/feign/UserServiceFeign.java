package com.wings.wingsofferservice.feign;

import com.wings.wingsofferservice.Models.Route;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@FeignClient(name = "USER-SERVICE")
public interface UserServiceFeign {
    @RequestMapping(method = RequestMethod.POST, value = "/api/auth/Add-Route/{id}", consumes = "application/json")
    Route newRoute(@PathVariable("id") long id, @RequestBody Route route);

    @RequestMapping(method = RequestMethod.GET, value = "/api/auth/GetRouteById/{id}", consumes = "application/json")
    Optional<Route> getRoute(@PathVariable("id") long id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/api/auth/DeleteRoute/{id}")
    void DeleteRoute(@PathVariable("id") long id);

    @RequestMapping(method = RequestMethod.PUT, value = "/api/auth/UpdateRouteById/{id}")
    Route UpdateRoute(@PathVariable("id") long id, @RequestBody Route route);

    @RequestMapping(method = RequestMethod.GET, value = "/api/auth/GetRouteByFilter")
    Route GetRouteByFilter(@RequestBody Route route);

}
