package com.peaksoft;


import com.peaksoft.dao.UserDaoHibernateImpl;
import com.peaksoft.dao.UserDaoJdbcImpl;
import com.peaksoft.model.User;

import java.util.List;

public class App {
    public static void main( String[] args ) {

          UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();




//         userDaoJdbc.saveUser("Elzat", "Sadykov",(byte) 27);
//         userDaoJdbc.saveUser("Aida", "Kydyrmysheva",(byte) 31);
//         userDaoJdbc.saveUser("Rayana", "Kydyrmysheva",(byte) 4);
//         userDaoJdbc.saveUser("Usman", "Kydyrmyshev",(byte) 2);


//         List<User> allUsers = userDaoJdbc.getAllUsers();
//         System.out.println(allUsers);

//         userDaoHibernate.cleanUsersTable();

//         userDaoHibernate.dropUsersTable();

//         userDaoHibernate.removeUserById(1);

    }
}
