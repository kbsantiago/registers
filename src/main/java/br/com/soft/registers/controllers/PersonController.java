package br.com.soft.registers.controllers;

import br.com.soft.registers.domain.dtos.Message;
import br.com.soft.registers.domain.dtos.person.PersonDto;
import br.com.soft.registers.domain.dtos.person.v1.PersonV1AddDto;
import br.com.soft.registers.domain.dtos.person.v1.PersonV1EditDto;
import br.com.soft.registers.domain.dtos.person.v2.PersonV2EditDto;
import br.com.soft.registers.services.interfaces.PersonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/v1/registers/person")
@ResponseBody
@CrossOrigin(origins = "*")
@Api(value = "Person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @ApiOperation(value = "Return a list o person")
    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getAll(@RequestParam int page) {
        return ResponseEntity.ok(personService.getAll(page));
    }

    @ApiOperation(value = "Return a list o person")
    @RequestMapping(path = "/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity get(@PathVariable long id) {
        PersonDto personDto = personService.getById(id);
        if(personDto != null) {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(personDto);
            }  catch (Exception exception) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @ApiOperation(value = "Add a new person and return data")
    @RequestMapping(method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity save(@RequestBody PersonV1AddDto personDto) {
        if (personService.isValid(personDto)
                && personService.isDuplicatedDocument(personDto)) {
            try {
                personService.save(personDto);
                return ResponseEntity.status(HttpStatus.OK).body(personDto);
            } catch (Exception exception) {
                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(personDto);
        }
    }

    @ApiOperation(value = "Update a person and return data")
    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody PersonV2EditDto personDto) {
        if (personService.isValid(personDto)) {
            try {
                personService.save(personDto);
                return ResponseEntity.status(HttpStatus.OK).body(personDto);
            } catch (Exception exception) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(personDto);
        }
    }

    @ApiOperation(value = "Delete a person register")
    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable int id) {
        try {
            personService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
