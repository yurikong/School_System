package model;

import datatypes.*;
import database.*;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SuperAdminModel extends AdminModel
{
	public SuperAdminModel()
	{
		super();
	}
	public int addAdminAccount(Admin admin, String password)
	{
		int id = generateUserID();
		User user = new User(id, password, "Admin");
		admin.setID(id);
		UsersTable.getInstance().getData().put(id, user);
		AdminsTable.getInstance().getData().put(id, admin);
		return id;
	}
	public void removeAdminAccount(int id)
	{
		AdminsTable.getInstance().getData().remove(id);
	}
	public void setAdminAccount(Admin admin)
	{
		AdminsTable.getInstance().getData().replace(admin.id(), admin);
	}
	public TreeMap<Integer, Admin> getAllAdmins()
	{
		return AdminsTable.getInstance().getData();
	}
	public Object[][] getAllAdminsConverted()
	{
		TreeMap<Integer, Admin> admins = getAllAdmins();
		int row = admins.size();
		Object[][] tableData = new Object[row - 1][4];
		int i = 0;
		for(Entry<Integer, Admin> entry : admins.entrySet())
		{
			Integer id = entry.getKey();
			Admin admin = entry.getValue();
			if(id != 0)
			{
				tableData[i][0] = id;
				tableData[i][1] = admin.firstname();
				tableData[i][2] = admin.middlename();
				tableData[i][3] = admin.lastname();
				i++;
			}
		}
		return tableData;
	}
}
