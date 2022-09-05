package fourth.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="article")
public class ColumnBean implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="article_no")
	private int article_no;
	@Column(name="publish_time")
	private String publish_time;
	@Column(name="user_id")
	private int user_id;
	@Column(name="author")
	private String author;
	@Column(name="role")
	private String role;
	@Column(name="contents")
	private String contents;
	
	public ColumnBean() {
		
	}

	
	
	public ColumnBean(int article_no, String publish_time, int user_id, String author, String role, String contents) {
		super();
		this.article_no = article_no;
		this.publish_time =publish_time ;
		this.user_id = user_id;
		this.author = author;
		this.role = role;
		this.contents = contents;
	}



	

	public int getArticle_no() {
		return article_no;
	}



	public void setArticle_no(int article_no) {
		this.article_no = article_no;
	}



	public String getPublish_time() {
		return publish_time;
	}



	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}



	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}



	@Override
	public String toString() {
		return "ColumnBean [article_no=" + article_no + ", publish_time=" + publish_time + ", user_id=" + user_id
				+ ", author=" + author + ", role=" + role + ", contents=" + contents + "]";
	}



	
	
	
}
