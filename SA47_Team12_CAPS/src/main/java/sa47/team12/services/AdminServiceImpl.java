package sa47.team12.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sa47.team12.model.Administrator;
import sa47.team12.repo.AdministratorRepo;


@Service
public class AdminServiceImpl implements AdminService {
 
	@Resource
	private AdministratorRepo aRepository;

	/* (non-Javadoc)
	 * @see edu.iss.cats.service.EmployeeService#findEmployeesByManager(java.lang.String)
	 */
	@Override
	@Transactional
	public ArrayList<Administrator> findAllAdministrator() {
		return (ArrayList<Administrator>) aRepository.findAll();
	}
	
	@Override
	@Transactional
	public Administrator findAdministrator(Integer id) {
		return (Administrator) aRepository.findById(id).get();
	}
	@Override
	@Transactional
	public Administrator updateAdministrator(Administrator a)
	{
		return aRepository.saveAndFlush(a);
	}

}
