package vn.iotstar.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vn.iotstar.Models.Books;

public class BooksDaoImpl implements IBooksDao{

	Connection cnn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<Books> findAll() {
		List<Books> list = new ArrayList<Books>();
		String sql = "select * from Books";
		try {
			cnn = new DBConnectionsqlserver().getConnection();
			ps = cnn.prepareStatement(sql);
			rs = ps.executeQuery();
		while(rs.next()) {
			Books book = new Books();
			book.setBookid(rs.getInt("bookid"));
			book.setIsbn(rs.getInt("isbn"));
			book.setTitle(rs.getString("title"));
			book.setPublisher(rs.getString("publisher"));
			book.setPrice(rs.getFloat("price"));
			book.setDescription(rs.getString("description"));
			//book.setPublish_date(rs.getDate("publish_date"));
			book.setCover_image(rs.getString("cover_image"));
			book.setQuantity(rs.getInt("quantity"));
			list.add(book);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}


	@Override
	public List<Books> findAllPage(int indexp) {
		List<Books> list = new ArrayList<Books>();
		String sql = "select * from Books order by Bookid OFFSET ?* 6 Rows fetch next 6 rows only;";
		try {
			cnn = new DBConnectionsqlserver().getConnection();
			ps = cnn.prepareStatement(sql);
			ps.setInt(1, indexp);
			rs = ps.executeQuery();
		while(rs.next()) {
			Books book = new Books();
			book.setBookid(rs.getInt("bookid"));
			book.setIsbn(rs.getInt("isbn"));
			book.setTitle(rs.getString("title"));
			book.setPublisher(rs.getString("publisher"));
			book.setPrice(rs.getFloat("price"));
			book.setDescription(rs.getString("description"));
			book.setPublish_date(rs.getDate("publish_date"));
			book.setCover_image(rs.getString("cover_image"));
			book.setQuantity(rs.getInt("quantity"));
			list.add(book);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int countAll() {
		String sql = "select count(*) from books";
		try {
			cnn = new DBConnectionsqlserver().getConnection();
			ps = cnn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
		
		}
		return 0;
	}


	@Override
	public Books findOne(int id) {
		String sql = "select * from books where bookid=?";
		Books book = new Books();
		try {
			cnn = new DBConnectionsqlserver().getConnection();
			ps = cnn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				
				book.setBookid(rs.getInt("bookid"));
				book.setIsbn(rs.getInt("isbn"));
				book.setTitle(rs.getString("title"));
				book.setPublisher(rs.getString("publisher"));
				book.setPrice(rs.getFloat("price"));
				book.setDescription(rs.getString("description"));
				//book.setPublish_date(rs.getDate("publish_date"));
				book.setCover_image(rs.getString("cover_image"));
				book.setQuantity(rs.getInt("quantity"));
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}return book;
	}


	@Override
	public void update(Books book) {
		String sql = "update Books set isbn=?, title=?, publisher=?, price =?, description=?,  cover_image=?,quantity=?  where bookid=?";
		try {
			cnn = new DBConnectionsqlserver().getConnection();//ket noi du lieu
			ps = cnn.prepareStatement(sql);//phat bieu cau query
			ps.setInt(1,book.getIsbn());//truyen tham so vao query
			ps.setString(2,book.getTitle());
			ps.setString(3,book.getPublisher());
			ps.setFloat(4,book.getPrice());
			ps.setString(5,book.getDescription());
			/*
			 * Date publishDate = new Date(book.getPublish_date().getTime()); // Chuyển đổi
			 * từ java.util.Date sang java.sql.Date ps.setDate(6, publishDate);
			 */
			ps.setString(6, book.getCover_image());
			ps.setInt(7, book.getQuantity());
			ps.setInt(8, book.getBookid());
	
			ps.executeUpdate();//Thuc thi cau truy van
			cnn.close();
			}catch (Exception e) {
				e.printStackTrace();
		}
		
	}


	@Override
	public void delete(int id) {
		String sql = "delete from Books where bookid=?";
		try {
			cnn = new DBConnectionsqlserver().getConnection();//ket noi du lieu
			ps = cnn.prepareStatement(sql);//phat bieu cau query
			ps.setInt(1, id);
			ps.executeUpdate();// thực hiện các truy vấn SQL không trả về dữ liệu từ cơ sở dữ liệu.
			cnn.close();
			}catch (Exception e) {
				e.printStackTrace();
		}
		
	}


	@Override
	public void insert(Books book) {
		String sql = "insert into Books(isbn, title, publisher, price, description,  cover_image,quantity) values(?,?,?,?,?,?,?)";
		try {
			cnn = new DBConnectionsqlserver().getConnection();//ket noi du lieu
			ps = cnn.prepareStatement(sql);//phat bieu cau query
			
			// 
			ps.setInt(1,book.getIsbn());//truyen tham so vao query
			ps.setString(2,book.getTitle());
			ps.setString(3,book.getPublisher());
			ps.setFloat(4,book.getPrice());
			ps.setString(5,book.getDescription());
			/*
			 * Date publishDate = new Date(book.getPublish_date().getTime()); // Chuyển đổi
			 * từ java.util.Date sang java.sql.Date ps.setDate(6, publishDate);
			 */
			ps.setString(6, book.getCover_image());
			ps.setInt(7, book.getQuantity());
			ps.executeUpdate();//Thuc thi cau truy van
			cnn.close();
			}catch (Exception e) {
				e.printStackTrace();
		}
		
	}
	

}
