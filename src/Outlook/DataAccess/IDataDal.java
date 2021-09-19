package Outlook.DataAccess;

import java.util.ArrayList;

public interface IDataDal {
	public ArrayList<String> GetList();
	public void addObjectToList(Object o);
}
