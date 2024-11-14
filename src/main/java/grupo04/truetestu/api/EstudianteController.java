package grupo04.truetestu.api;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.enums.EstadoCuenta;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.service.EstudianteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")

public class EstudianteController {

    @Autowired
    private EstudianteService estudianteService;
//listar
    @Operation(summary = "Listar todos los estudiantes", description = "Devuelve una lista de todos los estudiantes registrados.")
    @GetMapping
    public ResponseEntity<List<EstudianteDTO>> listar() {
        List<EstudianteDTO> estudiantes = estudianteService.findAll();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }

//encontrar por id
    @GetMapping("/{id}")
    public ResponseEntity <EstudianteDTO> findById(@PathVariable int idEstudiante) {
        EstudianteDTO estudiante = estudianteService.findById(idEstudiante);
        return new ResponseEntity<>(estudiante, HttpStatus.OK);
    }
/*
    @Operation(summary = "Cambiar plan de un estudiante",
            description = "Cambia el plan de un estudiante por el ID proporcionado.",
            parameters = {
                    @Parameter(name = "id", description = "ID del estudiante", required = true),
                    @Parameter(name = "nuevoPlan", description = "Nuevo plan que se asignará al estudiante", required = true)
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Plan cambiado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })*/
    // Endpoint para cambiar el plan de un estudiante
   /*@PatchMapping("/{id}/cambiar-plan")
    public ResponseEntity<?> cambiarPlan(@PathVariable int id, @RequestParam EstadoPlan nuevoPlan) {
        estudianteService.cambiarPlan(id, nuevoPlan);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Cambiar estado de cuenta de un estudiante",
            description = "Inhabilita o habilita la cuenta de un estudiante por el ID proporcionado.",
            parameters = {
                    @Parameter(name = "id", description = "ID del estudiante", required = true),
                    @Parameter(name = "cambioEstadoCuenta", description = "Nuevo estado de la cuenta", required = true)
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estado de cuenta cambiado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })*/
  //inhabilitar mentor
  /*@PatchMapping("/{id}/cambiar-estadoCuenta")
  public ResponseEntity<?> cambiarCuenta(@PathVariable int id, @RequestParam EstadoCuenta cambioEstadoCuenta) {
      estudianteService.cambiarCuenta(id, cambioEstadoCuenta);
      return ResponseEntity.ok().build();
  }

    @Operation(summary = "Actualizar información de un estudiante",
            description = "Actualiza los datos de un estudiante por el ID proporcionado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Estudiante actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Estudiante no encontrado")
    })*/

//modificar
    @PutMapping("/{id}")
    public ResponseEntity<EstudianteDTO> updateEstudiante(@PathVariable int id,@Valid @RequestBody EstudianteDTO estudianteDTO) {
        EstudianteDTO updateEstudianteDTO = estudianteService.update(id, estudianteDTO);
        return new ResponseEntity<>(updateEstudianteDTO, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable int id) {
        estudianteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}