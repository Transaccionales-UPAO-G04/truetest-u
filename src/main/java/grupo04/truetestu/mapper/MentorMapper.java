package grupo04.truetestu.mapper;

import grupo04.truetestu.dto.MentorDetailsDTO;
import grupo04.truetestu.model.entity.Mentor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MentorMapper {
    private final ModelMapper modelMapper;

    public MentorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public MentorDetailsDTO toDTO(Mentor mentor) {
        return modelMapper.map(mentor, MentorDetailsDTO.class);
    }

    public Mentor toEntity(MentorDetailsDTO mentorDetailsDTO) {
        return modelMapper.map(mentorDetailsDTO, Mentor.class);
    }

}
