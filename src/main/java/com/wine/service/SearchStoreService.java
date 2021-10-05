package com.wine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wine.entity.SearchStoreEntity;
import com.wine.repository.SearchStoreRepository;

@Service
public class SearchStoreService {

	@Autowired
	private SearchStoreRepository searchStoreRepository;

	public boolean saveStore(SearchStoreEntity storeEntity) {
		var initialZipCode = searchStoreRepository.findByInitialZipCode(storeEntity.getInitialZipCode());
		var finalZipCode = searchStoreRepository.findByFinalZipCode(storeEntity.getFinalZipCode());
		if (initialZipCode == storeEntity.getInitialZipCode() && finalZipCode == storeEntity.getFinalZipCode()) {
			return false;
		} else {
			searchStoreRepository.save(storeEntity);
		}
		return true;
	}

	public List<SearchStoreEntity> findStoreByCep(Integer zipCode) {
		return searchStoreRepository.findByStoreIdWithCustomQuery(zipCode);
	}

	public boolean deleteStore(Integer id) {
		if (id != null) {
			searchStoreRepository.deleteById(id);
		} else {
			return false;
		}
		return true;
	}

	public boolean updateStore(Integer id, SearchStoreEntity storeEntity) {
		Optional<SearchStoreEntity> storeDate = searchStoreRepository.findById(id);
		if (searchStoreRepository.findById(id).isPresent()) {
			var initialZipCode = searchStoreRepository.findByInitialZipCode(storeEntity.getInitialZipCode());
			var finalZipCode = searchStoreRepository.findByFinalZipCode(storeEntity.getFinalZipCode());
			if (initialZipCode == storeEntity.getInitialZipCode() && finalZipCode == storeEntity.getFinalZipCode()) {
				return false;
			} else {
				SearchStoreEntity entity = storeDate.get();
				entity.setStoreId(storeEntity.getStoreId());
				entity.setInitialZipCode(storeEntity.getInitialZipCode());
				entity.setFinalZipCode(storeEntity.getFinalZipCode());
				searchStoreRepository.save(entity);
				return true;
			}
		}
		return false;
	}
}
