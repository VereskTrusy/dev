package vo.goods;

public class OrderDetailVo {
	 private int goods_no;
	 private int order_no;
	 private int order_amount;
	 
	 
	public OrderDetailVo() {

	}

	
	public int getGoods_no() {
		return goods_no;
	}

	public void setGoods_no(int goods_no) {
		this.goods_no = goods_no;
	}

	public int getOrder_no() {
		return order_no;
	}

	public void setOrder_no(int order_no) {
		this.order_no = order_no;
	}

	public int getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(int order_amount) {
		this.order_amount = order_amount;
	}


	@Override
	public String toString() {
		return "OrderDetailVO [goods_no=" + goods_no + ", order_no=" + order_no + ", order_amount=" + order_amount
				+ "]";
	}
	
	
	 
	 
	 
}
