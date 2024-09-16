package com.stepasha.zoo.controllers;

import com.stepasha.zoo.handlers.RestExceptionHandler;
import com.stepasha.zoo.logging.Loggable;
import com.stepasha.zoo.models.Zoo;
import com.stepasha.zoo.services.TelephoneService;
import com.stepasha.zoo.services.ZooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping(value = "/zoos")
@Loggable
public class ZooController
{
    //todo 10 add logger make sure LSF4J
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);
    @Autowired
    private ZooService zooService;
    @Autowired
    private TelephoneService telephoneService;
   // http://localhost:2020/zoos/zoos
    @GetMapping(value = "/zoos", produces = {"application/json"})
    public ResponseEntity<?> listAllZoos(HttpServletRequest request)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");
        return new ResponseEntity<>(zooService.findAllZoos(), HttpStatus.OK);
    }
    // http://localhost:2020/zoos/zoos/1
    @GetMapping(value = "/zoos/{id}", produces = {"application/json"})
    public ResponseEntity<?> findZooById(HttpServletRequest request, @PathVariable long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");
        Zoo z = zooService.findZooById(id);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }

    // http://localhost:2020/zoos/zoos/name
    @GetMapping(value = "/{name}", produces = {"application/json"})
    public ResponseEntity<?> findZooByName(HttpServletRequest request, @PathVariable String name)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");
        Zoo z = zooService.findZooByName(name);
        return new ResponseEntity<>(z, HttpStatus.OK);
    }
    @PutMapping(value = "/zoos/{id}",
            produces = {"application/json"},
            consumes = {"application/json"})
    public ResponseEntity<?> updateZoo(HttpServletRequest request,
            @RequestBody
                    Zoo updateZoo,
            @PathVariable
                    long id)
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");
        zooService.updateZoo(updateZoo, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/zoos",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewZoo(HttpServletRequest request, @Valid
    @RequestBody
            Zoo newZoo) throws URISyntaxException
    {
        logger.trace(request.getMethod()
                .toUpperCase() + " " + request.getRequestURI() + " accessed");
        newZoo = zooService.saveZoo(newZoo);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        // URI newRestaurantURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{zooid}").buildAndExpand(newZoo.getZooid()).toUri();
        URI newRestaurantURI = ServletUriComponentsBuilder.fromUriString(request.getServerName() + ":" + request.getLocalPort() + "/zoos/zoos/{zooid}").buildAndExpand(newZoo.getZooid()).toUri();
        responseHeaders.setLocation(newRestaurantURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/zoos/{zooid}")
    public ResponseEntity<?> deleteZooById(
            @PathVariable
                    long zooid)
    {
        zooService.deleteZoo(zooid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //localhost:2020/zoos/zoo/{zooid}/animals/{animalid} -- DELETE
    @DeleteMapping(value = "/zoo/{zooid}/animals/{animalid}")
    public ResponseEntity<?> deleteZooAnimalByIds(@PathVariable long zooid, @PathVariable long animalid) {
        zooService.deleteZooAnimal(zooid, animalid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    //todo 7 create new animal in the zoo
    //localhost:2020/zoos/zoo/{zooid}/animals/{animalid} -- POST
    @PostMapping(value = "/zoo/{zooid}/animals/{animalid}")
    public ResponseEntity postZooAnimalByIds(@PathVariable long zooid, @PathVariable long animalid) {
        zooService.addZooAnimal(zooid, animalid);
        return new ResponseEntity(HttpStatus.CREATED);
    }

}
