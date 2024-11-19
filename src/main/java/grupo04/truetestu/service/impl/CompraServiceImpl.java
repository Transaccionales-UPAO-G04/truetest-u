package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.dto.CompraCreateUpdateDTO;
import grupo04.truetestu.dto.CompraDTO;
import grupo04.truetestu.dto.CompraReportDTO;
import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.mapper.CompraMapper;
import grupo04.truetestu.model.entity.Compra;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Usuario;
import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.model.enums.EstadoPago;
import grupo04.truetestu.repository.CompraRepository;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.repository.UsuarioRepository;
import grupo04.truetestu.repository.PlanRepository;
import grupo04.truetestu.service.CompraService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    private final UsuarioRepository usuarioRepository;
    private final CompraMapper compraMapper;
    private final PlanRepository planRepository;
    private final EstudianteRepository estudianteRepository;

    @Override
    @Transactional
    public CompraDTO createCompra(CompraCreateUpdateDTO compraDTO) {
        // Convertir el DTO en una entidad Compra
        Compra compra = compraMapper.toCompraEntity(compraDTO);

        // Obtener el EstudianteDTO desde el DTO de la compra
        EstudianteDTO estudianteDTO = compraDTO.getEstudiante();  // Esto obtiene el EstudianteDTO del DTO de la compra

        // Buscar al Usuario correspondiente usando el 'email' del EstudianteDTO
        Usuario usuario = usuarioRepository.findByEmail(estudianteDTO.getEmail()) // Busca el Usuario usando el email
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado con email: " + estudianteDTO.getEmail()));

        // Asociar el Usuario con la compra
        compra.setUsuario(usuario);  // Aquí asignamos el Usuario, no el EstudianteDTO

        // Verificar si los planes existen en la base de datos antes de proceder
        compra.getItems().forEach(item -> {
            Plan plan = planRepository.findById(item.getPlan().getIdPlan())  // Verificar el plan por ID
                    .orElseThrow(() -> new RuntimeException("Plan no encontrado con ID: " + item.getPlan().getIdPlan()));
            item.setPlan(plan); // Asociar el plan existente al CompraItem
            item.setCompra(compra); // Asociar el CompraItem a la compra actual
        });

        // Establecer la fecha de creación y el estado del pago
        compra.setCreatedAt(LocalDateTime.now());
        compra.setEstadoPago(EstadoPago.PENDIENTE);

        // Guardar la compra en la base de datos
        Compra savedCompra = compraRepository.save(compra);

        // Retornar el DTO mapeado
        return compraMapper.toCompraDTO(savedCompra);
    }



    /* @Override
    @Transactional(readOnly = true)
    public List<PurchaseDTO> getPurchaseHistoryByUserId(Integer userId) {
        return purchaseRepository.findByUserId(userId)
                .stream()
                .map(purchaseMapper::toPurchaseDTO)
                .collect(Collectors.toList());
    }*/

    @Override
    @Transactional(readOnly = true)
    public List<CompraDTO> getCompraHistoryByUsuarioId() {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = null;

        if (authentication != null && !authentication.getPrincipal().equals("anonymousUser")) {
            usuario = usuarioRepository.findByEmail(authentication.getName())
                    .orElseThrow(ResourceNotFoundException::new);
        }

        return compraRepository.findByUsuarioId(usuario.getId()).stream()
                .map(compraMapper::toCompraDTO)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraReportDTO> getCompraReportByDate() {
        // Obtener reporte de compras
        List<Object[]> results = compraRepository.getCompraReportByDate();

        return results.stream()
                .map(result -> new CompraReportDTO(
                        ((Integer) result[0]).intValue(),  // Cantidad
                        (String) result[1]                // Fecha
                ))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<CompraDTO> getAllCompras() {
        // Obtener todas las compras
        return compraRepository.findAll()
                .stream()
                .map(compraMapper::toCompraDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CompraDTO getCompraById(Integer id) {
        // Obtener una compra por su ID
        Compra compra = compraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Compra no encontrada"));
        return compraMapper.toCompraDTO(compra);
    }

    @Override
    @Transactional
    public CompraDTO confirmCompra(Integer compraId) {
        // Confirmar la compra por su ID
        Compra compra = compraRepository.findById(compraId)
                .orElseThrow(() -> new ResourceNotFoundException("Compra no encontrada"));

        // Cambiar el estado de pago
        compra.setEstadoPago(EstadoPago.PAGADO);

        // Guardar y retornar el DTO actualizado
        Compra updatedCompra = compraRepository.save(compra);
        return compraMapper.toCompraDTO(updatedCompra);
    }
}
