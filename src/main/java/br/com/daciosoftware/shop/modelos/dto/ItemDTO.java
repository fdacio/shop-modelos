package br.com.daciosoftware.shop.modelos.dto;

import br.com.daciosoftware.shop.modelos.entity.Item;
import br.com.daciosoftware.shop.modelos.entity.Product;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDTO {
	
	private Long id;
	@NotNull(message="Informe a quantidade")
	private Integer quantidade;
	@NotNull(message="Informe a preco do produto")
	private Float preco;
	@NotNull(message="Informe o produto")
	private ProductDTO product;
	
	public static ItemDTO convert(Item item) {
		ItemDTO itemDTO = new ItemDTO();
		Product product = item.getProduct();
		ProductDTO productDTO = ProductDTO.convert(product);
		itemDTO.setId(item.getId());
		itemDTO.setProduct(productDTO);
		itemDTO.setQuantidade(item.getQuantidade());
		itemDTO.setPreco(item.getPreco());
		return itemDTO;
	}

	@Override
	public String toString() {
		return "ItemDTO [product=" + product + ", quantidade=" + quantidade + ", preco=" + preco + "]";
	}
	
}
