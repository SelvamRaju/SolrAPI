package com.tandf.solrj;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.WriteResult;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
 
public class MongoDBSelectExample {
     
    /*private static void setUpTestData(DBCollection collection){
        for (int i=1; i <= 10; i++) {
            collection.insert(new BasicDBObject().append("employeeId", i).append("employeeName", "TestEmployee_"+i));
        }
    }*/
     
    public static void main(String[] args) throws UnknownHostException
    {
    	MongoClientURI uri = new MongoClientURI("mongodb://m0ng0u$er:m0ng0pa$$w0rd@ds039096-a0-external.dxk34.fleet.mlab.com:39096/products-dev");
        MongoClient mongo = new MongoClient(uri);
        DB db = mongo.getDB("products-dev");
        DBCollection mongoCollection = db.getCollection("titles");
         
        //Delete All documents before running example again
        //WriteResult result = collection.remove(new BasicDBObject());
        //System.out.println(result.toString());
         
        //Set up test data
        //setUpTestData(collection);
         
        //Select all document from a collection
        selectAllRecordsFromACollection(mongoCollection);
         
        //Select first document in collection
        //selectFirstRecordInCollection(mongoCollection);
         
        //Select single document and single field based on record number
        //selectSingleRecordAndFieldByRecordNumber(collection);
         
        //Select all documents where record number = n
        //selectAllRecordByRecordNumber(collection);
         
        //In example
        //in_Example(collection);
         
        //Less than OR greater than example
        //lessThan_GreaterThan_Example(collection);
         
        //Select document where record number != n
        //negation_Example(collection);
         
        //And logical comparison query example
        //andLogicalComparison_Example(collection);
         
        //Select documents based on regex match LIKE example
        //regex_Example(collection);
         
    }
 
    private static void selectFirstRecordInCollection(DBCollection collection) {
        DBObject dbObject = collection.findOne();
        System.out.println(dbObject);
    }
 
    private static void selectAllRecordsFromACollection(DBCollection collection) {
        DBCursor cursor = collection.find();
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
 
    private static void selectSingleRecordAndFieldByRecordNumber(DBCollection collection) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("employeeId", 5);
        BasicDBObject fields = new BasicDBObject();
        fields.put("employeeId", 1);
      
        DBCursor cursor = collection.find(whereQuery, fields);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
 
    private static void selectAllRecordByRecordNumber(DBCollection collection) {
        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("employeeId", 5);
        DBCursor cursor = collection.find(whereQuery);
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
 
    private static void in_Example(DBCollection collection) {
        BasicDBObject inQuery = new BasicDBObject();
        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(4);
        list.add(5);
        inQuery.put("employeeId", new BasicDBObject("$in", list));
        DBCursor cursor = collection.find(inQuery);
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
 
    private static void lessThan_GreaterThan_Example(
            DBCollection collection) {
        BasicDBObject gtQuery = new BasicDBObject();
        gtQuery.put("employeeId", new BasicDBObject("$gt", 2).append("$lt", 5));
        DBCursor cursor = collection.find(gtQuery);
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
 
    private static void negation_Example(DBCollection collection) {
        BasicDBObject neQuery = new BasicDBObject();
        neQuery.put("employeeId", new BasicDBObject("$ne", 4));
        DBCursor cursor = collection.find(neQuery);
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
 
    private static void andLogicalComparison_Example(DBCollection collection) {
        BasicDBObject andQuery = new BasicDBObject();
        List<BasicDBObject> obj = new ArrayList<BasicDBObject>();
        obj.add(new BasicDBObject("employeeId", 2));
        obj.add(new BasicDBObject("employeeName", "TestEmployee_2"));
        andQuery.put("$and", obj);
      
        System.out.println(andQuery.toString());
      
        DBCursor cursor = collection.find(andQuery);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
 
    private static void regex_Example(DBCollection collection) {
        BasicDBObject regexQuery = new BasicDBObject();
        regexQuery.put("employeeName",
            new BasicDBObject("$regex", "TestEmployee_[3]")
            .append("$options", "i"));
      
        System.out.println(regexQuery.toString());
      
        DBCursor cursor = collection.find(regexQuery);
        while (cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
}
