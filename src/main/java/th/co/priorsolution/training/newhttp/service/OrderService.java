package th.co.priorsolution.training.newhttp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import th.co.priorsolution.training.newhttp.entity.pure.BillOrderEntity;
import th.co.priorsolution.training.newhttp.entity.pure.TableBillEntity;
import th.co.priorsolution.training.newhttp.model.ResponseModel;
import th.co.priorsolution.training.newhttp.repositroy.TableBillNativeRepository;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Service
@Slf4j
public class OrderService {

    private TableBillNativeRepository tableBillNativeRepository;

    public OrderService(TableBillNativeRepository tableBillNativeRepository) {
        this.tableBillNativeRepository = tableBillNativeRepository;
    }

    public ResponseModel<Void>  insertNewBill(TableBillEntity tableBillEntity){
        ResponseModel<Void> result = new ResponseModel<>();

        result.setStatus(201);
        result.setDescription("ok");
        try {
            // do some business
            this.insertTableBill(tableBillEntity);
//            insert billOrder
//
        } catch (Exception e){
            e.printStackTrace();
            result.setStatus(500);
            result.setDescription(e.getMessage());
        }
        return result;
    }

    @Transactional(rollbackFor = SQLException.class, propagation = Propagation.REQUIRES_NEW)
    public void insertTableBill(TableBillEntity tableBillEntity) throws IOException {

        int tableBillId = this.tableBillNativeRepository.insertTableBill(tableBillEntity);

        //            insert billOrder
        BillOrderEntity billOrderEntity = new BillOrderEntity();
        billOrderEntity.setBillId(tableBillId);
        billOrderEntity.setStatus("NEW");
        billOrderEntity.setOrderDate(LocalDateTime.now());
//        int billOrderId = this.orderBillNativeRepository.insertBillOrder(billOrderEntity);



    }
}
