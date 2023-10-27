package lk.ijse.gdse.UserService.util;
import lk.ijse.gdse.UserService.dto.UserDTO;
import lk.ijse.gdse.UserService.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataTypeConversion {

    private final ModelMapper modelMapper;

    @Autowired
    public DataTypeConversion(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO getUserDTO(UserEntity user){
        return modelMapper.map(user, UserDTO.class);
    }
    public UserEntity getUserEntity(UserDTO userDTO){
        return modelMapper.map(userDTO, UserEntity.class);
    }

}
