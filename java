Slip-1) Write a Java program to print the sum of elements of the array. Also display array elements in ascending order.

import java.util.*;
class ArraySum {
    public static void main(String[] args) {
        int[] a = {5, 2, 8, 1, 3};
        int sum = 0;
        for (int x : a)
            sum += x;
        Arrays.sort(a);
        System.out.println("Sum = " + sum);
        System.out.print("Ascending order: ");
        for (int x : a)
            System.out.print(x + " ");
    }
}




Slip-2) Write a Java Program to Display Armstrong Numbers Between range. Accept range from user.

import java.util.*;
class Armstrong {
        public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter range: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print("Enter ending range: ");
        for(int n = a; n <= b; n++) {
            int x = n, sum = 0;
            while(x > 0) {
                int r = x % 10;
                sum = sum + r*r*r;
                x = x / 10;
            }
            if(sum == n)
                System.out.print(n + " ");
        }
    }
}




Slip-4)  Write a menu driven program to perform the following operations on multidimensional array ie matrix : 
i. Addition 
ii. Multiplication 
iii. Transpose of any matrix. 
iv. Exit


import java.util.*;
class Matrix {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int ch;
        do {
            System.out.println("\n1.Addition");
            System.out.println("2.Multiplication");
            System.out.println("3.Transpose");
            System.out.println("4.Exit");
            System.out.print("Enter choice: ");
            ch = s.nextInt();
            if(ch == 1) {
                int[][] a={{1,2},{3,4}}, b={{5,6},{7,8}};
                System.out.println("Addition:");
                for(int i=0;i<2;i++) {
                    for(int j=0;j<2;j++)
                        System.out.print((a[i][j]+b[i][j])+" ");
                    System.out.println();
                }
            }
            else if(ch == 2) {
                int[][] a={{1,2},{3,4}}, b={{5,6},{7,8}};
                System.out.println("Multiplication:");
                for(int i=0;i<2;i++) {
                    for(int j=0;j<2;j++) {
                        int sum=0;
                        for(int k=0;k<2;k++)
                            sum += a[i][k]*b[k][j];
                        System.out.print(sum+" ");
                    }
                    System.out.println();
                }
            }
            else if(ch == 3) {
                int[][] a={{1,2},{3,4}};
                System.out.println("Transpose:");
                for(int i=0;i<2;i++) {
                    for(int j=0;j<2;j++)
                        System.out.print(a[j][i]+" ");
                    System.out.println();
                }
            }
        } while(ch != 4);
    }
}





Slip-6) Write a program to define a class Account having members custname, accno. Define default and parameterized constructor. Create a subclass 
called SavingAccount with members savingbal, minbal. Create a derived class AccountDetail that extends the class SavingAccount with members, 
depositamt and withdrawalamt. Write a appropriate method to display customer details.


import java.util.*;
class Account {
    String name, no;
    Account(String n,String a){name=n;no=a;}
}
class SavingAccount extends Account {
    double bal,min;
    SavingAccount(String n,String a,double b,double m){
        super(n,a); bal=b; min=m;
    }
}
class AccountDetail extends SavingAccount {
    double dep,with;
    AccountDetail(String n,String a,double b,double m,double d,double w){
        super(n,a,b,m); dep=d; with=w;
    }
    void show(){
        double f=bal+dep-with;
        System.out.println("\n--- Account Details ---");
        System.out.println("Customer Name: "+name);
        System.out.println("Account No: "+no);
        System.out.println("Saving Balance: "+bal);
        System.out.println("Minimum Balance: "+min);
        System.out.println("Deposit: "+dep);
        System.out.println("Withdrawal: "+with);
        System.out.println("Final Balance: "+f);
        System.out.println(f>=min ? "Minimum balance maintained" :
                                      "Minimum balance not maintained");
    }
}
class Test {
    public static void main(String[] x) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter name: "); String n=s.next();
        System.out.print("Enter account no: "); String a=s.next();
        System.out.print("Enter saving balance: "); double b=s.nextDouble();
        System.out.print("Enter minimum balance: "); double m=s.nextDouble();
        System.out.print("Enter deposit: "); double d=s.nextDouble();
        System.out.print("Enter withdrawal: "); double w=s.nextDouble();
        new AccountDetail(n,a,b,m,d,w).show();
    }
}




Slip-8) Write a program to create an abstract class named Shape that contains two integers and an empty method named printArea(). Provide three 
classes named Rectangle, Triangle and Circle such that each one of the classes extends the class Shape. Each one of the classes contain only the 
method printArea() that prints the area of the given shape. (use method overriding).


abstract class Shape {
    int a, b;
    abstract void printArea();
}
class Rectangle extends Shape {
    Rectangle(int x, int y) { a=x; b=y; }
    void printArea() {
        System.out.println("Rectangle Area = " + a*b);
    }
}
class Triangle extends Shape {
    Triangle(int x, int y) { a=x; b=y; }
    void printArea() {
        System.out.println("Triangle Area = " + (a*b)/2);
    }
}
class Circle extends Shape {
    Circle(int x) { a=x; }
    void printArea() {
        System.out.println("Circle Area = " + 3.14*a*a);
    }
}
class Test {
    public static void main(String[] args) {
        new Rectangle(10,5).printArea();
        new Triangle(10,5).printArea();
        new Circle(5).printArea();
    }
}




Slip-9)Write a program which define class Employee with data member as id, name and salary Store the information of ‘n’ employees and display the 
name of employee having maximum salary (Use array of object)



import java.util.*;

class Employee {
    int id;
    String name;
    double salary;

    Employee(int i, String n, double s) {
        id=i; name=n; salary=s;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n=sc.nextInt();
        Employee e[]=new Employee[n];

        for(int i=0;i<n;i++) {
            System.out.print("Enter id, name, salary: ");
            e[i]=new Employee(sc.nextInt(),sc.next(),sc.nextDouble());
        }

        int max=0;
        for(int i=1;i<n;i++)
            if(e[i].salary>e[max].salary) max=i;

        System.out.println("Maximum salary employee: "+e[max].name);
    }
}



Slip-11) Write a program to create a super class Vehicle having members Company and price. 
Derive two different classes LightMotorVehicle (mileage) and HeavyMotorVehicle (capacity_in_tons).
Accept the information for "n" vehicles and display the information in appropriate form. While taking data, ask user about the type of vehicle first.



import java.util.*;
class Vehicle {
    String company;
    double price;
    Vehicle(String c,double p) {
        company=c; price=p;
    }
}
class LightMotorVehicle extends Vehicle {
    double mileage;
    LightMotorVehicle(String c,double p,double m) {
        super(c,p); mileage=m;
    }
    void show() {
        System.out.println(company+" "+price+" Mileage: "+mileage);
    }
}
class HeavyMotorVehicle extends Vehicle {
    double capacity;
    HeavyMotorVehicle(String c,double p,double c1) {
        super(c,p); capacity=c1;
    }
    void show() {
        System.out.println(company+" "+price+" Capacity: "+capacity+" tons");
    }
}
class Test {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        System.out.print("Enter number of vehicles: ");
        int n=s.nextInt();
        for(int i=0;i<n;i++) {
            System.out.print("Enter type (L/H): ");
            char t=s.next().charAt(0);
            System.out.print("Enter company and price: ");
            String c=s.next();
            double p=s.nextDouble();
            if(t=='L') {
                System.out.print("Enter mileage: ");
                new LightMotorVehicle(c,p,s.nextDouble()).show();
            } else {
                System.out.print("Enter capacity in tons: ");
                new HeavyMotorVehicle(c,p,s.nextDouble()).show();
            }
        }
    }
}





Slip-13) Define a “Clock” class that does the following; 
a. Accept Hours, Minutes and Seconds 
b. Check the validity of numbers 
c. Set the time to AM/PM mode 
Use the necessary constructors and methods to do the above task


import java.util.*;
class Clock {
    int h, m, s;
    Clock(int h, int m, int s) {
        this.h=h; this.m=m; this.s=s;
    }
    void check() {
        if(h<0 || h>23 || m<0 || m>59 || s<0 || s>59)
            System.out.println("Invalid time");
        else {
            String ap = h<12 ? "AM" : "PM";
            int x = h%12;
            if(x==0) x=12;
            System.out.println("Valid Time: " + x + ":" + m + ":" + s + " " + ap);
        }
    }
        public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter hours: ");
        int h=sc.nextInt();
        System.out.print("Enter minutes: ");
        int m=sc.nextInt();
        System.out.print("Enter seconds: ");
        int s=sc.nextInt();
        new Clock(h,m,s).check();
    }
}




Slip-7) Create an unordered list of Programming Language names and apply different styles to the first and last list items.(Use :first-child and :last-child)

<!DOCTYPE html>
<html>
<head>
    <title>Programming Languages</title>

    <style>
        li:first-child {
            color: red;
            font-weight: bold;
        }

        li:last-child {
            color: blue;
            font-style: italic;
        }
    </style>
</head>

<body>

    <h2>Programming Languages</h2>

    <ul>
        <li>Python</li>
        <li>Java</li>
        <li>C</li>
        <li>C++</li>
        <li>JavaScript</li>
    </ul>

</body>
</html>





Slip-12) Write a JavaScript program using an arrow function to calculate the total price of a product. Display the bill using template literals and string interpolation.


<!DOCTYPE html>
<html>
<head>
    <title>Product Bill</title>
</head>
<body>

<script>
    const calculateTotal = (price, quantity) => price * quantity;

    const productName = "Laptop";
    const price = 50000;
    const quantity = 2;

    const total = calculateTotal(price, quantity);

    const bill = `
        Product Name: ${productName}
        Price: ₹${price}
        Quantity: ${quantity}
        Total Price: ₹${total}
    `;

    document.write("<pre>" + bill + "</pre>");
</script>

</body>
</html>
