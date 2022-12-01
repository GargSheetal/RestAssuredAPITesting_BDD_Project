package serializationDeserialization;

public class PostComments {

	public int userId;
	public int it;
	public String title;
	public String body;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public int getIt() {
		return it;
	}
	
	public void setId(Integer it) {
		this.it = it;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getBody() {
		return body;
	}
	
	public void setBody(String body) {
		this.body = body;
	}
	
	public String getPostBody() {
		return(this.userId + " " + this.it + " " + this.title + " " + this.body);
	}
	
}
