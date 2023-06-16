package question2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * this class contains the method for querying the database
 * for better visibility and control i have separated these methods in a DAO class
 * 
 * */
public class MovieDao {
	public void createTable() {

		try {
			Connection connection = CP.createConnection();
			Statement statement = connection.createStatement();

			String create_table_query = "create table movie_table(movieName varchar(30) primary key,releaseDate varchar(20) not null,productionCost long not null,noOfScreen int not null,directedBy varchar(30) not null,producedBy varchar(30) not null,status varchar(5) not null);";

			statement.executeUpdate(create_table_query);
			System.out.println("Table Created....");
			connection.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void insertMovie(Movie movie) {

		try {
			Connection connection = CP.createConnection();
			connection.setAutoCommit(false);
			String insert_query = "insert into movie_table(movieName,releaseDate,productionCost,noOfScreen,directedBy,producedBy,status) values(?,?,?,?,?,?,?)";
			PreparedStatement pstmt = connection.prepareStatement(insert_query);
			pstmt.setString(1, movie.getMovieName());
			pstmt.setString(2, movie.getReleaseDate());
			pstmt.setLong(3, movie.getProductionCost());
			pstmt.setInt(4, movie.getNoOfScreenReleased());
			pstmt.setString(5, movie.getDirectedBy());
			pstmt.setString(6, movie.getProducedBy());
			String status = movie.isStatus() ? "true" : "false";
			pstmt.setString(7, status);

			pstmt.execute();
			connection.commit();
			connection.close();

			System.out.println("one Record Inserted");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// method for deleting the records

	public void deleteRecord(String movieName) {
		String delete_query = "delete from movie_table where movieName=?";
		Connection con = CP.createConnection();
		PreparedStatement st;
		try {
			st = con.prepareStatement(delete_query);
			st.setString(1, movieName);
			st.executeUpdate();
			st.close();
			con.close();
			System.out.println("Record deleted successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// from here Assignment specific method regarding class are going on
	public static List<Movie> getAllMovie() {
		Connection con = CP.createConnection();
		ResultSet rs;
		PreparedStatement pt;
		List<Movie> m = new ArrayList<>();
		try {
			pt = con.prepareStatement("Select * from movie_table;");
			rs = pt.executeQuery();
			while (rs.next()) {
				boolean b = false;
				if (rs.getString(7).equals("true")) {
					b = true;
				}
				Movie m1 = new Movie(rs.getString(1), rs.getString(2), rs.getLong(3), rs.getInt(4), rs.getString(5),
						rs.getString(6), b);
				m.add(m1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return m;
	}

}
