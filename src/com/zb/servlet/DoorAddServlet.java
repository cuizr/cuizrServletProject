package com.zb.servlet;

import com.zb.dao.DoorDao;
import com.zb.pojo.Door;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doorAdd")
public class DoorAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String tel = request.getParameter("tel");
        String addr = request.getParameter("addr");
        Door door =new Door();
        door.setName(name);
        door.setTel(tel);
        door.setAddr(addr);
        DoorDao doorDao = new DoorDao();
        doorDao.addDoor(door);
        response.sendRedirect("doorlist");
    }
}
