package sec01.ex02;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/download.do")
public class FileDownload extends HttpServlet {
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메서드 호출");
	}

	public void destroy() {
		System.out.println("destroy 메서드 호출");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request,response);
	}
	
	private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String file_repo = "C:\\file_repo";
		String fileName = (String) request.getParameter("fileName");
		System.out.println("fileName=" + fileName);
		
		OutputStream out = response.getOutputStream();
		
		String downFile = file_repo+"\\"+fileName;
		File f = new File(downFile);
		
		//파일 다운로드
		response.setHeader("Cache-Control", "no-cache");
		response.addHeader("Content-disposition","attachment;fileName="+fileName);

		FileInputStream in = new FileInputStream(f);
		//버퍼로 데이터를 읽어와 한꺼번에 출력
		byte[] buffer = new byte[1024*8];
		while(true) {
			int count = in.read(buffer);
			if(count==-1) {
				break;
			}
			out.write(buffer,0,count);
		}
		in.close();
		out.close();
	}
}
