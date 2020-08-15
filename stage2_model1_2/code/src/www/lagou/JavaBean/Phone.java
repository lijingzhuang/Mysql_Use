package www.lagou.JavaBean;

import java.io.Serializable;

public class Phone implements Serializable{

        // 定义变量
        private int id;
        private String pname;
        private double price;
        private String prodate;
        private String color;
        //构造参数方法

        public Phone() {
        }

        public Phone(int id, String pname, double price, String prodate, String color) {
            this.id = id;
            this.pname = pname;
            this.price = price;
            this.prodate = prodate;
            this.color = color;
        }

        //get和set方法
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public String getPname() {
            return pname;
        }
        public void setPname(String pname) {
            this.pname = pname;
        }

        public double getPrice() {
            return price;
        }
        public void setPrice(double price) {
            this.price = price;
        }

        public String getProdate() {
            return prodate;
        }

        public void setProdate(String prodate) {
            this.prodate = prodate;
        }

        public String getColor() {
            return color;
        }
        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "PhoneUtils{" +
                    "id=" + id +
                    ", pname='" + pname + '\'' +
                    ", price=" + price +
                    ", prodate='" + prodate + '\'' +
                    ", color='" + color + '\'' +
                    '}';
        }
}
