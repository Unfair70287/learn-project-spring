package fourth.bean;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="Subject")
@Component
public class ExamSubBean {
	
	@Id
	@Column(name="subjectid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer subjectId;
	
	@Column(name="subjectname")
	private String subjectName;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "subject")
	private Set<ExamBean> examBeans = new LinkedHashSet<ExamBean>();
	

	@Override
	public String toString() {
		return "SubBean [subjectId=" + subjectId + ", subjectName=" + subjectName + "]";
	}

	public ExamSubBean() {
		// TODO Auto-generated constructor stub
	}

	public ExamSubBean(Integer subjectId, String subjectName) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
	}


	public Integer getSubjectId() {
		return subjectId;
	}


	public void setSubjectId(Integer subjectId) {
		this.subjectId = subjectId;
	}



	public String getSubjectName() {
		return subjectName;
	}



	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
	
}
