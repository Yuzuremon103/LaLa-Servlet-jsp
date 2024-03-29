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
import model.NumLogic;
import model.Siritori;
import model.TextLogic;

@WebServlet("/main")
public class MainSiritoriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 秒速画面遷移
		int i = 600;
		request.setAttribute("i", i);
		String url = "/WEB-INF/jsp/main.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text = request.getParameter("text");
		String lastChar = request.getParameter("lastChar");    // 最後の文字
		String counter = request.getParameter("count");        // 現在の回数
		String num = request.getParameter("num");              // トランプの数字
		String i = request.getParameter("i");                   // 残り秒数
		int number = Integer.parseInt(num);                   // トランプの数字を数字化
		int textLength = text.length();                       // textの文字数
		int integer = Integer.parseInt(i);                   // 残り秒数をint化
		
		System.out.println("ランダムトランプnumは : " + num);
		System.out.println("残り秒数 : " + integer);
		System.out.println(lastChar + "最後の文字");
		String errorMsg = "";
		
		
		// 初回はここを通る
		if(counter.equals("") || counter.equals(null)) {
			// countを数字に変換
			counter = "1";
			int count = Integer.parseInt(counter);           // 1回目
			
			lastChar = text.substring(text.length() - 1);     // 最後の文字
			lastChar = TextLogic.textLogic(lastChar, text);
			System.out.println("今回の最後の文字" + lastChar);
			
			// numberが1,2,3のとき
			if(number <= 3) {
				// 正誤判定
				if(NumLogic.three(textLength)) {
					// 投稿をしりとりリストに追加
					List<Siritori> siritoriList = new ArrayList<>();
					Siritori siritori = new Siritori(text);
					AddSiritoriListLogic logic = new AddSiritoriListLogic();
					logic.execute(siritori, siritoriList);
					ServletContext application = this.getServletContext();
					application.setAttribute("siritoriList", siritoriList);

					System.out.println("\n ============================ \n");
					
					request.setAttribute("count", count);
					request.setAttribute("lastChar", lastChar);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				} else {
					errorMsg = "文字数が正しくありません。\n最初からやり直しです。";
//					request.setAttribute("lastChar", lastChar);
					request.setAttribute("errorMsg", errorMsg);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}
			}

			// numberが4,5,6のとき
			if(number >= 4 && number <= 6) {
				// 正誤判定
				if(NumLogic.six(textLength)) {
					// 投稿をしりとりリストに追加
					List<Siritori> siritoriList = new ArrayList<>();
					Siritori siritori = new Siritori(text);
					AddSiritoriListLogic logic = new AddSiritoriListLogic();
					logic.execute(siritori, siritoriList);
					ServletContext application = this.getServletContext();
					application.setAttribute("siritoriList", siritoriList);

					System.out.println("\n ============================ \n");
					
					request.setAttribute("count", count);
					request.setAttribute("lastChar", lastChar);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				} else {
					errorMsg = "文字数が正しくありません。\n最初からやり直しです。";
					request.setAttribute("errorMsg", errorMsg);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}
			}
			
			// numberが7,8,9のとき
			if(number >= 7 && number <= 9) {
				// 正誤判定
				if(NumLogic.nine(textLength)) {
					// 投稿をしりとりリストに追加
					List<Siritori> siritoriList = new ArrayList<>();
					Siritori siritori = new Siritori(text);
					AddSiritoriListLogic logic = new AddSiritoriListLogic();
					logic.execute(siritori, siritoriList);
					ServletContext application = this.getServletContext();
					application.setAttribute("siritoriList", siritoriList);

					System.out.println("\n ============================ \n");
					
					request.setAttribute("count", count);
					request.setAttribute("lastChar", lastChar);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				} else {
					errorMsg = "文字数が正しくありません。\n最初からやり直しです。";
					request.setAttribute("errorMsg", errorMsg);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}
			}
			
			// numberが10~のとき
			if(number >= 10) {
				// 正誤判定
				if(NumLogic.ten(textLength)) {
					// 投稿をしりとりリストに追加
					List<Siritori> siritoriList = new ArrayList<>();
					Siritori siritori = new Siritori(text);
					AddSiritoriListLogic logic = new AddSiritoriListLogic();
					logic.execute(siritori, siritoriList);
					ServletContext application = this.getServletContext();
					application.setAttribute("siritoriList", siritoriList);

					System.out.println("\n ============================ \n");
					
					request.setAttribute("count", count);
					request.setAttribute("lastChar", lastChar);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				} else {
					errorMsg = "文字数が正しくありません。\n最初からやり直しです。";
					request.setAttribute("errorMsg", errorMsg);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
				}
			}
// ============================================================================================
		// 2回目以降からこちら
		} else {
			// counterが特定回数のとき(終わりの指定)
			if(counter.equals("11")) {     // (終わらせたい数 - 1) *13人の場合は12
				errorMsg = "Congratulations !!";
				integer = 0;
				request.setAttribute("errorMsg", errorMsg);
				request.setAttribute("i", integer);
				
				// アプリケーションスコープに保存された現存しりとりログを取得
				ServletContext application = this.getServletContext();
				
				@SuppressWarnings("unchecked")
				List<Siritori> siritoriList = (List<Siritori>) application.getAttribute("siritoriList");
				
				// 投稿をしりとりリストに追加
				Siritori siritori = new Siritori(text);
				AddSiritoriListLogic logic = new AddSiritoriListLogic();
				logic.execute(siritori, siritoriList);
				application.setAttribute("siritoriList", siritoriList);

				String url = "/WEB-INF/jsp/main.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
			


			// トランプの数字が1,2,3
			if(number <= 3) {
				
	    		// 文字列の取り出し
	    		char first = text.charAt(0);                // 最初の文字
	    		String firstChar = String.valueOf(first);   // 最初の文字をcharからStringに
	    		firstChar = TextLogic.textLogic(firstChar, text);  // カナ変換
	    		System.out.println("最後の文字 : " + lastChar);
	    		System.out.println("最初の文字 : " + firstChar);
	    		
	    		// 入力値チェック
	    		if(NumLogic.three(textLength)) {       // 正常であればtrue
	    			// test
	    			System.out.println("textが通りました");
	    			
	    			// 最初と最後が同じかどうか
	    			if(lastChar.equals(firstChar)) {
	    				// test
	    				System.out.println("しりとれた");
	    				
	    				int count = Integer.parseInt(counter);
	    				count += 1;
	    	            System.out.println(count + "回目"); // count = 2~
	    				
	    				// アプリケーションスコープに保存された現存しりとりログを取得
	    				ServletContext application = this.getServletContext();
	    				
	    				@SuppressWarnings("unchecked")
	    				List<Siritori> siritoriList = (List<Siritori>) application.getAttribute("siritoriList");
	    				
	    				// 投稿をしりとりリストに追加
	    				Siritori siritori = new Siritori(text);
	    				AddSiritoriListLogic logic = new AddSiritoriListLogic();
	    				logic.execute(siritori, siritoriList);
	    				application.setAttribute("siritoriList", siritoriList);
	    				
	    	    		// 1周終わりました
	    	    		System.out.println("\n ============================ \n");
	    	            
	    	    		// 最後の文字をリクエストスコープへ
	    	    		lastChar = text.substring(text.length() - 1);     // 最後の文字
	    	    		lastChar = TextLogic.textLogic(lastChar, text);
	    	    		request.setAttribute("lastChar", lastChar);
	    				request.setAttribute("count", count);
	    				request.setAttribute("i", integer);
	    	    		
	    	    		// メイン画面にフォワード
	    	    		String url = "/WEB-INF/jsp/main.jsp";
	    	    		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    	    		dispatcher.forward(request, response);
	    	    		
	    			} else {
	    				// test
	    				System.out.println("しりを取ってください");
	    				
						List<Siritori> siritoriList = new ArrayList<>();
						ServletContext application = this.getServletContext();
						application.setAttribute("siritoriList", siritoriList);
	    				
						errorMsg = "しりが取れていません";
						request.setAttribute("errorMsg", errorMsg);
						request.setAttribute("i", integer);
						String url = "/WEB-INF/jsp/main.jsp";
						RequestDispatcher dispatcher = request.getRequestDispatcher(url);
						dispatcher.forward(request, response);
	    			}
	            } else { // 1,2,3の終わり(elseへ)
					errorMsg = "文字数が正しくありません。\n最初からやり直しです。";
					
					List<Siritori> siritoriList = new ArrayList<>();
					ServletContext application = this.getServletContext();
					application.setAttribute("siritoriList", siritoriList);

					request.setAttribute("errorMsg", errorMsg);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
	            }
			}
            
			// トランプの数字が4,5,6
			if(number >= 4 && number <= 6) {
	            
	    		// 文字列の取り出し
	    		char first = text.charAt(0);                 // 最初の文字
	    		String firstChar = String.valueOf(first);   // 最初の文字をcharからStringに
	    		firstChar = TextLogic.textLogic(firstChar, text);  // カナ変換
	    		System.out.println("最後の文字 : " + lastChar);
	    		System.out.println("最初の文字 : " + firstChar);
	    		
	    		// 入力値チェック
	    		if(NumLogic.six(textLength)) {       // 正常であればtrue
	    			// test
	    			System.out.println("textが通りました");
	    			
	    			// 最初と最後が同じかどうか
	    			if(lastChar.equals(firstChar)) {
	    				// test
	    				System.out.println("しりとれた");
	    				
	    				int count = Integer.parseInt(counter);
	    				count += 1;
	    	            System.out.println(count + "回目"); // count = 2~
	    				
	    				// アプリケーションスコープに保存された現存しりとりログを取得
	    				ServletContext application = this.getServletContext();
	    				
	    				@SuppressWarnings("unchecked")
	    				List<Siritori> siritoriList = (List<Siritori>) application.getAttribute("siritoriList");
	    				
	    				// 投稿をしりとりリストに追加
	    				Siritori siritori = new Siritori(text);
	    				AddSiritoriListLogic logic = new AddSiritoriListLogic();
	    				logic.execute(siritori, siritoriList);
	    				application.setAttribute("siritoriList", siritoriList);
	    				
	    	    		// 1周終わりました
	    	    		System.out.println("\n ============================ \n");
	    	            
	    	    		// 最後の文字をリクエストスコープへ
	    	    		lastChar = text.substring(text.length() - 1);     // 最後の文字
	    	    		lastChar = TextLogic.textLogic(lastChar, text);
	    	    		request.setAttribute("lastChar", lastChar);
	    				request.setAttribute("count", count);
	    				request.setAttribute("i", integer);
	    	    		
	    	    		// メイン画面にフォワード
	    	    		String url = "/WEB-INF/jsp/main.jsp";
	    	    		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    	    		dispatcher.forward(request, response);
	    	    		
	    			} else {
	    				// test
	    				System.out.println("しりを取ってください");
	    				
						List<Siritori> siritoriList = new ArrayList<>();
						ServletContext application = this.getServletContext();
						application.setAttribute("siritoriList", siritoriList);
	    				
						errorMsg = "しりが取れていません";
						request.setAttribute("errorMsg", errorMsg);
						request.setAttribute("i", integer);
						String url = "/WEB-INF/jsp/main.jsp";
						RequestDispatcher dispatcher = request.getRequestDispatcher(url);
						dispatcher.forward(request, response);
	    			}
	            } else { // 4,5,6の終わり(elseへ)
					List<Siritori> siritoriList = new ArrayList<>();
					ServletContext application = this.getServletContext();
					application.setAttribute("siritoriList", siritoriList);

					errorMsg = "文字数が正しくありません。\n最初からやり直しです。";
					request.setAttribute("errorMsg", errorMsg);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
	            }
			}
			
			// トランプの数字が7,8,9
			if(number >= 7 && number <= 9) {
	            
	    		// 文字列の取り出し
	    		char first = text.charAt(0);                 // 最初の文字
	    		String firstChar = String.valueOf(first);   // 最初の文字をcharからStringに
	    		firstChar = TextLogic.textLogic(firstChar, text);  // カナ変換
	    		System.out.println("最後の文字 : " + lastChar);
	    		System.out.println("最初の文字 : " + firstChar);
	    		
	    		// 入力値チェック
	    		if(NumLogic.nine(textLength)) {       // 正常であればtrue
	    			// test
	    			System.out.println("textが通りました");
	    			
	    			// 最初と最後が同じかどうか
	    			if(lastChar.equals(firstChar)) {
	    				// test
	    				System.out.println("しりとれた");
	    				
	    				int count = Integer.parseInt(counter);
	    				count += 1;
	    	            System.out.println(count + "回目"); // count = 2~
	    				
	    				// アプリケーションスコープに保存された現存しりとりログを取得
	    				ServletContext application = this.getServletContext();
	    				
	    				@SuppressWarnings("unchecked")
	    				List<Siritori> siritoriList = (List<Siritori>) application.getAttribute("siritoriList");
	    				
	    				// 投稿をしりとりリストに追加
	    				Siritori siritori = new Siritori(text);
	    				AddSiritoriListLogic logic = new AddSiritoriListLogic();
	    				logic.execute(siritori, siritoriList);
	    				application.setAttribute("siritoriList", siritoriList);
	    				
	    	    		// 1周終わりました
	    	    		System.out.println("\n ============================ \n");
	    	            
	    	    		// 最後の文字をリクエストスコープへ
	    	    		lastChar = text.substring(text.length() - 1);     // 最後の文字
	    	    		lastChar = TextLogic.textLogic(lastChar, text);
	    	    		request.setAttribute("lastChar", lastChar);
	    				request.setAttribute("count", count);
	    				request.setAttribute("i", integer);
	    	    		
	    	    		// メイン画面にフォワード
	    	    		String url = "/WEB-INF/jsp/main.jsp";
	    	    		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    	    		dispatcher.forward(request, response);
	    	    		
	    			} else {
	    				// test
	    				System.out.println("しりを取ってください");
	    				
						List<Siritori> siritoriList = new ArrayList<>();
						ServletContext application = this.getServletContext();
						application.setAttribute("siritoriList", siritoriList);
	    				
						errorMsg = "しりが取れていません";
						request.setAttribute("errorMsg", errorMsg);
						request.setAttribute("i", integer);
						String url = "/WEB-INF/jsp/main.jsp";
						RequestDispatcher dispatcher = request.getRequestDispatcher(url);
						dispatcher.forward(request, response);
	    			}
	            } else { // 7,8,9の終わり(elseへ)
					List<Siritori> siritoriList = new ArrayList<>();
					ServletContext application = this.getServletContext();
					application.setAttribute("siritoriList", siritoriList);

					errorMsg = "文字数が正しくありません。\n最初からやり直しです。";
					request.setAttribute("errorMsg", errorMsg);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
	            }
			}
			
			// トランプの数字が10~
			if(number >= 10) {
	            
	    		// 文字列の取り出し
	    		char first = text.charAt(0);                 // 最初の文字
	    		String firstChar = String.valueOf(first);   // 最初の文字をcharからStringに
	    		firstChar = TextLogic.textLogic(firstChar, text);  // カナ変換
	    		System.out.println("最後の文字 : " + lastChar);
	    		System.out.println("最初の文字 : " + firstChar);
	    		
	    		// 入力値チェック
	    		if(NumLogic.ten(textLength)) {       // 正常であればtrue
	    			// test
	    			System.out.println("textが通りました");
	    			
	    			// 最初と最後が同じかどうか
	    			if(lastChar.equals(firstChar)) {
	    				// test
	    				System.out.println("しりとれた");
	    				
	    				int count = Integer.parseInt(counter);
	    				count += 1;
	    	            System.out.println(count + "回目"); // count = 2~
	    				
	    				// アプリケーションスコープに保存された現存しりとりログを取得
	    				ServletContext application = this.getServletContext();
	    				
	    				@SuppressWarnings("unchecked")
	    				List<Siritori> siritoriList = (List<Siritori>) application.getAttribute("siritoriList");
	    				
	    				// 投稿をしりとりリストに追加
	    				Siritori siritori = new Siritori(text);
	    				AddSiritoriListLogic logic = new AddSiritoriListLogic();
	    				logic.execute(siritori, siritoriList);
	    				application.setAttribute("siritoriList", siritoriList);
	    				
	    	    		// 1周終わりました
	    	    		System.out.println("\n ============================ \n");
	    	            
	    	    		// 最後の文字をリクエストスコープへ
	    	    		lastChar = text.substring(text.length() - 1);     // 最後の文字
	    	    		lastChar = TextLogic.textLogic(lastChar, text);
	    	    		request.setAttribute("lastChar", lastChar);
	    				request.setAttribute("count", count);
	    				request.setAttribute("i", integer);
	    	    		
	    	    		// メイン画面にフォワード
	    	    		String url = "/WEB-INF/jsp/main.jsp";
	    	    		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    	    		dispatcher.forward(request, response);
	    	    		
	    			} else {
	    				// test
	    				System.out.println("しりを取ってください");
	    				
						List<Siritori> siritoriList = new ArrayList<>();
						ServletContext application = this.getServletContext();
						application.setAttribute("siritoriList", siritoriList);
	    				
						errorMsg = "しりが取れていません";
						request.setAttribute("errorMsg", errorMsg);
						request.setAttribute("i", integer);
						String url = "/WEB-INF/jsp/main.jsp";
						RequestDispatcher dispatcher = request.getRequestDispatcher(url);
						dispatcher.forward(request, response);
	    			}
	            } else { // 10~の終わり(elseへ)
					List<Siritori> siritoriList = new ArrayList<>();
					ServletContext application = this.getServletContext();
					application.setAttribute("siritoriList", siritoriList);

					errorMsg = "文字数が正しくありません。\n最初からやり直しです。";
					request.setAttribute("errorMsg", errorMsg);
					request.setAttribute("i", integer);
					String url = "/WEB-INF/jsp/main.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(url);
					dispatcher.forward(request, response);
	            }
			}
		}    // 2回目以降elseの終わり(何も続けない)
	}
}
