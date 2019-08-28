package code.customer.internalMapping

import code.util.Helper.MdcLoggable
import com.openbankproject.commons.model.{BankId, CustomerId}
import net.liftweb.common._
import net.liftweb.mapper.By


object MappedCustomerIdMappingProvider extends CustomerIdMappingProvider with MdcLoggable
{

  override def getOrCreateCustomerId(
    customerReference: String
  ) =
  {

    val mappedCustomerIdMapping = MappedCustomerIdMapping.find(
      By(MappedCustomerIdMapping.mCustomerReference, customerReference)
    )

    mappedCustomerIdMapping match
    {
      case Full(vImpl) =>
      {
        logger.debug(s"getOrCreateCustomerId --> the mappedCustomerIdMapping has been existing in server !")
        mappedCustomerIdMapping.map(_.customerId)
      }
      case Empty =>
      {
        val mappedCustomerIdMapping: MappedCustomerIdMapping =
          MappedCustomerIdMapping
            .create
            .mCustomerReference(customerReference)
            .saveMe
        logger.debug(s"getOrCreateCustomerId--> create mappedCustomerIdMapping : $mappedCustomerIdMapping")
        Full(mappedCustomerIdMapping.customerId)
      }
      case Failure(msg, t, c) => Failure(msg, t, c)
      case ParamFailure(x,y,z,q) => ParamFailure(x,y,z,q)
    }
  }


  override def getCustomerReference(customerId: CustomerId) = {
    MappedCustomerIdMapping.find(
      By(MappedCustomerIdMapping.mCustomerId, customerId.value),
    ).map(_.customerPlainTextReference)
  }
}

