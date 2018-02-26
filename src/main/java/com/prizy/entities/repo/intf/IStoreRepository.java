package com.prizy.entities.repo.intf;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prizy.entities.Store;

/**
 * @author Shailendra
 *
 */
public interface IStoreRepository extends JpaRepository<Store, Long> {

}
