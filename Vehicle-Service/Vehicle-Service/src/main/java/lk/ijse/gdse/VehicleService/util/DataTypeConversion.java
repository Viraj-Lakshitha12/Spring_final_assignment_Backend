package lk.ijse.gdse.VehicleService.util;
import lk.ijse.gdse.VehicleService.dto.VehicleDTO;
import lk.ijse.gdse.VehicleService.entity.Vehicle;
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

    public VehicleDTO getVehicleDTO(Vehicle vehicle){
        return modelMapper.map(vehicle, VehicleDTO.class);
    }
    public Vehicle getVehicleEntity(VehicleDTO vehicleDTO){
        return modelMapper.map(vehicleDTO, Vehicle.class);
    }
}
