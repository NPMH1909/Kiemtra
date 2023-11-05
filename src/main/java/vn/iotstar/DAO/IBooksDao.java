package vn.iotstar.DAO;

import java.util.List;

import vn.iotstar.Models.Books;

public interface IBooksDao {
	List<Books> findAll();
	List<Books> findAllPage(int indexp);
	int countAll();
	Books findOne(int id);
	void insert(Books model);
	void update(Books model);
	void delete(int id);
}
