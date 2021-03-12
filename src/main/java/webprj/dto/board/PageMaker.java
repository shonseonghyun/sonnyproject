package webprj.dto.board;

public class PageMaker {
		private int count;
		private int page;
		private int start;
		private int end;
		private int prev;
		private int next;

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			this.page = page;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}
		

		public int getPrev() {
			return prev;
		}

		public void setPrev(int prev) {
			this.prev = prev;
		}

		public int getNext() {
			return next;
		}

		public void setNext(int next) {
			this.next = next;
		}

		public PageMaker(int count,int page){
			this.count=count;
			this.page=page;
			calcPage();
		}
		
		@Override
		public String toString() {
			return "PageMaker [count=" + count + ", page=" + page + ", start=" + start + ", end=" + end + ", prev=" + prev
					+ ", next=" + next + "]";
		}

		private void calcPage() {
			start=page%5==0?page/5:page/5+1;
			end=count%5==0?count/5:count/5+1; //끝페이지번호
			//다음페이지번호,이전페이지번호 계산
			if(page%5!=0) {
				next=5*(page/5)+6;
				prev=5*(page/5-1)+1;
			}
			if(page%5==0) {
				next=page+1;
				prev=page-9;
			}
		}
		
}
