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
public class Bill {
    private String id;
    private String customerID;
    private Date date;
    private float value;
    private float moneyReceive;
    private float moneyChange;
    private String productID;
    private int count;
    private float price;
    private float moneyProduct;
    
    public String id(){return id;}
    public String customerID(){return customerID;}
    public Date date(){return date;}
    public float value(){return value;}
    public float moneyReceive(){return moneyReceive;}
    public float moneyChange(){return moneyChange;}
    public String productID(){return productID;}
    public int count(){return count;}
    public float price(){return price;}
    public float moneyProduct(){return moneyProduct;}
    public Bill(){}
    public Bill(String id, String customerID, Date date,float value,float moneyReceive, float moneyChange,String productID,int count,float price,float moneyProduct)
    {
        this.id=id;
        this.customerID=customerID;
        this.value=value;
        this.date=date;
        this.moneyChange=moneyChange;
        this.moneyReceive=moneyReceive;
        this.moneyProduct=moneyProduct;
        this.productID=productID;
        this.count=count;
        this.price=price;
    }

    public boolean AddBill(Date date, float value, float moneyReceive, float moneyChange, String customerID) {
        SimpleDateFormat df=new SimpleDateFormat("yyyy/MM/dd");
        String SQL="call USP_AddBill(\""+df.format(date)+"\",\""+value+"\",\""+moneyReceive+"\",\""+moneyChange+"\",\""+Integer.parseInt(customerID)+"\")";
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

    public boolean AddBillInfo(String id, int count, float price, float total) {
        String SQL="call USP_AddBillInfo(\""+id+"\",\""+count+"\",\""+price+"\",\""+total+"\")";
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

    public ArrayList<Bill> getBillByCustomerID(String customer) {
        String SQL="call USP_GetBillByCustomerID(\""+customer+"\")";
        ArrayList<Bill> list=new ArrayList<Bill>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("numbill");
                String customerID=rs.getString("customerid");
                Date date=(new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("createdate"));
                float value=Math.round(Float.parseFloat(rs.getString("totalmoney"))*10)/10;
                float moneyReceive=Math.round(Float.parseFloat(rs.getString("paid"))*10)/10;
                float moneyChange=Math.round(Float.parseFloat(rs.getString("rest"))*10)/10;
                String bookID=rs.getString("productid");
                int count=Integer.parseInt(rs.getString("amount"));
                float price=Math.round(Float.parseFloat(rs.getString("price"))*10)/10;
                float moneyBook=Math.round(Float.parseFloat(rs.getString("totalmoney"))*10)/10;
                
                list.add(new Bill(id, customerID, date, value, moneyReceive,  moneyChange, bookID, count, price, moneyBook));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }

    public ArrayList<Bill> getBillByBillID(String billID) {
        String SQL="call USP_GetBillByBillID(\""+billID+"\")";
        ArrayList<Bill> list=new ArrayList<Bill>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                 String id=rs.getString("numbill");
                String customerID=rs.getString("customerid");
                Date date=(new SimpleDateFormat("yyyy-MM-dd")).parse(rs.getString("createdate"));
                float value=Math.round(Float.parseFloat(rs.getString("totalmoney"))*10)/10;
                float moneyReceive=Math.round(Float.parseFloat(rs.getString("paid"))*10)/10;
                float moneyChange=Math.round(Float.parseFloat(rs.getString("rest"))*10)/10;
                String productID=rs.getString("productid");
                int count=Integer.parseInt(rs.getString("amount"));
                float price=Math.round(Float.parseFloat(rs.getString("price"))*10)/10;
                float moneyBook=Math.round(Float.parseFloat(rs.getString("totalmoney"))*10)/10;
                
                list.add(new Bill(id, customerID, date, value, moneyReceive,  moneyChange, productID, count, price, moneyBook));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }
}