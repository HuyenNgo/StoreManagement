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
public class Supplier {
    private String id;
    private String name;
    
    public Supplier(){}
    public Supplier(String id, String name)
    {
        this.id=id;
        this.name=name;
    }
    public String id(){return id;}
    public String name(){return name;}
    public ArrayList<Supplier> getSupplier() {
        String SQL="call USP_GetSupplier()";
        ArrayList<Supplier> list=new ArrayList<Supplier>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                list.add(new Supplier(rs.getString("SupplierId"),rs.getString("SupplierName")));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }

    public boolean AddSupplier(String supplier) {
        
        String SQL="call USP_AddSupplier(\""+supplier+"\")";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            int rs=statement.executeUpdate(SQL);
            
            if(rs>0)
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
    public Supplier getSuppierByID(String supplierid)
    {
    
    String SQL="call USP_GetSuppierByID(\""+supplierid+"\")";
        Supplier supplier=null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                 supplier=new Supplier(rs.getString("SupplierId"),rs.getString("SupplierName"));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return supplier;
    }
    public Supplier getSuppierByName(String supplierName)
    {
    
    String SQL="call USP_GetSuppierByName(\""+supplierName+"\")";
        Supplier supplier=null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                 supplier=new Supplier(rs.getString("SupplierId"),rs.getString("SupplierName"));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return supplier;
    }
    
     public ArrayList<Supplier> getSuppierByProduct(String productid) {
        String SQL="call USP_GetSuppierByProduct(\""+productid+"\")";
        ArrayList<Supplier> list=new ArrayList<Supplier>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                 list.add(new Supplier(rs.getString("SupplierId"),rs.getString("SupplierName")));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
}
