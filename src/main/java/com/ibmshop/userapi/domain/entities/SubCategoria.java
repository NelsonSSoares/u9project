package com.ibmshop.userapi.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "subcategoria")
public class SubCategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name ="nome_sub_categoria")
	@NotEmpty(message = "{}")
	private String nomeSubCategoria;
	
	@NotEmpty(message = "{}")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Integer categoriaId;
}
