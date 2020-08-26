package br.com.soft.registers.controllers;

import br.com.soft.registers.services.interfaces.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/api/v2/registers/person")
@ResponseBody
@CrossOrigin(origins = "*")
@Api(value = "Person v2")
public class PersonV2Controller {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "Return a list o person")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(@RequestParam int page) {
        return ResponseEntity.ok(personService.getAll(page));
    }

//    @ApiOperation(value = "Return a list o person")
//    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity get(@PathVariable long id) {
//        PersonV2EditDto personV2EditDto = (PersonV2EditDto)personService.getById(id);
//        if(personV2EditDto != null) {
//            try {
//                return ResponseEntity.status(HttpStatus.OK).body(personV2EditDto);
//            }  catch (Exception exception) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//            }
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    @ApiOperation(value = "Add a new person and return data")
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity save(@RequestBody PersonV2AddDto personV2AddDto) {
//        if (personService.isValid(personV2AddDto)) {
//            try {
//                personService.save(personV2AddDto);
//                return ResponseEntity.status(HttpStatus.OK).body(personV2AddDto);
//            } catch (Exception exception) {
//                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//            }
//        } else {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//    }
//
//    @ApiOperation(value = "Update a person and return data")
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity update(@RequestBody PersonV2EditDto personV2EditDto) {
//        if (personService.isValid(personV2EditDto) && personService.hasValidAddress(personV2EditDto)) {
//            try {
//                personService.save(personV2EditDto);
//                return ResponseEntity.status(HttpStatus.OK).body(personV2EditDto);
//            } catch (Exception exception) {
//                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//            }
//        } else {
//            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
//        }
//    }
}
