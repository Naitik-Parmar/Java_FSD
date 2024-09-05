package com.example.demo.BankRepo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entities.Bank;

@Repository
public interface BankRepository extends CrudRepository<Bank, Integer>{

}
