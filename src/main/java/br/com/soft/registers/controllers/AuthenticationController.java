package br.com.soft.registers.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/v1/auth")
@ResponseBody
@CrossOrigin(origins = "*")
@Api(value = "Authentication")
public class AuthenticationController {

    @ApiOperation(value = "Login (only for test purpose, using basic athentication)")
    @RequestMapping(path="/login",
            method = RequestMethod.POST,
            produces= MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity auth() {
        return ResponseEntity.ok().build();
    }

}
