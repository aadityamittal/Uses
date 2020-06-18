import java.util.*;
class Author
{
	private String name;
    private String email;
	private char gender;
	public Author(String name,String email,char gender)
	{
		this.name=name;
		this .email=email;
		this.gender=gender;
	}
	public String getName()
	{
		return(name);
	}
	public String getEmail()
	{
		return(email);
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public char getGender()
	{
		return(gender);
	}
	public String toString()
	{
		return("Author[name="+name+",email="+email+",gender="+gender+"]");
	}
}
class Book
{
	private String name;
	private Author author;
	private double price;
	private int qty=0;
	int maxqty=0;
	public Book(String name,Author author,double price)
	{
		this.name=name;
        this.author=author;
		this.price=price;
	}
	public Book(String name,Author author,double price,int qty)
	{
		this.name=name;
		this.author=author;
		this.price=price;
		this.qty=qty;
		maxqty=qty;
	}
	public String getName()
	{
		return(name);
	}
	public Author getAuthor()
	{
		return(author);
	}
	public double getPrice()
	{
		return(price);
	}
	public void setPrice(double price)
	{
		this.price=price;
	}
	public int getQty()
	{
		return(qty);
	}
	public void setQty(int qty)
	{
		this.qty=qty;
	}
	public String toString()
	{
		return("Book[name="+name+","+author+",price="+price+",qty="+qty+"]");
	}
}	
class Date
{
	private int mm,dd,yyyy;
	public Date(int dd,int mm,int yyyy)
	{
		this.dd=dd;
		this.mm=mm;
		this.yyyy=yyyy;
	}
	public int getDD()
	{
		return(dd);
	}
	public int getMM()
	{
		return(mm);
	}
	public int getYYYY()
	{
		return(yyyy);
	}
	public String toString()
	{
		return("[Date="+dd+"/"+mm+"/"+yyyy+"]");
	}
}
class Student
{
	private String name;
	private int roll;
	private Date issueDate;
	private Date returnDate;
	private Date depositDate;
	public Student(String name,int roll)
	{
		this.name=name;
		this.roll=roll;
	}
	public String getName()
	{
		return(name);
	}
	public int getRoll()
	{
		return(roll);
	}
	public Book[] issueBook(Book obj2[],Date obj4[],Date obj5[],Date obj6[])
	{
		int s=0,i;
		Scanner sc=new Scanner(System.in);
		System.out.println("Books Present In The Library:-");
		for(i=0;i<obj2.length;i++)
		{
			s=s+(obj2[i].maxqty)-(obj2[i].getQty());
			System.out.println("Enter "+i+" for "+obj2[i]);
		}
		if(s<5) 
		{
			int x;
			while(true)
			{
				System.out.println("Enter the Reference no. Alloted to the Book you want to issue");
				x=sc.nextInt();
				if(x<i)
					break;
				else
		        System.out.println("Invalid Input.");
			}
		if(obj2[x].getQty()==0) 
		{
			System.out.println("Book Not Avaliable");
			return null;
		}
		else if(obj2[x].maxqty>obj2[x].getQty())
		{
			System.out.println("This Book is Already Issued in Your Name.");
			return null;
		}
		else
		{
			obj2[x].setQty(obj2[x].getQty()-1);
			System.out.println("Enter the Issue Date of the Book In The Format(DD/MM/YYYY)");
			int dd=sc.nextInt();
			int mm=sc.nextInt();
			int yyyy=sc.nextInt();
			obj4[x]=new Date(dd,mm,yyyy);
			issueDate=obj4[x];
			System.out.println("Enter the Fixed Return Date of the Book In The Format(DD/MM/YYYY)");
			int rdd=sc.nextInt();
			int rmm=sc.nextInt();
			int ryyyy=sc.nextInt();
			obj5[x]=new Date(rdd,rmm,ryyyy);
			depositDate=obj5[x];
			System.out.println("Issued Book Reference No.:-"+x);
			return(obj2);
		    }
	   }
		else
		{
			System.out.println("Maximum Limit of Book issue Exceed.");
			return null;
		}
	}
	
		
	public void depositBook(Book obj2[],Date obj4[],Date obj5[],Date obj6[])
	{
		int f=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("Books To Be Deposited:-");
		for(int i=0;i<obj2.length;i++)
		{
			if(obj2[i].getQty()!=obj2[i].maxqty)
			{
			System.out.println("Enter "+i+" for "+obj2[i]);
			f=f+1;
			}
		}
		if(f!=0)
		{
			int x;
			while(true)
			{
		System.out.println("Enter the reference no. of the Book to be Deposited:-");
		x=sc.nextInt();
		if(obj2[x].getQty()!=obj2[x].maxqty)
			break;
		else
		{
			System.out.println("Invalid Reference No. Input.");
		}
			}
		obj2[x].setQty(obj2[x].getQty()+1);
		System.out.println("Enter the Fixed Deposit Date of the Book In The Format(DD/MM/YYYY)");
		int dd=sc.nextInt();
		int mm=sc.nextInt();
		int yyyy=sc.nextInt();
		issueDate=obj4[x];
		obj6[x]=new Date(dd,mm,yyyy);
		returnDate=obj6[x];
		depositDate=obj5[x];
		System.out.println("Deposited Book Reference No.:-"+x);
		int fine=fine(obj5[x],obj6[x]);
		if(fine>=0)
		System.out.println("Fine="+fine);
		else
			System.out.println("Invalid Date Data could not Process the Fine.");
		}
		else
		{
			System.out.println("Stock Full");
		}
		
	}
	public int fine(Date obj5,Date obj6)
	{
		int d1=0,d2=0,s=0;
		if(obj5.getMM()<=2)
		{
			d1=(146097*(obj5.getYYYY()-1))/400+(153*(obj5.getMM()+12)+ 8)/5 +obj5.getDD();
		}
		else
		{
			d1=(146097*obj5.getYYYY())/400 + (153*obj5.getMM()+ 8)/5 +obj5.getDD();
		}
		if(obj6.getMM()<=2)
		{
			d2=(146097*(obj6.getYYYY()-1))/400 + (153*(obj6.getMM()+12)+ 8)/5 +obj6.getDD();
		}
		else
		{
			d2=(146097*obj6.getYYYY())/400 + (153*obj6.getMM()+ 8)/5 +obj6.getDD();
		}
		return((int)(d2-d1));
	}
	public int checkExit(Book obj2[])
	{
		int f=0;
		for(int i=0;i<obj2.length;i++)
		{
			if(obj2[i].getQty()!=obj2[i].maxqty)
			{
			f=f+1;
			}
		}
		if(f==0)
			return 0;
		else 
			return 1;
	}
	public String toString()
	{
		return("[Name="+name+",Roll="+roll+",IssueDate="+issueDate+",Deposit Date="+depositDate+",ReturnDate="+returnDate+"]");
	}
}
public class Tester
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		Scanner scc =new Scanner(System.in);
		System.out.println("Enter the Total no. of Different Types Books present in the Library?");
		int n=sc.nextInt();
		Author obj1[]=new Author[n];
		Book obj2[]=new Book[n];
		int c=0;
		for(int i=0;i<n;i++)
		{
			System.out.println("Enter Book "+(i+1)+" Details:-");
			System.out.println("Enter the Author Name?");
			String name=scc.nextLine();
			System.out.println("Enter the Email Id of the Author?");
			String email=scc.nextLine();
			char gender;
			while (true)
			{
			System.out.println("Enter the Gender of Author only in 'm' for Male and 'f' for Female?");
			gender=sc.next().charAt(0);
			if((gender=='m')||(gender=='f'))
				break;
			else
				System.out.println("Invalid Input.");
			}
			obj1[i]=new Author(name,email,gender);
			System.out.println("Enter the Name of the Book?");
			String str=scc.nextLine();
			System.out.println("Enter the Price Amount of the Book?");
			double price=sc.nextDouble();
			System.out.println("Enter the Quantity of Book Present in the Library?");
			int qty=sc.nextInt();
			obj2[i]=new Book(str,obj1[i],price);
			obj2[i]=new Book(str,obj1[i],price,qty);
			c=c+qty;
		}
		System.out.println("Enter the value of 'N' stands for total no. of Student Present in the Library?");
		int N=sc.nextInt();
		if(N==0)
			System.out.println("No Student Present");
		Student obj3[]=new Student[N];
		for(int i=0;i<N;i++)
		{
			System.out.println("Enter the Details of Student "+(i+1)+" Entry?");
			System.out.println("Enter the name of the Student?");
			String sname=scc.nextLine();
			System.out.println("Enter the Roll No. of Student?");
			int roll=sc.nextInt();
			Date obj4[]=new Date[c];
			Date obj5[]=new Date[c];
			Date obj6[]=new Date[c];
			while(true)
			{
			obj3[i]=new Student(sname,roll);
			if(c!=0)
			{
				System.out.println("Enter 1 for Book Issue; 2 for Book Return; 3 for Exist from Library.");
			int x=sc.nextInt();
			if(x==1)
			{
				obj3[i].issueBook(obj2,obj4,obj5,obj6);
				System.out.println(obj3[i]);
			}
			else if (x==2)
			{
				obj3[i].depositBook(obj2,obj4,obj5,obj6);
				System.out.println(obj3[i]);
			}
			else if(x==3)
			{
				int flag=obj3[i].checkExit(obj2);
				if(flag==0)
				{
				break;
				}
				else
				{
					System.out.println("Please Enter The Deposit Date Details of Issued Book Before Exit.");
				}
			
			}
			else
				System.out.println("Invalid Input");
			}
			else
			{
				System.out.println("Sorry Library Stock is Empty.");
				break;
			}
		}
	}
}
}
	