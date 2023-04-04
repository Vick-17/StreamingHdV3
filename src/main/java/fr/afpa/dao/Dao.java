package fr.afpa.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class Dao<T> {


    public abstract T find(int id);
    public abstract ArrayList<T> findAll();
}
