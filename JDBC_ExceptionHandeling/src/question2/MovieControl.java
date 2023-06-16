package question2;

import java.util.List;
import java.util.Scanner;

public class MovieControl {

	public List<Movie> getAllMovie() {
		MovieDao movieDao = new MovieDao();
		List<Movie> allMovie = movieDao.getAllMovie();
		return allMovie;
	}

	public Movie getMovie(String name) {
		List<Movie> movieList = getAllMovie();
		return movieList.stream().filter(obj -> obj.getMovieName().equals(name)).findAny().orElse(null);
	}

	public Movie getMovie(long productionCost) {
		List<Movie> movieList = getAllMovie();
		return movieList.stream().filter(obj -> obj.getMovieName().equals(productionCost)).findAny().orElse(null);
	}

	public Movie getMovie(java.util.Date date) {
		List<Movie> movieList = getAllMovie();
		String d = date.toString();
		return movieList.stream().filter(obj -> obj.getReleaseDate().equals(d)).findAny().orElse(null);
	}

	public void insertMovie() throws ShorterMovieNameException, lesserProductionCostException {
		String movieName, date, directedBy, producedBy;
		long productionCost;
		int noOfScreen;
		boolean status, isEverythingOkay = true;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter then Movie name: ");
		movieName = scanner.nextLine();

		System.out.println("Enter then Movie release date:(dd-mm-yyyy) ");
		date = scanner.next();
		System.out.println("Enter then Movie production cost: ");
		productionCost = scanner.nextInt();
		System.out.println("Enter then number of screen on which it get's released: ");
		noOfScreen = scanner.nextInt();
		// moving cursor to next line
		scanner.nextLine();
		System.out.println("Enter then Movie director's name: ");
		directedBy = scanner.nextLine();
		System.out.println("Enter then Movie producer's name: ");
		producedBy = scanner.nextLine();
		System.out.println("Enter then Movie status: ");
		status = scanner.nextBoolean();

		if (movieName.length() <= 3) {
			throw new ShorterMovieNameException("Renter the Movie name");
		}
		movieName = scanner.nextLine();
		if (productionCost < 100000000) {
			throw new lesserProductionCostException("Reenter the production cost");
		}

		Movie movie = new Movie(movieName, date, productionCost, noOfScreen, directedBy, producedBy, status);
		MovieDao movieDao = new MovieDao();
		movieDao.insertMovie(movie);
	}
	
	
	public void deleteMovie(String moviename) {
		MovieDao movieDao=new MovieDao();
		movieDao.deleteRecord(moviename);
	}
	

	public static void main(String[] args) {
		System.out.println("***********Welcome to IMDB Database Store***********");

		MovieControl movieControl = new MovieControl();
		MovieDao movieDao = new MovieDao();

		movieDao.createTable();
		
		System.out.println("Insert operation starting: ");
		try {
			movieControl.insertMovie();
			System.out.println("Insert operation done");
		} catch (ShorterMovieNameException e) {
			e.printStackTrace();
		} catch (lesserProductionCostException e) {
			e.printStackTrace();
		}

		List<Movie> ml = movieControl.getAllMovie();
		for (Movie m1 : ml) {
			System.out.println(m1);
		}

		// movieDao.deleteRecord("PK");

	}

}
