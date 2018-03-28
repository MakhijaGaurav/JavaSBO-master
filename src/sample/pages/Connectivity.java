package sample.pages;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.sql.*;
import java.util.ArrayList;

public class Connectivity {
    Connection connection = null;
    Statement statement;
    ResultSet resultSet;

    ////******************CREATING CONNECTION AND DATABASE******************//
    public void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:SBO.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Connection Success!");
        } catch (Exception e) {
            System.out.println(e);

        }
    }
    //**********************CREATING TABLE******************************
    public void create() {
        try {
            statement = connection.createStatement();
            String create = "CREATE TABLE SBO(NAME TEXT(100)" +
                    ",DOB TEXT(10)" +
                    ",ADDRESS TEXT(100)" +
                    ",EMAIL TEXT(100)," +
                    " FRAME TEXT(100), " +
                    "GLASSES TEXT(100)," +
                    " DETAILS TEXT(200)," +
                    "RIGHT_SPH TEXT(5)," +
                    "RIGHT_CYL TEXT(5)," +
                    "RIGHT_AXIS TEXT(5)," +
                    "RIGHT_ADD TEXT(5)," +
                    "RIGHT_PD TEXT(10)," +
                    "LEFT_SPH TEXT(5)," +
                    "LEFT_CYL TEXT(5)" +
                    ",LEFT_AXIS TEXT(5)," +
                    "LEFT_ADD TEXT(5)," +
                    "LEFT_PD TEXT(10)," +
                    "RIGHT_CONTACT_SPHID TEXT(10)," +
                    "RIGHT_CONTACT_CYLID TEXT(10)," +
                    "RIGHT_CONTACT_AXISID TEXT(10)," +
                    "LEFT_CONTACT_SPH TEXT(10)," +
                    "LEFT_CONTACT_CYL TEXT(10)," +
                    "LEFT_CONTACT_AXIS TEXT(10));";

            System.out.println(create);
            statement.executeUpdate(create);
            System.out.println("Table Created");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    //******************************INSERTING INTO DATABASE TAKING VALUES FROM UI FORM***************************************
    public void insert(String name, String dob, String address, String mail,String frame, String glass, String details,
                       String RIGHTSPH, String RIGHTCYL, String RIGHTAXIS,String RIGHTADD, String RIGHTPD,
                       String LEFTSPH, String LEFTCYL, String LEFTAXIS, String LEFTADD, String LEFTPD,
                       String RIGHTCONTACTSPH, String RIGHTCONTACTCYL, String RIGHTCONTACTAXIS,
                       String LEFTCONTACTSPH, String LEFTCONTACTCYL, String LEFTCONTACTAXIS)
    {
        try{
            if(connection == null)
                connect();
            String insertQuery = "insert into SBO values" +
                    "("+"'"+name+"'"+","+"'"+dob+"'"+","+"'"+address+"'"+","+"'"+mail+"'"+","+"'"+frame+"'"+","+"'"+glass+"'"+","+"'"+details+"'"+","+"'"+RIGHTSPH+"'"+","+"'"+RIGHTCYL+"'"+","+"'"+RIGHTAXIS+"'"+","+"'"+RIGHTADD+"'"+","+"'"+RIGHTPD+"'"+","+"'"+LEFTSPH+"'"+","+"'"+LEFTCYL+"'"+","+"'"+LEFTAXIS+"'"+","+"'"+LEFTADD+"'"+","+"'"+LEFTPD+"'"+","+"'"+RIGHTCONTACTSPH+"'"+","+"'"+RIGHTCONTACTCYL+"'"+","+"'"+RIGHTCONTACTAXIS+"'"+","+"'"+LEFTCONTACTSPH+"'"+","+"'"+LEFTCONTACTCYL+"'"+","+"'"+LEFTCONTACTAXIS+"'"+");";
            System.out.println(insertQuery);
            statement = connection.createStatement();
            statement.execute(insertQuery);
            System.out.println("INSERTED");

        }
        catch (Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }


    /***********************RETRIVING ONLY NAMES FROM TABLE***************************/
    public ArrayList<String> viewName(){
        try {
            if (connection == null)
                connect();
            statement = connection.createStatement();
            String viewNameQuery = "Select NAME from SBO;";
            System.out.println(viewNameQuery);
            resultSet = statement.executeQuery(viewNameQuery);
            ArrayList<String> nameList = new ArrayList<>();
            int countOfName = 0;

            while(resultSet.next()){
                String name = resultSet.getString("NAME");
                nameList.add(name);
                countOfName++;
            }
            System.out.println("ADDEDD SUCESSFULLY!\nNumber of Entries "+countOfName);
            for(int i=0; i<countOfName; i++)
            {
                String pritingNames = nameList.get(i);
                System.out.println(pritingNames);
            }
            return nameList; //returning arrayList
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }




}
