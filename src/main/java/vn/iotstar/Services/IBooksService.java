package vn.iotstar.Services;

import java.util.List;

import vn.iotstar.Models.Books;

public interface IBooksService {
	List<Books> findAll();
	List<Books> findAllPage(int indexp);
	int countAll();
	Books findOne(int id);
	void insert(Books book);
	void update(Books model);
	void delete(int id);
}
