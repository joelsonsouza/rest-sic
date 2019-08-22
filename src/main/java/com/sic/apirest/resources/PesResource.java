package com.sic.apirest.resources;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sic.apirest.models.PesVO;
import com.sic.apirest.repository.PesRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="api/pes")
@Api(value="API REST PesVOs")
public class PesResource {
	
	@Autowired
	PesRepository pesRepository;
	
	@ApiOperation(value="Retorna uma lista de Pessoas")
	@GetMapping("/pessoas")
	public List<PesVO> listaPessoas(){
		return pesRepository.findAll();
	}
	
	@ApiOperation(value="Retorna uma pessoa unica")
	@GetMapping("/pessoa/{id}")
	public PesVO listaPesVOUnico(@PathVariable(value="id") long id){
		return pesRepository.findById(id);
	}
	
	
	@ApiOperation(value="Salva uma pessoa")
	@PostMapping("/pessoa")
	public PesVO salvaPesVO(@RequestBody @Valid PesVO PesVO) {
		return pesRepository.save(PesVO);
	}
	
	@ApiOperation(value="Excluir uma pessoa")
	@DeleteMapping("/pessoa")
	public void deletaPesVO(@RequestBody @Valid PesVO PesVO) {
		pesRepository.delete(PesVO);
	}
	
	@ApiOperation(value="Atualiza uma pessoa")
	@PutMapping("/pessoa")
	public PesVO atualizaPesVO(@RequestBody @Valid PesVO PesVO) {
		return pesRepository.save(PesVO);
	}
	 

}
