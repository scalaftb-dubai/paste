package models

import com.sksamuel.elastic4s.ElasticClient
import com.sksamuel.elastic4s.ElasticDsl._
import java.util.UUID

case class PasteElastic4sDAO() extends PasteDAO {

  val IndexName = "sftb"
  val TypeName = "pastes"
  val IdField = "_id"
  val ContentField = "content"
  val client = ElasticClient.local

  override def getOrCreate(id: Option[String], content: Option[String]): Paste = id match {
    case Some(sId) => { //id defined
      val pasteId = UUID.fromString(sId)
      val resp = client.sync.search(search in IndexName -> TypeName query { term(IdField, id.get) })
      if (resp.getHits.totalHits == 1) { //id found
        newPaste(pasteId, Option(resp.getHits.getAt(0).field(ContentField).value))
      } else { //paste with that id doesn't exist
        val paste = newPaste(pasteId, content)
        content match {
          case Some(sContent) => { //new content with defined id
            create(sId, sContent)
            paste

          }
          case None => //no content, no paste persisted
            paste
        }
      }
    }
    case None => { //no id defined
      val paste = newPaste(getRandomIdIfNone(id), content)
      if (content.isDefined) { //persist new paste if content is present
        create(paste.id.toString, content.get)
      }
      paste
    }
  }

  def create(id: String, content: String) {
    client.execute {
      index into s"$IndexName/$TypeName" fields (
        IdField -> id,
        ContentField -> content)
    }
  }
}
