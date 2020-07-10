package com.zb.dao;

import com.zb.pojo.Door;
import com.zb.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoorDao {


    public List<Door> findAll() throws Exception {
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "select * from tb_door";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        Door door =null;
        List<Door> list = new ArrayList<>();
        while (rs.next()){
            door =new Door();
            door.setId(rs.getInt("id"));
            door.setName(rs.getString("name"));
            door.setTel(rs.getString("tel"));
            door.setAddr(rs.getString("addr"));
            list.add(door);
        }
        DBUtils.close(conn);

        return list;

    }
    public void addDoor(Door door){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "insert into tb_door value (null,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1,door.getName());
            ps.setString(2,door.getTel());
            ps.setString(3,door.getAddr());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }

    }
    public void Delete(Integer id){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "delete from tb_door where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }

    }
    public Door findById(Integer id){
        Connection conn = DBUtils.getConnectionByDatasource();
        Door door = new Door();
        String sql = "select  * from tb_door where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                door.setId(rs.getInt("id"));
                door.setName(rs.getString("name"));
                door.setTel(rs.getString("tel"));
                door.setAddr(rs.getString("addr"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
        return door;
    }
    public void updateById(Door door){
        Connection conn = DBUtils.getConnectionByDatasource();
        String sql = "update tb_door set name =?,tel=?,addr=? where id=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,door.getName());
            ps.setString(2,door.getTel());
            ps.setString(3,door.getAddr());
            ps.setInt(4,door.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtils.close(conn);
        }
    }
}
