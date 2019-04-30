package br.com.fiap.microservicesfinal.repository;

import br.com.fiap.microservicesfinal.model.Transaction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TransactionRepository {
	
	private static Collection<Transaction> transactions = Collections.synchronizedCollection(new ArrayList<>());
	
	public void save(final Transaction transaction){

	    this.transactions.add(transaction);
    }

    public List<Transaction> getAll() {

	    return this.transactions.stream().collect(Collectors.toList());
    }

}
