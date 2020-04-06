package top.vchao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import top.vchao.db.DBManager;

public class StartService {

	/**
	 * ��¼����
	 * 
	 * @param username
	 * @param password
	 * @return ��¼�ɹ����
	 */
	public HashMap<String, String> login(String username, String password) {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		// ��ȡSql��ѯ���
		String logSql = "select perssion from tbl_user_info where username ='"
				+ username + "' and password ='" + password + "'";
		System.out.println(logSql);
		// ��ȡDB����
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		hashMap.put("permission", "-1");
		hashMap.put("username", username);

		// ����DB����
		try {
			ResultSet rs = sql.executeQuery(logSql);
			if (rs.next()) {
				hashMap.put("permission", rs.getInt(1) + "");
				System.out.print("Ȩ��===" + rs.getInt(1) + "\t");
				sql.closeDB();
				return hashMap;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return hashMap;
	}

	/**
	 * ע�᷽��
	 * 
	 * @param username
	 * @param password
	 * @return ע��ɹ����
	 */
	public HashMap<String, String> register(String username, String password) {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("username", username);
		hashMap.put("msg", "notok");
		if (this.namerepeat(username)) {
			hashMap.put("msg", "rename");
		} else {
			// ��ȡSql��ѯ���
			String regSql = "insert into tbl_user_info(username,password) values('"
					+ username + "','" + password + "')";
			System.out.println(regSql);

			// ��ȡDB����
			DBManager sql = DBManager.createInstance();
			sql.connectDB();

			int ret = sql.executeUpdate(regSql);
			if (ret != 0) {
				hashMap.put("msg", "ok");
				sql.closeDB();
				return hashMap;
			}
			sql.closeDB();
		}

		return hashMap;
	}

	/**
	 * �����˻��Ƿ��Ѿ�ע��
	 * 
	 * @param username
	 * @return ע��״̬
	 */
	public Boolean namerepeat(String username) {
		String checkSql = "select username from tbl_user_info where username ='"
				+ username + "'";
		// ��ȡSql��ѯ���
		System.out.println(checkSql);

		// ��ȡDB����
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		// ����DB����
		try {
			ResultSet rs = sql.executeQuery(checkSql);
			if (rs.next()) {

				sql.closeDB();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		sql.closeDB();
		return false;
	}
}