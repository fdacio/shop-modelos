package br.com.daciosoftware.shop.modelos.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.daciosoftware.shop.modelos.dto.UserDTO;
import reactor.core.publisher.Mono;

@Service
public class UserServiceValidation {

	@Value("${user.api.url}")
	private String userApiURL;
	
	public Optional<UserDTO> findUserByCPF(String cpf) {
		WebClient webClient = WebClient.builder().baseUrl(userApiURL).build();
		Mono<UserDTO> user = webClient.get().uri("/user/cpf/" + cpf).retrieve().bodyToMono(UserDTO.class);
		return user.blockOptional();
	}

	public Optional<UserDTO> findUserByEmail(String email) {
		WebClient webClient = WebClient.builder().baseUrl(userApiURL).build();
		Mono<UserDTO> user = webClient.get().uri("/user/email/" + email).retrieve().bodyToMono(UserDTO.class);
		return user.blockOptional();
	}
}
