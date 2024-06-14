package br.com.daciosoftware.shop.modelos.dto.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.daciosoftware.shop.modelos.dto.product.CategoryDTO;
import br.com.daciosoftware.shop.modelos.entity.user.User;
import br.com.daciosoftware.shop.modelos.validator.CPF;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO {

	private Long id;
	
	@NotBlank(message="Informe o nome")
	@Size(message="Nome tem que ter no máximo 80 caracteres", max = 80)
	private String nome;
	
	@NotBlank(message="Informe o CPF")
	@Size(message="CPF tem que ter no máximo 11 caracteres", max = 11)
	@CPF
	private String cpf;
	
	@NotBlank(message="Informe o endereço")
	@Size(message="Endereço tem que ter no máximo 100 caracteres", max = 100)
	private String endereco;
	
	@NotBlank(message="Informe o email")
	@Size(message="Email tem que ter no máximo 100 caracteres", max = 100)
	private String email;
	
	@NotBlank(message="Informe o telefone")
	@Size(message="Telefone tem que ter no máximo 20 caracteres", max = 20)
	private String telefone;
	
	private String key;
	
	private LocalDateTime dataCadastro;
	
	private List<CategoryDTO> interesses;
	
	public static UserDTO convert(User user) {		
		UserDTO userDTO = new UserDTO();
		userDTO.setId(user.getId());
		userDTO.setNome(user.getNome());
		userDTO.setCpf(user.getCpf());
		userDTO.setEndereco(user.getEndereco());
		userDTO.setEmail(user.getEmail());
		userDTO.setTelefone(user.getTelefone());
		userDTO.setKey(user.getKey());
		userDTO.setDataCadastro(user.getDataCadastro());
		if (user.getInteresses() != null)
			userDTO.setInteresses(user.getInteresses().stream().map(CategoryDTO::convert).collect(Collectors.toList()));
		return userDTO;
	}
	
	public static UserSimpleDTO convert(UserDTO user) {
		UserSimpleDTO userSimpleDTO = new UserSimpleDTO();
		userSimpleDTO.setId(user.getId());
		userSimpleDTO.setNome(user.getNome());
		userSimpleDTO.setCpf(user.getCpf());
		userSimpleDTO.setEndereco(user.getEndereco());
		userSimpleDTO.setEmail(user.getEmail());
		userSimpleDTO.setTelefone(user.getTelefone());
		return userSimpleDTO;
	}
}
