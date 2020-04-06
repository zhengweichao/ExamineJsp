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
		System.out.println("�ͻ��˲�����" + username + "  ======  " + password);

		// �½��������Ĭ��Ȩ��Ϊ-1��δ��¼״̬��
		StartService serv = new StartService();
		int permission = -1;

		HashMap<String, String> logiii = serv.login(username, password);
		String a = logiii.get("username");
		// ��½��֤����Ȩ��>-1Ϊ��¼�ɹ���
		if ("-1".equals(logiii.get("permission"))) {
			// ��¼ʧ��
			System.out.print("��¼ʧ��Failed");
		} else {
			// ��½�ɹ�
			permission = Integer.parseInt(logiii.get("permission"));
		}

		JSONObject jsonObj = new JSONObject();
		try {
			jsonObj.put("username", username);
			jsonObj.put("permission", permission);
			System.out.println(jsonObj);
			// ������Ϣ���ͻ���
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
