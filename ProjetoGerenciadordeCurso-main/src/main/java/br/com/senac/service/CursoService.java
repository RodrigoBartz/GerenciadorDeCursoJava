package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Curso;
import br.com.senac.repository.CursoRepository;

@Service
public class CursoService {

	@Autowired
	CursoRepository cursoRepo;
	
	public Curso salvar(Curso curso) {
		return cursoRepo.save(curso);
	}
	
	public List<Curso> buscarTodosCursos() {
		return cursoRepo.findAll();
	}
	
	public Curso getCursoById(Integer id) {
		return cursoRepo.findById(id).orElse(null);
	}
	
	public Boolean deleteCurso(Integer id) {
		Curso curso = cursoRepo.findById(id).orElse(null);
		if(curso != null) {
			cursoRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Curso updateCurso(Integer id, Curso cursoAlterado) {
		Curso cursoBD = cursoRepo.findById(id).orElse(null);
		if(cursoBD != null) {
			cursoBD.setNome(cursoAlterado.getNome());
			return cursoRepo.save(cursoBD);
		}else {
			return null;
		}
	}
}
