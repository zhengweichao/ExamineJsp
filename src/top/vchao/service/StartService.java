package top.vchao.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import top.vchao.db.DBManager;

public class StartService {

	/**
	 * 登录方法
	 * 
	 * @param username
	 * @param password
	 * @return 登录成功与否
	 */
	public HashMap<String, String> login(String username, String password) {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		// 获取Sql查询语句
		String logSql = "select perssion from tbl_user_info where username ='"
				+ username + "' and password ='" + password + "'";
		System.out.println(logSql);
		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		hashMap.put("permission", "-1");
		hashMap.put("username", username);

		// 操作DB对象
		try {
			ResultSet rs = sql.executeQuery(logSql);
			if (rs.next()) {
				hashMap.put("permission", rs.getInt(1) + "");
				System.out.print("权限===" + rs.getInt(1) + "\t");
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
	 * 注册方法
	 * 
	 * @param username
	 * @param password
	 * @return 注册成功与否
	 */
	public HashMap<String, String> register(String username, String password) {

		HashMap<String, String> hashMap = new HashMap<String, String>();
		hashMap.put("username", username);
		hashMap.put("msg", "notok");
		if (this.namerepeat(username)) {
			hashMap.put("msg", "rename");
		} else {
			// 获取Sql查询语句
			String regSql = "insert into tbl_user_info(username,password) values('"
					+ username + "','" + password + "')";
			System.out.println(regSql);

			// 获取DB对象
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
	 * 检测该账户是否已经注册
	 * 
	 * @param username
	 * @return 注册状态
	 */
	public Boolean namerepeat(String username) {
		String checkSql = "select username from tbl_user_info where username ='"
				+ username + "'";
		// 获取Sql查询语句
		System.out.println(checkSql);

		// 获取DB对象
		DBManager sql = DBManager.createInstance();
		sql.connectDB();

		// 操作DB对象
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