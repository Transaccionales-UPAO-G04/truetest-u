package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.UsuarioDTO;
import grupo04.truetestu.model.entity.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    private final ModelMapper modelMapper;

    public UsuarioMapper() {

        this.modelMapper = new ModelMapper();
    }

    public UsuarioDTO toDTO(Usuario usuario) {

        return modelMapper.map(usuario, UsuarioDTO.class);
    }

    public Usuario toEntity(UsuarioDTO usuarioDTO) {

        return modelMapper.map(usuarioDTO, Usuario.class);
    }

}
