package code.model.traits

trait User {
  
  def emailAddress : String
  def userName : String
  def permittedViews(bankAccount: BankAccount) : Set[View]
  def hasMangementAccess(bankpermalink : String, bankAccountPermalink : String)  : Boolean
  
}