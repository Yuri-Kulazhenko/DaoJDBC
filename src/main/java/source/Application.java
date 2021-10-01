package source;

import source.dao.ActorDao;
import source.entity.Actor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static source.data.Common.*;

public class Application {

    public static void main(String[] args) {

        List<Actor> listOfActors = new ArrayList<>();

        try(Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
            Statement statment = connection.createStatement()){

            String sql_query = "select * from Actor";
            ResultSet result1 = statment.executeQuery(sql_query);
            while(result1.next()){
                listOfActors.add(new Actor(
                        result1.getInt("ActorID"),
                        result1.getString("Name"),
                        result1.getString("Midlename"),
                        result1.getString("Surname"),
                        result1.getInt("YearOfBirth"),
                        result1.getInt("CountryKey")));
            }
            System.out.println(listOfActors);

            ActorDao actorDao = new ActorDao();

            Actor actor = new Actor(78,"Val", "Edward", "Kilmer", 1959, 150);
            actorDao.addActor(statment, actor);

            Actor actor1 = new Actor(74);
            actorDao.deleteActor(statment, actor1);

            Actor actor2 = new Actor(79);
            actorDao.updateActorByID(statment, actor2);

            Actor actor3 = new Actor(79,"Val", "Edward", "Kilmer", 1959, 149);
            actorDao.updateActor(statment, actor3);

            Actor actor4 = new Actor(78,"Val", "Edward", "Kilmer", 1959, 150);
            actorDao.getActor(statment, actor4);
            System.out.println(actor4);

            ResultSet result2 = statment.executeQuery(sql_query);
            while(result2.next()){
                listOfActors.add(new Actor(
                        result2.getInt("ActorID"),
                        result2.getString("Name"),
                        result2.getString("Midlename"),
                        result2.getString("Surname"),
                        result2.getInt("YearOfBirth"),
                        result2.getInt("CountryKey")));
            }
            System.out.println(listOfActors);

        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
