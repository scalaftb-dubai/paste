package models

import java.util.UUID

trait PasteDAO {

  def getOrCreate(id: Option[String], content: Option[String]): Paste

  def newPaste(id: UUID, content: Option[String]) = Paste(content getOrElse ("No paste"), id)

  def getRandomIdIfNone(id: Option[String]) = id match {
    case Some(s) => UUID.fromString(s)
    case None => UUID.randomUUID
  }

}