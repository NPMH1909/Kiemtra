package vn.iotstar.Services;

import java.util.List;

import vn.iotstar.DAO.BooksDaoImpl;
import vn.iotstar.DAO.IBooksDao;
import vn.iotstar.Models.Books;

public class BooksServiceImpl implements IBooksService{

	IBooksDao book = new BooksDaoImpl();
	@Override
	public List<Books> findAll() {
		// TODO Auto-generated method stub
		return book.findAll();
	}
	@Override
	public List<Books> findAllPage(int indexp) {
		// TODO Auto-generated method stub
		return book.findAllPage(indexp);
	}
	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return book.countAll();
	}
	@Override
	public Books findOne(int id) {
		// TODO Auto-generated method stub
		return book.findOne(id);
	}
	@Override
	public void update(Books model) {
		Books oldcate = book.findOne(model.getBookid());
		
		oldcate.setBookid(model.getBookid());
		oldcate.setIsbn(model.getIsbn());
		oldcate.setTitle(model.getTitle());
		oldcate.setPublisher(model.getPublisher());
		oldcate.setPrice(model.getPrice());
		oldcate.setDescription(model.getDescription());
		oldcate.setCover_image(model.getCover_image());
		oldcate.setQuantity(model.getQuantity());
		book.update(oldcate);
	}
	@Override
	public void delete(int id) {
		book.delete(id);
		
	}
	@Override
	public void insert(Books model) {
		book.insert(model);
		
	}

}
