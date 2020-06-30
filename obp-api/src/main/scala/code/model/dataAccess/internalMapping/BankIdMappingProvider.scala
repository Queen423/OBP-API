package code.model.dataAccess.internalMapping

import com.openbankproject.commons.model.BankId
import net.liftweb.common.Box
import net.liftweb.util.SimpleInjector


object BankIdMappingProvider extends SimpleInjector {

  val bankIdMappingProvider = new Inject(buildOne _) {}

  def buildOne: BankIdMappingProvider = MappedBankIdMappingProvider

}

trait BankIdMappingProvider {

  def getOrCreateBankId(bankPlainTextReference: String): Box[BankId]

  def getBankPlainTextReference(bankId: BankId): Box[String]

}


