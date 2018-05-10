package com.tandf.solrj;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.beans.DocumentObjectBinder;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.common.SolrInputField;
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
public class IndexingController {

	@Autowired
	TitlesRepository titlesRepo;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String solrj() throws SolrServerException, IOException {

		MongoClientURI uri = new MongoClientURI(
				"mongodb://m0ng0u$er:m0ng0pa$$w0rd@ds039096-a0-external.dxk34.fleet.mlab.com:39096/products-dev");
		MongoClient mongo = new MongoClient(uri);
		DB db = mongo.getDB("products-dev");
		DBCollection mongoCollection = db.getCollection("titles");

		System.out.println("SOLRJ INDEXING #########");
		QueryUtils qUtils = new QueryUtils();
		DBCursor dbCursor = qUtils.selectAllRecordsFromACollection(mongoCollection);
		System.out.println("DB INTERACTION DONE");
		Gson gson = new Gson();

		String urlString = "http://localhost:8983/solr/titles_new";
		HttpSolrClient solr = new HttpSolrClient.Builder(urlString).build();
		solr.setParser(new XMLResponseParser());
		while (dbCursor.hasNext()) {
			System.out.println(dbCursor.next());
			DBObject dbObject = dbCursor.next();
			TitleModel model = gson.fromJson(dbObject.toString(), TitleModel.class);
			saveRecord(solr, model);
			// document.addField("bio",model.getBio()==null?"":model.getBio());
			// document.addField("contentIsbn",model.getContentIsbn()==null?"":model.getContentIsbn());
			// document.addField("eIsbn",model.geteIsbn()==null?"":model.geteIsbn());
			// document.addField("allIsbns",model.getAllIsbns()==null?"":model.getAllIsbns());
			// document.addField("bookshopCategory",model.getBookshopCategory()==null?"":model.getBookshopCategory());
			// document.addField("description",model.getDescription()==null?"":model.getDescription());
			// document.addField("division",model.getDivision()==null?"":model.getDivision());
			// document.addField("dataSource",model.getDataSource()==null?"":model.getDataSource());
			// document.addField("divisionCode",model.getDivisionCode()==null?"":model.getDivisionCode());
			// document.addField("doi",model.getDoi()==null?"":model.getDoi());
			// document.addField("bookClass",model.getBookClass()==null?"":model.getBookClass());
			// document.addField("bookClassCode",model.getBookClassCode()==null?"":model.getBookClassCode());
			// document.addField("bookshopCategory",model.getBookshopCategory()==null?"":model.getBookshopCategory());
			// //document.addField("censoredTerritories",model.getCensoredTerritories()==null?"":model.getCensoredTerritories());
			// document.addField("copyright",model.getCopyright()==null?"":model.getCopyright());
			// document.addField("edition",model.getEdition()==null?"":model.getEdition());
			// document.addField("features",model.getFeatures()==null?"":model.getFeatures());
			// document.addField("formerImprint",model.getFormerImprint()==null?"":model.getFormerImprint());
			// document.addField("formerImprintCode",model.getFormerImprintCode()==null?"":model.getFormerImprintCode());
			// document.addField("groupOfCompanyCode",model.getGroupOfCompanyCode()==null?"":model.getGroupOfCompanyCode());
			// document.addField("isEditedCollection",model.getIsEditedCollection()==null?"":model.getIsEditedCollection());
			// document.addField("language",model.getLanguage()==null?"":model.getLanguage());
			// document.addField("languageCode",model.getLanguageCode()==null?"":model.getLanguageCode());
			// document.addField("masterEditionId",model.getMasterEditionId()==null?"":model.getMasterEditionId());
			// document.addField("ownership",model.getOwnership()==null?"":model.getOwnership());
			// document.addField("ownershipCode",model.getOwnershipCode()==null?"":model.getOwnershipCode());
			// document.addField("pages",model.getPages()==null?"":model.getPages());
			// document.addField("pagesArabic",model.getPagesArabic()==null?"":model.getPagesArabic());
			// document.addField("pagesRoman",model.getPagesRoman()==null?"":model.getPagesRoman());
			// document.addField("pdfSize",model.getPdfSize()==null?"":model.getPdfSize());
			// document.addField("publisher",model.getPublisher()==null?"":model.getPublisher());
			// document.addField("publisherCode",model.getPublisherCode()==null?"":model.getPublisherCode());
			// document.addField("reviews",model.getReviews()==null?"":model.getReviews());
			// document.addField("salesEvaluation",model.getSalesEvaluation()==null?"":model.getSalesEvaluation());
			// document.addField("salesEvaluationCode",model.getSalesEvaluationCode()==null?"":model.getSalesEvaluationCode());
			// document.addField("series",model.getSeries()==null?"":model.getSeries());
			// document.addField("shortTitle",model.getShortTitle()==null?"":model.getShortTitle());
			// document.addField("status",model.getStatus()==null?"":model.getStatus());
			// document.addField("statusCode",model.getStatusCode()==null?"":model.getStatusCode());
			// document.addField("subjectGroup",model.getSubjectGroup()==null?"":model.getSubjectGroup());
			// document.addField("subjectGroupCode",model.getSubjectGroupCode()==null?"":model.getSubjectGroupCode());
			// document.addField("subtitle",model.getSubtitle()==null?"":model.getSubtitle());
			// document.addField("summary",model.getSummary()==null?"":model.getSummary());
			// document.addField("title",model.getTitle()==null?"":model.getTitle());
			// document.addField("titleId",model.getTitleId()==null?"":model.getTitleId());
			// document.addField("toc",model.getToc()==null?"":model.getToc());

			System.out.println("In Loop");

		}

		// for(TitleModel model : titles) {

		// counter++;
		// }

		// String urlString = "http://172.16.21.73:8983/solr/#/solrj_core";
		/*
		 * String urlString = "http://localhost:8983/solr/solrj_core"; HttpSolrClient
		 * solr = new HttpSolrClient.Builder(urlString).build(); solr.setParser(new
		 * XMLResponseParser());
		 * 
		 * SolrInputDocument document = new SolrInputDocument(); document.addField("id",
		 * "123458"); document.addField("name", "Apple"); document.addField("price",
		 * "499.99"); solr.add(document); solr.commit();
		 */

		return "success";

	}

	private void saveRecord(HttpSolrClient solr, TitleModel model)  {
		SolrInputDocument document = new SolrInputDocument();
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.execute(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				DocumentObjectBinder binder=new DocumentObjectBinder();
				SolrInputDocument doc=binder.toSolrInputDocument(model);
				//SolrInputField inputField=
				//document.addChildDocument(doc);
				try {
					solr.add(document);
					solr.commit();
				} catch (SolrServerException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println("********* FAILED DOC: "+ model.getDacKey());
				}

			}
		});

	}

}
