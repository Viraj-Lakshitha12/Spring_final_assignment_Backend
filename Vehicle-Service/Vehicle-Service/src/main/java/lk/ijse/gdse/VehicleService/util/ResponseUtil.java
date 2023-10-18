package lk.ijse.gdse.VehicleService.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class ResponseUtil {
    private int code;
    private String massage;
    private Object data;
}
