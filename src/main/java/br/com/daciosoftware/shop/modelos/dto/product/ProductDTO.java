package br.com.daciosoftware.shop.modelos.dto.product;


import br.com.daciosoftware.shop.modelos.entity.product.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

	private Long id;
	@NotBlank(message = "Informe o nome")
	@Size(message="Campo nome muito longo. O máximo é 120 caracteres", max=120)
	private String nome;
	@NotBlank(message = "Informe o descrição")
	@Size(message="Campo descrição muito longo. O máximo são 240 caracteres", max=240)
	private String descricao;
	@NotBlank(message = "Informe o indenticador")
	@Size(message="Campo identificador muito longo. O máximo são 20 caracteres", max=20)
	private String productIdentifier;
	@NotNull(message = "Informe o preço")
	private Float preco;
	@NotNull(message = "Informe a categoria")
	private CategoryDTO category;
	private String foto;

	public static ProductDTO convert(Product product) {
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setNome(product.getNome());
		productDTO.setDescricao(product.getDescricao());
		productDTO.setPreco(product.getPreco());
		productDTO.setProductIdentifier(product.getProductIdentifier());
		productDTO.setCategory(CategoryDTO.convert(product.getCategory()));
		productDTO.setFoto(product.getFoto());
		return productDTO;
	}

	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", preco=" + preco
				+ ", productIdentifier=" + productIdentifier + ", category=" + category + "]";
	}

}
