package top.vchao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import top.vchao.bean.QuestBean;
import top.vchao.db.DBManager;

public class QuestionService {

	public ArrayList<QuestBean> GetQuestion(String type) {
		
		ArrayList<QuestBean> a=new ArrayList<QuestBean>();

		HashMap<String, String> hashMap = new HashMap<String, String>();
		// 获取Sql查询语句
//		String logSql = "SELECT * FROM `tbl_question` LIMIT 0, 5";
		String logSql = "SELECT tbl_question.id,tbl_question.q_type,tbl_question.title,tbl_question.optionA," +
				"tbl_question.optionB,tbl_question.optionC,tbl_question.optionD,tbl_question.tips," +
				" tbl_question.answer, tbl_question.`explain` FROM tbl_question" +
				" WHERE tbl_question.q_type = "+type+" LIMIT 0, 5";
		
		System.out.println(logSql);
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		// 操作DB对象
		try {
			ResultSet rs = sql.executeQuery(logSql);

			while (rs.next()) {
				int id = rs.getInt(1);
				int q_type = rs.getInt(2);
				String title = rs.getString(3);
				String optionA = rs.getString(4);
				String optionB = rs.getString(5);
				String optionC = rs.getString(6);
				String optionD = rs.getString(7);
				String tips = rs.getString(8);
				String answer = rs.getString(9);
				String explain = rs.getString(10);

				QuestBean questBean = new QuestBean(id, q_type, title, optionA, optionB, optionC, optionD, answer, tips, explain);
				
				a.add(questBean);
				System.out.println(questBean.getId()+"==================");
			}
			sql.closeDB();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return a;
	}
	
	public ArrayList<QuestBean> GetTestList(String kind,String num) {
		
		ArrayList<QuestBean> a=new ArrayList<QuestBean>();

		HashMap<String, String> hashMap = new HashMap<String, String>();
		// 获取Sql查询语句
//		String logSql = "SELECT * FROM `tbl_question` LIMIT 0, 5";
		String logSql = "SELECT tbl_question.id,tbl_question.q_type,tbl_question.title,tbl_question.optionA," +
				"tbl_question.optionB,tbl_question.optionC,tbl_question.optionD,tbl_question.tips," +
				" tbl_question.answer, tbl_question.`explain` FROM tbl_question" +
				" WHERE tbl_question.kind = '"+kind+"' LIMIT 0, "+num;
		
		System.out.println(logSql);
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		// 操作DB对象
		try {
			ResultSet rs = sql.executeQuery(logSql);

			while (rs.next()) {
				int id = rs.getInt(1);
				int q_type = rs.getInt(2);
				String title = rs.getString(3);
				String optionA = rs.getString(4);
				String optionB = rs.getString(5);
				String optionC = rs.getString(6);
				String optionD = rs.getString(7);
				String tips = rs.getString(8);
				String answer = rs.getString(9);
				String explain = rs.getString(10);

				QuestBean questBean = new QuestBean(id, q_type, title, optionA, optionB, optionC, optionD, answer, tips, explain);
				
				a.add(questBean);
				System.out.println(questBean.getId()+"==================");
			}
			sql.closeDB();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return a;
	}

}