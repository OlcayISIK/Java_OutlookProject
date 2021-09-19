package Outlook.DataAccess;

import java.util.ArrayList;
import java.util.Iterator;

import Outlook.Entities.Users;

public class AdminDal implements IDataDal{
	private ArrayList<Users> Admins = new ArrayList<>();
	public ArrayList<String> AdminList = (ArrayList<String>)(ArrayList<?>)(Admins);
	Iterator<String> it = AdminList.iterator();
	
	@Override
	public ArrayList<String> GetList() {
		return AdminList; 
	}

	@Override
	public void addObjectToList(Object o) {
		// TODO Auto-generated method stub
		
	}
}
