package fr.afpa.dao;

import fr.afpa.model.ConnectionBdd;
import fr.afpa.model.Film;
import fr.afpa.model.GetUserId;
import fr.afpa.model.Playlist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDao extends Dao<Playlist> {

    MoviesDao moviesDao = new MoviesDao();
    private final Connection connection;

    public PlaylistDao(){
        connection = ConnectionBdd.getInstance().connection;
    }

    public void addMoviesPlaylist(int moviesId) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("insert into playlist(movieId, userId) values (?,?);");
        int idUser = GetUserId.getInstance().getId();
        System.out.println(idUser);
        statement.setInt(1 , moviesId);
        statement.setInt(2, idUser);
        statement.executeUpdate();
    }

    public List<Playlist> findByUserID(int userId){
        List<Playlist> playlists = new ArrayList<>();

        try{
            PreparedStatement movieStatement = connection.prepareStatement("select moviesId from playlist where userId = ?");
            movieStatement.setInt(1, userId);

            ResultSet result = movieStatement.executeQuery();
            while (result.next()){
                Playlist playlist = new Playlist();
                playlist.setUserId(result.getInt("userId"));
                playlist.setMovieId(result.getInt("moviesId"));
                playlists.add(playlist);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return playlists;
    }

    public ArrayList<Film> getFilmsForUser(int userId) {

        ArrayList<Film> movies = new ArrayList<>();

        try (
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM playlist WHERE userId = ?;    ")) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int movieId = resultSet.getInt("movieId");
                Film movie = moviesDao.getMovieById(movieId);
                movies.add(movie);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    @Override
    public Playlist find(int id) {
        return null;
    }

    @Override
    public ArrayList<Playlist> findAll() {
        return null;
    }
}
