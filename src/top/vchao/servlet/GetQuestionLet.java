package top.vchao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import top.vchao.bean.JsonQuestBean;
import top.vchao.bean.QuestBean;
import top.vchao.service.QuestionService;
import top.vchao.service.StartService;

public class GetQuestionLet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// http://localhost:8080/Examine1/GetQuestionLet?type=1
		String type = request.getParameter("type");

		QuestionService service = new QuestionService();

		ArrayList<QuestBean> getQuestion = service.GetQuestion(type);

//		JSONObject jsonObj = new JSONObject();
		JsonQuestBean jsonQuestBean = new JsonQuestBean();
		jsonQuestBean.setCode("200");
		jsonQuestBean.setStatus("ok");

		jsonQuestBean.setQuestbeans(getQuestion);

		Gson gson = new Gson();
		String jsonObj = gson.toJson(jsonQuestBean);
		
		System.out.println(jsonObj);

		// 返回信息到客户端
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print(jsonObj);
		out.flush();
		out.close();

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
