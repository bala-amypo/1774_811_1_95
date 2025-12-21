package com.example.demo.service;

import java.util.List;
import com.example.demo.model.TransactionLog;

public interface TransactionService {

    TransactionLog save(TransactionLog transaction);

    List<TransactionLog> findAll();
}
