package top.vchao.bean;

public class QuestBean {

	private int id;
	private int q_type;// 题型：0：判断题 1：选择题
	private String title;// 问题
	private String optionA;// 选项A
	private String optionB;// 选项B
	private String optionC;// 选项C
	private String optionD;// 选项D
	private String answer;// 正确答案
	private String tips;// 提示
	private String explain;// 我的答案
	
	public QuestBean(int _id, int q_type, String title, String optionA,
            String optionB, String optionC, String optionD, String answer,
            String tips,String explain) {
        this.id = _id;
        this.q_type = q_type;
        this.title = title;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.answer = answer;
        this.tips = tips;
        this.explain = explain;
        
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQ_type() {
		return q_type;
	}
	public void setQ_type(int q_type) {
		this.q_type = q_type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getOptionA() {
		return optionA;
	}
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	public String getOptionB() {
		return optionB;
	}
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	public String getOptionC() {
		return optionC;
	}
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	public String getOptionD() {
		return optionD;
	}
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	
}