package controllers

import org.joda.time.DateTime
import com.github.nscala_time.time.Imports._
import play.api.mvc.{Action, Controller}
import com.typesafe.config.ConfigFactory


object Application extends Controller {

  val millisPerDay = 24 * 60 * 60 * 1000

  val date0 = new DateTime("2014-03-30")
  val date1 = new DateTime("2014-06-12")
  val date2 = new DateTime("2014-06-27")

  val conf = ConfigFactory.load()

  def index = Action {

    val header: String = conf.getBoolean("forward") match {
      case true => (DateTime.now to date1).millis / millisPerDay + " days to"
      case false => (date0 to DateTime.now).millis / millisPerDay + " days since"
    }

    Ok(views.html.index(header))
  }
}