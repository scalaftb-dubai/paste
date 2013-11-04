package models

import java.util.UUID

case class PasteMapDAO() extends PasteDAO {

  val pastes = scala.collection.mutable.Map[UUID, Paste]()

  override def getOrCreate(id: Option[String], content: Option[String]): Paste = {
    val pasteId = getRandomIdIfNone(id)
    pastes.getOrElse(pasteId, {
      val paste = newPaste(pasteId, content)
      pastes += pasteId -> paste
      paste
    })
  }

}