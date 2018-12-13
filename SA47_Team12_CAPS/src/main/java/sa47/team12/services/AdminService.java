package sa47.team12.services;

import java.util.ArrayList;

import sa47.team12.model.Administrator;

public interface AdminService {
 
	ArrayList<Administrator> findAllAdministrator();
	Administrator findAdministrator(Integer id);
	Administrator updateAdministrator(Administrator a);
}