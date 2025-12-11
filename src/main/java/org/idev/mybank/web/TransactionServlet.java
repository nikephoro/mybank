package org.idev.mybank.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.idev.mybank.model.Transaction;
import org.idev.mybank.service.TransactionService;

import java.io.IOException;
import java.util.List;

public class TransactionServlet extends HttpServlet {

    private final TransactionService trSrv = new TransactionService();
    private final ObjectMapper objMap = JsonMapper.builder()
                                                    .addModule(new JavaTimeModule())
                                                    .build();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equals("/transactions/create")) {

            Double amount = Double.valueOf(request.getParameter("amount"));
            String reference = request.getParameter("reference");

            Transaction transaction = trSrv.createTransaction(amount,reference);

            response.setContentType("application/json; charset=UTF-8");
            String jsonRes = objMap.writeValueAsString(transaction);
            response.getWriter().print(jsonRes);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getRequestURI().equals("/transactions/findAll")) {

            List<Transaction> transactionList = trSrv.findAll();

            response.setContentType("application/json; charset=UTF-8");
            String jsonRes = objMap.writeValueAsString(transactionList);
            response.getWriter().print(jsonRes);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
        }

    }


}
