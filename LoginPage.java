package atmecs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class LoginPage {
	static String username;
	static String password;

	public LoginPage(String username, String password) throws IOException
	{
		this.username=username;
		this.password=password;
		main(null);

	}


	public LoginPage() {
		// TODO Auto-generated constructor stub
	}


	public void Validate() throws IOException {
		Scanner input=new Scanner(System.in);
		System.out.println("enter your username");
		username=input.next();
		System.out.println("enter your password");
		password=input.next();
		if(this.username==username && this.password==password)
		{
			System.out.println("Login Successful");
			System.out.println("enter into employee management operation");
			operation();

		}
		else
		{
			System.out.println("enter correct details");
			Validate();
		}



	}

	public void operation() throws IOException {
		Scanner input=new Scanner(System.in);
		   for(;;) {
		System.out.println("enter 1:Create  Employee Details");
		System.out.println("enter 2:Search  Employee Details");
		System.out.println("enter 3:Delete  Employee Details");
		System.out.println("enter 4:Update  Employee Details");
		System.out.println("enter any other to exit");
		int choice=input.nextInt();
     
		switch(choice)
		{
		case 1:
			Create c =new Create();
			c.xlsxWrite();
			break;
		case 2:
			Search s =new Search();
			s.xlsxReader();
			break;
		/*case 3:
			Delete d =new Delete();
			break;
		case 4:
			Update u =new Update();
			u.xlsxupdate();
			break;*/
		default:
			System.exit(0);

		}

	}
	}
	public static void main(String[] args) throws IOException  {
		Scanner input=new Scanner(System.in);
		System.out.println("enter 1:if you have username and password");
		System.out.println("enter 2:if you don't have username and password");
        int option=input.nextInt();
        LoginPage lp=new LoginPage();
        switch(option)
        {
        	case 1:
        		{
        		    lp.Validate();  
        			break;
        		}
        	case 2:
        		{
        			System.out.println("enter username");
        			username=input.next();
        			System.out.println("enter password");
        			password=input.next();
        			LoginPage lp1=new LoginPage(username,password);   
        			break;
        		}

        }
       	}

}