package com.hospital.version1.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtils {

    public static ResponseEntity<Map<String, Object>> successResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public static ResponseEntity<Map<String, Object>> errorResponse(String message) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "error");
        response.put("message", message);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    public static ResponseEntity<Map<String, Object>> dataResponse(Object data) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "success");
        response.put("data", data);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
