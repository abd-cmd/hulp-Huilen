package nl.hu.ict.inno.presentation.controller;

import nl.hu.ict.inno.application.OpleidingService;
import nl.hu.ict.inno.application.execptions.VakNotFoundException;
import nl.hu.ict.inno.domain.Vak;
import nl.hu.ict.inno.presentation.dto.OpleidingDto;
import nl.hu.ict.inno.presentation.dto.VakDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opleidingen")
public class OpleidingRestController {

    private final OpleidingService opleidingService;

    public OpleidingRestController(OpleidingService opleidingService) {
        this.opleidingService = opleidingService;
    }

    @GetMapping
    public ResponseEntity<List<OpleidingDto>> getAllOpleidingen() {
        List<OpleidingDto> opleidingen = opleidingService.getAllOpleidingen();
        return ResponseEntity.ok(opleidingen);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpleidingDto> getOpleidingById(@PathVariable String id) {
        OpleidingDto opleiding = opleidingService.getOpleidingById(id);
        return ResponseEntity.ok(opleiding);
    }

    @PostMapping
    public ResponseEntity<OpleidingDto> createOpleiding(@RequestBody OpleidingDto opleidingDTO) {
        OpleidingDto opleiding = opleidingService.createOpleiding(opleidingDTO);
        return ResponseEntity.ok(opleiding);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpleidingDto> updateOpleiding(@PathVariable String id, @RequestBody OpleidingDto opleidingDto) {
        OpleidingDto opleiding = opleidingService.updateOpleiding(id, opleidingDto);
        return ResponseEntity.ok(opleiding);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpleiding(@PathVariable String id) {
        opleidingService.deleteOpleiding(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/vak/{vakId}")
    public ResponseEntity<Vak> getVakFromOpleiding(@PathVariable String id, @PathVariable String vakId) {
        Vak vak = opleidingService.getVakFromOpleiding(id, vakId);
        return ResponseEntity.ok(vak);
    }

//    @PostMapping("/{id}/vak/{vakId}")
//    public ResponseEntity<OpleidingDto> addVakToOpleiding(@PathVariable String id, @PathVariable String vakId) {
//        OpleidingDto opleiding = opleidingService.addVakToOpleiding(id, vakId);
//        return ResponseEntity.ok(opleiding);
//    }

    @PostMapping("/{id}/vak")
    public ResponseEntity<OpleidingDto> addVakToOpleiding(@PathVariable("id") String id,@Validated @RequestBody Vak vak) {
        System.out.println(vak.getId());
        OpleidingDto opleiding = opleidingService.addVakToOpleiding(id, vak);
        return ResponseEntity.ok(opleiding);
    }

    @DeleteMapping("/{id}/vak/{vakId}")
    public ResponseEntity<OpleidingDto> removeVakFromOpleiding(@PathVariable String id, @PathVariable String vakId) {
        OpleidingDto opleiding = opleidingService.removeVakFromOpleiding(id, vakId);
        return ResponseEntity.ok(opleiding);
    }

    @GetMapping("/{id}/vakken")
    public ResponseEntity<List<Vak>> getVakkenFromOpleiding(@PathVariable String id) {

        List<Vak> vakkenList = opleidingService.getVakkenFromOpleiding(id);

        if (!vakkenList.isEmpty()) {
            return ResponseEntity.ok(vakkenList);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
