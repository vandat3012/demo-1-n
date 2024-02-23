package com.example.demo1.model.service.product;

import com.example.demo1.dto.DTOProduct;
import com.example.demo1.model.Category;
import com.example.demo1.model.Product;

import javax.servlet.RequestDispatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.example.demo1.config.ConnectionJDBC.getConnection;

public class ProductService implements IProductService {

    @Override
    public List<DTOProduct> findAll() {
        List<DTOProduct> productList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select p.id,p.name,p.dates,c.nameC\n" +
                    "from product p\n" +
                    "join category c\n" +
                    "on p.id_ca = c.id\n" +
                    "order by p.id asc;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dates = String.valueOf(resultSet.getDate("dates"));
                String name1 = resultSet.getString("nameC");
                DTOProduct dtoProduct = new DTOProduct(id, name, dates, name1);
                productList.add(dtoProduct);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
    }

    @Override
    public void create(Product product) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into product(name,dates,id_ca) values \n" +
                    "(?,?,?);");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDate());
            preparedStatement.setInt(3, product.getIdCate());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Product findById(int id) {
        Connection connection = getConnection();
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from product where id = ?;");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dates = String.valueOf(resultSet.getDate("dates"));
                int idC = resultSet.getInt("id_ca");
                product = new Product(id1, name, dates, idC);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return product;
    }

    @Override
    public void edit(Product product) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set name = ?,dates = ?,id_ca=? where id = ?;");
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDate());
            preparedStatement.setInt(3, product.getIdCate());
            preparedStatement.setInt(4, product.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from product \n" +
                    "where id = ?;");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<DTOProduct> findByName(String name) {
        List<DTOProduct> productList = new ArrayList<>();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select p.id,p.name,p.dates,c.nameC\n" +
                    "from product p\n" +
                    "join category c\n" +
                    "on p.id_ca = c.id\n" +
                    "where p.name = ?;");
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name2 = resultSet.getString("name");
                String dates = String.valueOf(resultSet.getDate("dates"));
                String name1 = resultSet.getString("nameC");
                DTOProduct dtoProduct = new DTOProduct(id, name2, dates, name1);
                productList.add(dtoProduct);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;

    }
}
