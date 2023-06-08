package com.apishop.userapi.constraints;

import java.util.Iterator;
import java.util.List;

import com.apishop.userapi.domain.entities.Usuario;
import com.apishop.userapi.domain.enums.Pergunta;

public class SomenteUserAtivo {
	
	public static List<Usuario> usuariosAtivosList(List<Usuario> usuarios) {
	    Iterator<Usuario> iterator = usuarios.iterator();
	    while (iterator.hasNext()) {
	        Usuario usuario = iterator.next();
	        if (usuario.getAtivo().equals(Pergunta.NAO)) {
	            iterator.remove();
	        }
	    }
	    return usuarios;
	}

}
