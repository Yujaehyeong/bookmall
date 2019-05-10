package bookmall.vo;

public class OrderBookVo {
	
	private Long orderNo;
	private Long bookNo;
	private String title;
	private Long price;
	private String author;
	private String publisher;
	private String category;
	private Long bookAmount;

	public OrderBookVo() {}
	
	public OrderBookVo(Long bookNo, Long bookAmount) {
		this.bookNo =bookNo;
		this.bookAmount = bookAmount;
	}

	public Long getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}

	public Long getBookNo() {
		return bookNo;
	}

	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Long getBookAmount() {
		return bookAmount;
	}

	public void setBookAmount(Long bookAmount) {
		this.bookAmount = bookAmount;
	}

	@Override
	public String toString() {
		return "OrderBookVo [orderNo=" + orderNo + ", bookNo=" + bookNo + ", title=" + title + ", price=" + price
				+ ", author=" + author + ", publisher=" + publisher + ", category=" + category + ", bookAmount="
				+ bookAmount + "]";
	}
	
}
