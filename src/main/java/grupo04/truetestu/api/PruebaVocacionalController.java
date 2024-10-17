package grupo04.truetestu.api;

import grupo04.truetestu.dto.PreguntaDTO;
import grupo04.truetestu.dto.PruebaVocacionalDTO;
import grupo04.truetestu.dto.RespuestaDTO;
import grupo04.truetestu.service.PruebaVocacionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prueba-vocacional")
public class PruebaVocacionalController {

    @Autowired
    private PruebaVocacionalService pruebaVocacionalService;

    @GetMapping
    public List<PruebaVocacionalDTO> obtenerPruebasVocacionales() {
        return pruebaVocacionalService.obtenerPruebasVocacionales();
    }

    @PostMapping
    public PruebaVocacionalDTO crearPruebaVocacional(@RequestBody PruebaVocacionalDTO pruebaVocacionalDTO) {
        return pruebaVocacionalService.crearPruebaVocacional(pruebaVocacionalDTO);
    }

    @GetMapping("/preguntas")
    public List<PreguntaDTO> obtenerPreguntas() {
        return pruebaVocacionalService.obtenerPreguntas(); // Método para obtener preguntas
    }

    @PostMapping("/responder")
    public void responderPregunta(@RequestBody RespuestaDTO respuestaDTO) {
        pruebaVocacionalService.guardarRespuesta(respuestaDTO); // Método para guardar respuesta
    }

    @PostMapping("/resultado")
    public PruebaVocacionalDTO obtenerResultado(@RequestBody List<RespuestaDTO> respuestas) {
        return pruebaVocacionalService.calcularResultado(respuestas); // Método para calcular resultado
    }
}








