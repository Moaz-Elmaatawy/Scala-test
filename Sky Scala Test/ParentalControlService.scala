import scala.util.{Failure, Success}

class ParentalControlService {

  val level = Map("U" -> 0,"PG" -> 1, "12"-> 2, "15"-> 3, "18"-> 4)
  val MovieService = new MovieServiceClass

  def canWatch(PCL : String, PCLPreference : String): String={
    if(level(PCL) <= level(PCLPreference))
      "You Can Watch This Movie"
    else
      "You Cannot Watch This Movie"
  }

  def handleFailure(f: Throwable): String = {
    if(f.getMessage.compareTo("TitleNotFound")==0)
      "Title Not Found, This Movie Not Found"
    else
      "sorry you cannot watch this movie"
  }

  // The method the client call
  def watchMovie(PCLPreference : String, movieId: String) : String ={

      try(MovieService.getParentalControlLevel(movieId)) match{
        case Success(parentalControlLevel) => canWatch(parentalControlLevel,PCLPreference)
        case Failure(f) => handleFailure(f)
      }

    }
}
