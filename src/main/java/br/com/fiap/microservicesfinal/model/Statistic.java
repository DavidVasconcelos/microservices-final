package br.com.fiap.microservicesfinal.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Statistic {
	
	@ApiModelProperty(notes = "Soma dos valores das transações.")
	private Double sum;
	
	@ApiModelProperty(notes = "Média dos valores das transações.")
	private Double avg;
	
	@ApiModelProperty(notes = "Valor máximo de uma tansação.")
	private Double max;
	
	@ApiModelProperty(notes = "Valor mínimo de uma tansação.")
	private Double min;
	
	@ApiModelProperty(notes = "Número total de transações.")
	private Long count;
	

}
