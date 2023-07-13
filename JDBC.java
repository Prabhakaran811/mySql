import java.sql.*;
import java.util.Scanner;
public class JDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner ik=new Scanner(System.in);
        System.out.println("ENTER THE SERVICE YOU WOULD LIKE TO USE:");
        System.out.println("1.ACCOUNT CREATION.");
        System.out.println("2.PIN & PHONE UPDATION.");
        System.out.println("3.CHECK BALANCE.");
        System.out.println("ENTER THE NUMBER OF THE SERVICE:");
        int i=ik.nextInt();
        switch (i) {
            case 1: {
                System.out.println("ENTER THE ACCOUNT NUMBER:");
                int i1 = ik.nextInt();
                System.out.println("ENTER YOUR NAME:");
                String i2=ik.nextLine();
                System.out.println("ENTER YOUR PIN:");
                int i3= ik.nextInt();
                System.out.println("ENTER YOUR BRANCH:");
                String i4=ik.nextLine();
                System.out.println("ENTER YOUR BRANCH ID:");
                String i5=ik.nextLine();
                System.out.println("ENTER YOUR PAN NUMBER:");
                int i6=ik.nextInt();
                System.out.println("ENTER YOUR BALANCE:");
                int i7=ik.nextInt();
                System.out.println("ENTER YOUR ACCOUNT TYPE:");
                String i8=ik.nextLine();
                System.out.println("ENTER YOUR ADDRESS:");
                String i9=ik.nextLine();
                System.out.println("ENTER YOUR PHONE NUMBER:");
                int i10=ik.nextInt();
                insertRecord(i1,i2,i3,i4,i5,i6,i7,i8,i9,i10);
                System.out.println("YOUR DETAILS AS PER OUR RECORD:");
                showRecord(i1);
                break;
            }
            case 2:{
                System.out.println("ENTER YOUR ACCOUNT NUMBER:");
                int i11=ik.nextInt();
                System.out.println("ENTER YOUR NEW PIN:");
                int i12=ik.nextInt();
                System.out.println("ENTER YOUR NEW PHONE NUMBER:");
                int i13=ik.nextInt();
                updatePhone(i11,i12,i13);
                System.out.println("UPDATED SUCCESSFULLY");
                break;
            }
            case 3:{
                System.out.println("ENTER YOUR ACCOUNT NUMBER:");
                int i14=ik.nextInt();
                System.out.println("YOUR BALANCE AS OF NOW IS:");
                getBalance(i14);
                break;
            }
            default:
                System.out.println("INVALID SERVICE CHOOSEN.PLEASE CHOOSE THE GIVEN SERVICES");
                break;
        }
    }
    public static void getBalance(int accNo) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Power123");
        Statement s = con.createStatement();
        ResultSet r = s.executeQuery("select C_BALANCE from BANK.CUSTOMER WHERE C_ACC_NO="+""+accNo);
        while (r.next()) {
            System.out.println(r.getInt("C_BALANCE"));
        }
    }
    public static void updatePhone(int accNo,int phoneNo,int pinNo)throws ClassNotFoundException,SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Power123");
        Statement s = con.createStatement();
        s.executeUpdate("Update BANK.CUSTOMER SET C_PIN='"+pinNo+"',C_CONTACT='"+phoneNo+"' WHERE C_ACC_NO='"+accNo+"';");
    }
    public static void insertRecord(int C_ACC_NO,String C_NAME,int C_PIN,String BRANCH_NAME,String BRANCH_ID,int C_PAN,int C_BALANCE,String ACC_TYPE,String C_ADDRESS,int C_CONTACT) throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Power123");
        Statement s=con.createStatement();
        int r=s.executeUpdate("INSERT INTO BANK.CUSTOMER VALUES('"+C_ACC_NO+"','"+C_NAME+"','"+C_PIN+"','"+BRANCH_NAME+"','"+BRANCH_ID+"','"+C_PAN+"','"+C_BALANCE+"','"+ACC_TYPE+"','"+C_ADDRESS+"','"+C_CONTACT+"');");
        if (r>0){
            System.out.println("Inserted");
        }
        else{
            System.out.println("Insertion Error");
        }
    }
    public static void showRecord(int C_ACC_NO) throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "Power123");
        Statement s=con.createStatement();
        ResultSet r=s.executeQuery("select * from BANK.CUSTOMER WHERE C_ACC_NO='"+C_ACC_NO+"');");
        while(r.next()){
            System.out.println(r.getString(1)+" "+r.getString(2)+" "+r.getString(3)+" "+r.getString(4)+" "+r.getString(5)+" "+r.getString(6)+" "+r.getString(7)+" "+r.getString(8)+" "+r.getString(9)+" "+r.getString(10));
        }
    }
}
