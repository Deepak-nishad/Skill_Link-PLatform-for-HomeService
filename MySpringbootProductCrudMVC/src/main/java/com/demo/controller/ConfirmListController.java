package com.demo.controller;

import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.demo.model.ConfirmList;
import com.demo.service.ConfirmListService;

@RestController
@RequestMapping("/api/confirm")
public class ConfirmListController {

    @Autowired
    private ConfirmListService confirmListService;

    // Get list of ConfirmList by ServiceProvider ID
    @GetMapping("/serviceprovider/{sid}")
    public ResponseEntity<List<ConfirmList>> getConfirmListByServiceProviderId(@PathVariable("sid") int sid) {
        List<ConfirmList> confirmLists = confirmListService.getData(sid);
        if (confirmLists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(confirmLists, HttpStatus.OK);
    }

    // Add a new ConfirmList entry
    @PostMapping("/add")
    public ResponseEntity<ConfirmList> addConfirmList(@RequestBody ConfirmList confirmList) {
        try {
        	System.out.println("controller chla gaya");
        System.out.println(confirmList);
            confirmListService.addData(confirmList);
            return new ResponseEntity<>(confirmList, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

