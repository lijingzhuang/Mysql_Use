package www.lagou.JavaBean;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable {

    //定义成员变量
    private int id;
    private String cardid;
    private String tratype;
    private Double tramoney;
    private String datetime;

    public Transaction() {
    }
    public Transaction(String cardid,String tratype,Double tramoney,String datetime){
        this.cardid = cardid;
        this.tratype = tratype;
        this.tramoney = tramoney;
        this.datetime = datetime;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getCardid() {
        return cardid;
    }
    public void setCardid(String cardid) {
        this.cardid = cardid;
    }

    public String getTratype() {
        return tratype;
    }
    public void setTratype(String tratype) {
        this.tratype = tratype;
    }

    public Double getTramoney() {
        return tramoney;
    }
    public void setTramoney(Double tramoney) {
        this.tramoney = tramoney;
    }

    public String getDatetime() {
        return datetime;
    }
    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "cardid=" + cardid +
                ", tratype='" + tratype + '\'' +
                ",tramoney='" + tramoney + '\'' +
                "datetime=" + datetime +
                '}';
    }
}
