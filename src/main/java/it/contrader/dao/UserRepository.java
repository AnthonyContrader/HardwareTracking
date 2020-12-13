package it.contrader.dao;



import it.contrader.model.User;


public interface UserRepository extends DAOGeneralInterface<User>{

	User findByUsernameAndPassword(String username, String password);
	
}
