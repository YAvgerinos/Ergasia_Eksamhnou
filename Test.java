/*
	Μεταπτυχιακό στη Διοικητική Επιστήμη και Τεχνολογία
	Οικονομικό Πανεπιστήμιο Αθηνών
	Full-time 2017-18
	_____________________________________________________________________________
	Συστήματα Λογισμικού: Τελική Εργασία
	_____________________________________________________________________________
	Αυγερινός Ιωάννης         MSTFT1702
	Δοβλέτογλου Σοφία-Δανάη   MSTFT1704
	Μακρινός Αντώνης          MSTFT1716
	*/

import java.util.Scanner;

public class Test
{
	public static void main (String[] args)
	{
		Scanner number = new Scanner (System.in);
		int menu = 0; //Η μεταβλητή menu προσδιορίζει την επιλογή του χρήστη από τις 5 επιλογές.

		Lawyer ioannisavgerinos = new Lawyer ("Ioannis Avgerinos", 5, 22000);
		Lawyer danaidovletoglou = new Lawyer ("Danai Dovletoglou", 12, 34000);
		Lawyer antonismakrinos = new Lawyer ("Antonis Makrinos", 21, 40000);

		Defendant defendant1 = new Defendant ("Anastasia Georgiou", antonismakrinos, 32, "GR");
		Defendant defendant2 = new Defendant ("Michael Green", danaidovletoglou, 54, "USA");
		Defendant defendant3 = new Defendant ("Maria Anastasiou", ioannisavgerinos, 39, "GR");
		Defendant defendant4 = new Defendant ("George Kane", antonismakrinos, 42, "UK");

		System.out.println("********************** Software Systems Final Assignment ***********************");
		while (true) //Συνθήκη για τη συνεχή εκτέλεση του προγράμματος
		{
			System.out.println("Menu: ");
			do //Η εκτύπωση του menu επαναλαμβάνεται μέχρις ότου ο χρήστης δώσει έγκυρη τιμή.
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
			} //Λήξη επαναληπτικής διαδικασίας εκτύπωσης menu

			while (menu!=1 && menu!=2 && menu!=3 && menu!=4 && menu!=5);

			if (menu==1)
			{
				System.out.println("******************************** Lawyers' list *********************************");
				for (int i=0;i<Lawyer.lawyer.length;i++)
				{
					if (Lawyer.lawyer[i]!= null) //Εκτύπωση μόνο των κελιών που έχουν τιμές
						System.out.println(Lawyer.lawyer[i]);
				}
				System.out.println("\n********************************************************************************");
			}



			if (menu==2)
			{
				int over = 0; //Ορισμός μεταβλητής over που μετράει τον αριθμό των κατηγορούμενων που υπερβαίνουν το όριο ηλικίας που δίνει ο χρήστης
				int inputage; //Ορισμός μεταβλητής inputage, η οποία λαμβάνει την τιμή του ηλικιακού ορίου που δίνει ο χρήστης
				System.out.println("Enter your input age: ");
				inputage = number.nextInt();
				System.out.println("************************* Defendants over "+inputage+" years old *************************");
				for (int i=0;i<Defendant.defendant.length;i++)
				{
					if (Defendant.defendant[i]!= null)
					{
						if (Defendant.defendant[i].getAge()>inputage)
						{
							++over; //Αν ο κατηγορούμενος υπερβαίνει το ηλικιακό όριο, ο μετρητής αυξάνεται κατά 1.
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
					if (Lawyer.lawyer[i] == null) //Εισαγωγή νέου αντικειμένου στο επόμενο κενό κελί
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
				long max = 0; //Ορισμός μεταβλητής max που λαμβάνει την τιμή του μέγιστου εισοδήματος
				String name; //Ορισμός μεταβλητής name που λαμβάνει το όνομα του δικηγόρου με το μεγαλύτερο εισόδημα
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
							System.out.println(Lawyer.lawyer[i]); //Εκτύπωση του δικηγόρου με το μεγαλύτερο εισόδημα
					}
				}
				System.out.println("\n********************************************************************************");
			}

			if (menu==5)
			{
				System.out.println("*************************** Change a lawyer's income ***************************");
				System.out.println();
				int j = 0; //Ορισμός μεταβλητής j που θα αντιστοιχεί με τη θέση του πίνακα lawyer
				System.out.println("Enter the lawyer that you want to edit (choose between 0 to 9):");
				do //Επανάληψη της εισαγωγής τιμής j μέχρις ότου δοθεί έγκυρη τιμή
				{
					j = number.nextInt();
					if (j<0 || j>9)
						System.out.println("Invalid input. Enter a number between 0 and 9:");
				}
				while (j<0 || j>9);

				do //Επανάληψη της εισαγωγής τιμής j μέχρις ότου δοθεί τιμή ενός κελιού που δεν είναι κενό
				{
					if (Lawyer.lawyer[j] == null)
					{
						System.out.println("There is no input. Enter again.");
						j = number.nextInt();
					}
				}
				while (Lawyer.lawyer[j] == null);

				System.out.println("You have chosen the lawyer: ");
				System.out.println(Lawyer.lawyer[j]); //Εκτύπωση των στοιχείων του δικηγόρου που επιλέχθηκε
				System.out.println("Enter new income: ");
				Lawyer.lawyer[j].setIncome(number.nextLong()); //Ορισμός νέου εισοδήματος από το χρήστη
				System.out.println("Lawyer "+Lawyer.lawyer[j].getName()+"'s income has been changed to "+Lawyer.lawyer[j].getIncome()+".");

				System.out.println("\n********************************************************************************");
			}
		} //Λήξη συνθήκης συνεχούς εκτέλεσης

	}
}



