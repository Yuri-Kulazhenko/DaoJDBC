package source.dao;

import source.entity.Actor;

import java.sql.SQLException;
import java.sql.Statement;

public class ActorDao implements Dao {

    @Override
    public void addActor(Statement statement, Actor actor) throws SQLException {
        String query = "INSERT INTO Actor VALUES" +
                "(" +actor.getId()+",'"
                +actor.getName()+"', '"
                +actor.getMidleName()+"', '"
                +actor.getSurname()+"', "
                +actor.getYearOfBirth()+", "
                +actor.getCountryKey()+");";


        statement.execute(query);

    }

    @Override
    public void updateActor(Statement statement, Actor actor) throws SQLException{
        String query3 = "update Actor set CountryKey = 149 where ActorID=" +
                +actor.getId()+  ";";
        statement.execute(query3);
    }

    @Override
    public void updateActorByID(Statement statement, Actor actor) throws SQLException{
        String query2 = "Update Actor set YearOfBirth = 1957 where ActorID =" +
                +actor.getId()+  ";";
        statement.execute(query2);
    }

    @Override
    public void deleteActor(Statement statement, Actor actor ) throws SQLException{
        String query1 = "delete from Actor where ActorID =" +
                +actor.getId()+  ";";

        statement.execute(query1);
    }

    @Override
    public void getActor(Statement statement,Actor actor) throws SQLException{
        String query4 = "select * from Actor where ActorID =" +
                +actor.getId()+  ";";
        statement.execute(query4);
    }
}



