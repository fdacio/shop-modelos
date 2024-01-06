package br.com.daciosoftware.shop.modelos.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.daciosoftware.shop.modelos.dto.ShopDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "shop")
@Table(name = "shop", schema = "shopping")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime data;
	private Float total;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	
	//@ElementCollection(fetch = FetchType.EAGER)
	//@CollectionTable(name="itens", joinColumns = @JoinColumn(name="shop_id"))
	@OneToMany(
			mappedBy = "shop",
		    orphanRemoval = true,
		    cascade = CascadeType.ALL,
		    fetch = FetchType.EAGER)
	private List<Item> itens = new ArrayList<>();

	public static Shop convert(ShopDTO shopDTO) {
		Shop shop = new Shop();
		shop.setId(shopDTO.getId());
		shop.setData(shopDTO.getData());
		shop.setTotal(shopDTO.getTotal());
		shop.setUser(User.convert(shopDTO.getUser()));		
		List<Item> itens = shopDTO.getItens().stream().map(Item::convert).collect(Collectors.toList());
		itens.forEach((i) -> i.setShop(shop));//Anexar o item ao shop
		shop.setItens(itens);
		return shop;
	}

	@Override
	public String toString() {
		return "Shop [id=" + id + ", data=" + data + ", total=" + total + ", user=" + user + ", itens=" + itens + "]";
	}
	
	
}
