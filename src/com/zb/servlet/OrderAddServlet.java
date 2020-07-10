package com.zb.servlet;

import com.zb.dao.OrderDao;
import com.zb.pojo.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/orderAdd")
public class OrderAddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String order_no = request.getParameter("orderNo");
        String order_type = request.getParameter("orderType");
        int pnum = Integer.parseInt(request.getParameter("pnum"));
        String cashier = request.getParameter("cashier");
        String pay_type = request.getParameter("payType");
        Double price = Double.parseDouble(request.getParameter("price"));
        Order order = new Order();
        order.setOrder_no(order_no);
        order.setOrder_type(order_type);
        order.setPnum(pnum);
        order.setCashier(cashier);
        order.setPay_type(pay_type);
        order.setPrice(price);
        OrderDao orderDao = new OrderDao();
        orderDao.addOrder(order);
        response.sendRedirect("orderList");
    }
}
