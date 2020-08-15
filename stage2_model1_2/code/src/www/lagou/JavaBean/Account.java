package www.lagou.JavaBean;

import java.io.Serializable;

public class Account implements Serializable {

    // 定义成员变量
    private int id ;
    private String username;
    private String card;
    private double balance;

    // 构造有参或无参方法
    public Account() {
    }
    public Account(int id,String username,String card,double balance){
        this.id = id;
        this.username = username;
        this.card = card;
        this.balance = balance;
    }
    // get、set方法
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getCard() {
        return card;
    }
    public void setCard(String card) {
        this.card = card;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    //重写toString方法

    @Override
        public String toString() {
            return "Account{" +
                    "id=" + id +
                    ", username='" + username + '\'' +
                    ",card='" + card + '\'' +
                    "balance=" + balance +
                    '}';
    }
}
