package mongoClient;

import org.bson.types.ObjectId;

import mongoClient.User;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class UserConverter {
	
	public static DBObject toDBObject(User p) {
		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("name", p.getName());
		if (p.getId() != null)
			builder = builder.append("_id", new ObjectId(p.getId()));
		return builder.get();
	}

	// convert DBObject Object to Person
	// take special note of converting ObjectId to String
	public static User toPerson(DBObject doc) {
		User p = new User();
		p.setName((String) doc.get("name"));
		ObjectId id = (ObjectId) doc.get("_id");
		p.setId(id.toString());
		return p;

	}
}