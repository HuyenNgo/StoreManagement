/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Product;
import model.Category;
import model.ImportProduct;


/**
 *
 * @author huyen
 */
public class ProductController {
    Product Model=new Product();

    public void loadTable(JTable table) {
        String[] head=new String[]{"STT","Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Số lượng tồn"};
        ArrayList<Product> list= Model.getProduct();
        Object[][] body=new Object[list.size()][9];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=list.get(i).id();
            body[i][2]=list.get(i).name();
            body[i][3]=list.get(i).category().name();
            body[i][4]=list.get(i).count();
          // body[i][5]=list.get(i).supplier();
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
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
       // table.getColumnModel().getColumn(5).setPreferredWidth(200);
        
    }

    public void loadCBCategory(JComboBox<String> cbCategory) {
        cbCategory.removeAllItems();
        ArrayList<Category>list= (new Category()).getCategory();
        for(int i=0;i<list.size();i++)
        {
            cbCategory.addItem(list.get(i).name()+":"+list.get(i).id());
        }
        cbCategory.addItem("Thêm...");
    }


    public boolean AddBook(String name, String category) {
        String categoryID=category.split(":")[1];
        
        return Model.AddProduct(name,categoryID);
    }

    public void searchBook(String text,JTable table) {
        String[] head=new String[]{"STT","Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Số lượng tồn"};
        ArrayList<Product> list= Model.getProduct();
        for(int i=0;i<list.size();i++)
        {
          
            if(!((Product)list.get(i)).name().contains(text) && !((Product)list.get(i)).id().equals(text)
                    && !((Product)list.get(i)).category().name().contains(text)
                    )
            {
                list.remove(i);
                i--;
            }
        }

       Object[][] body=new Object[list.size()][9];
       for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=((Product)list.get(i)).id();
            body[i][2]=((Product)list.get(i)).name();
            body[i][3]=((Product)list.get(i)).category().name();
            body[i][4]=((Product)list.get(i)).count();
            //body[i][5]=Math.round(((Product)list.get(i)).price()*10)/10;
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
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
       // table.getColumnModel().getColumn(5).setPreferredWidth(200);
        
    }
    public Product getProductByID(String id) {
        return Model.getProductByID(id);
    }

    public boolean UpdateProduct(String id, String name, String category) {
        String categoryID=category.split(":")[1];
        return Model.UpdateProduct(id, name, categoryID);
    }

    public void loadImportByProductID(JTable table,String id) {
        String[] head=new String[]{"STT","Số phiếu nhập","Ngày lập","Nhà cung cấp","Số lượng","Đơn giá","Thành tiền"};
       ArrayList<ImportProduct> list= (new ImportProduct()).getImporByProductID(id);
        Object[][] body=new Object[list.size()][7];
        for(int i=0;i<list.size();i++)
        {
            body[i][0]=i;
            body[i][1]=list.get(i).id();
            body[i][2]=(new SimpleDateFormat("dd/MM/yyyy")).format(list.get(i).date());
            body[i][3]=list.get(i).supplier();
            body[i][4]=list.get(i).count();
            body[i][5]=list.get(i).price();
            body[i][6]=list.get(i).total();
            
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
        table.getColumnModel().getColumn(3).setPreferredWidth(200);
        table.getColumnModel().getColumn(4).setPreferredWidth(200);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(200);
    }
    
    
}
