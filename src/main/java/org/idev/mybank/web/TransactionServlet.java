package org.idev.mybank.web;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.idev.mybank.context.Application;
import org.idev.mybank.model.Transaction;
import org.idev.mybank.model.User;

import java.io.IOException;
import java.util.List;



public class TransactionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        if (request.getRequestURI().equals("/users/create")) {
            String name = request.getParameter("name");
            String id = request.getParameter("id");

            User user = Application.userService.createUser(id,name);

            response.setContentType("application/json; charset=UTF-8");
            String jsonRes = Application.objMap.writeValueAsString(user);
            response.getWriter().print(jsonRes);

        } else if (request.getRequestURI().equals("/transactions/create")) {

            Double amount = Double.valueOf(request.getParameter("amount"));
            String reference = request.getParameter("reference");
            String userId = request.getParameter("userId");

            Transaction transaction = Application.transactionService.createTransaction(amount,reference,userId);

            response.setContentType("application/json; charset=UTF-8");
            String jsonRes = Application.objMap.writeValueAsString(transaction);
            response.getWriter().print(jsonRes);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equals("/transactions/findAll")) {

            List<Transaction> transactionList = Application.transactionService.findAll();

            response.setContentType("application/json; charset=UTF-8");
            String jsonRes = Application.objMap.writeValueAsString(transactionList);
            response.getWriter().print(jsonRes);
        } else if (request.getRequestURI().equals("/users/findAll")){

            List<User> userList  = Application.userService.findAllUsers();

            response.setContentType("application/json; charset=UTF-8");
            String jsonRes = Application.objMap.writeValueAsString(userList);
            response.getWriter().print(jsonRes);
        } else{
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }


}
