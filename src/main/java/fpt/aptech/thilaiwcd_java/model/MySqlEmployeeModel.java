package com.example.thiwcd_java.model;

import com.example.thiwcd_java.constant.SqlConstant;
import com.example.thiwcd_java.entity.Phone;
import com.example.thiwcd_java.util.ConnectionHelper;

import java.sql.*;

public class MySqlPhoneModel implements PhoneModel {

    @Override
    public boolean save(Phone obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement
                    = connection.prepareStatement(SqlConstant.PHONE_INSERT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getBrand());
            preparedStatement.setDouble(3, obj.getPrice());
            preparedStatement.setString(4, obj.getDescription());
            preparedStatement.setInt(5, obj.getStatus().getValue());
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
        }
        return false;
    }
}