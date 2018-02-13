public class Defendant{
	static Defendant defendant[] = new Defendant [10];
	private int id;
	static int counter = 0;
	private Lawyer lawyer;
	private String name;
	private int age;
	private String nationality;

	public Defendant(String name, Lawyer lawyer, int age,String nationality){
	        this.name= name;
	        this.lawyer = lawyer;
			this.age= age;
			this.nationality = nationality;
			defendant[counter] = this;
			id = counter++;
	}

	public void setName(String name){
		this.name = name;
		}

	public String getName(){
		return name;
		}

	public void setAge(int age){
		this.age = age;
		}

	public int getAge(){
		return age;
		}

	public void setNationality(String nationality){
			this.nationality = nationality;
		}

	public String getNationality(){
			return nationality;
		}
	public Lawyer lawyer()
			{
				return lawyer;
		}

	public void setLawyer(Lawyer lawyer)
			{
				this.lawyer = lawyer;
	}


	public String toString(){
			return "Defendant "+id+": [name = " + name + ", age = " + age + ", nationality = " + nationality + "]";
		}
	}