package nl.hu.ict.inno.presentation.controller;


import nl.hu.ict.inno.application.VakService;
import nl.hu.ict.inno.domain.Opleiding;
import nl.hu.ict.inno.domain.Student;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.domain.exceptions.OpleidingNotFoundException;
import nl.hu.ict.inno.domain.exceptions.VakNotFoundException;
import nl.hu.ict.inno.presentation.dto.StudentDto;
import nl.hu.ict.inno.presentation.dto.ToetsGegevensDto;
import nl.hu.ict.inno.presentation.dto.VakDto;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/Vakken")
public class VakController {

    private final VakService vakService;

    public VakController(VakService vakService) {
        this.vakService = vakService;
    }

    @PostMapping("/create")
    public Vak save(@Validated @RequestBody VakDto vakDto) {
        try {
        return this.vakService.saveVak(vakDto.id,vakDto.naam,vakDto.periode,
                vakDto.ingangEisen,
                vakDto.loopTijd,
                vakDto.toetsGegevens,
                vakDto.herkansingGegevens);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        }
    }

    @PutMapping("/update/{id}")
    public Vak update(@PathVariable("id") String VakId, @Validated @RequestBody VakDto vakDto) {
        try {
            return this.vakService.updateVak(VakId,vakDto.naam,vakDto.periode,
                    vakDto.ingangEisen,
                    vakDto.loopTijd,
                    vakDto.toetsGegevens,
                    vakDto.herkansingGegevens,
                    vakDto.opleidingId);
        }catch (VakNotFoundException | OpleidingNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        }
    }
    @PostMapping("/AddVakToOpleiding/{id}")
    public Vak AddVakToOpleiding(@PathVariable("id") Long OpleidingId,@Validated @RequestBody VakDto vakDto) {
        try {
            return this.vakService.addVakToOpleiding(OpleidingId,vakDto.id);
        } catch (VakNotFoundException | OpleidingNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        }
    }

    @PostMapping("/AddStudent/{id}")
    public Vak AddStudent(@PathVariable("id") String VakId,@Validated @RequestBody StudentDto studentDto) {
        try {
            return this.vakService.saveStudent(VakId,studentDto.naam, studentDto.id);
        } catch (VakNotFoundException | OpleidingNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        }
    }


    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable("id") String VakId) {
        try {
            this.vakService.deleteVak(VakId);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.OK, exception.getMessage());
        }
    }
    @DeleteMapping("/DeleteAll")
    public void deleteAll() {
        try {
            this.vakService.deleteAll();
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.OK, exception.getMessage());
        }
    }
    @GetMapping("/getById/{id}")
    public Vak findById(@PathVariable("id") String VakId) {
        try {
            return this.vakService.findById(VakId);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping("/getByNaam/{naam}")
    public Vak getByNaam(@PathVariable("naam") String VakNaam) {
        try {
            return this.vakService.findByNaam(VakNaam);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping("/getByToetsGegevens")
    public List<Vak> getByToetsGegevens(@Validated @RequestBody ToetsGegevensDto toetsGegevensDto) {
        try {
            return this.vakService.findVakByToetsGegevens(toetsGegevensDto.toetsGegevens);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
    @GetMapping("/getByToetsGegevensVorm/{vorm}")
    public List<Vak> getByToetsGegevensVorm(@PathVariable("vorm") String vorm) {
        try {
            return this.vakService.findVakByToetsGegevensVorm(vorm);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
    @GetMapping("/getByPeriode/{periode}")
    public List<Vak> getByPeriode(@PathVariable("periode") int VakPeriode) {
        try {
            return this.vakService.findByPeriode(VakPeriode);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping("/getVakByOpleidingId/{id}")
    public List<Vak> getByOpleidingId(@PathVariable("id") Long id) {
        try {
            return this.vakService.findVakByOpleidingId(id);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping("/getOpleiding/{id}")
    public Opleiding getOpleidingById(@PathVariable("id") Long id) {
        try {
            return this.vakService.findOpleidingById(id);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping("/getAlleOpleidingVak")
    public List<Opleiding> getAlleOpleidingVak() {
        try {
            return this.vakService.getOpleidingVakken();
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }

    @GetMapping("/getAlleVakken")
    public List<Vak> getAlleVakken() {
        try {
            return this.vakService.getVakken();
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}
