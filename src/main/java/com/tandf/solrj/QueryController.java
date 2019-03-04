package com.tandf.solrj;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tandf.solrj.model.TitleModel;

@RestController
@CrossOrigin
public class QueryController {
	
	@RequestMapping(value="/query" , method=RequestMethod.GET)
	public String solrjQuery() throws SolrServerException, IOException {
		
	String urlString = "http://localhost:8983/solr/titles";
	HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
	solr.setParser(new XMLResponseParser());
	
	 SolrQuery solrQuery =new SolrQuery();
	 solrQuery.setQuery("*:*");
	 solrQuery.addFilterQuery("copyright:1970");
	 solrQuery.addFilterQuery("divisionCode:ECON");
	 solrQuery.setFields("division");
	 solrQuery.setStart(0);
	 solrQuery.set("defType", "edismax");

     QueryResponse response = solr.query(solrQuery);
     SolrDocumentList results = response.getResults();
     System.out.println("###"+results.getNumFound());
     for (int i = 0; i < results.size(); ++i) {
         System.out.println(results.get(i));
     }
	
		return "success";
		
	}

}
