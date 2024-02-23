package com.example.demo1.model.service.category;

import com.example.demo1.model.Category;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo1.config.ConnectionJDBC.getConnection;

public class CategoryService implements ICategoryService{
    @Override
    public List<Category> findAllCa() {
        List<Category> categoryServiceList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from category");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("nameC");
                Category category = new Category(id,name);
                categoryServiceList.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryServiceList;
    }
}
