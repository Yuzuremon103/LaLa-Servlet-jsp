package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FormSampleServlet")
public class FormSampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String tel = request.getParameter("tel");
		System.out.println("name" + name + "gender" + gender + "携帯電話" + tel);
		
		String errorMsg = "";
		if(name == null || name.length() == 0) {
			errorMsg += "名前が入力されていません<br>";
		}
		if(gender == null || gender.length() == 0) {
			errorMsg += "性別が入力されていません<br>";
		} else {
			if(gender.equals("0")) {
				gender = "男性";
			} else if(gender.equals("1")) {
				gender = "女性";
			}
		}
		if(tel == null || tel.length() == 0) {
			errorMsg += "携帯番号が入力されていません<br>";
		} else {
			Pattern pattern = Pattern.compile("^[0-9]{3}-[0-9]{4}-[0-9]{4}$");
			if(pattern.matcher(tel).matches()) {
				;
			} else {
				errorMsg = "携帯電話の形式が不正です<br>";
			}
		}
		
		String msg = name + "さん(" + gender + ") [" + tel+ "] を登録しました";
		if(errorMsg.length() != 0) {
			msg = errorMsg;
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<met charset=\"UTF-8\">");
		out.println("<title>ユーザー登録結果</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>" + msg + "</p>");
		out.println("</body>");
		out.println("</html>");
	}


}
