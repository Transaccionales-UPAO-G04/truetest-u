package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.EstudianteDTO;  // Asegúrate de tener esta importación
import grupo04.truetestu.dto.UsuarioProfileDTO;
import grupo04.truetestu.dto.UsuarioRegistrationDTO;
import grupo04.truetestu.model.entity.Usuario;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UsuarioMapper {
    private final ModelMapper modelMapper;

    // Convertir de UsuarioRegistrationDTO a Usuario
    public Usuario toUsuarioEntity(UsuarioRegistrationDTO usuarioRegistrationDTO) {
        return modelMapper.map(usuarioRegistrationDTO, Usuario.class);
    }

    // Convertir de Usuario a UsuarioProfileDTO
    public UsuarioProfileDTO toUsuarioProfileDTO(Usuario usuario) {
        UsuarioProfileDTO usuarioProfileDTO = modelMapper.map(usuario, UsuarioProfileDTO.class);

        // Convertir la información de Mentor si está disponible
        if(usuario.getMentor() != null) {
            usuarioProfileDTO.setNombre(usuario.getMentor().getNombre());
            usuarioProfileDTO.setEspecialidad(usuario.getMentor().getEspecialidad());
            usuarioProfileDTO.setExperiencia(usuario.getMentor().getExperiencia());
            usuarioProfileDTO.setLinkRecurso(usuario.getMentor().getLinkRecurso());
            usuarioProfileDTO.setLinkRecursoPremium(usuario.getMentor().getLinkRecursoPremium());
        }

        // Convertir la información de Estudiante si está disponible
        if(usuario.getEstudiante() != null) {
            usuarioProfileDTO.setNombre(usuario.getEstudiante().getNombre());
        }

        return usuarioProfileDTO;
    }

    // Convertir de EstudianteDTO a Usuario
    public Usuario toUsuarioEntityFromEstudianteDTO(EstudianteDTO estudianteDTO) {
        // Convertir EstudianteDTO a Usuario
        Usuario usuario = modelMapper.map(estudianteDTO, Usuario.class);

        // Puedes agregar lógica adicional si necesitas manejar la conversión de campos específicos
        return usuario;
    }

    // Convertir de Usuario a EstudianteDTO
    public EstudianteDTO toEstudianteDTO(Usuario usuario) {
        // Convertir Usuario a EstudianteDTO
        EstudianteDTO estudianteDTO = modelMapper.map(usuario, EstudianteDTO.class);

        // Si se requiere agregar más detalles o lógica personalizada, se puede hacer aquí
        return estudianteDTO;
    }
}
