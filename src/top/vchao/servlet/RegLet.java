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

public class RegLet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收客户端信息
		String username = request.getParameter("username");
		username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
		String password = request.getParameter("password");
		System.out.println(username + "--" + password);

		// 新建服务对象
		StartService serv = new StartService();
		String msg = "notok";
		HashMap<String, String> hashMap = serv.register(username, password);
		msg = hashMap.get("msg");
		if ("ok".equals(hashMap.get("msg"))) {
			// 注册成功
			System.out.println("注册成功");
		} else {
			System.out.println("注册失败" + msg);
		}

		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("username", username);
			jsonObj.put("msg", msg);
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
