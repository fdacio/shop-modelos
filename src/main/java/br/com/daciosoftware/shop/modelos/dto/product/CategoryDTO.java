package br.com.daciosoftware.shop.modelos.dto.product;

import br.com.daciosoftware.shop.modelos.entity.product.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
	
	private Long id;
	@NotBlank(message="Informe o nome")
	@Size(message="Campo nome muito longo. O máximo são de 30 caracteres", max = 30)
	private String nome;
	
	public static CategoryDTO convert(Category category) {
		CategoryDTO categoryDTO = new CategoryDTO();
		categoryDTO.setId(category.getId());
		categoryDTO.setNome(category.getNome());
		return categoryDTO;
	}

	@Override
	public String toString() {
		return "CategoryDTO [id=" + id + ", nome=" + nome + "]";
	}
}
