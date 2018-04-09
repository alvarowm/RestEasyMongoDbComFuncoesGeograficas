package br.zxventures.restzx.mongoclient;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoDBClient {

	private static MongoDBClient mongoDBClient;

	private static MongoClient mongoClient;

	private static DB db ;

	private static final String dbHost = "localhost";
	private static final int dbPort = 27017;
	private static final String dbName = "admin";
	private static final String dbUser = "alvaro";
	private static final String dbPassword = "nH8019*MP0ud";

	private MongoDBClient() {};

	public static MongoDBClient getInstance(){
		if(mongoDBClient == null){
			mongoDBClient = new MongoDBClient();
		}
		return mongoDBClient;
	} 

	public DB getDataBase(){
		if(mongoClient == null){
			try {
				mongoClient = new MongoClient(dbHost , dbPort);
			} catch (UnknownHostException e) {
				return null;
			}
		}
		if(db == null)
			db = mongoClient.getDB(dbName);
		if(!db.isAuthenticated()){
			db.authenticate(dbUser, dbPassword.toCharArray());
		}
		return db;
	}


}
