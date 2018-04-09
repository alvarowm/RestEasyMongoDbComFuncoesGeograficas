package br.zxventures.restzx.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import br.zxventures.restzx.models.PDV;
import br.zxventures.restzx.mongoclient.MongoDBClient;


@Path("/api")  
public class PDVService implements IPDVService{

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		String output = "OK!";
		return Response.status(200).entity(output).build();
	}

	@GET 
	@Path("/pdv/{id}")  
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getPDVById(@PathParam("id") String id){
		MongoDBClient mongoDBClient = MongoDBClient.getInstance();
		DB db = mongoDBClient.getDataBase();
		DBCollection coll = db.getCollection("pdvs"); 
		DBCursor cur = coll.find(new BasicDBObject("id", id));

		DBObject o;

		o = cur.next();

		if (o != null) {
			o.removeField("_id");
			return Response.status(200).entity(o.toString()).build();	
		}
		return Response.status(200).entity("").build();
	}

	@GET 
	@Path("/pdv/{lat},{lgn}")  
	@Produces(MediaType.APPLICATION_JSON)  
	public Response getPDVById(@PathParam("lat") String lat, @PathParam("lgn") String lgn){
		MongoDBClient mongoDBClient = MongoDBClient.getInstance();
		DB db = mongoDBClient.getDataBase();
		DBCollection coll = db.getCollection("pdvs"); 

		String query = String.format(QUERY_NEAR, lat,lgn);

		DBObject dbObject = (DBObject)JSON.parse(query);

		DBObject pdvMaisProximo = coll.findOne(dbObject);

		String idPdvMaisProximo = null;
		if (pdvMaisProximo != null) {
			pdvMaisProximo.removeField("_id");
			idPdvMaisProximo = String.valueOf(pdvMaisProximo.get("id"));
		} 

		query = String.format(QUERY_INTERSECTS, lat,lgn);

		dbObject = (DBObject)JSON.parse(query);

		DBCursor cur = coll.find(dbObject);

		DBObject pdvComAreaAtendida = null;
		if (cur != null && cur.hasNext()) {
			pdvComAreaAtendida = cur.next();
			pdvComAreaAtendida.removeField("_id");
			while (cur.hasNext() && idPdvMaisProximo != null) {
				if (String.valueOf(pdvComAreaAtendida.get("id")).equals(idPdvMaisProximo))
					return Response.status(200).entity(pdvComAreaAtendida.toString()).build();
				pdvComAreaAtendida = cur.next();
			}
		} 

		if (pdvComAreaAtendida == null) {
			return Response.status(200).entity(PDV_NAO_ENCONTRADO).build();
		}
			return Response.status(200).entity(pdvComAreaAtendida.toString()).build();
	} 

	@POST
	@Path("pdv/post")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(PDV pdv) {
		MongoDBClient mongoDBClient = MongoDBClient.getInstance();
		DB db = mongoDBClient.getDataBase();
		DBCollection coll = db.getCollection("pdvs"); 
		DBCursor cur = coll.find(new BasicDBObject("id", pdv.getId().toString()));
		DBObject o = null;

		if (cur.hasNext())
			o = cur.next();

		if (o != null) {
			return Response.status(200).entity(PDV_CADASTRADO).build();
		}

		ObjectMapper mapper = new ObjectMapper();

		try {
			String json = mapper.writeValueAsString(pdv);
			DBObject dbObject = (DBObject)JSON.parse(json);

			coll.insert(dbObject);
		} catch (JsonProcessingException e) {
			return Response.status(200).entity(JSON_INVALIDO).build();
		}

		return Response.status(200).entity(PDV_INSERIDO).build();
	}

}
