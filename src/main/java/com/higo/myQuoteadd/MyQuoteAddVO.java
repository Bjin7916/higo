package com.higo.myQuoteadd;

public class MyQuoteAddVO {

		private int myQuote_seq;
		private int gosu_seq;
		private int price;
		private int price_type;
		private String quote_detail;
		private String quoteFile_seq;
		private int subSvc_seq;
		private int middleSvc_seq; 
		private int majorSvc_seq; 
		private String myQuote_name;
		
		
		public MyQuoteAddVO() {}
		
		public MyQuoteAddVO(int myQuote_seq, int gosu_seq, int price, int price_type, String quote_detail, String quoteFile_seq,
				int subSvc_seq, int middleSvc_seq, int majorSvc_seq, String myQuote_name) {
			super();
			this.myQuote_seq = myQuote_seq;
			this.gosu_seq = gosu_seq;
			this.price = price;
			this.price_type = price_type;
			this.quote_detail = quote_detail;
			this.quoteFile_seq = quoteFile_seq;
			this.subSvc_seq = subSvc_seq;
			this.middleSvc_seq = middleSvc_seq;
			this.majorSvc_seq = majorSvc_seq;
			this.myQuote_name = myQuote_name;
		}
		
		

		public String getQuote_detail() {
			return quote_detail;
		}

		public void setQuote_detail(String quote_detail) {
			this.quote_detail = quote_detail;
		}

		public int getMyQuote_seq() {
			return myQuote_seq;
		}

		public void setMyQuote_seq(int myQuote_seq) {
			this.myQuote_seq = myQuote_seq;
		}

		public int getGosu_seq() {
			return gosu_seq;
		}

		public void setGosu_seq(int gosu_seq) {
			this.gosu_seq = gosu_seq;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

		public int getPrice_type() {
			return price_type;
		}

		public void setPrice_type(int price_type) {
			this.price_type = price_type;
		}

		public String getQuoteFile_seq() {
			return quoteFile_seq;
		}

		public void setQuoteFile_seq(String quoteFile_seq) {
			this.quoteFile_seq = quoteFile_seq;
		}

		public int getSubSvc_seq() {
			return subSvc_seq;
		}

		public void setSubSvc_seq(int subSvc_seq) {
			this.subSvc_seq = subSvc_seq;
		}

		public int getMiddleSvc_seq() {
			return middleSvc_seq;
		}

		public void setMiddleSvc_seq(int middleSvc_seq) {
			this.middleSvc_seq = middleSvc_seq;
		}

		public int getMajorSvc_seq() {
			return majorSvc_seq;
		}

		public void setMajorSvc_seq(int majorSvc_seq) {
			this.majorSvc_seq = majorSvc_seq;
		}

		public String getMyQuote_name() {
			return myQuote_name;
		}

		public void setMyQuote_name(String myQuote_name) {
			this.myQuote_name = myQuote_name;
		}
		
		
		
		
}
