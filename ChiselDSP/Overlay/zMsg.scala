/** Useful console status shorthand */

package ChiselDSP
import Chisel._

/** Red error message on console with [optional] stack trace. Throws exception. */
object Error {

  /** Turn on/off stack trace on error to better track problems */
  var dumpStack = true
  
  def apply(msg: String): Bool = {
    if (dumpStack) {println(Console.RED + "@["); Thread.dumpStack(); println("]" + Console.RESET)}
    throwException(Console.RED + msg + Console.RESET)
    Bool(false)
  }
  
}

/** [optional] Bold, Red warning message on console with [optional] stack trace. Does not throw exception. */
object Warn {

  /** Turn on/off stack trace on warning to better track potential problems */
  var dumpStack = false
  
  def apply(msg: String, bold: Boolean = false): Unit = {
    val format = Console.RED + {if (bold) Console.BOLD else ""}
    println(format + msg + Console.RESET)
    if (dumpStack) {println(format + "@["); Thread.dumpStack(); println("]" + Console.RESET)}
  }
}

/** [optional] Bold, Blue console message */
object Status {
  def apply(msg: String, bold: Boolean = false): Unit = {
    val format = Console.BLUE + {if (bold) Console.BOLD else ""}
    println(format + msg + Console.RESET)
  }
}
