package Outlook.Entities;

public class CustomerService {
	 private int id;
	 private String Name_Surname;
	 private String Photo;
	   

	    public CustomerService(int id,String Name_Surname,String Photo){
	        this.id = id;
	        this.Name_Surname = Name_Surname; 
	        this.Photo = Photo;
	        
	    }

	    public int getId() {
	        return id; 
	    }
	    

		public String getName_Surname() {
			return Name_Surname;
		}
		
		public String getPhoto() {
			return Photo;
		}


		
}
