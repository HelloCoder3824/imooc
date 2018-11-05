package com.jd.testutil;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @class: ReadData
 * @description:
 * @author: Jindong
 * @create: 2018-10-18 16:07
 **/
public class ReadData {

     //public static void ReadData() throws Exception {
    public static Object[][] ReadData() throws Exception {
        /*
        String filepath="D:\\idea-workspace01\\demo\\imooc3\\src\\test\\java\\com\\jd\\data\\imooc.xlsx";
        InputStream inputStream = new BufferedInputStream(new FileInputStream(filepath));
        //定义一个excel对象
        Workbook workbook = null;
        //截去文件名“.”前的字符串
        String extensionName = filepath.substring(filepath.indexOf("."));
        if (extensionName.equals(".xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else if (extensionName.equals(".xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else {
            System.out.println("文件格式不正确");
        }
        //或取第一个工作薄
        Sheet sheet = workbook.getSheetAt(0);
        //用最后行数减去首行行数得到总行数
        int rowcount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        List<Object[]> list = new ArrayList<Object[]>();
        for (int i = 0; i < rowcount; i++) {
            //遍历获取每一行,得到行对象
            Row row = sheet.getRow(i);
            //定义一个String数组，数组大小为每一行单元格数
            String feild[] = new String[row.getLastCellNum()];
            for (int j = 0; j < feild.length; j++) {
                //将cell值类型转换为String
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                //使用getCell()和getStringCellValue()方法获取Excel文件中的单元格数据
                feild[j] = row.getCell(j).getStringCellValue();
            }
            //将数组对象加到list中去
            list.add(feild);
        }
        Object[][] oj = new Object[rowcount][];
        for (int i = 0; i < rowcount; i++) {
            //遍历将list转换为二维数组
            oj[i] = list.get(i);
        }

        return oj;
     */


        //根据参数传入的数据文件路径和文件名称，组合出Excel数据文件的绝对路径，声明一个File文件对象

       String filepath="D:\\idea-workspace01\\demo\\imooc3\\src\\test\\java\\com\\jd\\data\\imooc.xlsx";
      // String filepath="com/jd/data/imooc.xlsx";

        File file = new File(filepath);
        //创建FileInputStream对象用于读取Excel文件x
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workbook = null;
        //将一个excel文件转为一个Workbook对象。
        //获取文件名参数的扩展名，判断是.xlsx文件还是.xls文件
        String extensionName = filepath.substring(filepath.indexOf("."));
        if (extensionName.equals(".xls")){
            workbook= new HSSFWorkbook(inputStream);
        }
        else if (extensionName.equals(".xlsx")){
            workbook= new XSSFWorkbook(inputStream);
        }
        else{
            System.out.println("文件格式不正确");
        }
        //读取一个excel sheet
        Sheet sheet = workbook.getSheetAt(0);
        //获取Excel数据文件Sheet1中数据的行数，getLastRowNum()方法获取数据的最后一行行号
        //getFirstRowNum()方法获取数据的第一行行号，相减之后得出数据的行数，Excel文件的行号和列号都是从0开始
        int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
        //创建list对象存储从Excel数据文件读取的数据
        List<Object[]> records =new ArrayList <Object[]>();
        //循环遍历Excel数据文件的所有数据，除了第一行，第一行是数据列名称
        for(int i=1;i<rowCount+1;i++){
            //使用getRow方法获取行对象
            Row row = sheet.getRow(i);
            //声明一个数组，存储Excel数据文件每行中的3个数据，数组的大小用getLastCellNum()方法进行动态声明，实现测试数据个数和数组大小一
            String fields[] = new String[row.getLastCellNum()];
            for(int j=0;j<row.getLastCellNum();j++){
                //将cell值类型转换为String
                row.getCell(j).setCellType(Cell.CELL_TYPE_STRING);
                //使用getCell()和getStringCellValue()方法获取Excel文件中的单元格数据
                fields[j]=row.getCell(j).getStringCellValue();
            }
            //将fields的数据对象存入records的list中
            records.add(fields);

        }
        // 将存储测试数据的List转换为一个Object的二维数组
        Object[][] results=new Object[records.size()][];
        // 设置二位数组每行的值，每行是一个Object对象
        for(int i=0;i<records.size();i++){
            results[i]=records.get(i);
            System.out.println( results[i]);
        }


        return results;
    }

    public static void main(String[] args) throws Exception {
       // ReadData.ReadData();
    }
}