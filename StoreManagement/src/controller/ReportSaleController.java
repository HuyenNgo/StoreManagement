/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Category;
import model.Product;
import model.Supplier;

/**
 *
 * @author NGO THI HUYEN
 */

import java.util.ArrayList;
import javax.swing.JComboBox;
import model.Category;
import model.Product;
import model.Supplier;

/**
 *
 * @author NGO THI HUYEN
 */
public class ReportSaleController {

    public ReportSaleController() {
    }
    public void loadProduct(JComboBox<String> cbProduct) {
        cbProduct.removeAllItems();
        ArrayList<Product>list= (new Product()).getProduct();
        for(int i=0;i<list.size();i++)
        {
            cbProduct.addItem(list.get(i).name()+":"+list.get(i).id());
        }
        cbProduct.addItem("All"+":"+(-1));
        
    }
    
     public void loadProductCategory(JComboBox<String> cbProductCategory) {
        cbProductCategory.removeAllItems();
        ArrayList<Category>list= (new Category()).getCategory();
        for(int i=0;i<list.size();i++)
        {
            cbProductCategory.addItem(list.get(i).name()+":"+list.get(i).id());
        }
        cbProductCategory.addItem("All"+":"+(-1));;
        
    }
     
      public void loadSupplier(JComboBox<String> cbSupplier) {
        cbSupplier.removeAllItems();
        ArrayList<Supplier>list= (new Supplier()).getSupplier();
        for(int i=0;i<list.size();i++)
        {
            cbSupplier.addItem(list.get(i).name()+":"+list.get(i).id());
        }
        cbSupplier.addItem("All"+":"+(-1));;
    }

}


