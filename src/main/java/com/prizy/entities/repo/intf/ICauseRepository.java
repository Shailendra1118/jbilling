package com.prizy.entities.repo.intf;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prizy.entities.Cause;

public interface ICauseRepository extends JpaRepository<Cause, Long> {

}
