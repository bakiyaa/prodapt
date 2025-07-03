package com.example.demo.Service;

import com.example.demo.exception.InvalidInputException;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String removeFirstLastCharacter(String originalString) throws InvalidInputException {
        if (originalString == null || originalString.length() < 2) {
            throw new InvalidInputException("Input string must have at least 2 characters.");
        }
        if (originalString.length() == 2) {
            return "";
        }
        return originalString.substring(1, originalString.length() - 1);
    }
}
