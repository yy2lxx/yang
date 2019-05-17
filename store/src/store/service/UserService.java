package store.service;

import java.sql.SQLException;

import store.domain.User;

import javax.jws.soap.SOAPBinding;

public interface UserService {

	void userRegist(User user)throws SQLException ;

	boolean userActive(String code)throws SQLException ;

	User userLogin(User user) throws SQLException ;



}
