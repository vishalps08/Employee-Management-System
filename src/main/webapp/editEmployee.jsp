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
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 600px;
        }

        label {
            font-size: 14px;
            margin-bottom: 8px;
            display: block;
            color: #333;
        }

        input[type="text"],
        input[type="email"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
            background-color: #f9f9f9;
        }

        input[type="text"]:focus,
        input[type="email"]:focus,
        input[type="number"]:focus {
            outline-color: #007bff;
            border-color: #007bff;
        }

        button {
            padding: 10px 20px;
            font-size: 16px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            width: 100%;
        }

        button:hover {
            background-color: #0056b3;
        }

        form input[readonly] {
            background-color: #e9ecef;
            cursor: not-allowed;
        }
    </style>
</head>
<body>

	 <%
    List<Employee> employeeList = (List<Employee>) request.getAttribute("employees");
    for (Employee employee : employeeList) {
    %>

	<form action="updateEmployee" method="POST">
		      <label for="id">ID</label>
            <input type="number" id="id" value="<%= employee.getId() %>" name="id" readonly>
            <br>
            <label for="empId">Employee ID</label>
            <input type="number" id="empId" value="<%= employee.getEmpID() %>" name="empId" readonly>
            <br>
            <label for="empName">Employee Name</label>
            <input type="text" id="empName" value="<%= employee.getEmpName() %>" name="empName" required>
            <br>
            <label for="empEmail">Employee Email</label>
            <input type="email" id="empEmail" value="<%= employee.getEmpEmail() %>" name="empEmail" required>
            <br>
            <label for="empSalary">Employee Salary</label>
            <input type="number" id="empSalary" value="<%= employee.getEmpSalary() %>" name="empSalary" required>
            <br>
            <label for="empAddress">Employee Address</label>
            <input type="text" id="empAddress" value="<%= employee.getEmpAddress() %>" name="empAddress" required>
            <br>
            <label for="empDesignation">Employee Designation</label>
            <input type="text" id="empDesignation" value="<%= employee.getEmpDesignation() %>" name="empDesignation" required>
            <br>
            <label for="empDepartment">Employee Department</label>
            <input type="text" id="empDepartment" value="<%= employee.getEmpDepartment() %>" name="empDepartment" required>
            <br>
            <label for="empPhoneNumber">Employee Phone Number</label>
            <input type="number" id="empPhoneNumber" value="<%= employee.getEmpPhoneNumber() %>" name="empPhoneNumber" required>
            <br>
            <button type="submit">Submit</button>
        </form>


	<%
	}
	%>

</body>
</html>