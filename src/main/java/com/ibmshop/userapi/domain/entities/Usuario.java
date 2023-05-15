package com.ibmshop.userapi.domain.entities;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import com.ibmshop.userapi.domain.enums.Pergunta;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(length = 255)
	@NotEmpty(message = "${campo.nome.obrigatorio}")
	private String nome;

	@Column(length = 255)
	@NotEmpty(message = "${campo.nome.obrigatorio}")
	private String sobrenome;

	@Column(length = 14)
	@NotEmpty(message = "${}")
	@CPF(message = "${campo.cpf.obrigatorio}")
	private String cpf;

	// @Pattern(regexp =
	// "(/^(?:(?:\\+|00)?(55)\\s?)?(?:\\(?([1-9][0-9])\\)?\\s?)?(?:((?:9\\d|[2-9])\\d{3})\\-?(\\d{4}))$/)"
	// ,message = "{campo.telefone.válido}")
	@Column(length = 20)
	private String telefone;

	@Column(name = "data_criacao")
	@NotNull(message = "${}")
	// @NotBlank
	private LocalDate dataCriacao;

	@Column(name = "data_modificacao")
	@NotNull(message = "${}")
	@DateTimeFormat(pattern = "YYYY-MM-DD")
	private LocalDate dataModificacao;

	@NotNull(message = "${}")
	@Enumerated(EnumType.ORDINAL)
	private Pergunta ativo;

	@OneToMany(mappedBy = "usuarioId", cascade = CascadeType.ALL)
	// @JoinColumn(name = "endereco")
	private List<Endereco> endereco;

}
