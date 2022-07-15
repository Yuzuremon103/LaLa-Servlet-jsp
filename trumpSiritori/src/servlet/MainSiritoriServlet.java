package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AddSiritoriListLogic;
import model.Siritori;

@WebServlet("/siritori")
public class MainSiritoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		String lastChar = request.getParameter("lastChar");     // 最後の文字
		
		String errorMsg = "";
		
		
		if(lastChar.equals("")) {
			// test
			System.out.println("lastCharが来ていない");
			
			// エラーメッセージをリクエストスコープに保存
			errorMsg = "lastCharが送信されていません";
			request.setAttribute("errorMsg", errorMsg);
			
			// メイン画面にフォワード
			String url = "/WEB-INF/jsp/index.jsp";
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);

		}
		
		
		// 文字列の取り出し
		char first = text.charAt(0);                 // 最初の文字
		String firstChar = String.valueOf(first);   // 最初の文字をcharからStringに
		System.out.println(lastChar);
		System.out.println(firstChar);
		
		// 入力値チェック
		if(text != null && text.length() != 0) {
			// test
			System.out.println("");
			
			if(lastChar.equals(firstChar)) {
				// test
				System.out.println("しりとれた");
				
				
				// アプリケーションスコープに保存された現存しりとりログを取得
				ServletContext application = this.getServletContext();
				List<Siritori> siritoriList = new ArrayList<>();
				
				
				// 投稿をしりとりリストに追加
				Siritori siritori = new Siritori(text);
//				siritoriList.add(0, siritori);
				AddSiritoriListLogic logic = new AddSiritoriListLogic();
				logic.execute(siritori, siritoriList);
				List<Siritori> siritoriList = (List<Sirirori>) application.getAttribute("siritori");

			} else {
				// test
				System.out.println("しりを取ってください");
			}
			
			
		} else {
			// test
			System.out.println("打ち込みに失敗");
			
			// エラーメッセージをリクエストスコープに保存
			errorMsg = "しりとりが入力されていません";
			request.setAttribute("errorMsg", errorMsg);
		}
			
//		// しりとりリストを取得して、リクエストスコープに保存
//		GetSiritoriListLogic getSiritoriListLogic = new GetSiritoriListLogic();
//		List<Siritori> siritoriList = getSiritoriListLogic.execute();
//		request.setAttribute("siritoriList", siritoriList);
		
		
		
		// 最後の文字を代入
		lastChar = text.substring(text.length() - 1);     // 最後の文字
		
		// メイン画面にフォワード
		String url = "/WEB-INF/jsp/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

		session.setAttribute("last", lastChar);
	}
}
