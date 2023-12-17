package br.com.daciosoftware.shop.modelos.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.daciosoftware.shop.modelos.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ShopDTO {

	private Long id;
	private LocalDateTime data;
	private Float total;
	private UserDTO user;
	private List<ItemDTO> itens;
	
	public static ShopDTO convert(Shop shop) {
		ShopDTO shopDTO = new ShopDTO();
		shopDTO.setId(shop.getId());
		shopDTO.setData(shop.getData());
		shopDTO.setTotal(shop.getTotal());
		if (shop.getUser() != null) {
			UserDTO userDTO = UserDTO.convert(shop.getUser());
			shopDTO.setUser(userDTO);
		}
		if (shop.getItens() != null) {
			List<ItemDTO> itensDTO = shop.getItens().stream().map(ItemDTO::convert).collect(Collectors.toList());
			shopDTO.setItens(itensDTO);
		}
		return shopDTO;
	}
}
