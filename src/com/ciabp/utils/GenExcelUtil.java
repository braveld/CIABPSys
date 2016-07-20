package com.ciabp.utils;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.ciabp.models.User;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.UnderlineStyle;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class GenExcelUtil {
	
	public static final String[] title = {"id","用户名","姓名","性别","民族","生日","教育程度","工作","email","qq","weixin","手机号","电话","地址","密码"};
	
	static int row = 500;
	static int col = 24;

	public static void generate(List<User> list,String filepath){
		try{
			OutputStream os = new FileOutputStream(filepath);
			WritableWorkbook wwb=Workbook.createWorkbook(os);
			WritableSheet sheet = wwb.createSheet("sheet1", 0);
			WritableFont wf = new WritableFont(WritableFont.ARIAL, 12,
				     WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
				     jxl.format.Colour.BLACK);
			WritableCellFormat wcf = new WritableCellFormat(wf);
			wcf.setAlignment(Alignment.CENTRE);
			wcf.setVerticalAlignment(VerticalAlignment.CENTRE);
			sheet.setRowView(0, row);
			for(int i=0;i<title.length;i++){
				sheet.setColumnView(i, col);
				Label label = new Label(i,0,title[i],wcf);
				sheet.addCell(label);
			}
			for(int j=0;j<list.size();j++){
				String edu = "";
				int op = list.get(j).getEducation();
				if(list.get(j).getEducation() == 0){
					edu = "小学";
				}
				if(list.get(j).getEducation() == 1){
					edu = "初中";
				}
				if(list.get(j).getEducation() == 2){
					edu = "高中";
				}
				if(list.get(j).getEducation() == 3){
					edu = "大学及以上";
				}
				if(list.get(j).getEducation() == 4){
					edu = "其他";
				}
				sheet.setColumnView(j+1, col);
				sheet.addCell(new Label(0,j+1,list.get(j).getId()+"",wcf));
				sheet.addCell(new Label(1,j+1,list.get(j).getNick(),wcf));
				sheet.addCell(new Label(2,j+1,list.get(j).getName(),wcf));
				sheet.addCell(new Label(3,j+1,list.get(j).getSex(),wcf));
				sheet.addCell(new Label(4,j+1,list.get(j).getType(),wcf));
				sheet.addCell(new Label(5,j+1,list.get(j).getBirthday(),wcf));
				sheet.addCell(new Label(6,j+1,edu,wcf));
				sheet.addCell(new Label(7,j+1,list.get(j).getWork(),wcf));
				sheet.addCell(new Label(8,j+1,list.get(j).getEmail(),wcf));
				sheet.addCell(new Label(9,j+1,list.get(j).getQq(),wcf));
				sheet.addCell(new Label(10,j+1,list.get(j).getWeixin(),wcf));
				sheet.addCell(new Label(11,j+1,list.get(j).getMphone(),wcf));
				sheet.addCell(new Label(12,j+1,list.get(j).getPhone(),wcf));
				sheet.addCell(new Label(13,j+1,list.get(j).getAddress(),wcf));
				sheet.addCell(new Label(14,j+1,list.get(j).getPassword(),wcf));
			}
			wwb.write();
			wwb.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	
	
	

}
