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
import top.vchao.bean.UpGradeBean;
import top.vchao.service.GradeService;
import top.vchao.service.QuestionService;

import com.google.gson.Gson;

public class UpUserGrade extends HttpServlet {

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

		// http://localhost:8080/Examine1/UpUserGrade?username=张三&grade=88&usetime=10&endtime=111&kind=math&number=5
				String username = request.getParameter("username");
				username = new String(username.getBytes("ISO-8859-1"), "UTF-8");
				String grade = request.getParameter("grade");
				String usetime = request.getParameter("usetime");
				String endtime = request.getParameter("endtime");
				String kind = request.getParameter("kind");
				String number = request.getParameter("number");

				GradeService service = new GradeService();
				boolean isOK = service.upgrade(username, grade, usetime, endtime, kind, number);
				
				UpGradeBean upGradeBean = new UpGradeBean();
				if(isOK){
					upGradeBean.setCode("200");
					upGradeBean.setStatus("ok");
				}else{
					upGradeBean.setCode("404");
					upGradeBean.setStatus("上传成绩失败");
				}

				Gson gson = new Gson();
				String jsonObj = gson.toJson(upGradeBean);
				
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
