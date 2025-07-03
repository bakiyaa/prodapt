package com.example.demo.controller;

import com.example.demo.Service.DemoService;
import com.example.demo.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/remove")
    public ResponseEntity<String> removeFirstLastCharacter(@RequestParam String originalString) throws InvalidInputException {

        String result = demoService.removeFirstLastCharacter(originalString);
        return ResponseEntity.ok(result);

       /* if (originalString == null || originalString.length() < 2) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Input string must have at least 2 characters.");
        }

        if (originalString.length() == 2) {
            return ResponseEntity.ok("");
        }

        return ResponseEntity.ok(originalString.substring(1, originalString.length() - 1));*/
    }

}
