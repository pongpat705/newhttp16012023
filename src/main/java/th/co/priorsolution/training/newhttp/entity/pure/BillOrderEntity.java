package th.co.priorsolution.training.newhttp.entity.pure;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BillOrderEntity {

    private Integer orderId;
    private Integer billId;
    private String status;
    private LocalDateTime orderDate;
}
