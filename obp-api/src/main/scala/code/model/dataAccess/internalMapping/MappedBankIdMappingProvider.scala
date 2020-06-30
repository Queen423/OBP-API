package code.model.dataAccess.internalMapping

import code.util.Helper.MdcLoggable
import com.openbankproject.commons.model.BankId
import net.liftweb.common._
import net.liftweb.mapper.By


object MappedBankIdMappingProvider extends BankIdMappingProvider with MdcLoggable {

  override def getOrCreateBankId(
                                  bankPlainTextReference: String
                                ): Box[BankId] = {

    val mappedBankIdMapping = BankIdMapping.find(
      By(BankIdMapping.mBankPlainTextReference, bankPlainTextReference)
    )

    mappedBankIdMapping match {
      case Full(vImpl) => {
        logger.debug(s"getOrCreateBankId --> the mappedBankIdMapping has been existing in server !")
        mappedBankIdMapping.map(_.bankId)
      }
      case Empty => {
        val mappedBankIdMapping: BankIdMapping =
          BankIdMapping
            .create
            .mBankPlainTextReference(bankPlainTextReference)
            .saveMe
        logger.debug(s"getOrCreateBankId--> create mappedBankIdMapping : $mappedBankIdMapping")
        Full(mappedBankIdMapping.bankId)
      }
      case Failure(msg, t, c) => Failure(msg, t, c)
      case ParamFailure(x, y, z, q) => ParamFailure(x, y, z, q)
    }
  }


  override def getBankPlainTextReference(bankId: BankId) = {
    BankIdMapping.find(
      By(BankIdMapping.mBankId, bankId.value),
    ).map(_.bankPlainTextReference)
  }
}

