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
import model.GetMutterListLogic;
import model.Mutter;
import model.Siritori;

@WebServlet("/siritori")
public class MainSiritoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 秒速画面遷移
		String url = "/WEB-INF/jsp/index.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		
		
		// 入力値チェック
		if(text != null && text.length() != 0) {
			// アプリケーションスコープに保存された現存しりとりログを取得
			ServletContext application = this.getServletContext();
			List<Siritori> siritoriList = new ArrayList<>();
			
			
			// つぶやきをつぶやきリストに追加
			Siritori siritori = new Siritori(text);
//			mutterList.add(0,mutter);  サーブレットは処理をしない。モデルにさせる。
			AddSiritoriListLogic logic = new AddSiritoriListLogic();
			logic.execute(siritori, siritoriList);
			
		} else {
			// エラーメッセージをリクエストスコープに保存
			String errorMsg = "つぶやきが入力されていません";
			request.setAttribute("errorMsg", errorMsg);
		}
		
		// つぶやきリストを取得して、リクエストスコープに保存
		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		List<Mutter> mutterList = getMutterListLogic.execute();
		request.setAttribute("mutterList", mutterList);
		
		
		// メイン画面にフォワード
		String url = "/WEB-INF/jsp/main.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
