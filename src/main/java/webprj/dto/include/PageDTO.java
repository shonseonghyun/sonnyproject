package webprj.dto.include;

public class PageDTO {
	//총페이지 수
	private int total;
	
	//
	private int quantity;
	
	//
	private int group;
	
	

	//현재 페이지
	private int page;

	//다음페이지
	private boolean next;
	
	//이전페이지
	private boolean prev;
	
	//첫 페이지 번호
	private int first_page;
	
	//마지막 페이지 번호
	private int last_page;

	public int getGroup() {
		return group;
	}

	public void setGroup(int group) {
		this.group = group;
	}
	
	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}


	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public boolean isPrev() {
		return prev;
	}

	public void setPrev(boolean prev) {
		this.prev = prev;
	}

	public int getFirst_page() {
		return first_page;
	}

	public void setFirst_page(int first_page) {
		this.first_page = first_page;
	}

	public int getLast_page() {
		return last_page;
	}

	public void setLast_page(int last_page) {
		this.last_page = last_page;
	}

	public PageDTO(int total, int page,int quantity,int group) {  //32개 5개씩 현재페이지 4
		this.quantity=quantity;					//first_page=1 , last_page= 7
		this.total = total;
		this.page = page;
		this.group=group;
		calPage();
	}
	
	
	// 1 2 3 4 -->12개   1234 ->4   5678-->8
	//5 6 7 --> 7개
	// 19(total)개 3(quantity)개씩 4(group)개페이지그룹
	public void calPage() {
		this.last_page = this.page % this.group !=0 ? (this.page/this.group+1)*this.group: (this.page/this.group)*this.group ;
		this.first_page = this.last_page-(group-1);
		int realEndPage= this.total % this.quantity !=0 ? this.total/this.quantity +1 :this.total/this.quantity ;
		if(this.last_page>realEndPage) {
			this.last_page=realEndPage;
		}
		this.prev = this.page>1;
		this.next = this.last_page < realEndPage;
	}
	
	@Override
	public String toString() {
		return "PageDTO [total=" + total + ", quantity=" + quantity + ", group=" + group + ", page=" + page + ", next="
				+ next + ", prev=" + prev + ", first_page=" + first_page + ", last_page=" + last_page + "]";
	}
}
