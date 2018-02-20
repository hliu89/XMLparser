package Parsers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import Beans.Car;
import Beans.Customer;
import Beans.Driver;
import Beans.RootUser;
import Beans.Transaction;
import JDBC.Dao;

public class XMLParsers {
	public static void main(String[] args) {
	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	DocumentBuilder db;
	try {
		db = dbf.newDocumentBuilder();
	
    //get xml files
	Document document1 = db.parse("CustomerData.xml");
	Document document2 = db.parse("DriverData.xml");
	Document document3 = db.parse("RootUser.xml");
	Document document4 = db.parse("TransactionData.xml");
	Document document5 = db.parse("CarData.xml");
	//get all information from document
	NodeList customerList = document1.getElementsByTagName("customer");
	NodeList driverList = document2.getElementsByTagName("driver");
	NodeList rootuserList = document3.getElementsByTagName("rootuser");
	NodeList TransactionList = document4.getElementsByTagName("Transaction");
	NodeList CarList = document5.getElementsByTagName("Car");
	
	List<Customer> cl=new ArrayList<Customer>();
	List<Driver> dl=new ArrayList<Driver>();
	List<Car> carl=new ArrayList<Car>();
	List<Transaction> tl=new ArrayList<Transaction>();
	List<RootUser> rl=new ArrayList<RootUser>();
	//customer 
	for(int i=0;i<customerList.getLength();i++){
	 Node customer=customerList.item(i);
	 Customer c=new Customer();
	 NodeList childNodes = customer.getChildNodes();
	 for(int j=0;j<childNodes.getLength();j++) {
		 if(childNodes.item(j).getNodeName().equals("id")) {
		   c.setId(childNodes.item(j).getFirstChild().getNodeValue());
		 }
		 if(childNodes.item(j).getNodeName().equals("password")) {
			   c.setPassword(childNodes.item(j).getFirstChild().getNodeValue());
			 }
		 if(childNodes.item(j).getNodeName().equals("name")) {
			   c.setName(childNodes.item(j).getFirstChild().getNodeValue());
			 }
	 }
	      cl.add(c);
	}
	
	//driver
	for(int i=0;i<driverList.getLength();i++){
		 Node driver=driverList.item(i);
		 Driver c=new Driver();
		 NodeList childNodes = driver.getChildNodes();
		 for(int j=0;j<childNodes.getLength();j++) {
			 if(childNodes.item(j).getNodeName().equals("id")) {
			   c.setId(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("password")) {
				   c.setPassword(childNodes.item(j).getFirstChild().getNodeValue());
				 }
			 if(childNodes.item(j).getNodeName().equals("name")) {
				   c.setName(childNodes.item(j).getFirstChild().getNodeValue());
				 }
			 if(childNodes.item(j).getNodeName().equals("car_id")) {
				  c.setCar_id(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("receipt")) {
				
				  c.setReceipt(Float.parseFloat(childNodes.item(j).getFirstChild().getNodeValue()));
			 }
		 }
		      dl.add(c);
		}
	//rootuser
	for(int i=0;i<rootuserList.getLength();i++){
		 Node rootuser=rootuserList.item(i);
		 RootUser c=new RootUser();
		 NodeList childNodes = rootuser.getChildNodes();
		 for(int j=0;j<childNodes.getLength();j++) {
			 if(childNodes.item(j).getNodeName().equals("id")) {
			   c.setId(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("password")) {
				   c.setPassword(childNodes.item(j).getFirstChild().getNodeValue());
				 }
			 if(childNodes.item(j).getNodeName().equals("name")) {
				   c.setName(childNodes.item(j).getFirstChild().getNodeValue());
				 }
			 if(childNodes.item(j).getNodeName().equals("administrator")) {
				   c.setAdministrator((childNodes.item(j).getFirstChild().getNodeValue()));
				 }
		 }
		      rl.add(c);
		}
	//car information
	for(int i=0;i<CarList.getLength();i++){
		 Node car=CarList.item(i);
		 Car c=new Car();
		 NodeList childNodes = car.getChildNodes();
		 for(int j=0;j<childNodes.getLength();j++) {
			 if(childNodes.item(j).getNodeName().equals("car_id")) {
			   c.setId(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("car_type")) {
				   c.setType(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("car_seats")) {
				   c.setSeat(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("per_hour")) {
				   c.setPer_hour(Float.parseFloat(childNodes.item(j).getFirstChild().getNodeValue()));
			 }
			 if(childNodes.item(j).getNodeName().equals("per_week")) {
				   c.setPer_week(Float.parseFloat(childNodes.item(j).getFirstChild().getNodeValue()));
			 }
		 }
		      carl.add(c);
		}
	
	//transaction information
	for(int i=0;i<TransactionList.getLength();i++){
		 Node transaction=TransactionList.item(i);
		 Transaction c=new Transaction();
		 NodeList childNodes = transaction.getChildNodes();
		 for(int j=0;j<childNodes.getLength();j++) {
			 if(childNodes.item(j).getNodeName().equals("car_id")) {
			   c.setCar_id(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("money")) {
				   c.setMoney(Float.parseFloat(childNodes.item(j).getFirstChild().getNodeValue()));
			 }
			 if(childNodes.item(j).getNodeName().equals("id")) {
				   c.setId(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("time")) {
				   c.setDuration((childNodes.item(j).getFirstChild().getNodeValue()));
			 }
			 if(childNodes.item(j).getNodeName().equals("customer_id")) {
				   c.setCustomer_id(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("driver_id")) {
				   c.setDriver_id(childNodes.item(j).getFirstChild().getNodeValue());
			 }
			 if(childNodes.item(j).getNodeName().equals("state")) {
				   c.setState(childNodes.item(j).getFirstChild().getNodeValue());
			 }
		 }
		      tl.add(c);
		}
	
//	CreateDatabase createtables=new CreateDatabase();
//	createtables.createcustomerTable();
//	createtables.createcarTable();
//	createtables.createdriverTable();
//	createtables.createRootUserTable();
//	createtables.createtransactionTable();
	
	Dao d=new Dao();
    for(int i=0;i<carl.size();i++) {
    	d.insertCar(cl.get(i).getId(), carl.get(i).getType(), carl.get(i).getSeat(), carl.get(i).getPer_hour(), carl.get(i).getPer_week());
    }
    for(int i=0;i<cl.size();i++) {
    	d.insertCustomer(cl.get(i).getId(), cl.get(i).getName(), cl.get(i).getPassword());
    }
    for(int i=0;i<dl.size();i++) {
    	d.insertDriver(dl.get(i).getId(), dl.get(i).getName(), dl.get(i).getPassword(), dl.get(i).getReceipt(), dl.get(i).getCar_id());
    }
    for(int i=0;i<rl.size();i++) {
    	d.insertRootUser(rl.get(i).getId(), rl.get(i).getName(), rl.get(i).getPassword(), rl.get(i).getAdministrator());
    }
    for(int i=0;i<tl.size();i++) {
    	d.insertTransaction(tl.get(i).getId(), tl.get(i).getDuration(), tl.get(i).getMoney(), tl.get(i).getCar_id(), tl.get(i).getDriver_id(), tl.get(i).getState(), tl.get(i).getCustomer_id());
    }
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
