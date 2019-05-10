package bookmall.vo;

public class CartVo {

	private Long bookNo;
	private String memberId;
	private String title;
	private Long amount;
	private Long price;

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

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "CartVo [bookNo=" + bookNo + ", memberId=" + memberId + ", title=" + title + ", amount=" + amount
				+ ", price=" + price + "]";
	}

}
