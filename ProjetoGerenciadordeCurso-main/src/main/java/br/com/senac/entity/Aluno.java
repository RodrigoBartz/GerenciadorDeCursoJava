package br.com.senac.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Aluno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
		
	private String nome;
	
//	@ManyToMany
//	@JoinColumn(name = "id_curso", referencedColumnName = "id")
//	private Curso curso;
//	
//	@ManyToOne
//	@JoinColumn(name = "id_turma", referencedColumnName = "id")
//	private Turma turma;
	
	
		
	
}
