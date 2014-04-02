package controllers

import org.joda.time.DateTime
import com.github.nscala_time.time.Imports._
import play.api.mvc.{Action, Controller}


object Application extends Controller {

  val millisPerDay  =  24 * 60 * 60 * 1000
  val date1 = new DateTime("2014-06-12")
  val date2 = new DateTime("2014-06-27")

  def index = Action {

    Ok(views.html.index((DateTime.now to date1).millis / millisPerDay + " days to"))
  }
}