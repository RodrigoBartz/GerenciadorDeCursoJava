package br.com.senac.inicializacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Turma;
import br.com.senac.repository.AlunoRepository;
import br.com.senac.service.TurmaService;

@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	TurmaService turmaService;
	
	@Autowired
	AlunoRepository alunoRepo;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Lucas");
		
		Turma turma1 = new Turma();
		turma1.setNome("Turma 603");
		
		turmaService.salvar(turma1);
		
		aluno1.setTurma(turma1);
		
		alunoRepo.save(aluno1);
		
	}
}
