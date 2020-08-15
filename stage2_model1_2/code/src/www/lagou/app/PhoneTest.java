package www.lagou.app;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import www.lagou.JavaBean.Phone;
import www.lagou.utils.DruidUtils;

import java.sql.SQLException;
import java.util.List;

public class PhoneTest {

    // 需求1:  查询价格高于2000元，生产日期是2019年之前的所有手机
    public List<Phone> getPhoneByPriceAndYear(double price, String date) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from phone where price > ? and date(prodate) < ?";
        Object[] param = {price,date};
        return qr.query(sql,new BeanListHandler<Phone>(Phone.class),param);
    }
    // 需求2:  查询所有颜色是白色的手机信息
    public List<Phone> getPhoneByColor(String color) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from phone where color = ?";
        return qr.query(sql,new BeanListHandler<Phone>(Phone.class),color);
    }
}
