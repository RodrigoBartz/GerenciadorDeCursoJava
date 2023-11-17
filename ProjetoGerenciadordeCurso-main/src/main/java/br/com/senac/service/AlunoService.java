package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;

@Service
public class AlunoService {
	
	@Autowired
	AlunoRepository alunoRepo;

	public Aluno salvar(Aluno aluno) {
		
		 return alunoRepo.save(aluno);
	}
	
	
	public List<Aluno> buscarTodosAlunos() {
		return alunoRepo.findAll();
	}
	
	public Aluno getAlunoById(Integer id) {
		return alunoRepo.findById(id).orElse(null);
	}
	
	public Boolean deleteAluno(Integer id) {
		Aluno aluno = alunoRepo.findById(id).orElse(null);
		if(aluno != null) {
			alunoRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Aluno updateAluno(Integer id, Aluno alunoAlterado) {
		Aluno alunoBD = alunoRepo.findById(id).orElse(null);
		if(alunoBD != null) {
			alunoBD.setNome(alunoAlterado.getNome());
			return alunoRepo.save(alunoBD);
		}else {
			return null;
		}
	}
}
