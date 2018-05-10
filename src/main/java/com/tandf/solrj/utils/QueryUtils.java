package com.tandf.solrj.utils;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class QueryUtils {
	
	
	public DBCursor selectAllRecordsFromACollection(DBCollection collection) {
        DBCursor cursor = collection.find();
        return cursor;
        
    
      
    }

}
