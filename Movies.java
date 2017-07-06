
public class Movies {

	
	private String[] moviesList = {"The Mummy","Wonder Woman","Baywatch","Jumanji"}; //List of movies
	
	void DisplayMovies() {
		
		System.out.println("List of movies currently playing: ");
		
		for(int i=0; i<moviesList.length; i++)
			System.out.println( (i+1) + ". " + moviesList[i]); // starting list from 1 onwards.
		
	}

	public String[] getMoviesList() {
		return moviesList;
	}
	
}

