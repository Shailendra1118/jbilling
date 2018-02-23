package com.prizy.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.prizy.entities.Cause;
import com.prizy.entities.repo.intf.ICauseRepository;
import com.prizy.services.intf.ICauseService;

@Service
public class CauseService implements ICauseService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	// private CauseRepository repo = new CauseRepository();
	@Autowired
	private ICauseRepository repo;

	@Override
	public List<Cause> getByType(String type) {
		Cause c = new Cause();
		c.setType(type);
		Example<Cause> example = Example.of(c);
		logger.info("Inside getByType -@@@" + type);
		List<Cause> list = new ArrayList<>();
		list = repo.findAll(example);
		list.forEach(s -> System.out.println(s.getSupportedBy()));
		return list;
	}

}
