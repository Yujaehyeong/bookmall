package bookmall.test;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;
import bookmall.vo.CategoryVo;

public class BookDaoTest {
	
	public static void main(String[] args) {
		setBookData(); // 도서데이터 세팅
	}

	public static void setBookData() {

		BookVo bookVo1 = new BookVo();
		bookVo1.setTitle("트와일라잇");
		bookVo1.setPrice(15000L);
		bookVo1.setAuthor("스테파니메이어");
		bookVo1.setPublisher("한빛");
		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setNo(1L);
		bookVo1.setCategoryVo(categoryVo);

		BookVo bookVo2 = new BookVo();
		bookVo2.setTitle("아리랑");
		bookVo2.setPrice(16000L);
		bookVo2.setAuthor("조정래");
		bookVo2.setPublisher("책과나무");
		CategoryVo categoryVo2 = new CategoryVo();
		categoryVo2.setNo(2L);
		bookVo2.setCategoryVo(categoryVo2);

		BookVo bookVo3 = new BookVo();
		bookVo3.setTitle("이것이자바다");
		bookVo3.setPrice(15000L);
		bookVo3.setAuthor("유재형");
		bookVo3.setPublisher("한빛");
		CategoryVo categoryVo3 = new CategoryVo();
		categoryVo3.setNo(3L);
		bookVo3.setCategoryVo(categoryVo3);

		insertBook(bookVo1);
		insertBook(bookVo2);
		insertBook(bookVo3);

	}

	public static void insertBook(BookVo bookVo) {

		if(new BookDao().insertBook(bookVo)){
			System.out.println("도서 INSERT 성공 !!");
		}

	}
}
