package com.sic.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sic.apirest.models.PesVO;

public interface PesRepository extends JpaRepository<PesVO, Long>{
	PesVO findById(long id);

}
