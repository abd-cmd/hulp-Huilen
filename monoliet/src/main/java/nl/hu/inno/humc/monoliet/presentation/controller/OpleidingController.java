package nl.hu.inno.humc.monoliet.presentation.controller;

import nl.hu.inno.humc.monoliet.application.OpleidingService;
import nl.hu.inno.humc.monoliet.domain.vak.Vak;
import nl.hu.inno.humc.monoliet.presentation.dto.OpleidingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opleidingen")
public class OpleidingController {

    private final OpleidingService opleidingService;

    public OpleidingController(OpleidingService opleidingService) {
        this.opleidingService = opleidingService;
    }

    @GetMapping
    public ResponseEntity<List<OpleidingDto>> getAllOpleidingen() {
        List<OpleidingDto> opleidingen = opleidingService.getAllOpleidingen();
        return ResponseEntity.ok(opleidingen);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpleidingDto> getOpleidingById(@PathVariable Long id) {
        OpleidingDto opleiding = opleidingService.getOpleidingById(id);
        return ResponseEntity.ok(opleiding);
    }

    @PostMapping
    public ResponseEntity<OpleidingDto> createOpleiding(@RequestBody OpleidingDto opleidingDTO) {
        OpleidingDto opleiding = opleidingService.createOpleiding(opleidingDTO);
        return ResponseEntity.ok(opleiding);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpleidingDto> updateOpleiding(@PathVariable Long id, @RequestBody OpleidingDto opleidingDto) {
        OpleidingDto opleiding = opleidingService.updateOpleiding(id, opleidingDto);
        return ResponseEntity.ok(opleiding);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpleiding(@PathVariable Long id) {
        opleidingService.deleteOpleiding(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/vak")
    public ResponseEntity<OpleidingDto> addVakToOpleiding(@PathVariable Long id, @Validated @RequestBody Vak vak) {
        OpleidingDto opleiding = opleidingService.addVakToOpleiding(id, vak);
        System.out.println("het vak is:"+vak.getNaam());
        System.out.println("het vakid is:"+vak.getId());

        return ResponseEntity.ok(opleiding);
    }

    @DeleteMapping("/{id}/vak/{vakId}")
    public ResponseEntity<OpleidingDto> removeVakFromOpleiding(@PathVariable Long id, @PathVariable Long vakId) {
        OpleidingDto opleiding = opleidingService.removeVakFromOpleiding(id, vakId);
        return ResponseEntity.ok(opleiding);
    }
}
