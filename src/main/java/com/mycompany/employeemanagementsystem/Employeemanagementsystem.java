import java.util.Scanner;

class EmployeeManagementSystem {

	static int count = 0;

	static class Node {
		Node prev;
		int ssn;
		long phno;
		float sal;
		String name, dept, desg;
		Node next;
	}

	static Node h, temp, temp1, temp2, temp4;

	static void create() {
		int ssn;
		long phno;  // Add this line
		float sal;
		String name, dept, desg;
		temp = new Node();
		temp.prev = null;
		temp.next = null;
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter ssn: ");
		ssn = scanner.nextInt();
		System.out.print("Enter name: ");
		name = scanner.next();
		System.out.print("Enter department: ");
		dept = scanner.next();
		System.out.print("Enter designation: ");
		desg = scanner.next();
		System.out.print("Enter salary: ");
		sal = scanner.nextFloat();
		System.out.print("Enter phone number: ");  // Add this line
		phno = scanner.nextLong();  // Add this line
		temp.ssn = ssn;
		temp.name = name;
		temp.dept = dept;
		temp.desg = desg;
		temp.sal = sal;
		temp.phno = phno;
		count++;
	}

	static void insertBeg() {
		if (h == null) {
			create();
			h = temp;
			temp1 = h;
		} else {
			create();
			temp.next = h;
			h.prev = temp;
			h = temp;
		}
	}

	static void insertEnd() {
		if (h == null) {
			create();
			h = temp;
			temp1 = h;
		} else {
			create();
			temp1.next = temp;
			temp.prev = temp1;
			temp1 = temp;
		}
	}

	static void displayBeg() {
		temp2 = h;
		if (temp2 == null) {
			System.out.println("List is empty");
			return;
		}
		while (temp2 != null) {
			System.out.println(temp2.ssn);
			System.out.println(temp2.name);
			System.out.println(temp2.dept);
			System.out.println(temp2.desg);
			System.out.println(temp2.sal);
			System.out.println(temp2.phno);
			temp2 = temp2.next;
		}
		System.out.println("Number of employees: " + count);
	}

	static int deleteEnd() {
		Node temp;
		temp = h;
		if (temp == null) {
			System.out.println("List is empty");
			return 0;
		}
		if (temp.next == null) {
			System.out.println(temp.ssn);
			System.out.println(temp.name);
			System.out.println(temp.dept);
			System.out.println(temp.desg);
			System.out.println(temp.sal);
			System.out.println(temp.phno);
			h = null;
		} else {
			temp = temp1;
			temp2 = temp1.prev;
			temp2.next = null;
			System.out.println(temp.ssn);
			System.out.println(temp.name);
			System.out.println(temp.dept);
			System.out.println(temp.desg);
			System.out.println(temp.sal);
			System.out.println(temp.phno);
			temp1 = temp2;
		}
		count--;
		return 0;
	}

	static int deleteBeg() {
		Node temp;
		temp = h;
		if (temp == null) {
			System.out.println("List is empty");
			return 0;
		}
		if (temp.next == null) {
			System.out.println(temp.ssn);
			System.out.println(temp.name);
			System.out.println(temp.dept);
			System.out.println(temp.desg);
			System.out.println(temp.sal);
			System.out.println(temp.phno);
			h = null;
		} else {
			h = h.next;
			h.prev = null;
			System.out.println(temp.ssn);
			System.out.println(temp.name);
			System.out.println(temp.dept);
			System.out.println(temp.desg);
			System.out.println(temp.sal);
			System.out.println(temp.phno);
		}
		count--;
		return 0;
	}

	static void employerDetails() {
		int ch, n, i;
		h = null;
		temp = temp1 = null;
		System.out.println("----------MENU----------");
		System.out.println("1.create a dll of n employee");
		System.out.println("2.display from the beginning");
		System.out.println("3.insert at the end");
		System.out.println("4.delete at the end");
		System.out.println("5.insert at the beginning");
		System.out.println("6.delete at the beginning");
		System.out.println("7.to show dll as a queue");
		System.out.println("8.Exit");
		System.out.println("--------------------------");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("Enter choice: ");
			ch = scanner.nextInt();
			switch (ch) {
				case 1:
					System.out.print("Enter the number of employees: ");
					n = scanner.nextInt();
					for (i = 0; i < n; i++) {
						insertEnd();
					}
					break;
				case 2:
					displayBeg();
					break;
				case 3:
					insertEnd();
					break;
				case 4:
					deleteEnd();
					break;
				case 5:
					insertBeg();
					break;
				case 6:
					deleteBeg();
					break;
				case 7:
					System.out.println("To show dll as a queue, perform insert and deletion operations by calling insertBeg() and deleteEnd() respectively.");
					break;
				case 8:
					System.exit(0);
				default:
					System.out.println("Wrong Choice");
			}
		}
	}

	public static void main(String[] args) {
		employerDetails();
	}
}
