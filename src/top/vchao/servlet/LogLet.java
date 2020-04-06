package top.vchao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import top.vchao.service.StartService;

public class LogLet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// http://localhost:8080/Examine1/LogLet?username=001&password=aaa
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("客户端参数：" + username + "  ======  " + password);

		// 新建服务对象，默认权限为-1（未登录状态）
		StartService serv = new StartService();
		int permission = -1;

		HashMap<String, String> logiii = serv.login(username, password);
		String a = logiii.get("username");
		// 登陆验证处理（权限>-1为登录成功）
		if ("-1".equals(logiii.get("permission"))) {
			// 登录失败
			System.out.print("登录失败Failed");
		} else {
			// 登陆成功
			permission = Integer.parseInt(logiii.get("permission"));
		}

		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("username", username);
			jsonObj.put("permission", permission);
			System.out.println(jsonObj);
			// 返回信息到客户端
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.print(jsonObj);
			out.flush();
			out.close();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
