package controllers

import play.api._
import play.api.mvc._
import models.Paste
import java.util.UUID

object Application extends Controller {

  val pastes = scala.collection.mutable.Map[UUID, Paste]()
 
  def paste = TODO

  def index(content: Option[String], id: Option[String]) = Action {
    val pasteId = if (id.isDefined) UUID.fromString(id.get) else UUID.randomUUID
    val paste = pastes.getOrElse(pasteId, {
    	val newPaste = Paste(content getOrElse("No paste"), pasteId)
    	pastes += pasteId -> newPaste
    	newPaste
    })
    Ok(views.html.index("Your new application is ready.", paste))
  }
 
}