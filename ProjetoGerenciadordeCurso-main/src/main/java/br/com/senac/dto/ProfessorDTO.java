package br.com.senac.dto;

import br.com.senac.entity.Curso;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class ProfessorDTO {
	private Integer id;
	private String nome;
	
	@OneToOne
	@JoinColumn(name = "id_curso", referencedColumnName="id")
	private Curso curso;
}
