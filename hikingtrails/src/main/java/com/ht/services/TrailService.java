package com.ht.services;

import java.util.ArrayList;
import java.util.List;

import com.ht.business.TrailBusinessServiceInterface;
import com.ht.model.Trail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/trailapi")
public class TrailService {

    @Autowired
    TrailBusinessServiceInterface service;

    @GetMapping("/findAll")
    List<Trail> getAllTrail() {
        List<Trail> trail = new ArrayList<Trail>();
        trail = service.getAllTrail();
        return trail;
    }

}
