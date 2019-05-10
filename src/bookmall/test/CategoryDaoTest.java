package bookmall.test;

import bookmall.dao.CategoryDao;

public class CategoryDaoTest {

	public static void main(String[] args) {
		
		setCategoryData(); // 카테고리 데이터 세팅
		
	}
	
	public static void setCategoryData() {
		
		String category1 = "소설";
		String category2 = "수필";
		String category3 = "컴퓨터/IT";
		
		insertCategory(category1);
		insertCategory(category2);
		insertCategory(category3);

	}

	public static void insertCategory(String category) {

		if(new CategoryDao().insertCategory(category)) {
			System.out.println("카테고리 INSERT 성공 !!");
		}

	}
}
