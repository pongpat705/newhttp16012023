package th.co.priorsolution.training.newhttp.repositroy.impl;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import th.co.priorsolution.training.newhttp.entity.pure.TableBillEntity;
import th.co.priorsolution.training.newhttp.repositroy.TableBillNativeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class TableBillNativeRepositoryImpl implements TableBillNativeRepository {

    private JdbcTemplate jdbcTemplate;

    public TableBillNativeRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertTableBill(TableBillEntity tableBillEntity) {

        List<Object> paramList = new ArrayList<>();

        StringBuilder sb = new StringBuilder();
        sb.append("  insert into table_bill  ");
        sb.append("  (table_id, bill_date, waitress_id)   ");
        sb.append("  value   ");
        sb.append("  (?, ?, ?)  ");
        paramList.add(tableBillEntity.getTableId());
        paramList.add(tableBillEntity.getBillDate());
        paramList.add(tableBillEntity.getWaitressId());

        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

        int insertedRow = this.jdbcTemplate.update(
                con -> this.prepareForInsertTableBill(sb.toString(), con, paramList)
                , generatedKeyHolder);
        log.info("insertTableBill affect {} row", insertedRow);

        return generatedKeyHolder.getKey().intValue();
    }
    private PreparedStatement prepareForInsertTableBill(String sql, Connection connection, List<Object> paramList) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        for (int i = 0; i < paramList.size(); i++) {
            int sqlI = i+1;
            preparedStatement.setObject(sqlI, paramList.get(i));
        }
        return preparedStatement;
    }
}
