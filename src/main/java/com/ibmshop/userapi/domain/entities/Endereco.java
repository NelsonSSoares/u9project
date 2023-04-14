package com.ibmshop.userapi.domain.entities;

import com.ibmshop.userapi.domain.enums.Pergunta;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
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
	
	@NotNull(message = "{}")
	@Column(length = 45)
	private String apelido;
	
	@NotNull(message = "{}")
	@Column(length = 45)
	private String rua;
	
	@NotNull(message = "{}")
	@Column(length = 45)
	private String numero;
	
	@Column(length = 45)
	private String complemento;
	
	@NotNull(message ="")
	private String cep; 
	
	@NotNull(message = "{}")
	@Column(length = 45)
	private String bairro;
	
	@NotNull(message = "{}")
	@Column(length = 45)
	private String cidade;
	
	@NotNull(message = "{}")
	@Column(length = 45)
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "pais_id")
	private Pais paisId;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuarioId;
	
	
	@Enumerated(EnumType.ORDINAL)
	private Pergunta enderecoPadrao;
	
}
