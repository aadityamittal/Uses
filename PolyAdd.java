import java.util.*;
class Node{
   int e,c;
   Node next;
   Node(int a,int b){
     c=a;
     e=b;
   }
   public void display(){
     if(c<0)
      System.out.print(c+"x^"+e);
     else
      System.out.print("+"+c+"x^"+e);
   }
}
class List{
   public Node f;
   public Node l;
   public List(){
     f=null;
     l=null;
   }
   public void inslst(int a,int b){
     Node n=new Node(a,b);
     if(isEmpty())
       f=n;
     else
       l.next=n;
     l=n;
   }
   public boolean isEmpty(){
     return(f==null);
   }
   public void display(){
     Node curr=f;
     while(curr != null){
       curr.display();
       curr=curr.next;
     }
     System.out.println();
   }
}
class Poly{
   List l1;
   Poly(){
	   l1=new List();
   }
   public void ins(int x,int y){
     l1.inslst(x,y);
   }
   public void display(){
     l1.display();
   }
   public void add(Poly poly1,Poly poly2){
     int x,y;
     Node curr1=poly1.l1.f;
     Node curr2=poly2.l1.f;
     while(curr1!=null&&curr2!=null){
       if(curr1.e==curr2.e){
         x=curr1.c+curr2.c;
         y=curr1.e;
         curr1=curr1.next;
         curr2=curr2.next;
       }
       else if(curr1.e>curr2.e){
         x=curr1.c;
         y=curr1.e;
         curr1=curr1.next;
       }
       else{
         x=curr2.c;
         y=curr2.e;
         curr2=curr2.next;
       }
       l1.inslst(x,y);
     }
     while(curr1!=null){
       x=curr1.c;
       y=curr1.e;
       curr1=curr1.next;
       l1.inslst(x,y);
     }
     while(curr2!=null){
       x=curr2.c;
       y=curr2.e;
       curr2=curr2.next;
       l1.inslst(x,y);
     }
   }
}
public class Test{
   public static void main(String args[]){
     char ch='y';
     Scanner sc=new Scanner(System.in);
     int c,e;
     while(ch=='y'){
       Poly p1=new Poly();
       Poly p2=new Poly();
       Poly p3=new Poly();
       e=1;
       System.out.println("Enter the 1st polynomial");
       while(e!=0){
         System.out.println("Enter the coefficent ");
         c=sc.nextInt();
         System.out.println("Enter the exponent");
         e=sc.nextInt();
         p1.ins(c,e);
       }
       e=1;
       System.out.println("Enter the 2nd polynomial");
       while(e!=0){
         System.out.println("Enter the coefficent ");
         c=sc.nextInt();
         System.out.println("Enter the exponent");
         e=sc.nextInt();
         p2.ins(c,e);
       }
       System.out.print("1st Polynomial: ");
       p1.display();
       System.out.print("2nd Polynomial: ");
       p2.display();
       p3.add(p1,p2);
       System.out.print("Polymials added ");
       p3.display();
       System.out.println("Enter y to continue ");
       ch=sc.next().charAt(0);
      }
   }
}