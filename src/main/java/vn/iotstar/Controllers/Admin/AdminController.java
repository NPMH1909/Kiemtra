package vn.iotstar.Controllers.Admin;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.iotstar.Models.Books;
import vn.iotstar.Services.BooksServiceImpl;
import vn.iotstar.Services.IBooksService;


@WebServlet(urlPatterns = {"/admin-view","/admin-home","/admin-update","/admin-delete","/admin-add"})
public class AdminController extends HttpServlet{
	
	IBooksService bookService = new BooksServiceImpl();
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURL().toString();
		if(url.contains("home")) {
			findAll(req, resp);
		}
		else if(url.contains("view"))
		{
			Page(req,resp);
		}
		else if(url.contains("add")) {
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/addbook.jsp");
			rd.forward(req, resp);
		}else if(url.contains("update")) {
			int id = Integer.parseInt(req.getParameter("id"));
			Books model = bookService.findOne(id);
			req.setAttribute("book", model);
			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/updatebook.jsp");
			rd.forward(req, resp);
		}else if(url.contains("delete")) {
			delete(req,resp);
			}
	}
	private void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Books> list = bookService.findAll();
		req.setAttribute("listcate", list);
		RequestDispatcher rd = req.getRequestDispatcher("/views/book/listbook.jsp");
		rd.forward(req, resp);
	}

	protected void Page(HttpServletRequest req, HttpServletResponse resp)
	        throws ServletException, IOException {
	    String indexPage = req.getParameter("index");
	    if(indexPage == null) {
	        indexPage = "1";
	    }
	    int indexp = Integer.parseInt(indexPage);
	 
	    int countP = bookService.countAll();
	    int endPage = countP / 6; 
	    if (countP % 6 != 0) {
	        endPage++;
	    }
	    List<Books> listBook = bookService.findAllPage(indexp - 1);
	    req.setAttribute("listBook", listBook);
	    req.setAttribute("countPage", countP);
	    List<Books> listBookAll = bookService.findAll();
	    req.setAttribute("listcate", listBookAll);
	    req.setAttribute("tag", indexp);
	    req.setAttribute("endP", endPage);
	    RequestDispatcher rd = req.getRequestDispatcher("/views/admin/pagebook.jsp");
	    rd.forward(req, resp);
	}
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		try {
			bookService.delete(id);
			req.setAttribute("message", "Xoa thanh cong");
			
		
		} catch (Exception e) {
			e.printStackTrace();
			req.setAttribute("error", "That bai");
		}
		RequestDispatcher rd = req.getRequestDispatcher("admin-view");
		rd.forward(req, resp);
		
	}
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = req.getRequestURI().toString();
		if(url.contains("add")) {
			insert(req,resp);
		}else if(url.contains("update")) {
			update(req,resp);
		}
	}
	
	private void insert(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String publish = req.getParameter("publish");
		String isbnString = req.getParameter("isbn");
		String priceString = req.getParameter("price");
		String desc = req.getParameter("description");
		String cover = req.getParameter("cover_image");
		String quanString = req.getParameter("quantity");

		int isbn = 0; 
		float price = 0.0f; 
		int quan = 0; 

		if (isbnString != null && !isbnString.isEmpty()) {
		    try {
		        isbn = Integer.parseInt(isbnString);
		    } catch (NumberFormatException e) {
		       
		    }
		}

		if (priceString != null && !priceString.isEmpty()) {
		    try {
		        price = Float.parseFloat(priceString);
		    } catch (NumberFormatException e) {
		        
		    }
		}

		if (quanString != null && !quanString.isEmpty()) {
		    try {
		        quan = Integer.parseInt(quanString);
		    } catch (NumberFormatException e) {
		        
		    }
		}

		Books model = new Books();
		model.setIsbn(isbn);
		model.setTitle(title);
		model.setPublisher(publish);
		model.setPrice(price);
		model.setDescription(desc);
		model.setCover_image(cover);
		model.setQuantity(quan);

		bookService.insert(model);

		
		resp.sendRedirect(req.getContextPath()+ "/admin-view");
		
	}
	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String publish = req.getParameter("publish");
		int id = Integer.parseInt(req.getParameter("bookid"));
		int isbn = Integer.parseInt(req.getParameter("isbn"));
		float price = Float.parseFloat(req.getParameter("price"));
		String desc = req.getParameter("description");
		String cover = req.getParameter("cover_image");;
		int quan = Integer.parseInt(req.getParameter("quantity"));
		
		Books model = new Books();
		model.setBookid(id);
		model.setIsbn(isbn);
		model.setTitle(title);
		model.setPublisher(publish);
		model.setPrice(price);
		model.setDescription(desc);
		//model.setPublish_date();
		model.setCover_image(cover);
		model.setQuantity(quan);
		
		bookService.update(model);

		resp.sendRedirect(req.getContextPath()+ "/admin-view");
		
	}
	}
