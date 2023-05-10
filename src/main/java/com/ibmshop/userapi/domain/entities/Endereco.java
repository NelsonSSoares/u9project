package com.ibmshop.userapi.domain.entities;

import com.ibmshop.userapi.domain.enums.Pergunta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class Endereco {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message = "${}")
	@Column(length = 45)
	private String apelido;
	
	@NotEmpty(message = "${}")
	@Column(length = 45)
	private String rua;
	
	@NotEmpty(message = "${}")
	@Column(length = 45)
	private String numero;
	
	@Column(length = 45)
	private String complemento;
	
	@NotEmpty(message ="${}")
	private String cep; 
	
	@NotEmpty(message = "${}")
	@Column(length = 45)
	private String bairro;
	
	@NotEmpty(message = "${}")
	@Column(length = 45)
	private String cidade;
	
	@NotEmpty(message = "${}")
	@Column(length = 45)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais pais;
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Usuario.class)
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioId;
	
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name ="endereco_padrao")
	private Pergunta enderecoPadrao;
	
}
