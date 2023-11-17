package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Turma;
import br.com.senac.repository.TurmaRepository;

@Service
public class TurmaService {

	@Autowired
	TurmaRepository turmaRepo;
	
	public Turma salvar(Turma turma) {
		return turmaRepo.save(turma);
	}
	
	public List<Turma> buscarTodasTurmas() {
		return turmaRepo.findAll();
	}
	
	public Turma getTurmaById(Integer id) {
		return turmaRepo.findById(id).orElse(null);
	}
	
	public Boolean deleteTurma(Integer id) {
		Turma turma = turmaRepo.findById(id).orElse(null);
		if(turma != null) {
			turmaRepo.deleteById(id);
			return true;
		}
		return false;
	}
	
	public Turma updateTurma(Integer id, Turma turmaAlterado) {
		Turma turmaBD = turmaRepo.findById(id).orElse(null);
		if(turmaBD != null) {
			turmaBD.setNome(turmaAlterado.getNome());
			return turmaRepo.save(turmaBD);
		}else {
			return null;
		}
	}
}
