package nl.hu.inno.humc.monoliet.presentation.controller;


import nl.hu.inno.humc.monoliet.application.VakService;
import nl.hu.inno.humc.monoliet.domain.exceptions.OpleidingNotFoundException;
import nl.hu.inno.humc.monoliet.domain.vak.Vak;
import nl.hu.inno.humc.monoliet.domain.exceptions.VakNotFoundException;
import nl.hu.inno.humc.monoliet.presentation.dto.ToetsGegevensDto;
import nl.hu.inno.humc.monoliet.presentation.dto.VakDto;
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
        return this.vakService.saveVak(vakDto.naam,vakDto.periode,
                vakDto.ingangEisen,
                vakDto.loopTijd,
                vakDto.toetsGegevens,
                vakDto.herkansingGegevens,
                vakDto.opleidingId);
        } catch (VakNotFoundException | OpleidingNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, exception.getMessage());
        }
    }

    @PatchMapping("/update/{id}")
    public Vak update(@PathVariable("id") Long VakId, @Validated @RequestBody VakDto vakDto) {
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

    @DeleteMapping("/Delete/{id}")
    public Vak delete(@PathVariable("id") Long VakId) {
        try {
            return this.vakService.deleteVak(VakId);
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.OK, exception.getMessage());
        }
    }

    @GetMapping("/getById/{id}")
    public Vak findById(@PathVariable("id") Long VakId) {
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

    @GetMapping("/getAlleVakken")
    public List<Vak> getAlleKlanten() {
        try {
            return this.vakService.getVakken();
        } catch (VakNotFoundException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
        }
    }
}
