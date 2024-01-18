package nl.hu.ict.inno.presentation.controller;


import nl.hu.ict.inno.application.VakInterface;
import nl.hu.ict.inno.application.VakService;
import nl.hu.ict.inno.domain.Opdracht;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.domain.exceptions.VakNotFoundException;
import nl.hu.ict.inno.presentation.dto.StudentPuntenDto;
import nl.hu.ict.inno.presentation.dto.VakDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/Vakken")
public class VakController {

    private final VakInterface vakInterface;

    public VakController(VakService vakService) {
        this.vakInterface = vakService;
    }

    @PostMapping("/create")
    public Vak save(@Validated @RequestBody VakDto vakDto) {
        try {

        return this.vakInterface.AddVak(vakDto);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public Vak findById(@PathVariable("id") String VakId) {
        try {
            return this.vakInterface.findById(VakId);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @PostMapping("/puntenSturen")
    public void puntenSturen(@Validated @RequestBody StudentPuntenDto studentPuntenDto) {
        try {
            this.vakInterface.studentHeeftPuntenBehaald(studentPuntenDto.getVakId(),studentPuntenDto.getStudentId());
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        }
    }

    @PostMapping("/opdrachten/{vakid}/{studentId}")
    public void opdrachtSturen(@PathVariable("vakid") String vakid,@PathVariable("studentId") String studentId) {
        try {
             this.vakInterface.studentHeeftGeenPuntenBehaald(vakid,studentId);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        }
    }


    @GetMapping("/getAllOpleidingen")
    public List<Opleiding> getAllOpleidingen() {
        try {
            return this.vakInterface.getOpleidingen();
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}
