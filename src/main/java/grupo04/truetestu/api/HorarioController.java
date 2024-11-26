package grupo04.truetestu.api;

import grupo04.truetestu.dto.HorarioDTO;
import grupo04.truetestu.service.HorarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/horarios")
public class HorarioController {
    private final HorarioService horarioService;

    public HorarioController(HorarioService horarioService) {
        this.horarioService = horarioService;
    }

    @PostMapping("/{idMentor}")
    @PreAuthorize("hasAnyRole('MENTOR')")
    public ResponseEntity<HorarioDTO> createHorario(@PathVariable int idMentor, @RequestBody HorarioDTO horarioDTO) {
        return new ResponseEntity<>(horarioService.createHorario(horarioDTO, idMentor), HttpStatus.CREATED);
    }

    @PutMapping("/{idHorario}/mentor/{idMentor}")
    public ResponseEntity<HorarioDTO> updateHorario(
            @PathVariable int idHorario, @PathVariable int idMentor, @RequestBody HorarioDTO horarioDTO) {
        return ResponseEntity.ok(horarioService.updateHorario(idHorario, horarioDTO, idMentor));
    }

    @DeleteMapping("/{idHorario}/mentor/{idMentor}")
    public ResponseEntity<Void> deleteHorario(@PathVariable int idHorario, @PathVariable int idMentor) {
        horarioService.deleteHorario(idHorario, idMentor);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/mentor/{idMentor}")
    public ResponseEntity<List<HorarioDTO>> getHorariosByMentorId(@PathVariable int idMentor) {
        return ResponseEntity.ok(horarioService.getHorariosByMentorId(idMentor));
    }
}