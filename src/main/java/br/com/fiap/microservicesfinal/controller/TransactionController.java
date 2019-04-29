package br.com.fiap.microservicesfinal.controller;

import br.com.fiap.microservicesfinal.model.Statistic;
import br.com.fiap.microservicesfinal.model.Transaction;
import br.com.fiap.microservicesfinal.service.TransactionService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

@RestController
@Api(value = "Transaction", description = "Transaction REST API")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @ApiOperation(httpMethod = "Post", value = "Método post inserir uma transação")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso"),
            @ApiResponse(code = 204, message = "A transação ocorreu há mais de 60 segundos")})
    @PostMapping("/transactions")
    public ResponseEntity save(@Valid @RequestBody Transaction transaction) {

        transactionService.save(transaction);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ApiOperation(httpMethod = "GET", value = "Método get para apresentar as estatísticas")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Retorna as estatísticas das transações dos últimos 60 segundos", response = Statistic.class)})
    @GetMapping("/statistics")
    public ResponseEntity<Statistic> getStatistics() {

        final Statistic statitic = transactionService.getStatitics();

        return new ResponseEntity<>(statitic, HttpStatus.OK);
    }

}
