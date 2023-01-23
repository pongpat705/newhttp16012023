package th.co.priorsolution.training.newhttp.entity.pure;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TableBillEntity {
    private int billId;
    private int tableId;
    private LocalDateTime billDate;
    private int waitressId;
}
