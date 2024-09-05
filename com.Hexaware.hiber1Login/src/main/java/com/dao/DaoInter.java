package com.dao;

import com.model.Login;

public interface DaoInter {

	boolean signUP(Login l);

	void showALL();

	boolean signIN(Login l);

	void showData();

	void updatePass();

	void deleteHQL();

}
