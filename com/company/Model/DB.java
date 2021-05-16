package com.company.Model;

import java.sql.*;

public class DB implements IDB{

    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    Connection con;

    @Override
    public void connect()
    {
        try{
            con = DriverManager.getConnection(url, "postgres", "test123");
        }
        catch (SQLException exception)
        {
            System.out.println(exception);
        }

    }

    @Override
    public User isUserExist(User user) {

        User userDB = null;
        connect();

        try {
            Statement st = con.createStatement();
            // update veya insertte update işlemi yapılıcak
            ResultSet rs =
                    st.executeQuery(String.format("SELECT * FROM users WHERE username='%s' AND password='%s'", user.getUsername(), user.getPassword()));
                    while(rs.next())
                    {
                        userDB = new User.Builder()
                                .name(rs.getString("name"))
                                .role(rs.getShort("role"))
                                .build();
                    }


            con.close();
            rs.close();
            st.close();

            return userDB;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return userDB;
        }
    }
}
