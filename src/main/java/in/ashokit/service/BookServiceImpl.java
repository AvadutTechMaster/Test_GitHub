package in.ashokit.service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.beans.Books;
import in.ashokit.dao.BookDao;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDao bookDao;

	@Override
	public void readData() {

		FileInputStream fileInputStream = null;
		Scanner scanner = null;

		try {
			fileInputStream = new FileInputStream("D:\\Avadut_Workspace_Java\\Assignment-001\\book.txt");
			scanner = new Scanner(fileInputStream);

			while (scanner.hasNext()) {
				//System.out.println(scanner.nextLine());
				String nextLine = scanner.nextLine();
				String[] split = nextLine.split(",");
				String bookId = split[0];
				String bookName = split[1];
				String bookPrice = split[2];
				
				Books b=new Books();
				b.setBookId(Integer.parseInt(bookId));
				b.setBookName(bookName);
				b.setBookPrice(Double.parseDouble(bookPrice));
				
				int insertData = bookDao.insertData(b);
				
				if(insertData>=1) {
					System.out.println("Record InsertSuccesfully");
				}
			}
		} catch (Exception e) {
			System.out.println(e);

		} finally {
			try {
				fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			scanner.close();
		}

	}

}
