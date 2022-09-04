package fourth.dao;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class AddFile
 */
@WebServlet("/ActivityAddImg")
@MultipartConfig
public class ActivityAddImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ActivityAddImg() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("已收到上傳請求");
		request.setCharacterEncoding("UTF-8");
		//相對位置
		String fileNamere = "/activityImages/"+ UUID.randomUUID().toString() + ".jpg";
		//絕對位置
		String imgPath	=request.getSession().getServletContext().getRealPath(fileNamere);
		System.out.println(fileNamere);
		System.out.println(imgPath);
		//==============================================================================
		PrintWriter out = response.getWriter();

		if(ServletFileUpload.isMultipartContent(request)){
            try {
                List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for(FileItem item : multiparts){
                	
                    if(!item.isFormField()){
                    	System.out.println(item.getName());
                        item.write( new File(imgPath));
                    }
                }
               out.print("."+fileNamere);
            } catch (Exception e) {
               System.err.println(e);
            }          
          
        }else{
        	System.out.println("AddFile錯誤");
        }
     

	}
	

}
