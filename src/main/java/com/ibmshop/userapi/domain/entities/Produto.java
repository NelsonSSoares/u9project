package com.ibmshop.userapi.domain.entities;

import java.math.BigDecimal;
import java.sql.Date;

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
@Table(name = "detalhes_pedido")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "subcategoria_id")
	private SubCategoria subcategoriaId;
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria categoriaId;
	
	@NotEmpty(message = "{}")
	@Column(name = "nome_produto", length = 45)
	private String nomeProduto;
	
	@NotEmpty
	@Column(length = 45)
	private String descricao;
	
	@NotEmpty(message = "{}")
	private Integer sku;
	
	@NotEmpty(message = "{}")
	@Column(name = "data_criacao", length = 45)
	private Date dataCriacao;
	
	@NotEmpty(message = "{}")
	@Column(name ="valor_unitario", precision = 20, scale = 2, length = 100)
	private BigDecimal valorUnitario;
	
	@NotEmpty(message = "{}")
	
	private Integer estoque;
}
