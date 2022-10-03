package srcpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.xdevapi.Statement;

//remember to do do alter table tomorrow
public class practicePkg {
	Connection con=null;
	Statement st = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	String url = "jdbc:mysql://localhost:3306/grocerstore";
	String user = "root";
	String pw = "";
	String query;
	
	String email;
	String pass;
	int admnOptn;
	
	Scanner sc= new Scanner(System.in);
	
	public void connection() throws SQLException, InterruptedException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			
			System.out.println("do you want to \n1. login\n2. exit");
			int aOpt = sc.nextInt();
			
			System.out.println("Please enter your registered email: ");
			email = sc.next();
			System.out.println("please enter your password");
			pass = sc.next();
			String val = verify(email, pass);
			//this will find out wether the user is admin or not and give a statement
			System.out.println("Hooray "+val+ "!!!");
			
			do {
				if(val.equals("admin")) {
					adminFn();
				}
				else if(val.equals("user")){
					userFn();
				}
				else {
					System.out.println("Please enter right login credentials!");
				}
				
				System.out.println("do you want to (option= 1)continue or exit ?");
				aOpt = sc.nextInt();
			}while(aOpt == 1);
			System.out.println("Exiting...");
			Thread.sleep(3000);
			System.out.println("Exited safely!");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String verify(String em, String passworrd) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,user, pw);
		query = "SELECT * FROM users WHERE emid = ? AND pw = ?";
		pst = con.prepareStatement(query);
		pst.setString(1, em);
		pst.setString(2, passworrd);
		rs = pst.executeQuery();
		String val = null;
		while(rs.next()) {
			val = rs.getString("type");
		}
		return val;
	}
	
	public void adminFn() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Do you want to: ");
		System.out.println("1. Add User");
		System.out.println("2. Remove User");
		System.out.println("3. Modify User");
		System.out.println("4. Display User");
		System.out.println("5. Add Products");
		System.out.println("6. Remove Products");
		System.out.println("7. Modify Products");
		System.out.println("8. Display Product");
		System.out.println("9. Display all Products");
		System.out.println("10. Display all Users");
		System.out.println("11. ADD COLUMN in Users");
		System.out.println("12. DELETE COLUMN in Users");
		System.out.println("13. ADD COLUMN in products");
		System.out.println("14. DELETE COLUMN in products");
		
		admnOptn = sc.nextInt();
		String fn, ln, emai, pasw,typ;
		int res;
		String val = null;
		String namePr;
		int code, Price;
		
		switch (admnOptn) {
		case 1: {//add user
			query = "INSERT INTO users(fn, ln, emid, pw, type) VALUES (?,?,?,?,?)";
			System.out.println("Please enter the details for the user:");
			System.out.println("first name:");
			fn = sc.next();
			System.out.println("last name:");
			ln = sc.next();
			System.out.println("email:");
			emai = sc.next();
			System.out.println("password:");
			pasw = sc.next();
			System.out.println("type:");
			typ = sc.next();
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			pst.setString(1, fn);
			pst.setString(2, ln);
			pst.setString(3, emai);
			pst.setString(4, pasw);
			pst.setString(5, typ);
			res = pst.executeUpdate();
			System.out.println(res+" row(s) have been affected;");
			break;
		}
		case 2://remove user
			query = "DELETE FROM `users` WHERE emid=?";
			System.out.println("Please enter the details for the user:");
			System.out.println("email:");
			emai = sc.next();
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			pst.setString(1, emai);
			res = pst.executeUpdate();
			System.out.println(res+" row(s) have been affected;");
			break;
		case 3://modify user
			query = "UPDATE users SET fn=?,ln=?,emid=?,pw=?,type=? WHERE emid=?";
			System.out.println("Please enter the details for the user:");
			System.out.println("first name:");
			fn = sc.next();
			System.out.println("last name:");
			ln = sc.next();
			System.out.println("email:");
			emai = sc.next();
			System.out.println("password:");
			pasw = sc.next();
			System.out.println("type:");
			typ = sc.next();
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			pst.setString(1, fn);
			pst.setString(2, ln);
			pst.setString(3, emai);
			pst.setString(4, pasw);
			pst.setString(5, typ);
			pst.setString(6, emai);
			res = pst.executeUpdate();
			System.out.println(res+" row(s) have been affected;");
			break;
		case 4://Display User
			query = "SELECT * FROM users WHERE emid=?";
			System.out.println("Please enter the details for the user:");
			System.out.println("email:");
			emai = sc.next();
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			pst.setString(1, emai);
			rs = pst.executeQuery();
			
			while(rs.next()) {
				val = rs.getString("type");
				
			}
			System.out.println("welcome"+val);
			break;
		case 5://Add Product
			query = "INSERT INTO products(code, Name, Price) VALUES (?,?,?)";
			System.out.println("Please enter the details for the product:");
			System.out.println("unique code:");
			code = sc.nextInt();
			System.out.println("product name(without spaces):");
			namePr = sc.next();
			System.out.println("price:");
			Price = sc.nextInt();
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			pst.setInt(1, code);
			pst.setString(2, namePr);
			pst.setInt(3, Price);
			res = pst.executeUpdate();
			System.out.println(res+" row(s) have been affected;");
			break;
		case 6://Remove Product
			query = "DELETE FROM products WHERE code=?";
			System.out.println("Please enter the details for the product:");
			System.out.println("unique code:");
			code = sc.nextInt();
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			pst.setInt(1, code);
			res = pst.executeUpdate();
			System.out.println(res+" row(s) have been affected;");
			break;
		case 7://Modify Product
			query = "UPDATE products SET code=?,Name=?,Price=? WHERE code=?";
			System.out.println("Please enter the details for the product:");
			System.out.println("unique code:");
			code = sc.nextInt();
			System.out.println("product name:");
			namePr = sc.next();
			System.out.println("price:");
			Price = sc.nextInt();
			typ = sc.next();
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			pst.setInt(1, code);
			pst.setString(2, namePr);
			pst.setInt(3, Price);
			pst.setInt(6, code);
			res = pst.executeUpdate();
			System.out.println(res+" row(s) have been affected;");
			break;
		case 8://Display Product
			query = "SELECT * FROM products WHERE code=?";
			System.out.println("Please enter the details for the product:");
			System.out.println("Unique code:");
			code = sc.nextInt();
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			pst.setInt(1, code);
			rs = pst.executeQuery();
			Price=0;
			while(rs.next()) {
				val = rs.getString("Name");
				Price = rs.getInt("Price");
				
				
			}
			System.out.println("Product "+val+" Price "+Price);
			break;
		case 9://Display all Product
			query = "SELECT * FROM products WHERE 1";
			
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			
			rs = pst.executeQuery();
			Price=0;
			while(rs.next()) {
				val = rs.getString("Name");
				Price = rs.getInt("Price");
				System.out.println("Product "+val+" Price "+Price);
				
			}
			
			break;
		case 10://Display Users
			query = "SELECT * FROM users WHERE 1";
			
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				fn = rs.getString("fn");
				ln = rs.getString("ln");
				emai = rs.getString("emid");
				pasw = rs.getString("pw");
				typ = rs.getString("type");
				System.out.println("fn: "+fn+" ln: "+ln+" emid: "+emai+" pw: "+pasw+" type: "+typ);
			}
			break;
		case 11://add user column
			
			System.out.println("Please enter the details for the column in users:");
			
			System.out.println("column name:");
			namePr = sc.next();
			
			query = "ALTER TABLE users ADD COLUMN "+namePr+" VARCHAR(255)";
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			
			
			pst.executeUpdate();
			System.out.println("Added column;");
			break;
		case 12://delete user column
			System.out.println("Please enter the details for the column in users:");
			
			System.out.println("column name:");
			namePr = sc.next();
			query = "ALTER TABLE users Drop "+namePr+"";
			
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			
			pst.executeUpdate();
			System.out.println("Deleted column;");
			break;
		case 13://add user column
			System.out.println("Please enter the details for the column in products:");
			
			System.out.println("column name:");
			namePr = sc.next();
			query = "ALTER TABLE products ADD COLUMN "+namePr+" VARCHAR(255)";
			
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			
			pst.executeUpdate();
			System.out.println("Added column;");
			break;
		case 14://delete user column
			System.out.println("Please enter the details for the column in products:");
			
			System.out.println("column name:");
			namePr = sc.next();
			query = "ALTER TABLE products Drop "+namePr+"";
			
			con = DriverManager.getConnection(url,user, pw);
			pst = con.prepareStatement(query);
			
			pst.executeUpdate();
			System.out.println("Deleted column;");
			break;
			
		default:
			throw new IllegalArgumentException("Unexpected value: " + admnOptn);
		}
	}
	
	public void userFn() throws ClassNotFoundException, SQLException{
		String namePr;
		int code;
		int Price=0;
		String val = null;
		query = "SELECT * FROM products WHERE 1";
		
		con = DriverManager.getConnection(url,user, pw);
		pst = con.prepareStatement(query);
		rs = pst.executeQuery();
		
		while(rs.next()) {
			val = rs.getString("Name");	
			Price = rs.getInt("Price");
			System.out.println("product "+val+" Price "+Price);
		}
		
	}

}
