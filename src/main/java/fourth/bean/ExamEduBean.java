package fourth.bean;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
@Table(name="education")
@Component
public class ExamEduBean {
	
	@Id
	@Column(name="educationid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer educationId;
	
	@Column(name="educationlevel")
	private String educationName;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "education")
	private Set<ExamBean> examBeans = new LinkedHashSet<ExamBean>();


	@Override
	public String toString() {
		return "EduBean [educationId=" + educationId + ", educationName=" + educationName + "]";
	}

	public ExamEduBean() {
		// TODO Auto-generated constructor stub
	}


	public ExamEduBean(Integer educationId, String educationName) {

		super();
		this.educationId = educationId;
		this.educationName = educationName;
	}
	
	

	public Integer getEducationId() {
		return educationId;
	}


	public void setEducationId(Integer educationId) {
		this.educationId = educationId;
	}


	public String getEducationName() {
		return educationName;
	}


	public void setEducationName(String educationName) {
		this.educationName = educationName;
	}
	
	
	
}
