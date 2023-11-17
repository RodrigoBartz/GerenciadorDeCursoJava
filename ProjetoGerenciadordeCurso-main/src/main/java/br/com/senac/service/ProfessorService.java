package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Professor;
import br.com.senac.repository.ProfessorRepository;

@Service
public class ProfessorService {
	
	@Autowired
	ProfessorRepository professorRepo;
	
	public Professor salvar(Professor professor) {
		return professorRepo.save(professor);
	}
	
	public List<Professor> buscarTodosProfessores() {
		return professorRepo.findAll();
	}
	
	public Professor getProfessorById(Integer id) {
		return professorRepo.findById(id).orElse(null);
	}
	
	public Boolean deleteProfessor(Integer id) {
		Professor professor = professorRepo.findById(id).orElse(null);
		if(professor != null) {
			professorRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Professor updateProfessor(Integer id, Professor professorAlterado) {
		Professor professorBD = professorRepo.findById(id).orElse(null);
		if(professorBD != null) {
			professorBD.setNome(professorAlterado.getNome());
			return professorRepo.save(professorBD);
		}else {
			return null;
		}
	}
	
}
