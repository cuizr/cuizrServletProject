package com.zb.pojo;

public class Order {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private int door_id;
    private String order_no;
    private String order_type;
    private int pnum;
    private String cashier;
    private String order_time;
    private String pay_time;
    private String pay_type;
    private Double price;

    public int getDoor_id() {
        return door_id;
    }

    public void setDoor_id(int door_id) {
        this.door_id = door_id;
    }

    public String getOrder_no() {
        return order_no;
    }

    public void setOrder_no(String order_no) {
        this.order_no = order_no;
    }

    public String getOrder_type() {
        return order_type;
    }

    public void setOrder_type(String order_type) {
        this.order_type = order_type;
    }

    public int getPnum() {
        return pnum;
    }

    public void setPnum(int pnum) {
        this.pnum = pnum;
    }

    public String getCashier() {
        return cashier;
    }

    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getPay_time() {
        return pay_time;
    }

    public void setPay_time(String pay_time) {
        this.pay_time = pay_time;
    }

    public String getPay_type() {
        return pay_type;
    }

    public void setPay_type(String pay_type) {
        this.pay_type = pay_type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", door_id=" + door_id +
                ", order_no='" + order_no + '\'' +
                ", order_type='" + order_type + '\'' +
                ", pnum=" + pnum +
                ", cashier='" + cashier + '\'' +
                ", order_time='" + order_time + '\'' +
                ", pay_time='" + pay_time + '\'' +
                ", pay_type='" + pay_type + '\'' +
                ", price=" + price +
                '}';
    }
}
