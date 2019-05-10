package bookmall.vo;

public class OrderVo {

	private Long no;
	private Long paymentPrice;
	private String destination;
	private String deliveryStatus;
	private String orderDate;
	private String memberId;
	
	public Long getNo() {
		return no;
	}

	public void setNo(Long no) {
		this.no = no;
	}

	public Long getPaymentPrice() {
		return paymentPrice;
	}

	public void setPaymentPrice(Long paymentPrice) {
		this.paymentPrice = paymentPrice;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", paymentPrice=" + paymentPrice + ", destination=" + destination
				+ ", deliveryStatus=" + deliveryStatus + ", orderDate=" + orderDate + ", memberId=" + memberId + "]";
	}

}