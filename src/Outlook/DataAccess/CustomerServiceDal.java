package Outlook.DataAccess;

import java.util.ArrayList;
import java.util.Iterator;

import Outlook.Entities.CustomerService;

public class CustomerServiceDal implements IDataDal {
	public ArrayList<CustomerService> CustomerServiceList = new ArrayList<>();
	public ArrayList<String> customerServiceList = (ArrayList<String>)(ArrayList<?>)(CustomerServiceList);
	Iterator<String> it = customerServiceList.iterator(); 


	@Override
	public ArrayList<String> GetList() {
		return customerServiceList;
	}

	@Override
	public void addObjectToList(Object o) {
		// TODO Auto-generated method stub
		
	}

}
