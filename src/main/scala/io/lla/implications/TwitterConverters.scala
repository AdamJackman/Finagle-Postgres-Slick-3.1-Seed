package io.lla.implications

import com.twitter.util.{Promise, Return, Throw, Future => twitterFuture, Try => twitterTry}

import scala.concurrent.{ExecutionContext, Future => scalaFuture}
import scala.util.{Failure, Success, Try => scalaTry}

/**
  * Slick 3.1 likes to use Scala Futures.
  * Everything else uses Twitter Futures.
  * This should be imported By Slick DAOs so everything else is happy
  */
object TwitterConverters {
  implicit def scalaTryToTwitterTry[T](t: scalaTry[T]): twitterTry[T] = t match {
    case Success(r) => Return(r)
    case Failure(ex) => Throw(ex)
  }

  implicit def scalaFutureToTwitterFuture[T](f: scalaFuture[T])(implicit ec: ExecutionContext): twitterFuture[T] = {
    val promise = Promise[T]()
    f.onComplete(promise.update(_))
    promise
  }
}
