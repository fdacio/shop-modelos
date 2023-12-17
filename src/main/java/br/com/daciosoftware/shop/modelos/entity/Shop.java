package br.com.daciosoftware.shop.modelos.entity;

import java.time.LocalDateTime;
import java.util.List;

import br.com.daciosoftware.shop.modelos.dto.ShopDTO;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="shop")
@Table(name="shop", schema = "shopping")
public class Shop {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime data;
	private Float total;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="itens", joinColumns = @JoinColumn(name = "shop_id"))
	private List<Item> itens; 
	
	public static Shop convert(ShopDTO shopDTO) {
		Shop shop = new Shop();
		
		return shop;
	}
}
