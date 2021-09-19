package Outlook.DataAccess;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

import Outlook.Entities.Users;

public class UserDal implements IDataDal {

	private ArrayList<Users> Users = new ArrayList<>();
	public ArrayList<String> userList = (ArrayList<String>)(ArrayList<?>)(Users);
	Iterator<String> it = userList.iterator();
	

	@Override
	public ArrayList<String> GetList() {
		return userList; 
	}

	@Override
	public void addObjectToList(Object o) {
		// TODO Auto-generated method stub
		
	} 
	

}
