package codetest.repository;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class PhotoRepo {
	public int uploadPhoto(byte[] photoByte) {
		int i=0;
		Connection cn=LinkConnection.linkConnection();
		String query="INSERT INTO codetest.photo (photo) VALUES (?);";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ps.setBytes(1, photoByte);
			i=ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Uploading Photo Error "+e.getMessage());
		}
		return i;
	}
	public List<String> viewPhoto(){
		List<String>photoList=new ArrayList<String>();
		Connection cn=LinkConnection.linkConnection();
		String query="SELECT * FROM codetest.photo;";
		try {
			PreparedStatement ps=cn.prepareStatement(query);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Blob blob=rs.getBlob("photo");
				byte[]b=blob.getBytes(1, (int)blob.length());
				String base=Base64.getEncoder().encodeToString(b);
				photoList.add(base);
			}
		} catch (SQLException e) {
			System.out.println("Viewing Photo Error "+e.getMessage());
		}
		return photoList;
	}
}
