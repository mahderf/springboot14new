package springboot14.mahi.springboot14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot14.mahi.springboot14.models.Director;
import springboot14.mahi.springboot14.repository.DirectorRepository;
import springboot14.mahi.springboot14.models.Movie;
import springboot14.mahi.springboot14.repository.MovieRepository;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectorRepository directorRepository;
    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model){
        // First let's create a director
        model.addAttribute("director", new  Director());
//        Director director = new Director();
//        director.setName("Stephen Bullock");
//        director.setGenre("Sci Fi");

        // Now let's create a movie
//        Movie movie = new Movie();
//        movie.setTitle("Star Movie");
//        movie.setYear(2017);
//        movie.setDescription("About Stars...");

        // Add the movie to an empty list
//        Set<Movie> movies = new HashSet<Movie>();
//        movies.add(movie);

//        movie = new Movie();
//        movie.setTitle("DeathStar Ewoks");
//        movie.setYear(2011);
//        movie.setDescription("About Ewoks on the DeathStar...");
//        movies.add(movie);

        // Add the list of movies to the director's movie list
//        director.setMovies(movies);

        // Save the director to the database
//        directorRepository.save(director);

        // Grad all the directors from the database and send them to
        // the template
//        model.addAttribute("directors", directorRepository.findAll());
        return "getdirector";
    }

    @PostMapping("/")
    public String postMovie(@ModelAttribute ("director") Director otherdirector,Movie movies){
     directorRepository.save(otherdirector);
     return"postdirector";
    }

    @RequestMapping("/addmovie/{id}")
    public String getMovie(@PathVariable("id") long id,Model model){

            Movie movie = new Movie();
            movie.setDirector(directorRepository.findOne(id));
           model.addAttribute("movie", movie);
           return"getmovie";
    }
    @PostMapping("/addmovie")
    public String postMovie(@ModelAttribute("movie") Movie othermovie,
                            Model model)
    {
       movieRepository.save(othermovie);
        return "postmovie";
    }

    @GetMapping("/listmovies")
    public String showMovies(Model model){
        model.addAttribute("movie", movieRepository.findAll());
        return "listmovies";
    }
    @GetMapping("/detaildirector/{id}")
    public String showDirector(@PathVariable("id") long id, Model model){

        model.addAttribute("director", directorRepository.findOne(id));
        model.addAttribute("movie",movieRepository.findOne(id));
        return "detaildirector";
    }
    @GetMapping("/listdirectors")
    public String showDirector(Model model){
        model.addAttribute("director", directorRepository.findAll());
        return "listdirectors";
    }
    @GetMapping("/detailmovie/{id}")
    public String showMovies(@PathVariable("id") long id, Model model){

        model.addAttribute("movie", movieRepository.findAllByIdIs(id));
        model.addAttribute("director", directorRepository.findAllByIdIs(id));

        return "detailmovie";
    }
}