package top.vchao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import top.vchao.bean.QuestBean;
import top.vchao.db.DBManager;

public class GradeService {

	/**
	 * 上传成绩方法
	 * 
	 * @return 成績表插入成功与否
	 */
	public boolean upgrade(String username, String grade,String usetime,String endtime,String kind,String number) {

		// 获取Sql查询语句
		String gradeSql = "insert into tbl_grade(username, grade,usetime,endtime,kind,number) values('"
				+ username + "','" + grade + "','" +usetime+"','" +endtime+"','" +kind+"','" +number+"')";
		System.out.println(gradeSql);

		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		int ret = sql.executeUpdate(gradeSql);
		if (ret != 0) {
			sql.closeDB();
			return true;
		}
		sql.closeDB();

		return false;
	}

}