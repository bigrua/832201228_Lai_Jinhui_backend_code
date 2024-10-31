
domain.java: used to define the data entity class, containing properties, getter and setter methods.
mapper.java: interface file, responsible for interacting with the database. SQL statements are mapped when using frameworks such as MyBatis.
service.java: service interface, defines the functions of the business logic layer, including the processing of data and logical judgements.
serviceImpl.java: service implementation class, the specific implementation of the methods defined in service.java, call the methods in mapper.java to complete the actual business logic.
controller.java: controller class , handle user requests , call the methods of the service layer and return the response. Usually used in MVC architecture.
mapper.xml: MyBatis XML configuration file , defining specific SQL statements , combined with the mapper.java interface to perform database operations .
These files together form the basic architecture of a complete Java application
