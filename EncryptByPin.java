import java.util.*;
public class EncryptByPin{
	public static void main (String args[]){
		Scanner sc=new Scanner (System.in);
		System.out.println("Enter the message");
		String msg=sc.nextLine();
		msg=msg.replaceAll("\\s+","");
		msg=msg.toLowerCase();
		System.out.println("First Enter the length of Integers & Enter the four n-digits +ve integers of same lenght ");
		int n=sc.nextInt();
		System.out.println("Enter first integer"); 
		int a=sc.nextInt();
		System.out.println("Enter second integer"); 
		int b=sc.nextInt();
		System.out.println("Enter third integer"); 
		int c=sc.nextInt();
		System.out.println("Enter fourth integer"); 
		int d=sc.nextInt();
		int l=msg.length();
		int m,r1,r2,r3,r4;
		String str="",str1="";
		for(int i=1;i<=n;i++){
			r1=a%10;r2=b%10;r3=c%10;r4=d%10;
			m=Math.min(r1,Math.min(r2,Math.min(r3,r4)));
			str=str+m;
			a/=10;b/=10;c/=10;d/=10;
			}
		int cti=Integer.parseInt(str),r=0,rem,c1,c2=0;
		while(cti>0){
			rem=cti%10;
			r=(r*10)+rem;	
			cti/=10;
			}
		str1=str1+r;
		String str2="";
		for (c1=0;c1<l;c1++){
			if (c2==l)
				break;
			if(c1==n)
				c1=0;
			c2++;
			str2=str2+str1.charAt(c1);
			}
		char z1;
		for (int d1=0;d1<l;d1++){
			z1=msg.charAt(d1)+(str2.charAt(d1)-48);
			}
		System.out.println(z1);
		System.out.println(msg);
		System.out.println(str2);
		}
	}