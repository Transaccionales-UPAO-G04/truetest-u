package grupo04.truetestu.api;


import grupo04.truetestu.model.entity.ResultadoPrueba;
import grupo04.truetestu.service.ResultadoPruebaService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/resultadoPrueba")
public class ResultadoPruebaController {
    private final ResultadoPruebaService resultadoPruebaService;
    //Se inyecta las interfaces, no las clases

    @GetMapping
    public ResponseEntity<List<ResultadoPrueba>> getAllResultadoPrueba() {
        List<ResultadoPrueba> resultadoPruebas = resultadoPruebaService.getAll();
        return new ResponseEntity<List<ResultadoPrueba>>(resultadoPruebas, HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<ResultadoPrueba>> paginateResultadoPrueba(
            @PageableDefault(size=5, sort="name") Pageable pageable){
    Page<ResultadoPrueba> resultadoPruebaPage = resultadoPruebaService.paginate(pageable);
        return new ResponseEntity<Page<ResultadoPrueba>>(resultadoPruebaPage,HttpStatus.OK);

    }

}
