package com.ibmshop.userapi.commons;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.apishop.userapi.domain.dto.EnderecoDTO;
import com.apishop.userapi.domain.dto.PaisDTO;
import com.apishop.userapi.domain.dto.UsuarioDTO;
import com.apishop.userapi.domain.entities.Endereco;
import com.apishop.userapi.domain.entities.Usuario;
import com.apishop.userapi.domain.enums.Pergunta;

public class UsuariosConstant {
	public static final PaisDTO PAIS = new PaisDTO("Brasil","+055");
	public static final EnderecoDTO ENDTEST= new EnderecoDTO(1,"Av paulista","1000","AP 11","02636-030","Parada inglesa","São Paulo","São Paulo","Casa",PAIS,Pergunta.SIM);
	public static final List<EnderecoDTO> ENDDTO =  new ArrayList<>();
	//public static final List<EnderecoDTO> ENDDTO1 = new ArrayList<>();
	static List<Endereco> endereco = new ArrayList<>();
	public static final Optional<Usuario> USUARIOOP = Optional.of(new Usuario(1,"Cabron","Brabo","420.197.488-00","(11) 91234-5678",LocalDate.now(),LocalDate.now(),"123deoliveira4@gmal.com","12345","USER",Pergunta.SIM));
	public static final Optional<Usuario> INVALID_USUARIOOP = Optional.of(new Usuario(1,"Cabron","Brabo","420.197.488-00","(11) 91234-5678",LocalDate.now(),LocalDate.now(),"123deoliveira4@gmal.com","12345","USER",Pergunta.SIM));
	public static final Usuario USUARIO = new Usuario(1,"Cabron","Brabo","420.197.488-00","(11) 91234-5678",LocalDate.now(),LocalDate.now(),"123deoliveira4@gmal.com","12345","USER",Pergunta.SIM);
	public static final UsuarioDTO USUARIOUPDATE = new UsuarioDTO("Geremias","Cabra Homi","420.197.488-00","(11) 91234-5678","123deoliveira4@gmail.com","12345");
	public static final UsuarioDTO USUARIODTO = new UsuarioDTO("Geremias","Cabra Homi","420.197.488-00","(11) 91234-5678","123deoliveira4@gmail.com","12345");
	public static final UsuarioDTO INVALID_USUARIODTO = new UsuarioDTO();
	public static final Usuario INVALID_USUARIO = new Usuario(1,"Cabron","Brabo","420.197.488-00","(11) 91234-5678",LocalDate.now(),LocalDate.now(),"123deoliveira4@gmal.com","12345","USER",Pergunta.SIM);
		
}

//{"Casa","Av paulista","1000","AP 11","02636-030","Parada inglesa","São Paulo","São Paulo",pais,Pergunta.SIM}
/*
	USUARIO 
	this.id = id;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataCriacao = dataCriacao;
		this.dataModificacao = dataModificacao;
		this.ativo = ativo;
		this.endereco = endereco;
*/

/*			
 *			ENDERECODTO
			"rua": "Av paulista",
            "numero": "1000",
            "complemento": "AP 11",
            "cep": "02636-030",
            "bairro": "Parada inglesa",
            "cidade": "São Paulo",
            "estado": "São Paulo",
            "enderecoPadrao": 0,
            "apelido": "Casa",
            "pais": {
               "nome": "Brasil",
               "codigo": "+055"
            } 
 */
