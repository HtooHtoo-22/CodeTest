package codetest.repository;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.CartBean;

public class CartRepo {
	public List<CartBean> showMyCart(){
		List<CartBean> list =new ArrayList<CartBean>();
		CartBean bean=null;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT cart.cart_id,product_id,product.product_name,product.brand,product.price,quantity,product.photo FROM codetest.cart INNER JOIN product ON cart.product_id=product.id WHERE cart_status=1;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				bean=new CartBean();
				bean.setCart_id(rs.getInt(1));
				bean.setProduct_id(rs.getInt(2));
				bean.setProduct_name(rs.getString(3));
				bean.setBrand(rs.getString(4));
				bean.setPrice(rs.getDouble(5));
				bean.setQuantity(rs.getInt(6));
				Blob b=rs.getBlob(7);
				bean.setPhotoByte(b.getBytes(1, (int)b.length()));
				list.add(bean);
			}
		} catch (SQLException e) {
			System.out.println("show my cart error "+e.getMessage());
		}
		return list;
	}
	public int order() {
		int i=0;
		Connection cn=LinkConnection.linkConnection();
		String query="UPDATE codetest.cart SET cart_status=0;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ORder error "+e.getMessage());
		}
		return i;
	}
	public int addToCart(int id) {
		int i=0;
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM codetest.cart WHERE product_id=? AND cart_status=1;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				int quantity=rs.getInt("quantity");
				quantity++;
				query="UPDATE codetest.cart SET quantity=? WHERE product_id=? AND cart_status=1;";
				ps=cn.prepareStatement(query);
				ps.setInt(1, quantity);
				ps.setInt(2, id);
				i=ps.executeUpdate();
			}else {
				query="INSERT INTO codetest.cart (product_id) VALUES (?);";
				ps=cn.prepareStatement(query);
				ps.setInt(1, id);
				i=ps.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println("Add to cart error "+e.getMessage());
		}
		return i;
	}
	public int deleteFromCart(int id) {
		int i=0;
		Connection cn=LinkConnection.linkConnection();
		String query="DELETE FROM codetest.cart WHERE cart_id=? AND cart_status=1;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setInt(1, id);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Delete From cart error "+e.getMessage());
		}
		return i;
	}
}
