

  case class ThingyRequest[A](thingy: Thingy, request: RequestContext) extends WrappedRequest(request)

  object ThingyAction {

    class ThingyActionBuilder(thingyId: Long) extends ActionBuilder[ThingyRequest] {
      
      def invokeBlock[A](request: Request[A], block: (ThingyRequest[A]) => Future[Result]): Future[Result] = {
        val maybeThingy = thingyDao.findByThingyId(thingyId)
        maybeThingy match {
          case Some(thingy) => block(ThingyRequest(thingy, RequestContext(request)))
          case None => Future.successful(NoContent)
        }
      }
    }

    def apply(thingyId: Long): ThingyActionBuilder = {
      new ThingyActionBuilder(bookingId)
    }
  }

  def index(thingyId: Long) = ThingyAction(bookingId) { thingyRequest: ThingyRequest[AnyContent] =>
    implicit val request = thingyRequest.request
    showIndexPage(thingyRequest.thingy)
  }
  