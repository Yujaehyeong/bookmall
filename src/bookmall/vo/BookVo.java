package bookmall.vo;

public class BookVo {
	private Long no;
	private String title;
	private Long price;
	private String author;
	private String publisher;
	private CategoryVo categoryVo;
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Long getPrice() {
		return price;
	}
	
	public void setPrice(Long price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public CategoryVo getCategoryVo() {
		return categoryVo;
	}

	public void setCategoryVo(CategoryVo categoryVo) {
		this.categoryVo = categoryVo;
	}

	@Override
	public String toString() {
		return "BookVo [no=" + no + ", title=" + title + ", price=" + price + ", author=" + author + ", publisher="
				+ publisher + ", category=" + categoryVo.getCategory() + "]";
	}
	
}
