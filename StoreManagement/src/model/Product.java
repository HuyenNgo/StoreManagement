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
    private Supplier supplier;
    
    public Product(){}
    
     public Product(String id, String name ,Supplier supplier,int count,float price)
    {
        this.id=id;
        this.name=name;
        this.supplier=supplier;
        this.price=price;
        this.count=count;
        
    }
    public Product(String id, String name ,Category category,int count)
    {
        this.id=id;
        this.name=name;
        this.category=category;
       //this.price=price;
        this.count=count;
        
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    public String id(){return id;}
    public String name(){return name;}
    public Category category(){return category;}
    public int count(){return count;}
    public float price(){return price;}
    public Supplier supplier (){return supplier;}
    
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
              //  float price=(float)Math.round(Float.parseFloat(rs.getString("price"))*10)/10;
                Product product=new Product(id, name,category,count);
                list.add(product);
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
     public ArrayList<Product> getProductOfSupplier() {
        String SQL="call USP_GetProductOfSupplier";
        ArrayList<Product> list=new ArrayList<>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("ProductID");
                String name=rs.getString("ProductName");
                Supplier supplier = (new Supplier()).getSuppierByID(rs.getString("supplierID"));
                int count=Integer.parseInt(rs.getString("totalnum"));
                float price=(float)Math.round(Float.parseFloat(rs.getString("price"))*10)/10;
                Product product=new Product(id, name,supplier,count,price);
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
            int rs=statement.executeUpdate(SQL);
            if(rs >0)
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
               // float price=(float)Math.round(Float.parseFloat(rs.getString("price"))*10)/10;
                product=new Product(id, name, category,count);
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
