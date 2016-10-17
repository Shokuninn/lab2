package domin;

public class book {
    private String ISBN;
    private String Title;
    private String AuthorID;
    private String Publisher;
    private String PublishDate;
    private String Price;

	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(String authorID) {
		AuthorID = authorID;
	}
	public String getPublisher() {
		return Publisher;
	}
	public void setPublisher(String publisher) {
		Publisher = publisher;
	}
	public String getPublishDate() {
		return PublishDate;
	}
	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}
	public String getPrice() {
		return Price;
	}
	public void setPrice(String price) {
		Price = price;
	}
	public book(){}
	public book(String iSBN, String title, String authorID, String publisher, String publishDate, String price) {
		super();
		ISBN = iSBN;
		Title = title;
		AuthorID = authorID;
		Publisher = publisher;
		PublishDate = publishDate;
		Price = price;

	}

}