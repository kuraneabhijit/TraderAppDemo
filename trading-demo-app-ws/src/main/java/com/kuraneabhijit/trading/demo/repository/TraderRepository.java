package com.kuraneabhijit.trading.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kuraneabhijit.trading.demo.repository.entity.TraderEntity;


@Repository
public interface TraderRepository extends CrudRepository<TraderEntity, Long>{
	TraderEntity findByEmail(String email);

	TraderEntity findByTraderId(String traderId);

}
