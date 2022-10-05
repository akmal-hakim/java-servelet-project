package review.model;

import payment.model.paymentBean;

public class reviewBean extends paymentBean{
	private int review_id, review_star;
	private String review_text;
	
	public int getReviewID() {
		return this.review_id;
	}
	
	public int getReviewStar() {
		return this.review_star;
	}
	
	public String getReviewText() {
		return this.review_text;
	}
	
	public void setReviewID(int review_id) {
		this.review_id = review_id;
	}
	
	public void setReviewStar(int review_star) {
		this.review_star = review_star;
	}
	
	public void setReviewText(String review_text) {
		this.review_text = review_text;
	}

	@Override
	public String toString() {
		return "reviewBean [review_id=" + review_id + ", review_star=" + review_star + ", review_text=" + review_text
				+ "]";
	}
	
	
}
