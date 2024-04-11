package br.com.daciosoftware.shop.modelos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductReportRequestDTO {

	private String descricao;
	private CategoryDTO category;
	private Float precoInicial;
	private Float precoFinal;
}
