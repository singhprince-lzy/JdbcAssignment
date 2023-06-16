package question1;

import java.util.Date;

public class Movie {
	public String movieName;
	public Date releaseDate;
	public int productionCost;
	public int noOfScreenReleased;
	public String directedBy;
	public String producedBy;
	public boolean status;

	public Movie(String movieName, Date releaseDate, boolean status) {
		super();
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.status = status;
	}

	public Movie(String movieName, int productionCost, String directedBy) {
		super();
		this.movieName = movieName;
		this.productionCost = productionCost;
		this.directedBy = directedBy;
	}

	public Movie() {
		this.movieName = "PK";
		this.productionCost = 100000000;
		this.noOfScreenReleased = 2000;
		this.directedBy = "RajKumar Hirani";
		this.producedBy = "Manish Shah";
		this.status = true;
		this.releaseDate = new Date();
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getProductionCost() {
		return productionCost;
	}

	public void setProductionCost(int productionCost) {
		this.productionCost = productionCost;
	}

	public int getNoOfScreenReleased() {
		return noOfScreenReleased;
	}

	public void setNoOfScreenReleased(int noOfScreenReleased) {
		this.noOfScreenReleased = noOfScreenReleased;
	}

	public String getDirectedBy() {
		return directedBy;
	}

	public void setDirectedBy(String directedBy) {
		this.directedBy = directedBy;
	}

	public String getProducedBy() {
		return producedBy;
	}

	public void setProducedBy(String producedBy) {
		this.producedBy = producedBy;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", releaseDate=" + releaseDate + ", productionCost=" + productionCost
				+ ", noOfScreenReleased=" + noOfScreenReleased + ", directedBy=" + directedBy + ", producedBy="
				+ producedBy + ", status=" + status + "]";
	}
	
	

}
