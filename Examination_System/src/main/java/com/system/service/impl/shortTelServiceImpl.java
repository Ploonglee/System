package com.system.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.stereotype.Repository;

import com.system.mapper.shortTelMapper;
import com.system.po.ShortTel;
import com.system.service.shortTelService;

/**
 * @author 李鹏龙
 *
 */
@Repository
public class shortTelServiceImpl implements shortTelService{

	@Override
	public int importShortTel(HSSFSheet sheet) {
		// TODO Auto-generated method stub
		// 获取该工作表的第一行  
        HSSFRow row = null;  
        // 获取该工作表的第一个单元格  
        HSSFCell cell = null;  
  
        // 存放短号的List  
        List<ShortTel> shortTelList = new ArrayList<>();  
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {  
            // 在循环里面写，List保存的是引用，故在外边写会被覆盖，对象的地址相同  
            ShortTel tel = new ShortTel();  
            row = sheet.getRow(i);  
  
            // 数字取整  
            DecimalFormat df = new DecimalFormat("0");  
  
            // 获取第I列 第一个单元格  
            cell = row.getCell(0);  
            if (null == cell) {  
                continue;  
            }  
            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {  
                String number = df.format(cell.getNumericCellValue());  
                if (number.equals("")) {  
                    continue;  
                }  
            } else {  
                if (cell.getRichStringCellValue().getString().equals("")) {  
                    continue;  
                }  
            }  
            String shortTel = "";  
            if (cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {  
                shortTel = df.format(cell.getNumericCellValue());  
            } else {  
                shortTel = cell.getRichStringCellValue().getString();  
            }  
  
            tel.setShortTel(shortTel);  
            // 将放到list中  
            shortTelList.add(tel);  
  
        }  
  
        return shortTelMapper.insertShortTelBatch(shortTelList);
	}

}
