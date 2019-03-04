package com.tandf.solrj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.tandf.solrj.model.TitleModel;
import com.tandf.solrj.repository.TitlesRepository;
import com.tandf.solrj.utils.QueryUtils;

@RestController
@CrossOrigin
public class IndexingControllerNew {

	@Autowired
	TitlesRepository titlesRepo;

	@RequestMapping(value = "/indexer", method = RequestMethod.GET)
	public String solrjIndexer() throws SolrServerException, IOException{
		
		/*MongoClientURI uri = new MongoClientURI(
				"mongodb://m0ng0u$er:m0ng0pa$$w0rd@ds039096-a0-external.dxk34.fleet.mlab.com:39096/products-dev");
		MongoClient mongo = new MongoClient(uri);
		DB db = mongo.getDB("products-dev");
		DBCollection mongoCollection = db.getCollection("titles");

		System.out.println("SOLRJ INDEXING #########");
		QueryUtils qUtils = new QueryUtils();
		DBCursor dbCursor = qUtils.selectAllRecordsFromACollection(mongoCollection);
		System.out.println("DB INTERACTION DONE");
		Gson gson = new Gson();*/

		String urlString = "http://localhost:8983/solr/core_dinesh2";
		HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
		solr.setParser(new XMLResponseParser());
		
		/*while (dbCursor.hasNext()) {
			System.out.println(dbCursor.next());
			DBObject dbObject = dbCursor.next();
			TitleModel model = gson.fromJson(dbObject.toString(), TitleModel.class);
			
			Collection<SolrInputDocument> batch = new ArrayList<SolrInputDocument>();
			//Primary Document
			SolrInputDocument primaryDocument = new SolrInputDocument();
			
			primaryDocument.addField("bookshopCategory",model.getBookshopCategory()==null?"":model.getBookshopCategory());
			primaryDocument.addField("description",model.getDescription()==null?"":model.getDescription());
			primaryDocument.addField("division",model.getDivision()==null?"":model.getDivision());
			primaryDocument.addField("subtitle",model.getSubtitle()==null?"":model.getSubtitle());
			primaryDocument.addField("summary",model.getSummary()==null?"":model.getSummary());
			primaryDocument.addField("title",model.getTitle()==null?"":model.getTitle());
			
			// Format Child document
			SolrInputDocument bisacSubjectHeadingDocument=new SolrInputDocument("bisacSubjectHeadings");
			//bisacSubjectHeadingDocument.addField();
			
			for(int i=0;i<model.getBisacSubjectHeadings().length;i++) {
				bisacSubjectHeadingDocument.addField("code",model.getBisacSubjectHeadings()[i].getCode()==null?"":model.getBisacSubjectHeadings()[i].getCode());
				bisacSubjectHeadingDocument.addField("heading",model.getBisacSubjectHeadings()[i].getHeading()==null?"":model.getBisacSubjectHeadings()[i].getHeading());
			}
			
			
			
			//solr.add(document);
			solr.commit();
			System.out.println("In Loop");
		}*/
		
		Collection<SolrInputDocument> batch = new ArrayList<SolrInputDocument>();

	    // Parent Doc 1
	    SolrInputDocument product01 = new SolrInputDocument();
	    product01.addField( "id", "product01" );
	    product01.addField( "name", "car" );
	    product01.addField( "content_type", "product" );

	    // 3 Children
	    SolrInputDocument part01 = new SolrInputDocument();
	    part01.addField( "id", "part01" );
	    part01.addField( "name", "wheels" );
	    part01.addField( "content_type", "part" );
	    SolrInputDocument part02 = new SolrInputDocument();
	    part02.addField( "id", "part02" );
	    part02.addField( "name", "engine" );
	    part02.addField( "content_type", "part" );
	    SolrInputDocument part03 = new SolrInputDocument();
	    part03.addField( "id", "part03" );
	    part03.addField( "name", "brakes" );
	    part03.addField( "content_type", "part" );

	    // Add children to parent
	    product01.addChildDocument( part01 ); 
	    product01.addChildDocument( part02 ); 
	    product01.addChildDocument( part03 ); 

	    //System.out.println( "product01 = " + product01 );

	    // Add parent to batch
	    batch.add( product01 );

	    // Parent Doc 2 with 2 children
	    SolrInputDocument product02 = new SolrInputDocument();
	    product02.addField( "id", "product02" );
	    product02.addField( "name", "truck" );
	    product02.addField( "content_type", "product" );
	    SolrInputDocument part04 = new SolrInputDocument();
	    part04.addField( "id", "part04" );
	    part04.addField( "name", "wheels" );
	    part04.addField( "content_type", "part" );
	    SolrInputDocument part05 = new SolrInputDocument();
	    part05.addField( "id", "part05" );
	    part05.addField( "name", "flaps" );
	    part05.addField( "content_type", "part" );
	    product02.addChildDocument( part04 ); 
	    product02.addChildDocument( part05 ); 
	    //System.out.println( "product02 = " + product02 );
	    batch.add( product02 );

	    System.out.println( "Adding batch of " + batch.size() + " parent docs" );

	    // Submit as a group
	    solr.add( batch );
	    solr.commit();
	

		return "success";

	}

}
