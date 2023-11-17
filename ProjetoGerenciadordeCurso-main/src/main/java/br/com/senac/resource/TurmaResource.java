package br.com.senac.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senac.dto.TurmaDTO;
import br.com.senac.entity.Turma;
import br.com.senac.service.TurmaService;

@RestController
@RequestMapping("turmas")
public class TurmaResource {

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private TurmaService turmaService;
	
	@PostMapping
	public ResponseEntity<TurmaDTO> cadastrarTurma(@RequestBody TurmaDTO turmaDTO){
		
		Turma turma = mapper.map(turmaDTO, Turma.class);
		
		turma = turmaService.salvar(turma);
		
		TurmaDTO turmaNova = mapper.map(turma, TurmaDTO.class);
		
		return ResponseEntity.ok().body(turmaNova);
	}
	
	@GetMapping
	public ResponseEntity<List<TurmaDTO>> buscarTodasTurmas() {
		
		List<Turma> listaTurmas = turmaService.buscarTodasTurmas();
		
		List<TurmaDTO> listaTurmaDTO = listaTurmas.stream().map(turma -> mapper.map(turma, TurmaDTO.class)).collect(Collectors.toList());
		
		return ResponseEntity.ok().body(listaTurmaDTO);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<TurmaDTO> buscarTurmaPorID(@PathVariable("id") Integer id){
		
		Turma turma = turmaService.getTurmaById(id);
		
		TurmaDTO turmaDTO = mapper.map(turma, TurmaDTO.class);
		
		return ResponseEntity.ok().body(turmaDTO);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<TurmaDTO> atualizarTurma(@PathVariable("id") Integer id, @RequestBody TurmaDTO turmaDTO) {
		
		Turma turma = mapper.map(turmaDTO, Turma.class);
		
		turma = turmaService.updateTurma(id, turma);
		
		TurmaDTO turmaAlteradoDTO = mapper.map(turma, TurmaDTO.class);
		
		return ResponseEntity.ok().body(turmaAlteradoDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> excluirTurma(@PathVariable("id") Integer id){
		
		Boolean flag = turmaService.deleteTurma(id);
		
		return ResponseEntity.ok().body(flag);
	}
	
	
}
