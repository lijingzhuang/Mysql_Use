package www.lagou.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {

    public static DataSource dataSource;

    static {
        try {
            //创建属性类对象
            Properties properties = new Properties();
            //加载配置文件Druid连接池
            InputStream inputStream = DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
    //获取连接对象方法
    public static DataSource getDataSource(){
        return dataSource;
    }

    //释放资源方法
    public static void close(Connection con, Statement statement){
        if(null != con && null != statement){
            try {
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection con, Statement statement, ResultSet resultSet){
        if(null != con && null != statement && null != resultSet){
            try {
                resultSet.close();
                statement.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
