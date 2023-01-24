package th.co.priorsolution.training.newhttp.entity.pure;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TableBillEntity {
    private int billId;
    private int tableId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime billDate;
    private int waitressId;
}
