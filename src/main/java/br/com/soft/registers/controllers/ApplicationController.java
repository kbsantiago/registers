package br.com.soft.registers.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/v1/source")
@ResponseBody
@CrossOrigin(origins = "*")
@Api(value = "Source")
public class ApplicationController {

    @ApiOperation(value = "Return github source address")
    @RequestMapping(method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get() {
        return ResponseEntity.ok("Go to -> " + "github.com/kbsantiago/registers");
    }

}
