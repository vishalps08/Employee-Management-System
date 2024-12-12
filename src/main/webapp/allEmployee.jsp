<%@page import="com.besant.packages.model.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            font-size: 18px;
            text-align: left;
        }

        table, th, td {
            border: 1px solid #dddddd;
        }

        th, td {
            padding: 12px;
        }

        th {
            background-color: #f2f2f2;
        }

        button {
            padding: 5px 10px;
            font-size: 14px;
            color: #ffffff;
            background-color: #007bff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
	<h1>All employees</h1>
	<table>

		<tr>
			<td>ID</td>
			<th>Employee Number</th>
            <th>Employee Name</th>
            <th>Employee Email</th>
            <th>Employee Salary</th>
            <th>Employee Address</th>
            <th>Employee Designation</th>
            <th>Employee Department</th>
            <th>Employee Phone Number</th>
            <th>Creator ID</th>
            <th>Created At</th>
            <th colspan="2">Actions</th>
            
            
        </tr>
		<%
		List<Employee> employeeList = (List<Employee>) request.getAttribute("Employees");
		for (Employee employee : employeeList) {
		%>
		<tr>
			<td><%=employee.getId()%>
			<td><%=employee.getEmpID()%></td>
			<td><%=employee.getEmpName()%></td>
			<td><%=employee.getEmpEmail()%></td>
			<td><%= employee.getEmpSalary() %></td>
            <td><%= employee.getEmpAddress() %></td>
            <td><%= employee.getEmpDesignation() %></td>
            <td><%= employee.getEmpDepartment() %></td>
            <td><%= employee.getEmpPhoneNumber() %></td>
            <td><%= employee.getCreatorID() %></td>
            <td><%= employee.getCreatedAt() %></td>
            <td colspan="2">
				<form action="deleteEmployee" method="POST">
					<input type="hidden" value=<%=employee.getId()%> name="id">
					<button type="submit">Delete</button>
				</form>
			</td>
			
			<td>
				<form action="editEmployeeData" method="GET">
					<input type="hidden" value=<%=employee.getId()%> name="id">
					<button type="submit">Edit</button>
				</form>
			</td>

		</tr>
		<%
		}
		%>
	</table>
	<button onClick="window.location.href='dashboard.html'">Dashboard</button>
</body>
</html>