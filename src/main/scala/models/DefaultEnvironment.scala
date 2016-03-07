package models

import akka.actor.Actor
import akka.stream.ActorMaterializer
import play.api.libs.oauth.{ConsumerKey, OAuthCalculator, RequestToken}
import play.api.libs.ws.ahc.{AhcConfigBuilder, AhcWSClient}

object DefaultEnvironment extends Actor {
  val config  = new AhcConfigBuilder().build()
  val c       = new AhcWSClient(config)(ActorMaterializer())


  val defaultEnvironment = new UseWSClient with UseOAuthCred {
    override val client = c
    override val cred = OAuthCalculator(
      ConsumerKey(
        "key",
        "secret"
      ),
      RequestToken(
        "token",
        "secret"
      )
    )
  }

  override def receive: Receive = ???
}