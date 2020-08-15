package www.lagou.app;
/*
       a) 使用连接池创建QueryRunner对象；
       b) 判断转出方是否有足够余额，如果不足，提示信息：”余额不足！”，并结束程序；
       c) 通过卡号 进行转账的操作；
       d) 转账结束后, 将转入、转出记录分别写入到Transaction表中。
* */
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;
import www.lagou.JavaBean.Account;
import www.lagou.JavaBean.Transaction;
import www.lagou.utils.DateUtils;
import www.lagou.utils.DruidUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Scanner;


public class AccountTest {

    public boolean transforMoney(String card1,String card2,double money) throws SQLException {
        //判断转账余额是否足够
        if(getBalanceFromAccountCard(card1) < money){
            System.out.println("余额不足！");
            return false;
        }
        //获取QuerRunner
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        Connection con = null;
        try {

            con = DruidUtils.getConnection();
            con.setAutoCommit(false);
            String sql = "update account set balance = balance + ? where card = ?";
            //转出操作
            Object[] param1 = {0 - money,card1};
            qr.update(con,sql,param1);
            Transaction transaction1 = new Transaction(card1,"转出",money, DateUtils.getDateFormat());
            //转入操作
            Object[] param2 = {money,card2};
            qr.update(con,sql,param2);
            Transaction transaction2 = new Transaction(card2,"转入",money, DateUtils.getDateFormat());
            //将转账结果写到transation表中
            TransactionWrite tw = new TransactionWrite();
            if(TransactionWrite.addTransaction(transaction1) > 0){
                System.out.println("转账记录已写入数据库！");
            }
            if(TransactionWrite.addTransaction(transaction2) > 0){
                System.out.println("转账记录已写入数据库！");
            }
            DbUtils.commitAndCloseQuietly(con);

        } catch (SQLException e) {
            //回滚
            DbUtils.rollbackAndCloseQuietly(con);
            e.printStackTrace();
            return false;
        } finally {
            DbUtils.closeQuietly(con);
        }
        return true;
    }

    public double getBalanceFromAccountCard(String card) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        //SQL语句
        String sql = "select balance from account where card = ?";
        return qr.query(sql, new ScalarHandler<Double>(),card);
    }
}
