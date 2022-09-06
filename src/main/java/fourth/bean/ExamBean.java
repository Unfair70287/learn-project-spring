package fourth.bean;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name="examination")
@Component
public class ExamBean implements Serializable
{		

	@Id
	@Column(name = "examid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer examID;
	
	@ManyToOne
	@JoinColumn(name="subjectname")
    private ExamSubBean subject;
	
	@ManyToOne
	@JoinColumn(name="educationlevel")
    private ExamEduBean education;
	
	@Column(name = "examname")
    private String examName;

	@Column(name = "examdate")	
    private Date examdate;
	
	
	@Override
	public String toString() {
		return " examID=" + examID +" subject=" + subject + ", education=" + 
	education + ", examName="+ examName + ", examdate=" + examdate;
	}
	
	
	public ExamBean(){
    }

	
	
	public ExamBean(ExamSubBean subject, ExamEduBean education, String examName, Date examdate) {
		super();
		this.subject = subject;
		this.education = education;
		this.examName = examName;
		this.examdate = examdate;
	}


	public ExamBean(Integer examID, ExamSubBean subject, ExamEduBean education, String examName, Date examdate) {
		super();
		this.examID = examID;
		this.subject = subject;
		this.education = education;
		this.examName = examName;
		this.examdate = examdate;
	}


	public int getExamID() {
		return examID;
	}


	public void setExamID(Integer examID) {
		this.examID = examID;
	}


	public ExamSubBean getSubject() {
		return subject;
	}


	public void setSubject(ExamSubBean subject) {
		this.subject = subject;
	}


	public ExamEduBean getEducation() {
		return education;
	}


	public void setEducation(ExamEduBean education) {
		this.education = education;
	}


	public String getExamName() {
		return examName;
	}


	public void setExamName(String examName) {
		this.examName = examName;
	}


	public Date getExamdate() {
		return examdate;
	}


	public void setExamdate(Date examdate) {
		this.examdate = examdate;
	}
	
	
	

  

}