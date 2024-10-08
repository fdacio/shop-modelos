package br.com.daciosoftware.shop.modelos.entity.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.daciosoftware.shop.modelos.dto.user.UserDTO;
import br.com.daciosoftware.shop.modelos.entity.product.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Entity(name="user")
@Table(name="user", schema="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String email;
	private String telefone;
	private LocalDateTime dataCadastro;
	@OneToMany
	@JoinTable(schema="users", name="interesses",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="category_id"))
	private List<Category> interesses;
	private String key;

	public static User convert(UserDTO userDTO) {		
		User user = new User();
		user.setId(userDTO.getId());
		user.setNome(userDTO.getNome());
		user.setCpf(userDTO.getCpf());
		user.setEndereco(userDTO.getEndereco());
		user.setEmail(userDTO.getEmail());
		user.setTelefone(userDTO.getTelefone());
		user.setKey(userDTO.getKey());
		user.setDataCadastro(userDTO.getDataCadastro());
		if (userDTO.getInteresses() != null) 
			user.setInteresses(userDTO.getInteresses().stream().map(Category::convert).collect(Collectors.toList()));
		return user;
	}

}
