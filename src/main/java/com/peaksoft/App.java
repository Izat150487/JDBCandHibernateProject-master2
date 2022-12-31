package com.peaksoft;


import com.peaksoft.dao.UserDaoJdbcImpl;
import com.peaksoft.model.User;

import java.util.List;

public class App {
    public static void main( String[] args ) {

          UserDaoJdbcImpl userDaoJdbc = new UserDaoJdbcImpl();

           /*1. User-лерге таблица тузуу*/
//        userDaoJdbc.createUsersTable();

           /*2. 4 user-ди базага кошуу. Ар бир user базага кошулгандан кийин анын аты  базага кошулду деп консольго чыгуусу керек*/
//        userDaoJdbc.saveUser("Elzat", "Sadykov",(byte) 27);
//        userDaoJdbc.saveUser("Aida", "Kydyrmysheva",(byte) 31);
//        userDaoJdbc.saveUser("Rayana", "Kydyrmysheva",(byte) 4);
//        userDaoJdbc.saveUser("Usman", "Kydyrmyshev",(byte) 2);

            /*3. Бардык user-лерди алуу жана консольго чыгаруу,toString методун override кылышыныз керек*/
//        List<User> allUsers = userDaoJdbc.getAllUsers();
//        System.out.println(allUsers);

            /*4. Таблицанын маалыматтарын очуруу*/
//         userDaoJdbc.cleanUsersTable();

            /*5. Таблицаны очуруу*/
//         userDaoJdbc.dropUsersTable();

               /*Userди ID менен очуруу*/
//         userDaoJdbc.removeUserById(33);
    }
}
