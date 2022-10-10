package wp;

import java.io.IOException;
import model.Product;
import mongoClient.User;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.WriteResult;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String name,username;
	public static String pwd;
	public static User user;
	public static DBObject doc ;
	public static int i=0,n=0;
	public static DBCollection col;
	public static WriteResult result;
	public static String url;
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		        HttpSession session = request.getSession(false);
			    url = null;
				name = request.getParameter("name");
				username = request.getParameter("username");
				pwd = request.getParameter("pwd");
				
				MongoClient mongo = new MongoClient("localhost", 27017);
				DB db = mongo.getDB("merhaba");
				
		    	
				User user = createUser(name,pwd);
				DBObject doc = createDBObject(user);
			
				col = db.getCollection("users");
				
				//create user
				 result = col.insert(doc);
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
				user.setName(name);
				doc = createDBObject(user);
				result = col.update(query, doc);
				System.out.println(result.getUpsertedId());
				System.out.println(result.getN());
				System.out.println(result.isUpdateOfExisting());
				
				//List<User> data = new ArrayList<User>();
				DBCursor cursorr = col.find();
				while (cursorr.hasNext()) {
					System.out.println(cursorr.next());
				}
				String a = user.getName();
				String p = user.getPwd();
				String idi=user.getId();
				selectAllRecordByRecordNumber(col,a,p,idi);
				
				url=null;
				if(session == null) {
					if(name.equals("")  || pwd.equals("")) {
						url = "nossesion.jsp";
					}
					else {
						url = "nossesion.jsp";
						}
				}
				else {
					if(name.equals("") || pwd.equals("")) {
						url = "nossesion.jsp";
					}
					else {
						HttpSession session1 = request.getSession();
						session1.setAttribute("user", name);
						session1.setAttribute("username", username);
						url = "singinSucces.jsp";
					}
				}

				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
				
				//close resources
				mongo.close();
	
	}
	private static DBObject createDBObject(User user) {
		BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
		docBuilder.append("id", user.getId());
		docBuilder.append("name", user.getName());
		docBuilder.append("pass", user.getPwd());
		return docBuilder.get();
	}

	private static User createUser(String name, String pass) {
		User u = new User();
		u.setId(Integer.toString(i));
		u.setName(name);
		u.setPwd(pass);
		i=i+1;
		return u;
	}
	
	private static void selectAllRecordByRecordNumber(DBCollection collection, String getname,String pwd,String idi) 
	{
		n=0;
	    BasicDBObject whereQuery = new BasicDBObject();
	    whereQuery.put("name", getname);
	    whereQuery.put("pass", pwd);
	    DBCursor cursor = collection.find(whereQuery);
	    System.out.println(whereQuery);
	    while(cursor.hasNext()) {
	    	n=n+1;
	        System.out.println(cursor.next());
	        System.out.println("n harfi hasNext:"+n);
	        if(n>1) {
	        	System.out.println("n harfi:"+n);
	        	BasicDBObject deleteQuery = new BasicDBObject();
	        	deleteQuery.put("id", idi);
	        	result = col.remove(deleteQuery);
	    		System.out.println(result.getUpsertedId());
	    		System.out.println(result.getN());
	    		System.out.println(result.isUpdateOfExisting());
	    		System.out.println("n harfi:"+n);
	    		url="nossesion.jsp";

	        }
	    }
	}
}