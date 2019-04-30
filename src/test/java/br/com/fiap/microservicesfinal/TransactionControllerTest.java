package br.com.fiap.microservicesfinal;

import br.com.fiap.microservicesfinal.controller.TransactionController;
import br.com.fiap.microservicesfinal.model.Statistic;
import br.com.fiap.microservicesfinal.model.Transaction;
import br.com.fiap.microservicesfinal.repository.TransactionRepository;
import br.com.fiap.microservicesfinal.service.TransactionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private TransactionService service;

    @MockBean
    private TransactionRepository repository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void statisticsFounded() throws Exception {
        final Statistic statistic = getStatistic();
        when(this.service.getStatitics()).thenReturn(statistic);
        mvc.perform(get("/statistics")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(response -> {
                    String json = response.getResponse().getContentAsString();
                    Statistic statisticFounded = new ObjectMapper().readValue(json, Statistic.class);
                    Assertions.assertThat(statistic).isEqualToComparingFieldByField(statisticFounded);
                });
    }


    @Test
    public void insertTransaction() throws Exception {
        final Transaction transaction = getTransaction();

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();
        String jsonInString = mapper.writeValueAsString(transaction);

        mvc.perform(post("/transactions")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonInString)
                .characterEncoding("utf-8"))
                .andExpect(status().isCreated());
    }

    private Transaction getTransaction() {

        return new Transaction(259.00, 1556579338000L);
    }

    private Statistic getStatistic() {

        return new Statistic(259.00, 259.00, 259.00, 259.00, 1L);
    }


}