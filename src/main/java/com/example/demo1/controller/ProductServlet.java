package com.example.demo1.controller;

import com.example.demo1.HelloServlet;
import com.example.demo1.dto.DTOProduct;
import com.example.demo1.model.Category;
import com.example.demo1.model.Product;
import com.example.demo1.model.service.category.CategoryService;
import com.example.demo1.model.service.category.ICategoryService;
import com.example.demo1.model.service.product.IProductService;
import com.example.demo1.model.service.product.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "productServlet",urlPatterns = "/product")
public class ProductServlet extends HelloServlet {
    static ICategoryService iCategoryService = new CategoryService();
    static IProductService iProductService = new ProductService();
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create" :
                showFormCreate(request,response);
            break;
            case "edit" :
                showFormEdit(request,response);
            break;
            case  "delete":
                deleteProduct(request,response);
                break;
            default:
                showListProduct(request,response);
        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        iProductService.delete(id);
        try {
            response.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("edit.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = iProductService.findById(id);
        List<Category> categories = iCategoryService.findAllCa();
        request.setAttribute("category",categories);
        request.setAttribute("product",product);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("create.jsp");
        List<Category> categories = iCategoryService.findAllCa();
        request.setAttribute("category",categories);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showListProduct(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("list.jsp");
        List<DTOProduct> dtoProducts = iProductService.findAll();
        request.setAttribute("dtoProduct",dtoProducts);
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        action = action == null ? "" : action;
        switch (action) {
            case "create" :
                createProduct(req,resp);
                break;
            case "edit" :
                editProduct(req,resp);
                break;
            case "find" :
                findByName(req,resp);
                break;
            default:
                showListProduct(req,resp);
        }
    }

    private void findByName(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        List<DTOProduct> products = iProductService.findByName(name);
        req.setAttribute("dtoProduct",products);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String date = req.getParameter("date");
        int idC = Integer.parseInt(req.getParameter("id_ca"));
        Product product = new Product(id,name,date,idC);
        iProductService.edit(product);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        String date = req.getParameter("date");
        int idC = Integer.parseInt(req.getParameter("id_ca"));
        Product product = new Product(name,date,idC);
        iProductService.create(product);
        try {
            resp.sendRedirect("/product");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
