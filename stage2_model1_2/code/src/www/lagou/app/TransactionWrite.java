package www.lagou.app;


import com.alibaba.druid.sql.visitor.functions.Concat;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import www.lagou.JavaBean.Account;
import www.lagou.JavaBean.Transaction;
import www.lagou.utils.DruidUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransactionWrite {

    public static int addTransaction(Transaction transaction) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        Connection con = null;
        con = DruidUtils.getConnection();
        String sql = "insert into transaction(cardid,tratype,tramoney,tradate) values(?,?,?,?)";
        Object[] params = {transaction.getCardid(),transaction.getTratype(),transaction.getTramoney(),
                transaction.getDatetime()};
        return qr.update(sql,params);
    }

}
