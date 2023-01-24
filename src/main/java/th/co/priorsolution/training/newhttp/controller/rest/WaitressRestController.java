package th.co.priorsolution.training.newhttp.controller.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import th.co.priorsolution.training.newhttp.entity.pure.TableBillEntity;
import th.co.priorsolution.training.newhttp.model.ResponseModel;
import th.co.priorsolution.training.newhttp.service.OrderService;

@RestController
@RequestMapping("/waitress/api")
public class WaitressRestController {
    private OrderService service;

    public WaitressRestController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/create-table-bill")
    public ResponseModel<Void> createTableBill(@RequestBody TableBillEntity tableBillEntity){
        return this.service.insertNewBill(tableBillEntity);
    }
}
