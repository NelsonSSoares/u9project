package com.ibmshop.userapi.domain.entities;

import java.sql.Date;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import com.ibmshop.userapi.domain.enums.Pergunta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
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
	@NotEmpty(message = "{}")
	private String nome;
	
	@Column(length = 255)
	@NotEmpty(message = "{}")
	private String sobrenome;
	
	@Column(length = 14)
	@NotEmpty(message = "{}")
	@CPF(message = "{}")
	private String cpf;
	
	@Column(length = 20)
	private String telefone;	
	
	@Column(name = "data_criacao")
	@NotEmpty(message = "{}")
	private Date dataCriacao;
	
	@Column(name = "data_modificacao")
	@NotEmpty(message = "{}")
	private Date dataModificacao;
	
	@NotEmpty(message = "{}")
	@Enumerated(EnumType.ORDINAL)
	private Pergunta ativo;
	
	@OneToMany // (mappedBy = "endereco" ,fetch = FetchType.LAZY)
	@JoinColumn(name = "endereco")
	private List<Endereco> enderecoId;

}
