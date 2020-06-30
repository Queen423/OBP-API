package code.model.dataAccess.internalMapping

import com.openbankproject.commons.model.BankId

/**
 * This trait is used for storing the mapped between obp bank_id and bank real id reference.
 * BankPlainTextReference is just a plain text from bank. Bank need to prepare it.
 *
 * eg: Once we create the bank over CBS, we need also create a BankId in api side.
 * For security reason, we can only use the BankId in the apis.
 * Because these id’s might be cached on the internet.
 */
trait BankIdMappingT {
  /**
   * This is the obp Bank id.
   *
   * @return
   */
  def bankId: BankId

  /**
   * This is the bank plain text string, need to be unique for each bank. ( Bank need to take care of it)
   *
   * @return It can be concatenated of real bank data:
   *         eg: bankPlainTextReference =  bicSwift
   */
  def bankPlainTextReference: String
}