package com.sura.it.management.platforms.dataAccess;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sura.it.management.platforms.model.Department;

public class DepartmentsDataAccess {
	private static final String LIST_DEPARTMENTS_BY_TYPE_SQL = "SELECT * FROM tblDepartments WHERE active = TRUE AND departmentType = ";
	private static final String LIST_DEPARTMENTS_BY_PARENT_ID_SQL = "SELECT * FROM tblDepartments WHERE active = TRUE AND parentId = ";
	private static final String LIST_ALL_SQL = "SELECT * FROM tblDepartments WHERE ACTIVE = TRUE";
	private static final String GET_DEPARTMENT_BY_ID_SQL = "SELECT * FROM tblDepartments WHERE id = ";

	private static Department loadObject(ResultSet rs) throws SQLException {
		Department department = new Department();
		department.setId(rs.getInt("id"));
		department.setName(rs.getString("name"));
		department.setDepartmentType(rs.getString("departmentType"));
		department.setActive(rs.getBoolean("active"));

		return department;

	}

	public static List<Department> listAll() throws URISyntaxException,
			SQLException {
		List<Department> list = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			list = listAll(connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}

	protected static List<Department> listAll(Connection connection)
			throws URISyntaxException, SQLException {
		Department department = null;
		List<Department> list = new ArrayList<Department>();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(LIST_ALL_SQL);
		while (rs.next()) {
			department = loadObject(rs);
			list.add(department);
		}
		return list;
	}

	public static List<Department> getByDepartmentType(String departmentType)
			throws URISyntaxException, SQLException {
		List<Department> list = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			list = getByDepartmentType(departmentType, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}

	protected static List<Department> getByDepartmentType(
			String departmentType, Connection connection)
			throws URISyntaxException, SQLException {
		Department department = null;
		List<Department> list = new ArrayList<Department>();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(LIST_DEPARTMENTS_BY_TYPE_SQL + "'"
				+ departmentType + "'");
		while (rs.next()) {
			department = loadObject(rs);
			list.add(department);
		}
		return list;
	}

	public static List<Department> getByParent(int id) throws URISyntaxException,
			SQLException {
		List<Department> list = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			list = getByParent(id, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return list;
	}

	protected static List<Department> getByParent(int id, Connection connection)
			throws URISyntaxException, SQLException {
		Department department = null;
		List<Department> list = new ArrayList<Department>();

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(LIST_DEPARTMENTS_BY_PARENT_ID_SQL
				+ Integer.toString(id));
		while (rs.next()) {
			department = loadObject(rs);
			list.add(department);
			break;
		}
		return list;
	}

	public static Department getById(int id) throws URISyntaxException,
			SQLException {
		Department department = null;

		Connection connection = null;
		try {
			connection = DataServiceHelper.getInstance().getConnection();
			department = getById(id, connection);
		} finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
				}
		}
		return department;
	}

	protected static Department getById(int id, Connection connection)
			throws URISyntaxException, SQLException {
		Department department = null;

		Statement stmt = connection.createStatement();
		ResultSet rs = stmt.executeQuery(GET_DEPARTMENT_BY_ID_SQL
				+ Integer.toString(id));
		while (rs.next()) {
			department = loadObject(rs);
			break;
		}
		return department;
	}

}
