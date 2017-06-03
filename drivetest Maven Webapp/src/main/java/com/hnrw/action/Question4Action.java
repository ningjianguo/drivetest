package com.hnrw.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hnrw.entity.ExamQuestion4;
import com.hnrw.service.IQuestion4Service;
@Controller
@Scope("prototype")
public class Question4Action extends BaseAction<ExamQuestion4>{

	private static final long serialVersionUID = -3208864256256963678L;
	private String page;
	private String rows;
	private File file;
	private String fileFileName;
	@Resource
	private IQuestion4Service question4ServiceImpl;
	
	public String loadQuestion4(){
		String timu = request.getParameter("timu");
		StringBuffer sbf = new StringBuffer();
		sbf.append(" 1=1");
		if(!"".equals(timu)){
			sbf.append(" and question4Question like '%"+timu+"%'");
		}
		sbf.append(" order by question4No");
		printJsonStringToBrowser(question4ServiceImpl.loadAllData(Integer.parseInt(page), Integer.parseInt(rows),sbf.toString()));
		return null;
	}
	
	public String addQuestion4(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		ExamQuestion4 question4 = getModel();
		if (file != null) {
			// 判断文件格式是否正确
			String[] contentTypes = { ".jpg", ".jpeg", ".png"};
			boolean flag = false;
			for (String contentType : contentTypes) {
				if (fileFileName.endsWith(contentType)) {
					flag = true;
				}
			}
			if (!flag) {
				// 格式不正确
				try {
					response.getWriter().print("fileerror");
					return null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			question4.setQuestion4Url(fileFileName);
		}
		int question4No = question4ServiceImpl.addQuestion4(question4);
		if(file != null){
			String temp = fileFileName.substring(fileFileName.lastIndexOf("."));
			//保存照片到物理路径
			try {
				FileInputStream inputStream = new FileInputStream(
						this.getFile());
				FileOutputStream outputStream = new FileOutputStream("C://jiakao_question4//"+question4No+temp);
				byte[] buf = new byte[1024];
				int length = 0;
				while ((length = inputStream.read(buf)) != -1) {
					outputStream.write(buf, 0, length);
				}
				inputStream.close();
				outputStream.flush();
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			response.getWriter().print("ok");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String deleteQuestion4(){
		String delItems = request.getParameter("delItems");
		printJsonStringToBrowser(question4ServiceImpl.deleteQuestion4(delItems));
		return null;
	}
	public String editeQuestion4(){
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setCharacterEncoding("utf-8");
		ExamQuestion4 question4 = getModel();
		if (file != null) {
			// 判断文件格式是否正确
			String[] contentTypes = { ".jpg", ".jpeg", ".png"};
			boolean flag = false;
			for (String contentType : contentTypes) {
				if (fileFileName.endsWith(contentType)) {
					flag = true;
				}
			}
			if (!flag) {
				// 格式不正确
				try {
					response.getWriter().print("fileerror");
					return null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			question4.setQuestion4Url(fileFileName);
		}
		question4ServiceImpl.editeQuestion4(question4);
		if(file != null){
			//删除原来的照片
			File oldFile = new File("C://jiakao_question4//"+getModel().getQuestion4Url());
			oldFile.delete();
			//保存新的照片
			String temp = fileFileName.substring(fileFileName.lastIndexOf("."));
			try {
				FileInputStream inputStream = new FileInputStream(
						this.getFile());
				FileOutputStream outputStream = new FileOutputStream("C://jiakao_question4//"+getModel().getQuestion4No()+temp);
				byte[] buf = new byte[1024];
				int length = 0;
				while ((length = inputStream.read(buf)) != -1) {
					outputStream.write(buf, 0, length);
				}
				inputStream.close();
				outputStream.flush();
				outputStream.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			response.getWriter().print("ok");
			return null;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String getPage() {
		return page;
	}
	public void setPage(String page) {
		this.page = page;
	}
	public String getRows() {
		return rows;
	}
	public void setRows(String rows) {
		this.rows = rows;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
}
