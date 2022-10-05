import java.sql.SQLException;
import java.util.Scanner;

import srcpkg.practicePkg;
public class practice{
	public static void main(String args[]) throws SQLException, InterruptedException, ClassNotFoundException{
		Scanner sc= new Scanner(System.in);
		practicePkg pkg = new practicePkg();
		
		String fn, ln, em, pw,type;
		String newVal;
		int id;
		
		
		String Name;
		int code, Price;
		
		System.out.println("Please enter your mail: ");
		em = sc.next();
		System.out.println("Please enter your password");
		pw = sc.next();
		int options3 = 0;
		do {
			type = pkg.verify(em, pw);
			int options, options2;
			switch (type) {
			case "admin": {
				System.out.println("Hello Admin");
				System.out.println("Please select an option: ");
				System.out.println("1. Insert users\r\n"
						+ "2. Update users\r\n"
						+ "3. Delete users\r\n"
						+ "4. Display users\r\n"
						+ "5. Insert products\r\n"//here
						+ "6. Update products\r\n"
						+ "7. Delete products\r\n"
						+ "8. Display products\r\n"
						+ "9. ADD COLUMN in Users\r\n"
						+ "10. DELETE COLUMN in Users\r\n"
						+ "11. ADD COLUMN in products\r\n"
						+ "12. Delete COLUMN in products");
				options = sc.nextInt();
				
				switch (options) {
				case 1: {
					System.out.println("please enter ur first name: ");
					fn = sc.next();
					System.out.println("please enter ur last name: ");
					ln = sc.next();
					System.out.println("please enter ur email id: ");
					em = sc.next();
					System.out.println("please enter ur password: ");
					pw = sc.next();
					System.out.println("please enter type: ");
					type = sc.next();
					boolean reurn = pkg.insert(fn, ln, em, pw, type);
					if (reurn) {
						System.out.println("1 entry inserted into table;");
					}
					else {
						System.out.println("no entry inserted into table;");
					}
					
					break;
				}
				case 2:
					System.out.println("please enter what do you want to edit: \r\n");
					System.out.println("    1. firstname \r\n"
							+ "    2. last name \r\n"
							+ "    3. email id \r\n"
							+ "    4. password \r\n"
							+ "    5. type ");
					options2 = sc.nextInt();
					switch (options2) {
					case 1: {
						System.out.println("please enter your id");
						id = sc.nextInt();
						
						System.out.println("please enter your new first name");
						newVal = sc.next();
						
						boolean reurn = pkg.update("fn", newVal, id);
						if (reurn) {
							System.out.println("1 entry updated into table;");
						}
						else {
							System.out.println("no entry updated into table;");
						}
						break ;
					}
					case 2:
						System.out.println("please enter your id");
						id = sc.nextInt();
						
						System.out.println("please enter your new last name");
						newVal = sc.next();
						
						boolean reurn = pkg.update("ln", newVal, id);
						if (reurn) {
							System.out.println("1 entry updated into table;");
						}
						else {
							System.out.println("no entry updated into table;");
						}
						
						break;
					case 3:
						System.out.println("please enter your id");
						id = sc.nextInt();
						
						
						System.out.println("please enter your new email");
						newVal = sc.next();
						
						boolean reurn1 = pkg.update("emid", newVal, id);
						if (reurn1) {
							System.out.println("1 entry updated into table;");
						}
						else {
							System.out.println("no entry updated into table;");
						}
						break;
					case 4:
						System.out.println("please enter your id");
						id = sc.nextInt();

						System.out.println("please enter your new password");
						newVal = sc.next();
						
						boolean reurn11 = pkg.update("pw", newVal, id);
						if (reurn11) {
							System.out.println("1 entry updated into table;");
						}
						else {
							System.out.println("no entry updated into table;");
						}
						break;
					case 5:
						System.out.println("please enter your id");
						id = sc.nextInt();
						
						System.out.println("please enter your new type");
						newVal = sc.next();
						
						boolean reurn111 = pkg.update("type", newVal, id);
						if (reurn111) {
							System.out.println("1 entry updated into table;");
						}
						else {
							System.out.println("no entry updated into table;");
						}
						break;
					default:
						throw new IllegalArgumentException("Unexpected value: " + options2);
					}
					break;
				case 3:
					System.out.println("please enter the id you want to delete: ");
					id = sc.nextInt();
					pkg.delete(id);
					
					break;
				case 4:
					pkg.display();
					break;
				case 5://Insert products
					System.out.println("please enter product code: ");
					code = sc.nextInt();
					
					System.out.println("please enter product name: ");
					Name = sc.next();
					System.out.println("please enter product price: ");
					Price = sc.nextInt();
					
					boolean reurn = pkg.insertPr(code, Name, Price);
					if (reurn) {
						System.out.println("1 entry inserted into table;");
					}
					else {
						System.out.println("no entry inserted into table;");
					}
					
					
					break;
				case 6://Update products
					System.out.println("please enter what do you want to edit: \r\n");
					System.out.println("    1. product name \r\n"
							+ "    2. product code \r\n"
							+ "    3. product price \r\n");
					options2 = sc.nextInt();
					switch (options2) {
					case 1: {
						System.out.println("please enter product code");
						code = sc.nextInt();
						
						System.out.println("please enter your new product Name");
						Name = sc.next();
						
						boolean reurn22 = pkg.updatePr("Name", Name, code);
						if (reurn22) {
							System.out.println("1 entry updated into table;");
						}
						else {
							System.out.println("no entry updated into table;");
						}
						break ;
					}
					case 2:
						System.out.println("please enter your product code");
						code = sc.nextInt();
						
						System.out.println("please enter your new product code");
						int codenew = sc.nextInt();
						
						boolean reurn2 = pkg.updatePr("code", code, codenew);
						if (reurn2) {
							System.out.println("1 entry updated into table;");
						}
						else {
							System.out.println("no entry updated into table;");
						}
						
						break;
					case 3:
						System.out.println("please enter your product code");
						code = sc.nextInt();
						
						System.out.println("please enter your new product price");
						Price = sc.nextInt();
						
						boolean reurn222 = pkg.updatePr("Price", code, Price);
						if (reurn222) {
							System.out.println("1 entry updated into table;");
						}
						else {
							System.out.println("no entry updated into table;");
						}
						
						break;
					
					default:
						throw new IllegalArgumentException("Unexpected value: " + options2);
					}
					
					break;
				case 7://Delete products
					System.out.println("please enter the product code you want to delete: ");
					code = sc.nextInt();
					pkg.deletePr(code);
					break;
				case 8://Display products
					pkg.displayPr();
					break;
				case 9://ADD COLUMN in Users
					System.out.println("Please enter the details for the column in users:");
					System.out.println("column name:");
					String nameCol = sc.next();
					pkg.addColUsers(nameCol);
					break;
				case 10://DELETE COLUMN in Users
					System.out.println("Please enter the details for the column in users:");
					System.out.println("column name:");
					String nameCol1 = sc.next();
					pkg.delColUsers(nameCol1);
					break;
				case 11://ADD COLUMN in products
					System.out.println("Please enter the details for the column in products:");
					System.out.println("column name:");
					String nameCol2 = sc.next();
					pkg.addColProds(nameCol2);
					break;
				case 12://Delete COLUMN in products
					System.out.println("Please enter the details for the column in users:");
					System.out.println("column name:");
					String nameCol3 = sc.next();
					pkg.delColProds(nameCol3);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + options);
				}
				break;
			}
			case "user":
				System.out.println("Hello user!!!");
				pkg.display();
				
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
			
		}
			System.out.println("do you want to continue(1 for yes/2 for no)");
			options3 = sc.nextInt();
		}while(options3 == 1);
		
	}		
}