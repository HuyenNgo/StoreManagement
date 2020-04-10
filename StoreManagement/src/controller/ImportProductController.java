/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import model.Product;
import model.ImportProduct;
import model.Supplier;

/**
 *
 * @author tnd
 */
public class ImportProductController {
    ImportProduct Model=new ImportProduct();

    public void loadProduct(JComboBox<String> cbProduct) {
        cbProduct.removeAllItems();
        ArrayList<Product>list= (new Product()).getProduct();
        for(int i=0;i<list.size();i++)
        {
            cbProduct.addItem(list.get(i).name()+":"+list.get(i).id());
        }
        cbProduct.addItem("Thêm...");
    }

    public void loadSupplier(JComboBox<String> cbSupplier)
    {
    
    cbSupplier.removeAllItems();
        ArrayList<Supplier>list= (new Supplier()).getSupplier();
        for(int i=0;i<list.size();i++)
        {
            cbSupplier.addItem(list.get(i).name()+":"+list.get(i).id());
        }
        cbSupplier.addItem("Thêm...");
    
    }
    
    public boolean AddImportProduct(String[][] data,String date,String value,String supplierID) throws ParseException {
        if(!Model.AddImportProduct(new SimpleDateFormat("dd/MM/yyyy").parse(date),Float.parseFloat(value),supplierID))
            return false;
        for(int i=0;i<data.length;i++)
        {
            String id=data[i][0];
            int count=Integer.parseInt(data[i][1]);
            float price=Float.parseFloat(data[i][2]);
            float total=Float.parseFloat(data[i][3]);
            if(!Model.AddImportProductInfo(id,count,price,total,supplierID))
                return false;
        }
        return true;
    }
  
}
