package top.vchao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import top.vchao.bean.QuestBean;
import top.vchao.db.DBManager;

public class GradeService {

	/**
	 * �ϴ��ɼ�����
	 * 
	 * @return �ɿ������ɹ����
	 */
	public boolean upgrade(String username, String grade,String usetime,String endtime,String kind,String number) {

		// ��ȡSql��ѯ���
		String gradeSql = "insert into tbl_grade(username, grade,usetime,endtime,kind,number) values('"
				+ username + "','" + grade + "','" +usetime+"','" +endtime+"','" +kind+"','" +number+"')";
		System.out.println(gradeSql);

		// ��ȡDB����
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