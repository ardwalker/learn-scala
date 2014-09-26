

/** 
 * Wanted to access members of the Pricing object so they can all be formatted the same way,
 * while reducing duplication.
 */

case class Pricing(subtotal: Option[Money], total: Option[Money], baseAmount: Option[Money], tax: Option[Money]){
}
 
 
case class ModificationInfo(..., chargeInfo: Option[Pricing]) {
  def formatter = new Formatter(this)
}
 
 
 
class Formatter(info: ModificationInfo) {
 
  def asMoneyString(fn: Pricing => Option[Money]): String = {
    info.chargeInfo match {
      case Some(charge) => fn(charge) match {
        case Some(money) => money.toString
        case None => ""
      }
      case None => ""
    }
  }
 
  def total      = asMoneyString(_.total)
 
  def subtotal   = asMoneyString(_.subtotal)
 
  def baseAmount = asMoneyString(_.baseAmount)
 
  def tax        = asMoneyString(_.tax)
 
}

