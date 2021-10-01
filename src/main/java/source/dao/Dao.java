package source.dao;

import source.entity.Actor;

import java.sql.SQLException;
import java.sql.Statement;

public interface Dao {

void addActor(Statement statement, Actor actor) throws SQLException;
void getActor(Statement statement, Actor actor) throws SQLException;
void updateActor(Statement statement, Actor actor) throws SQLException;
void updateActorByID(Statement statement, Actor actor) throws SQLException;
void deleteActor(Statement statement, Actor actor) throws SQLException;
}