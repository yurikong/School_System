package model;

import datatypes.User;
import datatypes.Session;
import database.UsersTable;
import database.AdminsTable;
import database.EmployeesTable;
import database.SessionsTable;
import database.StudentsTable;

import java.util.ArrayList;
import java.util.TreeMap;

public class UserModel
{
	public UserModel() {}
	public Object login(int id, String password)
	{
		if(UsersTable.getInstance().getData().containsKey(id))
		{
			User user = UsersTable.getInstance().getData().get(id);
			if(password.equals(user.password()))
			{
				if(user.status().equalsIgnoreCase("student"))
					return StudentsTable.getInstance().getData().get(id);
				if(user.status().equalsIgnoreCase("admin") || user.status().equalsIgnoreCase("superadmin"))
					return AdminsTable.getInstance().getData().get(id);
				if(user.status().equalsIgnoreCase("employee"))
					return EmployeesTable.getInstance().getData().get(id);
			}
		}
		return null;
	}
	public String getStatus(int id)
	{
		return UsersTable.getInstance().getData().get(id).status();
	}
}
