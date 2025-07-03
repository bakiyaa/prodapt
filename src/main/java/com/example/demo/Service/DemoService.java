package com.example.demo.Service;


import com.example.demo.exception.InvalidInputException;
import org.springframework.stereotype.Service;


public interface DemoService {
    String removeFirstLastCharacter(String originalString) throws InvalidInputException;
}


