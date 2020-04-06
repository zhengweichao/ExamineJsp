package top.vchao.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import top.vchao.bean.JsonQuestBean;
import top.vchao.bean.QuestBean;
import top.vchao.service.QuestionService;

import com.google.gson.Gson;

public class GetTestList extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		 http://localhost:8080/Examine1/GetTestList?kind=chinese&number=5
		String kind = request.getParameter("kind");
		String num = request.getParameter("number");
		System.out.println("客户端接收到的参数"+kind+num);
		
		QuestionService service = new QuestionService();

		ArrayList<QuestBean> getQuestion = service.GetTestList(kind, num);

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

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
