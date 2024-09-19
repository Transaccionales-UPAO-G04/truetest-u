package grupo04.truetestu.api;

////
import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.service.ResultadoPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/resultadoPrueba")
public class ResultadoPruebaController {
    private final ResultadoPruebaService resultadoPruebaService;
    //Se inyecta las interfaces, no las clases

    @GetMapping
    public ResponseEntity<List<ResultadoPrueba>> getAllResultadoPrueba() {
        List<ResultadoPrueba> resultadoPruebas = resultadoPruebaService.getAll();
        return new ResponseEntity<>(resultadoPruebas, HttpStatus.OK);
    }

    @GetMapping("/estudiante/{id}")
    public ResponseEntity<?> getResultadoPruebaByEstudianteId(@PathVariable("id") int id) {
        Optional<ResultadoPrueba> resultadoPruebaOpt = resultadoPruebaService.findByEstudianteId(id);
        if (resultadoPruebaOpt.isPresent()) {
            ResultadoPrueba resultadoPrueba = resultadoPruebaOpt.get();
            return new ResponseEntity<>(resultadoPrueba, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontraron resultados para el estudiante con ID: " + id, HttpStatus.NOT_FOUND);
        }
    }


}
