package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		
		String siri = "";
		
		HttpSession session = request.getSession();
		session.getAttribute(siri);
		
		if(siri.equals("")) {
			// test
			System.out.println("成功");

		} else {
			// test
			System.out.println("失敗");

		}
		
		
		// 文字列の取り出し
		String lastChar = text.substring(text.length() - 1);     // 最後の文字
		char firstChar = text.charAt(0);                         // 最初の文字
		System.out.println(lastChar);
		System.out.println(firstChar);
		
		// 入力値チェック
		if(text != null && text.length() != 0) {
			// test
			System.out.println("成功");
			
			if(lastChar.equals(firstChar)) {
				// test
				System.out.println("成功");

			} else {
				// test
				System.out.println("失敗");
			}
			
			
//			// アプリケーションスコープに保存された現存しりとりログを取得
//			ServletContext application = this.getServletContext();
//			List<Siritori> siritoriList = new ArrayList<>();
//			
//			
//			// つぶやきをつぶやきリストに追加
//			Siritori siritori = new Siritori(text);
////			mutterList.add(0,mutter);  サーブレットは処理をしない。モデルにさせる。
//			AddSiritoriListLogic logic = new AddSiritoriListLogic();
//			logic.execute(siritori, siritoriList);
//			
		} else {
			// test
			System.out.println("失敗");
			
			
//			// エラーメッセージをリクエストスコープに保存
//			String errorMsg = "つぶやきが入力されていません";
//			request.setAttribute("errorMsg", errorMsg);
//		}
	//		
	//		// つぶやきリストを取得して、リクエストスコープに保存
	//		GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
	//		List<Mutter> mutterList = getMutterListLogic.execute();
	//		request.setAttribute("mutterList", mutterList);
	//		
	//		
	//		// メイン画面にフォワード
	//		String url = "/WEB-INF/jsp/index.jsp";
	//		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	//		dispatcher.forward(request, response);
	
			session.setAttribute("last", lastChar);
		}
	}
}
