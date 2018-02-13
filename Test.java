/*
	������������ ��� ���������� �������� ��� ����������
	���������� ������������ ������
	Full-time 2017-18
	_____________________________________________________________________________
	��������� ����������: ������ �������
	_____________________________________________________________________________
	��������� �������         MSTFT1702
	����������� �����-�����   MSTFT1704
	�������� �������          MSTFT1716
	*/

import java.util.Scanner;

public class Test
{
	public static void main (String[] args)
	{
		Scanner number = new Scanner (System.in);
		int menu = 0; //� ��������� menu ������������ ��� ������� ��� ������ ��� ��� 5 ��������.

		Lawyer ioannisavgerinos = new Lawyer ("Ioannis Avgerinos", 5, 22000);
		Lawyer danaidovletoglou = new Lawyer ("Danai Dovletoglou", 12, 34000);
		Lawyer antonismakrinos = new Lawyer ("Antonis Makrinos", 21, 40000);

		Defendant defendant1 = new Defendant ("Anastasia Georgiou", antonismakrinos, 32, "GR");
		Defendant defendant2 = new Defendant ("Michael Green", danaidovletoglou, 54, "USA");
		Defendant defendant3 = new Defendant ("Maria Anastasiou", ioannisavgerinos, 39, "GR");
		Defendant defendant4 = new Defendant ("George Kane", antonismakrinos, 42, "UK");

		System.out.println("********************** Software Systems Final Assignment ***********************");
		while (true) //������� ��� �� ������ �������� ��� ������������
		{
			System.out.println("Menu: ");
			do //� �������� ��� menu ��������������� ������ ���� � ������� ����� ������ ����.
			{
			System.out.println("Type 1 to display lawyers' list");
			System.out.println("Type 2 to display defendants over an input age");
			System.out.println("Type 3 to insert a new lawyer");
			System.out.println("Type 4 to display the most well-paid Lawyer");
			System.out.println("Type 5 to change a lawyer's income");
			System.out.print("Type here: ");
			menu = number.nextInt();
			System.out.print("\n");

			if (menu!=1 && menu!=2 && menu!=3 && menu!=4 && menu!=5)
						System.out.println("Invalid input. Choose from 1 to 5.");
			} //���� ������������� ����������� ��������� menu

			while (menu!=1 && menu!=2 && menu!=3 && menu!=4 && menu!=5);

			if (menu==1)
			{
				System.out.println("******************************** Lawyers' list *********************************");
				for (int i=0;i<Lawyer.lawyer.length;i++)
				{
					if (Lawyer.lawyer[i]!= null) //�������� ���� ��� ������ ��� ����� �����
						System.out.println(Lawyer.lawyer[i]);
				}
				System.out.println("\n********************************************************************************");
			}



			if (menu==2)
			{
				int over = 0; //������� ���������� over ��� ������� ��� ������ ��� �������������� ��� ����������� �� ���� ������� ��� ����� � �������
				int inputage; //������� ���������� inputage, � ����� �������� ��� ���� ��� ��������� ����� ��� ����� � �������
				System.out.println("Enter your input age: ");
				inputage = number.nextInt();
				System.out.println("************************* Defendants over "+inputage+" years old *************************");
				for (int i=0;i<Defendant.defendant.length;i++)
				{
					if (Defendant.defendant[i]!= null)
					{
						if (Defendant.defendant[i].getAge()>inputage)
						{
							++over; //�� � �������������� ���������� �� �������� ����, � �������� ��������� ���� 1.
							System.out.println(Defendant.defendant[i]);
						}

					}
				}
				System.out.print("\n");

				if (over>1)
				System.out.println(over + " defendants were found.");

				if (over==1)
				System.out.println(over + " defendant was found.");

				if (over==0)
				{
				System.out.println("No defendants were found.");
				}
				System.out.println("\n********************************************************************************");
			}

			if (menu==3)
			{
				System.out.println("***************************** Insert a new lawyer *****************************");
				for (int i=0;i<Lawyer.lawyer.length;i++)
				{
					if (Lawyer.lawyer[i] == null) //�������� ���� ������������ ��� ������� ���� ����
					{
						System.out.print("\nCreate new lawyer: ");
						System.out.print("\nName: ");
						number.nextLine();
						String name = number.nextLine();
						System.out.print("Work Experience: ");
						int workExperience = number.nextInt();
						System.out.print("Income: ");
						long income = number.nextLong();
						Lawyer.lawyer[i] = new Lawyer (name, workExperience, income);
						System.out.println(name + " created.");
						break;
					}
				}
				System.out.println("\n********************************************************************************");
			}


			if (menu==4)
			{
				long max = 0; //������� ���������� max ��� �������� ��� ���� ��� �������� �����������
				String name; //������� ���������� name ��� �������� �� ����� ��� ��������� �� �� ���������� ��������
				System.out.println("**************************** Most well-paid Lawyer *****************************");
				System.out.println();
				for (int i=0;i<Lawyer.lawyer.length;i++)
				{
					if (Lawyer.lawyer[i]!= null)
					{
						if (Lawyer.lawyer[i].getIncome()>max)
						{
							max = Lawyer.lawyer[i].getIncome();
							name = Lawyer.lawyer[i].getName();
						}
					}
				}
				System.out.println("The lawyer who receives the greatest income is:");
				for (int i=0;i<Lawyer.lawyer.length;i++)
				{
					if (Lawyer.lawyer[i]!= null)
					{
						if (Lawyer.lawyer[i].getIncome() == max)
							System.out.println(Lawyer.lawyer[i]); //�������� ��� ��������� �� �� ���������� ��������
					}
				}
				System.out.println("\n********************************************************************************");
			}

			if (menu==5)
			{
				System.out.println("*************************** Change a lawyer's income ***************************");
				System.out.println();
				int j = 0; //������� ���������� j ��� �� ����������� �� �� ���� ��� ������ lawyer
				System.out.println("Enter the lawyer that you want to edit (choose between 0 to 9):");
				do //��������� ��� ��������� ����� j ������ ���� ����� ������ ����
				{
					j = number.nextInt();
					if (j<0 || j>9)
						System.out.println("Invalid input. Enter a number between 0 and 9:");
				}
				while (j<0 || j>9);

				do //��������� ��� ��������� ����� j ������ ���� ����� ���� ���� ������ ��� ��� ����� ����
				{
					if (Lawyer.lawyer[j] == null)
					{
						System.out.println("There is no input. Enter again.");
						j = number.nextInt();
					}
				}
				while (Lawyer.lawyer[j] == null);

				System.out.println("You have chosen the lawyer: ");
				System.out.println(Lawyer.lawyer[j]); //�������� ��� ��������� ��� ��������� ��� ����������
				System.out.println("Enter new income: ");
				Lawyer.lawyer[j].setIncome(number.nextLong()); //������� ���� ����������� ��� �� ������
				System.out.println("Lawyer "+Lawyer.lawyer[j].getName()+"'s income has been changed to "+Lawyer.lawyer[j].getIncome()+".");

				System.out.println("\n********************************************************************************");
			}
		} //���� �������� �������� ���������

	}
}



