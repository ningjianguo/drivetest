package com.hnrw.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hnrw.dao.ICollectionDao;
import com.hnrw.service.ICollectionService;

@Service
public class CollectionServiceImpl implements ICollectionService {
	
	@Resource
	private ICollectionDao collectionDaoImpl;
	
	@Override
	public String collectOrNotCollect(String questionId) {
		return collectionDaoImpl.collectOrNotCollected(questionId);
	}
	
}
