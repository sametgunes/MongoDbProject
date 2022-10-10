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
		
		products.add(new Product(1,"Ayd�n Sar�yer Bal�k","Deniz manzaral� , taze bal�k yiyebilce�iniz tek adres.", 250,"Garip�e Mahallesi, Garip�e Cd. No:78, 34450","Sar�yer","garipceayd�nbal�k.jpg"));
		products.add(new Product(2,"Galata Cafe","Galatan�n i�inde tarihi romantizim.", 200,"Bereketzade, Hac� Ali Sk. No:2, 34425","Beyo�lu","galatacafe.jpg"));
		products.add(new Product(3,"Ka��Beyaz Akvaryum","D��ar�da deniz i�eride akvaryum manzaral� �zel g�nlerin tek adresi.", 350,"Ye�ilk�y, Ye�ilk�y Halkal� Cd. 93/4, 34153","Florya","kas�beyaz.jpg"));
		products.add(new Product(4,"Kosmos","Arkada�lar�n�zda e�lenebilce�iniz harika bir ortam.", 60,"Merkez Mahallesi, S�racevizler Caddesi, Halepli ��kr� Sokak, No 19/A,","�i�li","kosmos.jpg"));
		products.add(new Product(5,"�ayona Cafe ve Restoran","Karadeniz mutfa��n� ya�amak i�in Karadeniz'e gitmeye gerek yok.", 80,"Mimar Sinan, 7, &, Selman-� Pak Caddesi, Atlas Sk., 34672","�sk�dar","cayona.jpg"));
		products.add(new Product(6,"Geli�li Bal�k Restaurant","Nostalji , taze bal�k ve deniz manzaras�n�n bulu�tu�u tek adres.", 430,"Yeni, 34450","Sar�yer","gelisli-table-dff1c.jpg"));
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
