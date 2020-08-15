package www.lagou.app;

import org.junit.Test;
import www.lagou.JavaBean.Dept;
import www.lagou.JavaBean.Employee;
import www.lagou.JavaBean.Phone;
import www.lagou.JavaBean.Transaction;
import www.lagou.utils.DateUtils;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class test {

    /*
    *       编程题 1 测试
    * */
    //获取定义对象
    AccountTest account = new AccountTest();
    TransactionWrite transactionwrite = new TransactionWrite();
    @Test
    /*
    查询卡号余额
    * */
    public void testGetBalanceFromAccountCard() throws SQLException {
        System.out.println("卡号1122334455 的余额为：" + account.getBalanceFromAccountCard("1122334455"));
        System.out.println("卡号55443332211 的余额为：" + account.getBalanceFromAccountCard("55443332211"));
    }
    //  1
    @Test
    /*  测试卡号间转账
     * */
    public void testTransaction() throws SQLException {
        if(account.transforMoney("1122334455","55443332211",5000)){
            System.out.println("卡号 1122334455 已经向 卡号 55443332211 转账: 5000元" );
        }
        else {
            System.out.println("转账失败！");
        }
    }

    //2 将交易记录写入transaction
    @Test
    public void testAddTransaction() throws SQLException {
        Transaction transaction = new Transaction();
        transaction.setCardid("1122334455");
        transaction.setTratype("转出");
        transaction.setTramoney((double) 5000);
        transaction.setDatetime(DateUtils.getDateFormat());

        int result = transactionwrite.addTransaction(transaction);
        if(result > 0){
            System.out.println("交易记录增加成功！");
        }else {
            System.out.println("交易失败！");
        }

    }

    /*
    *           编程题 2 测试
    * */
    PhoneTest phoneTest = new PhoneTest();
    @Test  // 1
    public void testByPriceAndYear() throws SQLException {
        List<Phone> phoneUtils = phoneTest.getPhoneByPriceAndYear(2000,"2019");
        System.out.println("查询价格高于2000，生产日期是2019年之前的所有手机：");
        for(Phone phone:phoneUtils){
            System.out.println(phone);
        }
    }
    @Test // 2
    public void testByColor() throws SQLException {
        List<Phone> phoneUtils = phoneTest.getPhoneByColor("白色");
        phoneUtils.forEach(System.out :: println);
    }



    /*
    *           编程 3 测试
    * */
    EmployTest employTest = new EmployTest();
    Dept dept = new Dept();
    // 1
    @Test
    public void testgetAllEmployee() throws SQLException {
        System.out.println("1.查询所有员工信息，不包含没有部门的员工");
        employTest.getAllEmployee().forEach(System.out::println);
    }
    // 2
    @Test
    public void testgetNameSalaryAndDept() throws SQLException {
        List<Employee> employees = employTest.getAllEmployee();
        System.out.println("2.查询每个员工的姓名, 薪资和所属部门名称");
        for(Employee employee:employees){
            System.out.println("姓名：" + employee.getData() + ",薪资：" + employee.getSalary() +
                    ",所属部门：" + Optional.ofNullable(employee.getDept().getDeptname()).orElse("没有部门"));
        }
    }

}
