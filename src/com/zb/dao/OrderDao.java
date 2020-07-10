package com.zb.dao;

import com.zb.pojo.Order;
import com.zb.utils.DBUtils;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDao {
    public List<Order> findAll(){
        Connection connection =null;
        List<Order> list =null;
        Order order =null;
        try {
            connection = DBUtils.getConnectionByDatasource();
            String sql = "select *from tb_order";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            list = new ArrayList<>();
            while (rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setDoor_id(rs.getInt("door_id"));
                order.setOrder_no(rs.getString("order_no"));
                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));
                order.setOrder_time(rs.getString("order_time"));
                order.setPay_time(rs.getString("pay_time"));
                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));
                list.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection);

        }
        return list;
    }
    public void addOrder(Order order){
        Connection connection = DBUtils.getConnectionByDatasource();
        String sql="insert into tb_order value (null,null,?,?,?,?,?,?,?,?);";
        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String date = df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,order.getOrder_no());
            ps.setString(2,order.getOrder_type());
            ps.setInt(3,order.getPnum());
            ps.setString(4,order.getCashier());
            ps.setString(5,date);
            ps.setString(6,date);
            ps.setString(7,order.getPay_type());
            ps.setDouble(8,order.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection);
        }
    }
    public void deleteOrder(Integer id){
        Connection connection = DBUtils.getConnectionByDatasource();
        String sql ="delete from tb_order where id=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(connection);
        }
    }
    public Order findById(Integer id){
        Connection connection = DBUtils.getConnectionByDatasource();
        Order order =null;
        String sql="select *from tb_order where id=?";
        try {
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            while (rs.next()){
                order = new Order();
                order.setId(rs.getInt("id"));
                order.setDoor_id(rs.getInt("door_id"));
                order.setOrder_no(rs.getString("order_no"));
                order.setOrder_type(rs.getString("order_type"));
                order.setPnum(rs.getInt("pnum"));
                order.setCashier(rs.getString("cashier"));
                order.setOrder_time(rs.getString("order_time"));
                order.setPay_time(rs.getString("pay_time"));
                order.setPay_type(rs.getString("pay_type"));
                order.setPrice(rs.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }
    public void UpdateById(Order order){
        Connection connection =DBUtils.getConnectionByDatasource();
        String sql ="update tb_order set order_no=?,order_type=?,pnum=?,cashier=?,order_time=?," +
                "pay_time=?,pay_type=?,price=? where id=? ";
        try {
            PreparedStatement ps =connection.prepareStatement(sql);
            ps.setString(1,order.getOrder_no());
            ps.setString(2,order.getOrder_type());
            ps.setInt(3,order.getPnum());
            ps.setString(4,order.getCashier());
            ps.setString(5,order.getOrder_time());
            ps.setString(6,order.getPay_time());
            ps.setString(7,order.getPay_type());
            ps.setDouble(8,order.getPrice());
            ps.setInt(9,order.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtils.close(connection);
        }
    }

}
