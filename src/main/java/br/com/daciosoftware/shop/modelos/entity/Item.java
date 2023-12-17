package br.com.daciosoftware.shop.modelos.entity;

import br.com.daciosoftware.shop.modelos.dto.ItemDTO;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Table(schema = "shopping")
public class Item {

	private Integer quantidade;
	private Float preco;
	
	public static Item convert(ItemDTO itemDTO) {
		Item item = new Item();
		
		return item;
	}
}
