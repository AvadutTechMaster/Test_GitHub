package in.ashokit.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.springframework.stereotype.Repository;

import in.ashokit.beans.Books;

@Repository
public class BookDaoImpl implements BookDao {

	@Override
	public int insertData(Books book) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice", "root", "Chand@143");

			PreparedStatement pstmt = con
					.prepareStatement("insert into bookdata(bookId,bookName,bookPrice)values(?,?,?)");

			pstmt.setInt(1, book.getBookId());
			pstmt.setString(2, book.getBookName());
			pstmt.setDouble(3, book.getBookPrice());

			int i = pstmt.executeUpdate();

			return i;

		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;

	}

}
