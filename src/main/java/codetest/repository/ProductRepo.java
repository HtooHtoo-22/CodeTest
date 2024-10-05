package codetest.repository;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.CartBean;
import Model.ProductBean;

public class ProductRepo {
	public List<ProductBean> showAllProducts(){
		List<ProductBean> list =new ArrayList<ProductBean>();
		ProductBean bean=null;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM codetest.product;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean=new ProductBean();
				bean.setId(rs.getInt(1));
				bean.setProduct_name(rs.getString(2));
				bean.setBrand(rs.getString(3));
				bean.setPrice(rs.getDouble(4));
				Blob b=rs.getBlob(6);
				bean.setPhoto(b.getBytes(1, (int)b.length()));
				
				list.add(bean);
			}
		} catch (SQLException e) {
			System.out.println("Show proucts error "+e.getMessage());
		}
		return list;
	}
	
	
	
}
