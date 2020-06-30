package code.model.dataAccess.internalMapping

import code.util.MappedUUID
import com.openbankproject.commons.model.BankId
import net.liftweb.mapper._

class BankIdMapping extends BankIdMappingT with LongKeyedMapper[BankIdMapping] with IdPK with CreatedUpdated {

  def getSingleton = BankIdMapping

  override def bankId = BankId(mBankId.get)

  override def bankPlainTextReference = mBankPlainTextReference.get

  object mBankId extends MappedUUID(this)

  object mBankPlainTextReference extends MappedString(this, 255)

}


object BankIdMapping extends BankIdMapping with LongKeyedMetaMapper[BankIdMapping] {
  //one bank info per bank for each api user
  override def dbIndexes = UniqueIndex(mBankId) :: UniqueIndex(mBankId, mBankPlainTextReference) :: super.dbIndexes
}

