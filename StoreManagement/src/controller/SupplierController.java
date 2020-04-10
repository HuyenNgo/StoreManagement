/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Supplier;

/**
 *
 * @author huyen
 */
public class SupplierController {
    Supplier Model=new Supplier();
    
    public boolean AddSupplier(String supplier) {
        if(supplier.equals(""))
            return false;
        return Model.AddSupplier(supplier);
    }

    public void getSupplier(JTable table) {
        String[] head=new String[]{"STT","Mã nhà cumg cấp","Tên nhà cung cấp"};
        ArrayList<Supplier> list= Model.getSupplier();
        Object[][] body=new Object[list.size()][3];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=((Supplier)list.get(i)).id();
            body[i][2]=((Supplier)list.get(i)).name();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
    }

    public void SearchSupplier(JTable table, String text) {
        String[] head=new String[]{"STT","Mã nhà cung cấp","Tên cung cấp"};
        ArrayList<Supplier> list= Model.getSupplier();
        for(int i=0;i<list.size();i++)
        {
            if(!list.get(i).name().contains(text) && !list.get(i).id().equals(text))
            {
                list.remove(i);
                i--;
            }
        }
        Object[][] body=new Object[list.size()][3];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=((Supplier)list.get(i)).id();
            body[i][2]=((Supplier)list.get(i)).name();
        }
        DefaultTableModel dtm = new DefaultTableModel(body,head){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        table.setModel(dtm);
        table.getColumnModel().getColumn(0).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setPreferredWidth(200);
        table.getColumnModel().getColumn(2).setPreferredWidth(200);
    }
    
}
