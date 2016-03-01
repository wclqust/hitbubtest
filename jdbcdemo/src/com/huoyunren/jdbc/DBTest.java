package com.huoyunren.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DBTest {
	static String sql = null;
	static DBHelper db1 = null;
	static ResultSet ret = null;

	public static void main(String[] args) {
		sql = "select * from t_user where id=?";// SQL语句
		db1 = new DBHelper(sql);// 创建DBHelper对象

		try {
			db1.pst.setString(1, "1");
			ret = db1.pst.executeQuery();// 执行语句，得到结果集
			while (ret.next()) {
				Long uid = ret.getLong(1);
				String ufname = ret.getString(2);
				System.out.println(uid + "\t" + ufname + "\t");
			}// 显示数据
		
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				ret.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			db1.close();// 关闭连接
		}
	}

}
