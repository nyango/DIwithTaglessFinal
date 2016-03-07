package models

import play.api.libs.ws.WSSignatureCalculator

trait UseOAuthCred {
  val cred: WSSignatureCalculator
}
