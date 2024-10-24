package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.MentorDTO;
import grupo04.truetestu.model.entity.Mentor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MentorMapper {
    private final ModelMapper modelMapper;

    public MentorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MentorDTO toDTO(Mentor mentor) {
        return modelMapper.map(mentor, MentorDTO.class);
    }

    public Mentor toEntity(MentorDTO mentorDTO) {
        return modelMapper.map(mentorDTO, Mentor.class);
    }

}
