package com.management.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.management.dao.StudentDao;
import com.management.pojo.Student;
import com.management.utils.JDBCUtil;
/*
 * dao层 JDBC表数据操作方法
 * @author by LiF
 * */
public class StudentDaoImpl implements StudentDao {

	@Override
	/**
	 * @method getAllStudent() 遍历获取所有学生信息
	 * @return List<Student> 查询表中数据
	 */
	public List<Student> getAllStudent() {// 遍历获取所有学生信息

		List<Student> list = new ArrayList<Student>();//存放所有学生信息的数据集合
		Connection con;//创建Connection对象
		String sql = "select * from student";//SQL查询命令字符串
		PreparedStatement pstmt;//创建PreparedStatement对象
		try {
			con = JDBCUtil.getConnection();//建立连接
			pstmt = (PreparedStatement)con.prepareStatement(sql);//对Connection对象传入SQL查询命令，获得PreparedStatement对象；
			ResultSet rs = pstmt.executeQuery();//对PreparedStatement对象执行executeQurey()获得结果,返回结果集；
			while(rs.next()) {// next()将光标向后一行
				long id = rs.getLong(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String clazz = rs.getString(4);
				long phone = rs.getLong(5);
                String date = rs.getString(6);

				Student student = new Student(id, name, sex, clazz, phone, date);
				list.add(student);//添加到List中
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override

	public Student getStudentById(Long id) {//根据学号查询学生信息
		Connection con = null;//创建Connection对象
		String sql = "select * from student where Sno=?";//SQL查询命令字符串
		PreparedStatement pstmt = null;//创建PreparedStatement对象
		Student student = null;//创建实体类对象
		ResultSet rs = null;//创建结果集对象
		try {
			con = JDBCUtil.getConnection();//建立连接
			pstmt = (PreparedStatement)con.prepareStatement(sql);//对Connection对象传入SQL查询命令，获得PreparedStatement对象；
			pstmt.setLong(1, id);//设置参数
			rs = pstmt.executeQuery();//对PreparedStatement对象执行executeQurey()获得结果,返回结果集；
			while(rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String clazz = rs.getString(4);
				long phone = rs.getLong(5);
                String date = rs.getString(6);
				student = new Student(no, name, sex, clazz, phone, date);//将结果集所获取的参数写入构造方法中
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {//先后关闭PreparedStatement对象和Connection对象。
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs != null && !rs.isClosed()) {//关闭结果集
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return student;
	}

	@Override
	/**
	 * @method updateStudent(long id, Student student) 更改表中数据
	 * @return int 成功更改表中数据条数
	 */
	public int updateStudent(long id, Student student) {// 根据学号编辑学生信息
		Connection con = null;//创建Connection对象
		String sql = "update student set Sname=?,Ssex=?,Sclass=?,Sphone=?,Sdate=? where Sno=?";//SQL查询命令字符串
		PreparedStatement pstmt = null;//创建PreparedStatement对象
		int updateCon = 0;
		try {
			con = JDBCUtil.getConnection();//建立连接
			pstmt = (PreparedStatement) con.prepareStatement(sql);//对Connection对象传入SQL查询命令，获得PreparedStatement对象；
			pstmt.setString(1, student.getName());//设置参数的方法
			pstmt.setString(2, student.getSex());
			pstmt.setString(3, student.getClazz());
			pstmt.setLong(4, student.getPhone());
            pstmt.setString(5, student.getDate());
			pstmt.setLong(6, student.getId());
			updateCon = pstmt.executeUpdate();//对PreparedStatement对象执行executeUpdate()获得结果
		} catch (Exception e) {
			e.printStackTrace();
		} finally {//关闭PreparedStatement对象和Connection对象。
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCon;
	}

	@Override
	/**
	 * @method deleteStudent(long id) 删除表中数据
	 * @return int 成功删除表中数据条数
	 */
	public int deleteStudent(long id) {//根据学号删除学生信息
		// TODO Auto-generated method stub
		Connection con = null;//创建Connection对象
		String sql = "delete from student where Sno=?";//SQL查询命令字符串
		PreparedStatement pstmt = null;//创建PreparedStatement对象
		int deleteCon = 0;
		try {
			con = JDBCUtil.getConnection();//建立连接
			pstmt = (PreparedStatement)con.prepareStatement(sql);//对Connection对象传入SQL查询命令，获得PreparedStatement对象；
			pstmt.setLong(1, id);
			deleteCon = pstmt.executeUpdate();//对PreparedStatement对象执行executeUpdate()获得结果
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {//关闭PreparedStatement对象和Connection对象。
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deleteCon;
	}

	@Override
	/**
	 * @method insertStudent(Student student) 往表中插入数据
	 * @return int 成功插入数据条数
	 */
	public int insertStudent(Student student) {//插入学生信息
		// TODO Auto-generated method stub
		Connection con = null;//创建Connection对象
		String sql = "insert into student values(?,?,?,?,?,?)";//SQL查询命令字符串
		PreparedStatement pstmt = null;//创建PreparedStatement对象
		int insertCon = 0;
		try {
			con = JDBCUtil.getConnection();//建立连接
			pstmt = (PreparedStatement)con.prepareStatement(sql);//对Connection对象传入SQL查询命令，获得PreparedStatement对象；
			pstmt.setLong(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getSex());
			pstmt.setString(4, student.getClazz());
			pstmt.setLong(5, student.getPhone());
            pstmt.setString(6, student.getDate());
			insertCon = pstmt.executeUpdate();//对PreparedStatement对象执行executeUpdate()获得结果
		} catch(Exception e) {
			e.printStackTrace();
		} finally {//关闭PreparedStatement对象和Connection对象。
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return insertCon;
	}

}
