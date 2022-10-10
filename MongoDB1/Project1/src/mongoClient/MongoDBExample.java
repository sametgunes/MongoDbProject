package mongoClient;

import wp.Controller;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mongoClient.User;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

public class MongoDBExample { 
	private static int i=0;
	public static void main(String[] args) throws UnknownHostException {
	
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("journaldev");
		
		
    	
		User user = createUser(Controller.name,Controller.pwd);
		DBObject doc = createDBObject(user);
	
		
		DBCollection col = db.getCollection("users");
		
		
		
		//create user
		WriteResult result = col.insert(doc);
		System.out.println(result.getUpsertedId());
		System.out.println(result.getN());
		System.out.println(result.isUpdateOfExisting());
		
		//read example
		DBObject query = BasicDBObjectBuilder.start().add("_id", user.getId()).get();
		DBCursor cursor = col.find(query);
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
		//update example
		user.setName(Controller.name);
		doc = createDBObject(user);
		result = col.update(query, doc);
		System.out.println(result.getUpsertedId());
		System.out.println(result.getN());
		System.out.println(result.isUpdateOfExisting());
		
		List<User> data = new ArrayList<User>();
		DBCursor cursorr = col.find();
		while (cursorr.hasNext()) {
			System.out.println(cursorr.next());
		}
		
		
		//close resources
		mongo.close();
	}

	public static DBObject createDBObject(User user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("_id", user.getId());
		docBuilder.append("name", user.getName());
		docBuilder.append("role", user.getPwd());
		return docBuilder.get();
	}

	public static User createUser(String name, String pass) {
		User u = new User();
		u.setId(Integer.toString(i));
		u.setName(name);
		u.setPwd(pass);
		i=i+1;
		return u;
	}
	
	
}