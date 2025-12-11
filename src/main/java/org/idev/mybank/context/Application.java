package org.idev.mybank.context;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.idev.mybank.service.TransactionService;
import org.idev.mybank.service.UserService;

public class Application {
    public static final UserService userService = new UserService();
    public static final TransactionService transactionService = new TransactionService(userService);
    public static final ObjectMapper objMap = JsonMapper.builder()
                                                .addModule(new JavaTimeModule())
                                                .build();
}
