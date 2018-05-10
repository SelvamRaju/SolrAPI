package com.tandf.solrj.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tandf.solrj.model.TitleModel;

@Repository
public interface TitlesRepository extends MongoRepository<TitleModel,Integer> {

	List<TitleModel> findAll();
	List<TitleModel> findByDivision(String divisionName);
	TitleModel findOneByDivision(String divisionName);
}
