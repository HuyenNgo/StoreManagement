/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/**
 *
 * @author tnd
 */
public class ImportProduct {
    private String id;
    private String productID;
    private int count;
    private float price;
    private float total;
    private Date date;
    private float valueImport;
    private String supplier;
    
    public ImportProduct(){}
    public ImportProduct(String id,String productID,int count, float price, float total, Date date, float valueImport,String supplier)
    {
        this.id=id;
        this.productID=productID;
        this.count=count;
        this.price=price;
        this.total=total;
        this.date=date;
        this.valueImport=valueImport;
        this.supplier=supplier;
    }
    public String id(){return id;}
    public String productID(){return productID;}
    public int count(){return count;}
    public float price(){return price;}
    public float total(){return total;}
    public Date date(){return date;}
    public float valueImport(){return valueImport;}
    public String supplier (){ return supplier;}

    public boolean AddImportProduct(Date date, float value,String supplierID) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd");
        String SQL="call USP_AddImportProduct(\""+df.format(date)+"\",\""+value + "\",\""+supplierID+"\")";
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

    public boolean AddImportProductInfo(String productID, int count, float price, float total,String supplierID) {
        String SQL="call USP_AddImportProductInfo(\""+productID+"\",\""+supplierID+"\",\""+count+"\",\""+price+"\",\""+total+"\")";
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            int rs=statement.executeUpdate(SQL);
            if(rs>0)
            {
                DataAccessHelper.getInstance().getClose();
                return true;
            }
            {
                DataAccessHelper.getInstance().getClose();
                return false;
            }
        } catch (Exception e) {return false;}
    }

    public ArrayList<ImportProduct> getImporByProductID(String productID) {
        String SQL="call USP_GetImporByProductID(\""+productID+"\")";
        ArrayList<ImportProduct> list=new ArrayList<ImportProduct>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("numinventory");
                String pdID=rs.getString("productid");
                int count=Integer.parseInt(rs.getString("numinput"));
                float price=Math.round(Float.parseFloat(rs.getString("money"))*10)/10;
                float total=Math.round(Float.parseFloat(rs.getString("totalmoney"))*10)/10;
                Date date=(new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("datecreate"));
                float valueImport=Math.round(Float.parseFloat(rs.getString("totalmoney"))*10)/10;
                String supplier=rs.getString("supplierName");
                list.add(new ImportProduct(id,pdID,count,price,total,date,valueImport,supplier));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
    
}
