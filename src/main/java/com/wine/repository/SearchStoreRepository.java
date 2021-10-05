package com.wine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wine.entity.SearchStoreEntity;

@Repository
public interface SearchStoreRepository extends JpaRepository<SearchStoreEntity, Integer>{
	
	@Query("select u from SearchStoreEntity u where ?1 between u.initialZipCode and u.finalZipCode")
	public List<SearchStoreEntity> findByStoreIdWithCustomQuery(Integer zipCode);
	
	public Integer findByInitialZipCode(Integer initialZipCode);
	public Integer findByFinalZipCode(Integer finalZipCode);
}

	