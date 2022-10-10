package wp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Product;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ArrayList<Product> products = new ArrayList<Product>();
	@Override
	public void init() {
		
		products.add(new Product(1,"Aydýn Sarýyer Balýk","Deniz manzaralý , taze balýk yiyebilceðiniz tek adres.", 250,"Garipçe Mahallesi, Garipçe Cd. No:78, 34450","Sarýyer","garipceaydýnbalýk.jpg"));
		products.add(new Product(2,"Galata Cafe","Galatanýn içinde tarihi romantizim.", 200,"Bereketzade, Hacý Ali Sk. No:2, 34425","Beyoðlu","galatacafe.jpg"));
		products.add(new Product(3,"KaþýBeyaz Akvaryum","Dýþarýda deniz içeride akvaryum manzaralý özel günlerin tek adresi.", 350,"Yeþilköy, Yeþilköy Halkalý Cd. 93/4, 34153","Florya","kasýbeyaz.jpg"));
		products.add(new Product(4,"Kosmos","Arkadaþlarýnýzda eðlenebilceðiniz harika bir ortam.", 60,"Merkez Mahallesi, Sýracevizler Caddesi, Halepli Þükrü Sokak, No 19/A,","Þiþli","kosmos.jpg"));
		products.add(new Product(5,"Çayona Cafe ve Restoran","Karadeniz mutfaðýný yaþamak için Karadeniz'e gitmeye gerek yok.", 80,"Mimar Sinan, 7, &, Selman-ý Pak Caddesi, Atlas Sk., 34672","Üsküdar","cayona.jpg"));
		products.add(new Product(6,"Geliþli Balýk Restaurant","Nostalji , taze balýk ve deniz manzarasýnýn buluþtuðu tek adres.", 430,"Yeni, 34450","Sarýyer","gelisli-table-dff1c.jpg"));
	}
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String productId = request.getParameter("id");
		int id = Integer.parseInt(productId);
		request.setAttribute("product", products.get(id-1));
		RequestDispatcher rd = request.getRequestDispatcher("show_product.jsp");
		rd.forward(request, response);
	}  
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	request.setAttribute("prods", products);
    	RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
		rd.forward(request, response);

    	//response.sendRedirect("home.jsp");
    }

}
