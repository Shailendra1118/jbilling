package com.prizy.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prizy.entities.NGO;
import com.prizy.entities.repo.intf.INGORepository;
import com.prizy.services.intf.INGOService;

@Service
public class NGOService implements INGOService {

	// private NGORepository repo = new NGORepository();
	@Autowired
	private INGORepository repo;

	@Override
	public List<NGO> getAllNGO() {
		return repo.findAll();
	}

	@Override
	public NGO getNGOById(Long id) {
		return repo.getOne(id);
	}

}
