package fr.afpa.dao;

import fr.afpa.model.ConnectionBdd;
import fr.afpa.model.Game;

import java.sql.*;
import java.util.ArrayList;

public class GameDao extends Dao {
    private final Connection connection;

  public GameDao(){
      connection = ConnectionBdd.getInstance().connection;
  }

    @Override
    public Object find(int id) {
        try{
            PreparedStatement st = connection.prepareStatement("select * from video_game where id = ?");
            st.setInt(1,id);
            ResultSet rs = st.executeQuery();

            if(rs.next()){
                Game game = new Game();
                game.setId(rs.getInt("id"));
                game.setTitle(rs.getString("title"));
                game.setPubliDate(rs.getDate("publi_date"));
                game.setDescription(rs.getString("description"));
                game.setImagePath(rs.getString("image_path"));
                return game;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public ArrayList<Game> findAll() {
        ArrayList<Game> games = new ArrayList<>();
        try{
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from video_game");
            while (rs.next()){
                int id = rs.getInt("id");
                String title = rs.getString("title");
                Date date = rs.getDate("publi_date");
                String description = rs.getString("description");
                String imagePath = rs.getString("image_path");

                Game game = new Game(id, title, date, description, imagePath);
                games.add(game);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return games;
    }

    public void addGame(String title, Date publiDate, String descr){
        try{
            PreparedStatement statement = connection.prepareStatement("insert into movie (title, publiDate, description) values (?,?,?)");
            statement.setString(1, title);
            statement.setDate(2, publiDate);
            statement.setString(3,descr);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGame(int id, String title, Date date, String descr){
      try{
          PreparedStatement st = connection.prepareStatement("update video_game set title = ?, publiDate = ?, description = ? where id = ?");
          st.setString(1, title);
          st.setDate(2, date);
          st.setString(3, descr);
          st.executeUpdate();
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
    }

/*    public ArrayList<Game> getGameForUser(int userId){
      ArrayList<Game> games = new ArrayList<>();
      try{
          PreparedStatement st = connection.prepareStatement("SELECT * FROM game_playlist WHERE userId = ?;");
          st.setInt(1,userId);
          ResultSet rs = st.executeQuery();

          while (rs.next()){
              int gameId = rs.getInt("gameid");
              Game game =  gameDao.find(gameId);
              games.add(game);
          }
      } catch (SQLException e) {
          throw new RuntimeException(e);
      }
      return games;
    }*/


}
