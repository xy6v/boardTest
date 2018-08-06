package upload.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import post.web.FileUtil;
import upload.model.UploadVo;
import upload.service.UploadService;
import upload.service.UploadServiceInf;

/**
 * Servlet implementation class FileDown
 */
@WebServlet("/fileDown")
public class FileDown extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String fileName = request.getParameter("upload");
		response.setHeader("Content-Disposition", "attachment; filename=\""+fileName+"\"");
		
		response.setContentType("application/octet-stream");
		
		//FileUtil.fileUploadPath : sally.png
		//파라미터로 파일명 제공
		// localhost:8180/fileDownLoad?fileName=sally.png
		
		
		//D:\A_TeachingMaterial\7.JspSpring\fileUpload\sally.png
		String file = FileUtil.fileUploadPath + File.separator + fileName;
		
		//file 입출력을 위한준비
		ServletOutputStream sos = response.getOutputStream();
		
		File f = new File(file);
		FileInputStream fis = new FileInputStream(f);
		byte[] b = new byte[512];
		int len = 0;
		while( (len = fis.read(b)) != -1 ){
			sos.write(b, 0, len);
		}
		
		sos.close();
		fis.close();
}
}
