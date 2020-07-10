package code.api.util


import code.api.util.APIUtil.parseDate
import net.liftweb.json.JsonDSL._
import code.api.util.Glossary.{glossaryItems, makeGlossaryItem}
import code.dynamicEntity.{DynamicEntityDefinition, DynamicEntityFooBar, DynamicEntityFullBarFields, DynamicEntityIntTypeExample, DynamicEntityStringTypeExample}
import com.openbankproject.commons.model.enums.DynamicEntityFieldType
import com.openbankproject.commons.util.ReflectUtils
import net.liftweb.json
import net.liftweb.json.JObject

case class ConnectorField(value: String, description: String) {

  //    def valueAndDescription: String = {
  //      s"${value} : ${description}".toString
  //    }

}
object ExampleValue {


  lazy val bankIdGlossary = glossaryItems.find(_.title == "Bank.bank_id").map(_.textDescription)

  lazy val bankIdExample = ConnectorField("gh.29.uk", s"A string that MUST uniquely identify the bank on this OBP instance. It COULD be a UUID but is generally a short string that easily identifies the bank / brand it represents.")
  lazy val bank_idExample = bankIdExample

  lazy val accountIdExample = ConnectorField("8ca8a7e4-6d02-40e3-a129-0b2bf89de9f0", s"A string that, in combination with the bankId MUST uniquely identify the account on this OBP instance. SHOULD be a UUID. MUST NOT be able to guess accountNumber from accountId. OBP-API or Adapter keeps a mapping between accountId and accountNumber. AccountId is a non reversible hash of the human readable account number.")
  lazy val account_idExample = accountIdExample


  lazy val accountNumberExample = ConnectorField("546387432", s"A human friendly string that identifies the account at the bank, possibly in combination with the branch and account type.")

  lazy val sessionIdExample = ConnectorField("b4e0352a-9a0f-4bfa-b30b-9003aa467f50", s"A string that MUST uniquely identify the session on this OBP instance, can be used in all cache. ")

  lazy val userIdExample = ConnectorField("9ca9a7e4-6d02-40e3-a129-0b2bf89de9b1", s"A string that MUST uniquely identify the user on this OBP instance.")
  glossaryItems += makeGlossaryItem("User.userId", userIdExample)


  lazy val usernameExample = ConnectorField("felixsmith", s"The username the user uses to authenticate.")
  glossaryItems += makeGlossaryItem("User.username", usernameExample)

  lazy val passwordExample = ConnectorField("password", s"The password the user uses to authenticate.")
  glossaryItems += makeGlossaryItem("User.password", passwordExample)
  
  
  lazy val userNameExample = ConnectorField("felixsmith", s"The userName the user uses to authenticate.")
  glossaryItems += makeGlossaryItem("User.userNameExample", userNameExample)

  lazy val correlationIdExample = ConnectorField("1flssoftxq0cr1nssr68u0mioj", s"A string generated by OBP-API that MUST uniquely identify the API call received by OBP-API. Used for debugging and logging purposes. It is returned in header to the caller.")
  glossaryItems += makeGlossaryItem("API.correlation_id", correlationIdExample)


  lazy val customerIdExample = ConnectorField("7uy8a7e4-6d02-40e3-a129-0b2bf89de8uh", s"A non human friendly string that identifies the customer and is used in URLs. This SHOULD NOT be the customer number. The combination of customerId and bankId MUST be unique on an OBP instance. customerId SHOULD be unique on an OBP instance. Ideally customerId is a UUID. A mapping between customer number and customer id is kept in OBP.")
  glossaryItems += makeGlossaryItem("Customer.customerId", customerIdExample)

  lazy val customerAttributeId = ConnectorField("7uy8a7e4-6d02-40e3-a129-0b2bf89de8uh", s"A non human friendly string that identifies the customer and is used in URLs. This SHOULD NOT be the customer number. The combination of customerId and bankId MUST be unique on an OBP instance. customerId SHOULD be unique on an OBP instance. Ideally customerId is a UUID. A mapping between customer number and customer id is kept in OBP.")
  glossaryItems += makeGlossaryItem("Customer.customerAttributeId", customerAttributeId)

  lazy val customerAttributeName = ConnectorField("7uy8a7e4-6d02-40e3-a129-0b2bf89de8uh", s"A non human friendly string that identifies the customer and is used in URLs. This SHOULD NOT be the customer number. The combination of customerId and bankId MUST be unique on an OBP instance. customerId SHOULD be unique on an OBP instance. Ideally customerId is a UUID. A mapping between customer number and customer id is kept in OBP.")
  glossaryItems += makeGlossaryItem("Customer.customerId", customerAttributeName)

  lazy val customerAttributeType = ConnectorField("7uy8a7e4-6d02-40e3-a129-0b2bf89de8uh", s"A non human friendly string that identifies the customer and is used in URLs. This SHOULD NOT be the customer number. The combination of customerId and bankId MUST be unique on an OBP instance. customerId SHOULD be unique on an OBP instance. Ideally customerId is a UUID. A mapping between customer number and customer id is kept in OBP.")
  glossaryItems += makeGlossaryItem("Customer.customerId", customerAttributeType)

  lazy val customerAttributeValue = ConnectorField("7uy8a7e4-6d02-40e3-a129-0b2bf89de8uh", s"A non human friendly string that identifies the customer and is used in URLs. This SHOULD NOT be the customer number. The combination of customerId and bankId MUST be unique on an OBP instance. customerId SHOULD be unique on an OBP instance. Ideally customerId is a UUID. A mapping between customer number and customer id is kept in OBP.")
  glossaryItems += makeGlossaryItem("Customer.customerId", customerAttributeValue)

  lazy val consumerIdExample = ConnectorField("7uy8a7e4-6d02-40e3-a129-0b2bf89de8uh", s"A non human friendly string that identifies the consumer. It is the app which calls the apis")
  glossaryItems += makeGlossaryItem("Customer.customerId", consumerIdExample)
  
  lazy val nameSuffixExample = ConnectorField("Sr", s"suffix of the name")
  glossaryItems += makeGlossaryItem("Customer.nameSuffix", nameSuffixExample)

  lazy val titleExample = ConnectorField("Dr.", s"title of the name")
  glossaryItems += makeGlossaryItem("Customer.title", titleExample)
  
  lazy val highestEducationAttainedExample = ConnectorField("Master", s"highest education attained")
  glossaryItems += makeGlossaryItem("Customer.highestEducationAttained", highestEducationAttainedExample)
  
  lazy val employmentStatusExample = ConnectorField("worker", s"employment status")
  glossaryItems += makeGlossaryItem("Customer.employmentStatus", employmentStatusExample)
  
  lazy val relationshipStatusExample = ConnectorField("single", s"relationship status")
  glossaryItems += makeGlossaryItem("Customer.relationshipStatus", relationshipStatusExample)
  
  lazy val dependentsExample = ConnectorField("1", s"the number of dependents")
  glossaryItems += makeGlossaryItem("Customer.dependents", dependentsExample)
  
  lazy val kycStatusExample = ConnectorField("true", s"This is boolean to indicate if the cusomter's KYC has been checked.") 
  glossaryItems += makeGlossaryItem("Customer.kycStatus", kycStatusExample)
  
  lazy val urlExample = ConnectorField("http://www.example.com/id-docs/123/image.png", s"The URL ") 
  glossaryItems += makeGlossaryItem("Customer.url", urlExample)
  
  lazy val customerNumberExample = ConnectorField("5987953", s"The human friendly customer identifier that MUST uniquely identify the Customer at the Bank ID. Customer Number is NOT used in URLs.")
  glossaryItems += makeGlossaryItem("Customer.customerNumber", customerNumberExample)

  lazy val customerAttributeIdExample = ConnectorField("7uy8a7e4-6d02-40e3-a129-0b2bf89de8uh", s"Customer attribute id")
  glossaryItems += makeGlossaryItem("Customer.attributeId", customerAttributeIdExample)
  
  lazy val customerAttributeNameExample = ConnectorField("SPECIAL_TAX_NUMBER", s"Customer attribute name")
  glossaryItems += makeGlossaryItem("Customer.attributeName", customerAttributeNameExample)
  
  lazy val templateAttributeNameExample = ConnectorField("SPECIAL_TAX_NUMBER", s"Attribute name")
  glossaryItems += makeGlossaryItem("Template.attributeName", templateAttributeNameExample)

  lazy val customerAttributeTypeExample = ConnectorField("STRING", s"Customer attribute type.")
  glossaryItems += makeGlossaryItem("Customer.attributeType", customerAttributeTypeExample)
  
  lazy val templateAttributeTypeExample = ConnectorField("STRING", s"Attribute type.")
  glossaryItems += makeGlossaryItem("Template.attributeType", templateAttributeTypeExample)
  
  lazy val attributeAliasExample = ConnectorField("STRING", s"Customer attribute alias.")
  glossaryItems += makeGlossaryItem("Customer.attributeAlias", attributeAliasExample)

  lazy val customerAttributeValueExample = ConnectorField("123456789", s"Customer attribute value.")
  glossaryItems += makeGlossaryItem("Customer.attributeValue", customerAttributeValueExample)
  
  lazy val labelExample = ConnectorField("My Account", s"A lable that describes the Account")
  lazy val legalNameExample = ConnectorField("Eveline Tripman", s"The legal name of the Customer.")
  glossaryItems += makeGlossaryItem("Customer.legalName", legalNameExample)
  
  lazy val mobileNumberExample = ConnectorField("+44 07972 444 876", s"The mobile number name of the Customer.")
  glossaryItems += makeGlossaryItem("Customer.mobileNumber", mobileNumberExample)
  
  lazy val ratingExample = ConnectorField("", s".")
  glossaryItems += makeGlossaryItem("Customer.Credit.rating", ratingExample)
  
  lazy val sourceExample = ConnectorField("", s".")
  glossaryItems += makeGlossaryItem("Customer.Credit.source", sourceExample)
  

  lazy val cbsTokenExample = ConnectorField("FYIUYF6SUYFSD", s"A token provided by the Gateway for use by the Core Banking System")
  glossaryItems += makeGlossaryItem("Adapter.cbsToken", cbsTokenExample)

  lazy val counterpartyIdExample = ConnectorField("9fg8a7e4-6d02-40e3-a129-0b2bf89de8uh", s"The Counterparty ID used in URLs. This SHOULD NOT be a name of a Counterparty.")
  glossaryItems += makeGlossaryItem("Counterparty.counterpartyId", counterpartyIdExample)
  
  lazy val otherAccountProviderExample = ConnectorField("", s"")//TODO, not sure what is this filed for?
  glossaryItems += makeGlossaryItem("Transaction.otherAccountProvider", otherAccountProviderExample)
  
  lazy val isBeneficiaryExample = ConnectorField("true", s"This is a boolean. True if the originAccount can send money to the Counterparty")
  glossaryItems += makeGlossaryItem("Counterparty.isBeneficiary", isBeneficiaryExample)

  lazy val counterpartyNameExample = ConnectorField("John Smith Ltd.", s"The name of a Counterparty. Ideally unique for an Account")
  glossaryItems += makeGlossaryItem("Counterparty.counterpartyName", counterpartyNameExample)

  lazy val transactionIdExample = ConnectorField("2fg8a7e4-6d02-40e3-a129-0b2bf89de8ub", s"The Transaction ID used in URLs. Used to store Metadata for the Transaction.")
  glossaryItems += makeGlossaryItem("Transaction.transactionId", transactionIdExample)

  lazy val transactionAttributeIdExample = ConnectorField("7uy8a7e4-6d02-40e3-a129-0b2bf89de8uh", s"Transaction attribute id")
  glossaryItems += makeGlossaryItem("Transaction.attributeId", transactionAttributeIdExample)

  lazy val transactionAttributeNameExample = ConnectorField("HOUSE_RENT", s"Transaction attribute name")
  glossaryItems += makeGlossaryItem("Transaction.attributeName", transactionAttributeNameExample)

  lazy val transactionAttributeTypeExample = ConnectorField("DATE_WITH_DAY", s"Transaction attribute type.")
  glossaryItems += makeGlossaryItem("Transaction.attributeType", transactionAttributeTypeExample)

  lazy val transactionAttributeValueExample = ConnectorField("123456789", s"Transaction attribute value.")
  glossaryItems += makeGlossaryItem("Transaction.attributeValue", transactionAttributeValueExample)

  lazy val transactionDescriptionExample = ConnectorField("For the piano lesson in June 2018 - Invoice No: 68", s"A description or reference for the transaction")
  glossaryItems += makeGlossaryItem("Transaction.transactionDescription", transactionDescriptionExample)

  lazy val transactionTypeExample = ConnectorField("DEBIT", s"A code for the type of transaction")
  glossaryItems += makeGlossaryItem("Transaction.transactionType", transactionTypeExample)
  
  lazy val limitExample = ConnectorField("100", s"The limit in pagination")
  glossaryItems += makeGlossaryItem("Adapter.limit", limitExample)

  lazy val offsetExample = ConnectorField("100", s"The offset in pagination")
  glossaryItems += makeGlossaryItem("Adapter.offset", offsetExample)


  lazy val ibanExample = ConnectorField("DE91 1000 0000 0123 4567 89", s"MUST uniquely identify the bank account globally.")
  glossaryItems += makeGlossaryItem("Account.iban", ibanExample)

  lazy val transactionRequestIban = ibanExample

  lazy val gitCommitExample = ConnectorField("59623811dd8a41f6ffe67be46954eee11913dc28", "Identifies the code running on the OBP-API (Connector) or Adapter.")

  lazy val subExample = ConnectorField(s"${userNameExample.value}","An identifier for the user, unique among all OBP-API users and never reused")
  lazy val issExample = ConnectorField("String","The Issuer Identifier for the Issuer of the response.")
  lazy val audExample = ConnectorField("String","Identifies the audience that this ID token is intended for. It must be one of the OBP-API client IDs of your application.") 
  lazy val jtiExample = ConnectorField("String","(JWT ID) claim provides a unique identifier for the JWT.")
  lazy val iatExample = ConnectorField("String","The iat (issued at) claim identifies the time at which the JWT was issued. Represented in Unix time (integer seconds).")
  lazy val nbfExample = ConnectorField("String","The nbf (not before) claim identifies the time before which the JWT MUST NOT be accepted for processing. Represented in Unix time (integer seconds).")
  lazy val expExample = ConnectorField("String","The exp (expiration time) claim identifies the expiration time on or after which the JWT MUST NOT be accepted for processing. Represented in Unix time (integer seconds).")
  lazy val emailVerifiedExample = ConnectorField("String","If the email is verified or not.")
  
  lazy val emailExample = ConnectorField(s"${userNameExample.value}@example.com", "An email address.")

  lazy val branchIdExample = ConnectorField("DERBY6", "Uniquely identifies the Branch in combination with the bankId.")
  glossaryItems += makeGlossaryItem("Branch.branch_id", branchIdExample)

  lazy val accountTypeExample = ConnectorField("AC","A short code that represents the type of the account as provided by the bank.")

  lazy val balanceAmountExample = ConnectorField("50.89", "The balance on the account.")

  lazy val amountExample = ConnectorField("10.12", "The balance on the account.")

  lazy val balanceCurrencyExample = ConnectorField("EUR", "The currency of the account.")

  lazy val creditLimitAmountExample = ConnectorField("1000.00", "The credit limit on the accounts of a customer.")

  lazy val transactionAmountExample = ConnectorField("19.64", "A Transaction Amount.")

  lazy val transactionPostedDateExample = ConnectorField("2018-01-27", "The Posted date of a transaction in the format: yyyy-MM-dd")
  lazy val transactionCompletedDateExample = ConnectorField("2018-01-28", "The Completed date of a transaction in the format: yyyy-MM-dd")

  lazy val dateExample = ConnectorField("2020-01-27", "The Date in the format: yyyy-MM-dd")
  lazy val cancelledDateExample = ConnectorField("2020-01-27", "The Cancelled Date in the format: yyyy-MM-dd")
  lazy val dateCancelledExample = cancelledDateExample
  lazy val signedDateExample = ConnectorField("2020-01-27", "The Signed Date in the format: yyyy-MM-dd")
  lazy val dateSignedExample = signedDateExample
  lazy val startDateExample = ConnectorField("2020-01-27", "The Start Date in the format: yyyy-MM-dd")
  lazy val dateStartsExample = startDateExample
  lazy val finishDateExample = ConnectorField("2020-01-27", "The Finish Date in the format: yyyy-MM-dd")
  lazy val completedDateExample = finishDateExample
  lazy val insertDateExample = ConnectorField("2020-01-27", "The Insert Date in the format: yyyy-MM-dd")
  lazy val postedDateExample = ConnectorField("2020-01-27", "The Posted Date in the format: yyyy-MM-dd")
  lazy val collectedDateExample = ConnectorField("2020-01-27", "The Collected Date in the format: yyyy-MM-dd")
  lazy val requestedDateExample = ConnectorField("2020-01-27", "The Requested Date in the format: yyyy-MM-dd")
  lazy val validFromDateExample = ConnectorField("2020-01-27", "The Valid From date in the format: yyyy-MM-dd")
  lazy val issueDateExample = ConnectorField("2020-01-27", "The Issue date in the format: yyyy-MM-dd")
  lazy val expiryDateExample = ConnectorField("2021-01-27", "The Expiry date in the format: yyyy-MM-dd")
  lazy val expiresDateExample = expiryDateExample
  lazy val dateExpiresExample = expiryDateExample

  lazy val transactionRequestTypeExample = ConnectorField("SEPA", "The Transaction Request Type defines the request body that is required - and the logic / flow of the Transaction Request. Allowed values include SEPA, COUNTERPARTY and SANDBOX_TAN.")
  glossaryItems += makeGlossaryItem("Transaction Requests.Transaction Request Type", transactionRequestTypeExample)

  lazy val transactionRequestIdExample = ConnectorField("8138a7e4-6d02-40e3-a129-0b2bf89de9f1", "The Transaction Request Id")
  glossaryItems += makeGlossaryItem("Transaction Requests.id", transactionRequestIdExample)

  lazy val transactionRequestCounterpartyIdExample = counterpartyIdExample

  lazy val transactionRequestRefundReasonCodeExample = ConnectorField("CUST", "The Transaction Request Refund Reason Code defines the reason of refund request according with the SEPA Credit Transfer Scheme.")
  glossaryItems += makeGlossaryItem("Transaction Requests.Transaction Request Refund Reason Code", transactionRequestRefundReasonCodeExample)

  lazy val currencyExample = balanceCurrencyExample

  lazy val owner1Example = ConnectorField("SusanSmith", "A username that is the owner of the account.")
  glossaryItems += makeGlossaryItem("Account.owner", owner1Example)

  lazy val viewIdExample = ConnectorField("owner", "A viewId can be owner, accountant, public ....")
  glossaryItems += makeGlossaryItem("view.id", viewIdExample)
  
  lazy val viewNameExample = ConnectorField("Owner","A viewName can be Owner, Accountant, Public ....")
  glossaryItems += makeGlossaryItem("view.name",viewNameExample)
  
  lazy val viewDescriptionExample = ConnectorField("This view is for the owner for the account.", "A description for this view.")
  glossaryItems += makeGlossaryItem("view.description", viewDescriptionExample)





  lazy val owner2Example = ConnectorField("JaneSmith", "A username that is the owner of the account.")

  lazy val bankRoutingSchemeExample = ConnectorField("BIC", "The scheme that the bank_routing_address / bankRoutingAddress is an example of.")
  glossaryItems += makeGlossaryItem("Bank.bank_routing_scheme", bankRoutingSchemeExample)

  lazy val bankRoutingAddressExample = ConnectorField("GENODEM1GLS", "An identifier that conforms to bank_routing_scheme / bankRoutingScheme")
  glossaryItems += makeGlossaryItem("Bank.bank_routing_address", bankRoutingAddressExample)

  lazy val branchRoutingSchemeExample = ConnectorField("BRANCH-CODE", "The scheme that the branch_routing_address / branchRoutingAddress is an example of.")
  glossaryItems += makeGlossaryItem("Branch.branch_routing_scheme", branchRoutingSchemeExample)

  lazy val branchRoutingAddressExample = ConnectorField("DERBY6", "An address that conforms to branch_routing_scheme / branchRoutingScheme")
  glossaryItems += makeGlossaryItem("Branch.branch_routing_address", branchRoutingAddressExample)

  lazy val accountRoutingSchemeExample = ConnectorField("IBAN", "The scheme that the account_routing_address / accountRoutingAddress is an example of.")
  glossaryItems += makeGlossaryItem("Account.account_routing_scheme",accountRoutingSchemeExample)

  lazy val accountRoutingAddressExample = ConnectorField("DE91 1000 0000 0123 4567 89", "An identifier that conforms to account_routing_scheme / accountRoutingScheme")
  glossaryItems += makeGlossaryItem("Account.account_routing_address", accountRoutingAddressExample)
  
  lazy val keyExample = ConnectorField(s"CustomerNumber", s"This key should be used with Adapter.value together. They are a pair.")
  glossaryItems += makeGlossaryItem("Adapter.key", keyExample)
  
  lazy val valueExample = ConnectorField(s"${customerNumberExample.value}", s"This key should be used with Adapter.key together. They are a pair.")
  glossaryItems += makeGlossaryItem("Adapter.value", valueExample)

  lazy val bankCardNumberExample = ConnectorField("364435172576215", s"The number of the physical card")
  glossaryItems += makeGlossaryItem("Adapter.card_number", bankCardNumberExample)

  lazy val cardTypeExample = ConnectorField("Credit", s"The type of the physical card. eg: credit, debit ...")
  glossaryItems += makeGlossaryItem("Adapter.card_type", cardTypeExample)

  lazy val cardIdExample = ConnectorField("36f8a9e6-c2b1-407a-8bd0-421b7119307e ", s"A string that MUST uniquely identify the card on this OBP instance. It SHOULD be a UUID.")
  glossaryItems += makeGlossaryItem("Adapter.card_id", cardIdExample)
  
  lazy val nameOnCardExample = ConnectorField(owner1Example.value, s"The name on the physical card")
  glossaryItems += makeGlossaryItem("Adapter.name_on_card", nameOnCardExample)

  lazy val issueNumberExample = ConnectorField("1", s"The issue number of the physical card, eg 1,2,3,4 ....")
  glossaryItems += makeGlossaryItem("Adapter.issue_number", issueNumberExample)
  
  lazy val serialNumberExample = ConnectorField("1324234", s"The serial number of the physical card, eg 1123.")
  glossaryItems += makeGlossaryItem("Adapter.serial_number", serialNumberExample)

  lazy val cardAttributeIdExample = ConnectorField("b4e0352a-9a0f-4bfa-b30b-9003aa467f50", s"A string that MUST uniquely identify the card attribute on this OBP instance. It SHOULD be a UUID.")
  glossaryItems += makeGlossaryItem("Adapter.card_attribute_id", cardAttributeIdExample)

  lazy val cardAttributeNameExample = ConnectorField("OVERDRAFT_START_DATE", s"The Card attribute name")
  glossaryItems += makeGlossaryItem("Adapter.card_attribute_name", cardAttributeNameExample)

  lazy val cardAttributeValueExample = ConnectorField("2012-04-23", s"The card attribute values")
  glossaryItems += makeGlossaryItem("Adapter.card_attribute_value", cardAttributeValueExample)

  lazy val providerValueExample = ConnectorField("http://127.0.0.1:8080", s"The Provider authenticating this User")
  glossaryItems += makeGlossaryItem("Authentication.provider", providerValueExample)

  lazy val providerIdValueExample = ConnectorField("Chris", s"The provider id of the user which is equivalent to the username.")
  glossaryItems += makeGlossaryItem("Adapter.provider_id", providerIdValueExample)
  
  lazy val cbsErrorCodeExample = ConnectorField("500-OFFLINE", "An error code returned by the CBS")

  //------------------------------------------------------------
  // TODO @Simon please fix the follow example values to reasonable values
  lazy val dateOfBirthExample = ConnectorField("2018-03-09", "customer birthday")
  lazy val customerTitleExample = ConnectorField("title of customer", "Sir")

  // can rename to "fromDateExample" and "toDateExample", if it is reasonable
  lazy val outBoundGetTransactionsFromDateExample = ConnectorField("2018-03-09", "fix me")
  lazy val outBoundGetTransactionsToDateExample = ConnectorField("2018-03-09", "fix me")

  lazy val inboundAdapterInfoInternalErrorCodeExample = ConnectorField("error code", "fix me")
  lazy val inboundAdapterInfoInternalNameExample = ConnectorField("NAME", "fix me")
  lazy val inboundAdapterInfoInternalGit_commitExample = ConnectorField("git_commit", "fix me")
  lazy val inboundAdapterInfoInternalDateExample = ConnectorField("date String", "fix me")
  lazy val inboundAdapterInfoInternalVersionExample = ConnectorField("version string", "fix me")

  lazy val inboundStatusMessageStatusExample = ConnectorField("Status string", "fix me")
  lazy val inboundStatusMessageErrorCodeExample = ConnectorField("errorCode string", "fix me")
  lazy val inboundStatusMessageTextExample = ConnectorField("text string", "fix me")

  lazy val statusErrorCodeExample = ConnectorField("status error code string", "fix me")

  lazy val bankShortNameExample = ConnectorField("bank shortName string", "fix me")
  lazy val bankFullNameExample = ConnectorField("bank fullName string", "fix me")
  lazy val bankLogoUrlExample = ConnectorField("bank logoUrl string", "fix me")
  lazy val bankWebsiteUrlExample = ConnectorField("bank websiteUrl string", "fix me")
  lazy val bankSwiftBicExample = ConnectorField("bank swiftBic string", "fix me")
  lazy val bankNationalIdentifierExample = ConnectorField("bank nationalIdentifier string", "fix me")

  lazy val bankAccountExample = ConnectorField("bankAccount nationalIdentifier string", "fix me")
  lazy val bankAccountNameExample = ConnectorField("bankAccount name string", "fix me")
  lazy val bankAccountNumberExample = ConnectorField("bankAccount number string", "fix me")
  lazy val bankAccountLastUpdateExample = ConnectorField("2018-03-09", "fix me")
  lazy val bankAccountAccountHolderExample = ConnectorField("bankAccount accountHolder string", "fix me")

  lazy val accountRuleSchemeExample = ConnectorField("AccountRule scheme string", "fix me")
  lazy val accountRuleValueExample = ConnectorField("AccountRule value string", "fix me")

  //the follow two examples are list type, InboundAccount#owners: List[String]  InboundAccount#viewsToGenerate: List[String]
  // the value should divided with , or ;
  lazy val inboundAccountOwnersExample = ConnectorField("InboundAccount,owners,list,string", "fix me, if there are multiple values, split with ,or;")
  lazy val inboundAccountViewsToGenerateExample = ConnectorField("Owner;Accountant;Auditor", "These are the views the account can have when import account data from adapter.")

  lazy val transactionUuidExample = ConnectorField("Transaction uuid string", "fix me")
  lazy val transactionStartDateExample = ConnectorField("2019-09-07", "fix me, Transaction start Date string")
  lazy val transactionRequestStartDateExample = transactionStartDateExample
  lazy val transactionFinishDateExample = ConnectorField("2019-09-08", "fix me, Transaction finish Date string")
  lazy val transactionRequestEndDateExample = transactionFinishDateExample

  lazy val counterpartyNationalIdentifierExample = ConnectorField("Counterparty nationalIdentifier string", "fix me")
  lazy val counterpartyKindExample = ConnectorField("Counterparty kind string", "fix me")

  // the follow examples all contains "others" part, but there are corresponding examples: bankRoutingSchemeExample, bankRoutingAddressExample...
  // if these are duplicate with those examples, just delete the follow examples
  lazy val counterpartyOtherBankRoutingSchemeExample = ConnectorField("OBP" ,"Counterparty otherBankRoutingScheme string")
  lazy val counterpartyOtherBankRoutingAddressExample = ConnectorField("gh.29.uk", "Counterparty otherBankRoutingAddress string")
  lazy val counterpartyOtherAccountRoutingSchemeExample = ConnectorField("OBP", "Counterparty otherAccountRoutingScheme string")
  lazy val counterpartyOtherAccountRoutingAddressExample = ConnectorField("36f8a9e6-c2b1-407a-8bd0-421b7119307e", "Counterparty otherAccountRoutingAddress string")  
  lazy val counterpartyOtherAccountSecondaryRoutingSchemeExample = ConnectorField("IBAN", "Counterparty otherAccountSecondaryRoutingScheme string")
  lazy val counterpartyOtherAccountSecondaryRoutingAddressExample = ConnectorField("DE89370400440532013000", "Counterparty otherAccountSecondaryRoutingAddress string")
  lazy val counterpartyOtherAccountProviderExample = ConnectorField("Counterparty otherAccountProvider string", "fix me")
  lazy val counterpartyOtherBranchRoutingSchemeExample = ConnectorField("OBP", "Counterparty otherBranchRoutingScheme string")
  lazy val counterpartyOtherBranchRoutingAddressExample = ConnectorField("12f8a9e6-c2b1-407a-8bd0-421b7119307e", "Counterparty otherBranchRoutingAddress string")


  lazy val customerFaceImageDateExample = ConnectorField("2019-09-08", "fix me, CustomerFaceImage Date string")
  lazy val customerLastOkDateExample = ConnectorField("2019-09-08", "fix me, lastOkDate Date string")
  lazy val dobOfDependentsExample = ConnectorField("2019-09-08,2019-01-03", "fix me, dobOfDependent Date string list, split with ,or ;")

  // @Simon, whether can make customerLastOkDateExample and outBoundCreateCustomerLastOkDateExample a single one: lastOkDateExample
  // if yes, please rename the follow to lastOkDateExample, and delete outBoundCreateCustomerLastOkDateExample
  lazy val outBoundCreateCustomerLastOkDateExample = ConnectorField("2019-09-12", "fix me, lastOkDate Date string")

  lazy val uuidExample = ConnectorField("9ca9a7e4-6d02-40e3-a129-0b2bf89de9b1", "UUID value")


  //this is only for dynamicEntity post or request body example
  """
    |{
    |   "FooBar": {
    |       "description": "description of this entity, can be markdown text."
    |       "required": [
    |           "name"
    |       ],
    |       "properties": {
    |           "name": {
    |               "type": "string",
    |               "maxLength": 20,
    |               "minLength": 3,
    |               "example": "James Brown",
    |               "description":"description of **name** field, can be markdown text."
    |           },
    |           "number": {
    |               "type": "integer",
    |               "example": "698761728934",
    |               "description": "description of **number** field, can be markdown text."
    |           }
    |       }
    |   }
    |}
    |""".stripMargin

  lazy val dynamicEntityRequestBodyExample = DynamicEntityFooBar(
    DynamicEntityDefinition(
      "description of this entity, can be markdown text.",
      List("name"),
      DynamicEntityFullBarFields(
        DynamicEntityStringTypeExample(DynamicEntityFieldType.string, 3, 20, "James Brown", "description of **name** field, can be markdown text."),
        DynamicEntityIntTypeExample(DynamicEntityFieldType.integer, 698761728, "description of **number** field, can be markdown text.")
      )
    )
  )

  lazy val dynamicEntityResponseBodyExample = dynamicEntityRequestBodyExample.copy(dynamicEntityId = Some("dynamic-entity-id"))

  private val dynamicEndpointSwagger =
    """{
      |  "swagger": "2.0",
      |  "info": {
      |    "version": "0.0.1",
      |    "title": "Example Title",
      |    "description": "Example Description",
      |    "contact": {
      |      "name": "Example Company",
      |      "email": " simon@example.com",
      |      "url": "https://www.tesobe.com/"
      |    }
      |  },
      |  "host": "localhost:8080",
      |  "basePath": "/user",
      |  "schemes": [
      |    "http"
      |  ],
      |  "consumes": [
      |    "application/json"
      |  ],
      |  "produces": [
      |    "application/json"
      |  ],
      |  "paths": {
      |    "/save": {
      |      "post": {
      |        "parameters": [
      |          {
      |            "name": "body",
      |            "in": "body",
      |            "required": true,
      |            "schema": {
      |              "$ref": "#/definitions/user"
      |            }
      |          }
      |        ],
      |        "responses": {
      |          "201": {
      |            "description": "create user successful and return created user object",
      |            "schema": {
      |              "$ref": "#/definitions/user"
      |            }
      |          },
      |          "500": {
      |            "description": "unexpected error",
      |            "schema": {
      |              "$ref": "#/responses/unexpectedError"
      |            }
      |          }
      |        }
      |      }
      |    },
      |    "/getById/{userId}": {
      |      "get": {
      |        "description": "get reuested user by user ID",
      |        "parameters": [
      |          {
      |            "$ref": "#/parameters/userId"
      |          }
      |        ],
      |        "consumes": ["application/json"],
      |        "responses": {
      |          "200": {
      |            "description": "the successful get requested user by user ID",
      |            "schema": {
      |              "$ref": "#/definitions/user"
      |            }
      |          },
      |          "400": {
      |            "description": "bad request",
      |            "schema": {
      |              "$ref": "#/responses/invalidRequest"
      |            }
      |          },
      |          "404": {
      |            "description": "user not found",
      |            "schema": {
      |              "$ref": "#/definitions/APIError"
      |            }
      |          },
      |          "500": {
      |            "description": "unexpected error",
      |            "schema": {
      |              "$ref": "#/responses/unexpectedError"
      |            }
      |          }
      |        }
      |      }
      |    },
      |    "/listUsers": {
      |      "get": {
      |        "description": "get list of users",
      |        "consumes": ["application/json"],
      |        "responses": {
      |          "200": {
      |            "description": "get all users",
      |            "schema": {
      |              "$ref": "#/definitions/users"
      |            }
      |          },
      |          "404": {
      |            "description": "user not found",
      |            "schema": {
      |              "$ref": "#/definitions/APIError"
      |            }
      |          }
      |        }
      |      }
      |    },
      |    "/updateUser": {
      |      "put": {
      |        "parameters": [
      |          {
      |            "name": "body",
      |            "in": "body",
      |            "required": true,
      |            "schema": {
      |              "$ref": "#/definitions/user"
      |            }
      |          }
      |        ],
      |        "responses": {
      |          "200": {
      |            "description": "create user successful and return created user object",
      |            "schema": {
      |              "$ref": "#/definitions/user"
      |            }
      |          },
      |          "500": {
      |            "description": "unexpected error",
      |            "schema": {
      |              "$ref": "#/responses/unexpectedError"
      |            }
      |          }
      |        }
      |      }
      |    },
      |    "/delete/{userId}": {
      |      "delete": {
      |        "description": "delete user by user ID",
      |        "parameters": [
      |          {
      |            "$ref": "#/parameters/userId"
      |          }
      |        ],
      |        "consumes": ["application/json"],
      |        "responses": {
      |          "204": {
      |            "description": "the successful delete user by user ID"
      |          },
      |          "400": {
      |            "description": "bad request",
      |            "schema": {
      |              "$ref": "#/responses/invalidRequest"
      |            }
      |          },
      |          "500": {
      |            "description": "unexpected error",
      |            "schema": {
      |              "$ref": "#/responses/unexpectedError"
      |            }
      |          }
      |        }
      |      }
      |    }
      |  },
      |  "definitions": {
      |    "user": {
      |      "type": "object",
      |      "properties": {
      |        "id": {
      |          "type": "integer",
      |          "description": "user ID"
      |        },
      |        "first_name": {
      |          "type": "string"
      |        },
      |        "last_name": {
      |          "type": "string"
      |        },
      |        "age": {
      |          "type": "integer"
      |        },
      |        "career": {
      |          "type": "string"
      |        }
      |      },
      |      "required": [
      |        "first_name",
      |        "last_name",
      |        "age"
      |      ]
      |    },
      |    "users": {
      |      "description": "array of users",
      |      "type": "array",
      |      "items": {
      |        "$ref": "#/definitions/user"
      |      }
      |    },
      |    "APIError": {
      |      "description": "content any error from API",
      |      "type": "object",
      |      "properties": {
      |        "errorCode": {
      |          "description": "content error code relate to API",
      |          "type": "string"
      |        },
      |        "errorMessage": {
      |          "description": "content user-friendly error message",
      |          "type": "string"
      |        }
      |      }
      |    }
      |  },
      |  "responses": {
      |    "unexpectedError": {
      |      "description": "unexpected error",
      |      "schema": {
      |        "$ref": "#/definitions/APIError"
      |      }
      |    },
      |    "invalidRequest": {
      |      "description": "invalid request",
      |      "schema": {
      |        "$ref": "#/definitions/APIError"
      |      }
      |    }
      |  },
      |  "parameters": {
      |    "userId": {
      |      "name": "userId",
      |      "in": "path",
      |      "required": true,
      |      "type": "string",
      |      "description": "user ID"
      |    }
      |  }
      |}
      |""".stripMargin
  lazy val dynamicEndpointRequestBodyExample = json.parse(dynamicEndpointSwagger).asInstanceOf[JObject]
  lazy val dynamicEndpointResponseBodyExample = ("dynamic_endpoint_id", "dynamic-endpoint-id") ~ ("swagger_string", dynamicEndpointRequestBodyExample)

  /**
   * parse date example value to Date type
   * @param exampleValue example value
   * @return parsed Date type value
   */
  def toDate(exampleValue: ConnectorField) = {
    exampleNameToValue.collectFirst {
      case (name, example) if example == exampleValue => parseDate(example.value).getOrElse(sys.error(s"$name.value is not a valid date format."))
    }.getOrElse(sys.error(s"$exampleValue is not an example value of code.api.util.ExampleValue"))
  }



  /**
   * all ConnectorField type example name map value
   */
  lazy val exampleNameToValue: Map[String, ConnectorField] = ReflectUtils.getFieldsNameToValue[ConnectorField](this)
}




