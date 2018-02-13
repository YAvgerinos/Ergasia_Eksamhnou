public class Lawyer{
	static Lawyer lawyer[] = new Lawyer [10];
	private int id;
	static int counter = 0;
	private String name;
	private int workExperience;
	private long income;

	public Lawyer(String name, int workExperience,long income){
	        this.name = name;
			this.workExperience = workExperience;
			this.income = income;
			lawyer[counter] = this;
			id = ++counter;
	}

	public void setName(String name){
		this.name = name;
		}

	public String getName(){
		return name;
		}

	public void setWorkExperience(int workExperience){
		this.workExperience = workExperience;
		}

	public int getWorkExperience(){
		return workExperience;
		}

	public void setIncome(long income){
			this.income = income;
		}

	public long getIncome(){
			return income;
		}

	public String toString(){
			return "Lawyer "+id+" : [name = " + name + ", workExperience = " + workExperience + ", income = " + income + "]";
		}
	}