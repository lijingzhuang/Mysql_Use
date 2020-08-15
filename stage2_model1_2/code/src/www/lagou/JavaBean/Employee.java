package www.lagou.JavaBean;

import javax.swing.*;
import java.io.Serializable;

public class Employee implements Serializable {

        // 定义变量
        private int id;
        private String name;
        private double age;
        private String sex;
        private double salary;
        private String data;
        private int did;          //外键
        private Dept dept;

        public Employee() {
        }

    public Employee(int id, String name, double age, String sex, double salary, String data, int did, Dept dept) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
        this.data = data;
        this.did = did;
        this.dept = dept;
    }

    //get set方法
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public double getAge() {
            return age;
        }
        public void setAge(double age) {
            this.age = age;
        }

        public String getSex() {
            return sex;
        }
        public void setSex(String sex) {
            this.sex = sex;
        }

        public double getSalary() {
            return salary;
        }
        public void setSalary(double salary) {
            this.salary = salary;
        }

        public String getData() {
            return data;
        }
        public void setData(String data) {
            this.data = data;
        }

        public int getDid() {
            return did;
        }
        public void setDid(int did) {
            this.did = did;
        }

        public Dept getDept() {
             return dept;
        }
        public void setDept(Dept dept) {
            this.dept = dept;
        }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", salary=" + salary +
                ", data='" + data + '\'' +
                ", did=" + did +
                ", dept=" + dept +
                '}';
    }
}
