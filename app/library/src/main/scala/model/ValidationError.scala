package library.model

trait Error {

  def validationError[T](error: T): String = {
    s"Cannot be implemented because the argument was ${error}"
  }
}
