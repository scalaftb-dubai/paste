package controllers

import play.api._
import play.api.mvc._
import models.Paste
import java.util.UUID
import models.PasteMapDAO
import models.PasteElastic4sDAO

object Application extends Controller {

//  val dao = PasteMapDAO()
  val dao = PasteElastic4sDAO()
  
  def paste = Action {
    Ok(views.html.paste())
  }

  def index(content: Option[String], id: Option[String]) = Action {
    val paste = dao.getOrCreate(id, content)
    Ok(views.html.index("Your new application is ready.", paste))
  }
 
}