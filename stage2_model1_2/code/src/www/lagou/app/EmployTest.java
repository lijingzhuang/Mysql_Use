package www.lagou.app;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import www.lagou.JavaBean.Dept;
import www.lagou.JavaBean.Employee;
import www.lagou.utils.DruidUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EmployTest {

    //获取所有员工信息
    public List<Employee> getAllEmployee() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        Connection con = null;
        con = DruidUtils.getConnection();
        String sql = " select * from employee where did is not null";
        return qr.query(con,sql,new BeanListHandler<Employee>(Employee.class));
    }

    //获取员工ID
    public Dept finddeptById(int id) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        Connection con = null;
        con = DruidUtils.getConnection();
        String sql = "select * from dept where id = ?";
        Dept dept = qr.query(sql,new BeanHandler<>(Dept.class),id);
        if(dept == null){
            dept = new Dept();
        }
        return dept;
    }

    //获取员工姓名、薪资和所属部门
    public List<Employee> getNameSalaryAndDEPT() throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        Connection con = null;
        con = DruidUtils.getConnection();
        String sql = "select * from employee";
        List<Employee> employees =  qr.query(con,sql,new BeanListHandler<Employee>(Employee.class));

        //循环查询员工信息
        for(Employee employee:employees){
            employee.setDept(finddeptById(employee.getId()));
        }
        return employees;
    }


}
