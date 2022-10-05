package srcpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.xdevapi.Statement;

//remember to do do alter table tomorrow
public class practicePkg {
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;

	String driver = "com.mysql.cj.jdbc.Driver";
	String host = "jdbc:mysql://localhost:3306/grocerstore";
	String user = "root";
	String pass = "";
	String sql = null;

	
	
	Connection con() throws ClassNotFoundException, SQLException {
		Class.forName(driver);
        conn = DriverManager.getConnection(host,user,pass);
        return conn;
        
	}
	
	public String verify(String em, String pw) throws SQLException, ClassNotFoundException {
		String type = null;
		sql = "SELECT * FROM users WHERE emid = ? AND pw = ?";
        pstmt = con().prepareStatement(sql);
        pstmt.setString(1, em);
        pstmt.setString(2, pw);
        rs = pstmt.executeQuery();
        while(rs.next()){
                  type = rs.getString("type");  
        }
		return type;
	}
	
	public boolean insert(String fn, String ln, String em, String pw,String type) throws ClassNotFoundException{
	    try{
	        sql = "INSERT INTO users(fn, ln, emid, pw, type) VALUES(?,?,?,?,?)";
	        pstmt = con().prepareStatement(sql);
	        pstmt.setString(1,fn);
	        pstmt.setString(2,ln);
	        pstmt.setString(3,em);
	        pstmt.setString(4,pw);
	        pstmt.setString(5,type);
	        int res = pstmt.executeUpdate();
	        if(res!=0){
	            return true;
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean delete(int id) throws ClassNotFoundException{
	    try{
	        sql = "DELETE FROM users WHERE id=?";
	        pstmt = con().prepareStatement(sql);
	        pstmt.setInt(1, id);
	        int res = pstmt.executeUpdate();
	        if (res!=0){
	        return true;
	        }
	    }catch(SQLException e){e.printStackTrace(); }
	    return false;
	}

	public boolean update(String columnName,String newValue,int id ) throws ClassNotFoundException{
	    try{
	        sql = "UPDATE users SET "+columnName+" = ? WHERE id = ?";
	        pstmt = con().prepareStatement(sql);
	        pstmt.setString(1,newValue);
	        pstmt.setInt(2,id);
	        int res = pstmt.executeUpdate();
	        if(res!=0){
	            return true;
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return false;
	}

	public void display() throws ClassNotFoundException{
	    try{
	        sql = "SELECT * FROM users";
	        pstmt = con().prepareStatement(sql);
	        rs = pstmt.executeQuery(sql);
	        while(rs.next()){
	                    System.out.println(rs.getInt("id")+"\t"+rs.getString("fn")+"\t"+rs.getString("ln")+"\t"+rs.getString("emid")+"\t"+rs.getString("type"));
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	}
	
	
	
	
	public boolean insertPr(int code, String Name, int Price) throws ClassNotFoundException{
	    try{
	        sql = "INSERT INTO products(code, Name, Price) VALUES(?,?,?)";
	        pstmt = con().prepareStatement(sql);
	        pstmt.setInt(1,code);
	        pstmt.setString(2,Name);
	        pstmt.setInt(3,Price);
	        int res = pstmt.executeUpdate();
	        if(res!=0){
	            return true;
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean deletePr(int code) throws ClassNotFoundException{
	    try{
	        sql = "DELETE FROM products WHERE code=?";
	        pstmt = con().prepareStatement(sql);
	        pstmt.setInt(1, code);
	        int res = pstmt.executeUpdate();
	        if (res!=0){
	        return true;
	        }
	    }catch(SQLException e){e.printStackTrace(); }
	    return false;
	}

	public boolean updatePr(String columnName,String Name,int code ) throws ClassNotFoundException{
	    try{
	        sql = "UPDATE products SET "+columnName+" = ? WHERE code = ?";
	        pstmt = con().prepareStatement(sql);
	        pstmt.setString(1,Name);
	        pstmt.setInt(2,code);
	        int res = pstmt.executeUpdate();
	        if(res!=0){
	            return true;
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return false;
	}
	public boolean updatePr(String columnName,int codeold,int codenew ) throws ClassNotFoundException{
	    try{
	        sql = "UPDATE products SET "+columnName+" = ? WHERE code = ?";
	        pstmt = con().prepareStatement(sql);
	        pstmt.setInt(1,codenew);
	        pstmt.setInt(2,codeold);
	        int res = pstmt.executeUpdate();
	        if(res!=0){
	            return true;
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return false;
	}
	public boolean updatePr(int code,String columnName,int price ) throws ClassNotFoundException{
	    try{
	        sql = "UPDATE products SET "+columnName+" = ? WHERE code = ?";
	        pstmt = con().prepareStatement(sql);
	        pstmt.setInt(1,price);
	        pstmt.setInt(2,code);
	        int res = pstmt.executeUpdate();
	        if(res!=0){
	            return true;
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	    return false;
	}

	public void displayPr() throws ClassNotFoundException{
	    try{
	        sql = "SELECT * FROM products";
	        pstmt = con().prepareStatement(sql);
	        rs = pstmt.executeQuery(sql);
	        while(rs.next()){
	                    System.out.println(rs.getInt("code")+"\t"+rs.getString("Name")+"\t"+rs.getInt("Price"));
	        }
	    }catch(SQLException e){
	        e.printStackTrace();
	    }
	}
	
	public void addColUsers(String colName) throws ClassNotFoundException, SQLException{
		sql = "ALTER TABLE users ADD COLUMN "+colName+" VARCHAR(255)";
		
		pstmt = con().prepareStatement(sql);
		
		
		pstmt.executeUpdate();
		System.out.println("Added column;");
	}
	public void delColUsers(String colName) throws ClassNotFoundException, SQLException{
		sql = "ALTER TABLE users Drop "+colName+"";
		
		pstmt = con().prepareStatement(sql);
		
		
		pstmt.executeUpdate();
		System.out.println("Deleted column;");
	}
	public void addColProds(String colName) throws ClassNotFoundException, SQLException{
		sql = "ALTER TABLE products ADD COLUMN "+colName+" VARCHAR(255)";
		
		pstmt = con().prepareStatement(sql);
		
		
		pstmt.executeUpdate();
		System.out.println("Added column;");
	}
	public void delColProds(String colName) throws ClassNotFoundException, SQLException{
		sql = "ALTER TABLE products Drop "+colName+"";
		
		pstmt = con().prepareStatement(sql);
		
		
		pstmt.executeUpdate();
		System.out.println("Deleted column;");
	}
}