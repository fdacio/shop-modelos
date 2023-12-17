package br.com.daciosoftware.shop.modelos.dto;

import br.com.daciosoftware.shop.modelos.entity.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {

	private Integer quantidade;
	private Float preco;
	
	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		
		return itemDTO;
	}
	
}
