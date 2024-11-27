package grupo04.truetestu.service.impl;

import grupo04.truetestu.dto.EstudianteDTO;
import grupo04.truetestu.dto.PurchaseCreateUpdateDTO;
import grupo04.truetestu.dto.PurchaseDTO;
import grupo04.truetestu.dto.PurchaseReportDTO;
import grupo04.truetestu.exception.ResourceNotFoundException;
import grupo04.truetestu.mapper.PurchaseMapper;
import grupo04.truetestu.model.entity.Purchase;
import grupo04.truetestu.model.entity.Estudiante;
import grupo04.truetestu.model.entity.Usuario;
import grupo04.truetestu.model.entity.Plan;
import grupo04.truetestu.model.enums.EstadoPago;
import grupo04.truetestu.model.enums.EstadoPlan;
import grupo04.truetestu.repository.PurchaseRepository;
import grupo04.truetestu.repository.EstudianteRepository;
import grupo04.truetestu.repository.UsuarioRepository;
import grupo04.truetestu.repository.PlanRepository;
import grupo04.truetestu.service.PurchaseService;
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
public class PurchaseServiceImpl implements PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final UsuarioRepository usuarioRepository;
    private final PurchaseMapper purchaseMapper;
    private final PlanRepository planRepository;
    private final EstudianteRepository estudianteRepository;

    @Override
    @Transactional
    public PurchaseDTO createPurchase(PurchaseCreateUpdateDTO purchaseDTO) {
        // Convertir el DTO en una entidad purchase
        Purchase purchase = purchaseMapper.toPurchaseEntity(purchaseDTO);


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = null;

        if (authentication != null && !authentication.getPrincipal().equals("anonymousUser")) {
            usuario = usuarioRepository.findByEmail(authentication.getName())
                    .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
        }


        purchase.setUsuario(usuario); // Asociar el cliente a la compra

        // Verificar si los planes existen en la base de datos antes de proceder
        purchase.getItems().forEach(item -> {
            Plan plan = planRepository.findById(item.getPlan().getIdPlan())  // Verificar el plan por ID
                    .orElseThrow(() -> new RuntimeException("Plan no encontrado con ID: " + item.getPlan().getIdPlan()));
            item.setPlan(plan); // Asociar el plan existente al purchaseItem
            item.setPurchase(purchase); // Asociar el purchaseItem a la purchase actual
        });

        // Establecer la fecha de creación y el estado del pago
        purchase.setCreatedAt(LocalDateTime.now());
        purchase.setEstadoPago(EstadoPago.PENDIENTE);

        // Guardar la purchase en la base de datos
        Purchase savedPurchase = purchaseRepository.save(purchase);

        // Retornar el DTO mapeado
        return purchaseMapper.toPurchaseDTO(savedPurchase);
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
    public List<PurchaseDTO> getPurchaseHistoryByUserId() {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario usuario = null;

        if (authentication != null && !authentication.getPrincipal().equals("anonymousUser")) {
            usuario = usuarioRepository.findByEmail(authentication.getName())
                    .orElseThrow(ResourceNotFoundException::new);
        }

        return purchaseRepository.findByUsuarioId(usuario.getId()).stream()
                .map(purchaseMapper::toPurchaseDTO)
                .toList();
    }
    /*
    @Override
    @Transactional(readOnly = true)
    public List<PurchaseDTO> getAllPurchases() {
        // Obtener todas las purchase
        return purchaseRepository.findAll()
                .stream()
                .map(purchaseMapper::toPurchaseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public PurchaseDTO getPurchaseById(Integer id) {
        // Obtener una purchase por su ID
        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("purchase no encontrada"));
        return purchaseMapper.toPurchaseDTO(purchase);
    }
*/
    @Override
    @Transactional
    public PurchaseDTO confirmPurchase(Integer purchaseId) {
        // Confirmar la purchase por su ID
        Purchase purchase = purchaseRepository.findById(purchaseId)
                .orElseThrow(() -> new ResourceNotFoundException("purchase no encontrada"));




        // Cambiar el estado de pago
        purchase.setEstadoPago(EstadoPago.PAGADO);

        // Actualizar el estado del plan del usuario
        Usuario usuario = purchase.getUsuario();
        if (usuario != null && usuario.getEstudiante() != null) {
            Estudiante estudiante = usuario.getEstudiante();

            estudiante.setEstadoPlan(EstadoPlan.PREMIUM); // Cambiar el estado del plan
            estudianteRepository.save(estudiante); // Guardar el cambio en la base de datos
        }

        // Guardar y retornar el DTO actualizado
        Purchase updatedPurchase = purchaseRepository.save(purchase);
        return purchaseMapper.toPurchaseDTO(updatedPurchase);
    }
}
