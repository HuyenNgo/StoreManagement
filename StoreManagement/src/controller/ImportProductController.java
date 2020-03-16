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

/**
 *
 * @author tnd
 */
public class ImportProductController {
    ImportProduct Model=new ImportProduct();

    public void loadBook(JComboBox<String> cbProduct) {
        cbProduct.removeAllItems();
        ArrayList<Product>list= (new Product()).getProduct();
        for(int i=0;i<list.size();i++)
        {
            cbProduct.addItem(list.get(i).name()+":"+list.get(i).id());
        }
        cbProduct.addItem("Thêm...");
    }

    public boolean AddImportProduct(String[][] data,String date,String value) throws ParseException {
        if(!Model.AddImportProduct(new SimpleDateFormat("dd/MM/yyyy").parse(date),Float.parseFloat(value)))
            return false;
        for(int i=0;i<data.length;i++)
        {
            String id=data[i][0];
            int count=Integer.parseInt(data[i][1]);
            float price=Float.parseFloat(data[i][2]);
            float total=Float.parseFloat(data[i][3]);
            if(!Model.AddImportProductInfo(id,count,price,total))
                return false;
        }
        return true;
    }
  
}
