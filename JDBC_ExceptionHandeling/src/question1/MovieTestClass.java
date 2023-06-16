package question1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MovieTestClass {
	
	public static Movie getMovie(Date givenReleaseDate,List<Movie> mlist) {
		Movie movie=mlist.stream().filter(obj -> obj.getReleaseDate().equals(givenReleaseDate)).findAny().orElse(null);
		return movie;
	}
	
	public static List<Movie> getMovie(boolean givenStatus,List<Movie> mlist) {
		return mlist.stream().filter(obj-> obj.isStatus()==givenStatus).collect(Collectors.toList());
	}
	
	public static List<Movie> getMovie(long givenProductionCost,List<Movie> mlist) {
		return mlist.stream().filter(obj-> obj.getProductionCost()>=100000000).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		
		ArrayList<Movie> movieList= new ArrayList<Movie>();
		Movie m1=new Movie();
		
		String date = "15-02-2000";
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Date releaseDate = null;
		try {
			releaseDate = sdf.parse(date);
		} catch (ParseException pe) {
			System.out.println("Error occurred in parsing the date");
		}
		
		Movie m2= new Movie("Sanam Teri Kasam",releaseDate,false);
		m2.setProductionCost(1000000000);
		m2.setDirectedBy("Prince");
		m2.setNoOfScreenReleased(2000);
		m2.setProducedBy("Dinesh Vijan");
		
		Movie m3= new Movie("Doctor Strange",releaseDate,false);
		m2.setProductionCost(1000000000);
		m2.setDirectedBy("Russo Brothers");
		m2.setNoOfScreenReleased(20000);
		m2.setProducedBy("Marvel Studio");
		
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		
		Movie movieAtSpecificDate=getMovie(releaseDate, movieList);
		System.out.println("Get Method for release Date(): "+movieAtSpecificDate);
		
		List<Movie> moviesAtSpecificCost=getMovie(1000000000, movieList);
		System.out.println("Get Method for production Cost: "+moviesAtSpecificCost);
		
		List<Movie> movieAtSpecificStatus=getMovie(false, movieList);
		System.out.println("Get Method for status: "+movieAtSpecificStatus);
		
		
		
		

	}

}
