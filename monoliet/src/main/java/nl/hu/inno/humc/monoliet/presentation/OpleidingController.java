package nl.hu.inno.humc.monoliet.presentation;

import nl.hu.inno.humc.monoliet.application.OpleidingService;
import nl.hu.inno.humc.monoliet.presentation.dto.OpleidingDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/opleiding")
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
        OpleidingDto savedOpleiding = opleidingService.createOpleiding(opleidingDTO);
        return ResponseEntity.ok(savedOpleiding);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpleidingDto> updateOpleiding(@PathVariable Long id, @RequestBody OpleidingDto opleidingDto) {
        OpleidingDto updatedOpleiding = opleidingService.updateOpleiding(id, opleidingDto);
        return ResponseEntity.ok(updatedOpleiding);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOpleiding(@PathVariable Long id) {
        opleidingService.deleteOpleiding(id);
        return ResponseEntity.noContent().build();
    }
}
