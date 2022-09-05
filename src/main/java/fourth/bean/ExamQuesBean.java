package fourth.bean;

import java.io.Serializable;

import org.springframework.stereotype.Component;


public class ExamQuesBean implements Serializable
{	
		
	private int quesID;
	private int quesSbjectName;
	private int quesEducationLevel;
	private String quesContent;
	private String optA;
	private String optB;
	private String optC;
	private String optD;
	private String answer;
	private int score;
	
	
	
	
	
	public ExamQuesBean(int quesID, int quesSbjectName, int quesEducationLevel, String quesContent, String optA,
			String optB, String optC, String optD, String answer, int score) {
		super();
		this.quesID = quesID;
		this.quesSbjectName = quesSbjectName;
		this.quesEducationLevel = quesEducationLevel;
		this.quesContent = quesContent;
		this.optA = optA;
		this.optB = optB;
		this.optC = optC;
		this.optD = optD;
		this.answer = answer;
		this.score = score;
	}
	
	
	public int getQuesID() {
		return quesID;
	}
	public void setQuesID(int quesID) {
		this.quesID = quesID;
	}
	public int getQuesSbjectName() {
		return quesSbjectName;
	}
	public void setQuesSbjectName(int quesSbjectName) {
		this.quesSbjectName = quesSbjectName;
	}
	public int getQuesEducationLevel() {
		return quesEducationLevel;
	}
	public void setQuesEducationLevel(int quesEducationLevel) {
		this.quesEducationLevel = quesEducationLevel;
	}
	public String getQuesContent() {
		return quesContent;
	}
	public void setQuesContent(String quesContent) {
		this.quesContent = quesContent;
	}
	public String getOptA() {
		return optA;
	}
	public void setOptA(String optA) {
		this.optA = optA;
	}
	public String getOptB() {
		return optB;
	}
	public void setOptB(String optB) {
		this.optB = optB;
	}
	public String getOptC() {
		return optC;
	}
	public void setOptC(String optC) {
		this.optC = optC;
	}
	public String getOptD() {
		return optD;
	}
	public void setOptD(String optD) {
		this.optD = optD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
	
	
	
	
}
