package models

import java.util.UUID

case class Paste(content:String, id: UUID = UUID.randomUUID)