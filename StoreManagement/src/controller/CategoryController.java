/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Category;

/**
 *
 * @author huyen
 */
public class CategoryController {
    Category Model=new Category();
    public boolean AddCategory(String categoryName) {
        if(categoryName.equals(""))
            return false;
        return Model.AddCategory(categoryName);
    }

    public void getCategory(JTable table) {
        String[] head=new String[]{"STT","Mã loại sản phẩm","Tên loại sản phẩm"};
        ArrayList<Category> list= Model.getCategory();
        Object[][] body=new Object[list.size()][3];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=((Category)list.get(i)).id();
            body[i][2]=((Category)list.get(i)).name();
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

    public void SearchCategory(JTable table, String text) {
        String[] head=new String[]{"STT","Mã loại sản phẩm","Tên loại sản phẩm"};
        ArrayList<Category> list= Model.getCategory();
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
            body[i][1]=((Category)list.get(i)).id();
            body[i][2]=((Category)list.get(i)).name();
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
