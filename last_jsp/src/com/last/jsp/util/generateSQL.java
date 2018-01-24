package com.last.jsp.util;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.last.jsp.common.MybatisSqlSessionFactory;

public class generateSQL {
	
	public static String generateSql(String tableName) {
		return "select * from "+tableName; 
	}
	public static void main(String[] agrs) {
		try(SqlSession ss=MybatisSqlSessionFactory.getSS()){
			
			String tableName = "user_info";
			List<Map<String, String>> colList = ss.selectList("common.selectTable", tableName);
			System.out.println(colList);
			
			String selectSql = "";
			for(Map<String, String> m : colList) {
				selectSql += m.get("colName")+",";
			}
			selectSql = "select "+selectSql.substring(0, selectSql.length()-1)+" from "+tableName;
			System.out.println(selectSql);
			
			String setSql ="";
			String whereNum = "";
			String valuesSql = "";
			String updateSql = "";
			String deleteSql = "";
			String insertSql = "";
			
			for(Map<String, String> m : colList) {
				 if(m.get("isKey").equals("y")) {
					 whereNum += " where " + m.get("colName") + "=#{" + m.get("colName") + "}";
				 }else {
					 if(m.get("colName").equals("uiregdate")) {
						 setSql += m.get("colName")+"=now(), ";
						 valuesSql += "now(),";
					 }else {
						 setSql += m.get("colName")+"=#{"+m.get("colName")+"}, ";
						 insertSql += m.get("colName")+",";
						 valuesSql += "#{"+m.get("colName")+"},";
					 }
				 }
			}
			updateSql = "update "+tableName+" set "+setSql.substring(0, setSql.length()-1)+whereNum;
			System.out.println(updateSql);

			deleteSql = "delete from "+tableName+whereNum;
			System.out.println(deleteSql);

			insertSql = "insert from "+tableName+"("+insertSql.substring(0, insertSql.length()-1)+
					") values("+valuesSql.substring(0, valuesSql.length()-1)+")";			
			System.out.println(insertSql);
		}
	}
	}
