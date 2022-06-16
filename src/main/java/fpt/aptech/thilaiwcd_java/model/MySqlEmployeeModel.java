package fpt.aptech.thilaiwcd_java.model;

import fpt.aptech.thilaiwcd_java.entity.Employee;
import fpt.aptech.thilaiwcd_java.constant.SqlConstant;
import fpt.aptech.thilaiwcd_java.util.ConnectionHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MySqlEmployeeModel implements EmployeeModel {

    @Override
    public boolean save(Employee obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SqlConstant.EMPLOYEE_INSERT);
            preparedStatement.setString(1, obj.getFullName());
            preparedStatement.setString(2, obj.getBirthday());
            preparedStatement.setString(3, obj.getAddress());
            preparedStatement.setString(4, obj.getPosition());
            preparedStatement.setString(5, obj.getDepartment());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
}