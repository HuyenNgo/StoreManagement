/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author huyen
 */
public class Product {
    private String id;
    private String name;
    private Category category;
    private int count;
    private float price;
    
    public Product(){}
    public Product(String id, String name ,Category category,int count,float price)
    {
        this.id=id;
        this.name=name;
        this.category=category;
        this.price=price;
        this.count=count;
        
    }
    public String id(){return id;}
    public String name(){return name;}
    public Category category(){return category;}
    public int count(){return count;}
    public float price(){return price;}
    
    public ArrayList<Product> getProduct() {
        String SQL="call USP_GetProduct";
        ArrayList<Product> list=new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("ProductID");
                String name=rs.getString("ProductName");
                Category category=(new Category()).getCategoryByProduct(rs.getString("productid"));
                
                int count=Integer.parseInt(rs.getString("totalnum"));
                float price=(float)Math.round(Float.parseFloat(rs.getString("price"))*10)/10;
                Product product=new Product(id, name,category,count,price);
                list.add(product);
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }

    public boolean AddProduct(String name,String categoryID) {
        String SQL="call USP_AddProduct(\""+name+"\",\""+categoryID+"\")";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            int rs1=statement.executeUpdate(SQL);
            if(rs1 >0)
            {
                DataAccessHelper.getInstance().getClose();
                return true;
            }
            else
            {
                DataAccessHelper.getInstance().getClose();
                return false;
            }
        } catch (Exception e) {return false;}
    }

    public Product getProductByID(String productID) {
        String SQL="call USP_GetProductByID(\""+productID+"\")";
        Product product=null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("productid");
                String name=rs.getString("productname");
                Category category=(new Category()).getCategoryByProduct(rs.getString("productid"));
             int count=Integer.parseInt(rs.getString("totalnum"));
                float price=(float)Math.round(Float.parseFloat(rs.getString("price"))*10)/10;
                product=new Product(id, name, category,count,price);
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return product;
    }

    public boolean UpdateProduct(String id, String name, String categoryID) {
        String SQL="call USP_UpdateProduct(\""+id+"\",\""+name+"\",\""+categoryID+"\")";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            int rs1=statement.executeUpdate(SQL);
            if(rs1 >0)
            {
                DataAccessHelper.getInstance().getClose();
                return true;
            }
            else
            {
                DataAccessHelper.getInstance().getClose();
                return false;
            }
        } catch (Exception e) {return false;}
    }
}
