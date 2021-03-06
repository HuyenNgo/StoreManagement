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
public class Customer {
    private String id;
    private String name;
    private String phoneNumber;
    private String email;
    private String address;
    private float owe;
    
    public String id(){return id;}
    public String name(){return name;}
    public String phoneNumber(){return phoneNumber;}
    public String email(){return email;}
    public String address(){return address;}
    public float owe(){return owe;}
    
    public Customer(){}
    public Customer(String id, String name, String phoneNumber, String email, String address)
    {
        this.id=id;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.email=email;
        this.address=address;
      //  this.owe=owe;
    }

    public boolean AddCustomer(String name, String phone, String email, String address) {
        String SQL="call USP_AddCustomer(\""+name+"\",\""+phone+"\",\""+email+"\",\""+address+"\")";
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

    public ArrayList<Customer> getCustomer() {
        String SQL="CALL USP_GetCustomer()";
        ArrayList<Customer> list=new ArrayList<Customer>();
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("Customerid");
                String name=rs.getString("customername");
                String phone=rs.getString("phone");
                String email=rs.getString("Email");
                String address=rs.getString("address");
               // Float owe=(float)Math.round(Float.parseFloat(rs.getString("SoTienNo")));
                list.add(new Customer(id,name,phone,email,address));
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return list;
    }

    public Customer getCustomerByID(String customerID) {
        String SQL="CALL USP_GetCustomerByID(\""+customerID+"\")";
        Customer customer=null;
        try{
            DataAccessHelper.getInstance().getConnect();
            Statement statement =DataAccessHelper.getInstance().conn.createStatement();
            ResultSet rs=statement.executeQuery(SQL);
            while(rs.next())
            {
                String id=rs.getString("CustomerID");
                String name=rs.getString("CustomerName");
                String phone=rs.getString("Phone");
                String email=rs.getString("Email");
                String address=rs.getString("Address");
              //  Float owe=(float)Math.round(Float.parseFloat(rs.getString("SoTienNo")));
                customer=new Customer(id,name,phone,email,address);
            }
            DataAccessHelper.getInstance().getClose();
        } catch (Exception e) {}
        return customer;
    }

    public boolean UpdateCustomer(String id, String name, String phone, String email, String address) {
        String SQL="call USP_UpdateCusTomer(\""+id+"\",\""+name+"\",\""+phone+"\",\""+email+"\",\""+address+"\")";
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
    
    
}
