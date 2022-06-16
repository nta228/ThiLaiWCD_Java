package fpt.aptech.thilaiwcd_java.controller;

import fpt.aptech.thilaiwcd_java.entity.Employee;
import fpt.aptech.thilaiwcd_java.model.EmployeeModel;
import fpt.aptech.thilaiwcd_java.model.MySqlEmployeeModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class CreateEmployeeServlet extends HttpServlet {
    private EmployeeModel employeeModel;

    public CreateEmployeeServlet() {
        this.employeeModel = new MySqlEmployeeModel();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/employee.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String fullName = req.getParameter("fullName");
        String birthday = req.getParameter("birthday");
        String address = req.getParameter("address");
        String position = req.getParameter("position");
        String department = req.getParameter("department");
       /* Employee employee = new Employee();
        employee.setFullName(fullName);
        employee.setBirthday(birthday);
        employee.setAddress(address);
        employee.setPosition(position);
        employee.setDepartment(department);*/
        Employee employee = Employee.EmployeeBuilder.aEmployee()
                .withFullName(fullName)
                .withBirthday(birthday)
                .withAddress(address)
                .withPosition(position)
                .withDepartment(department)
                .build();
        if(!employee.isValid()){
            // trả dữ liệu cũ về form
            req.setAttribute("employee", employee);
            // kèm theo thông tin lỗi
            req.setAttribute("errors", employee.getErrors());
            // tất cả được trả về
            req.getRequestDispatcher("/employee.jsp").forward(req, resp);
            return;
        }
        // thực hiện save
        employeeModel.save(employee);
        req.setAttribute("employee", employee);
        req.getRequestDispatcher("/list.jsp").forward(req, resp);
    }
    public static void main(String[] args) {
        HashMap<String, String> errors = new HashMap<>();
        errors.put("fullName", "Please enter fullName");
        errors.put("birthday", "Please enter birthday");
        errors.put("address", "Please enter address");
        errors.put("position", "Please enter position");
        errors.put("department", "Please enter department");
        if (errors.containsKey("username")) {

        }
    }
}
