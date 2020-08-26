package com.excel.lib.util;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReaderDOM {

public static void main(String args[]) 
{
	XMLReaderDOM.getValue("uat", "payerportal", "url", "username", "password");
}


public static void getValue(String env,String portal,String url,String username,String password)
{
	try {

		File TestData = new File("C:\\Users\\Test1\\eclipse-workspace\\SampleSelenium-Maven\\Config\\TestData.xml");
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(TestData);
		doc.getDocumentElement().normalize();

		System.out.println("root of xml file" + doc.getDocumentElement().getNodeName());
		NodeList nodes = doc.getElementsByTagName(portal);

		System.out.println("==========================");

		for (int i = 0; i < nodes.getLength(); i++) {
		Node node = nodes.item(i);

		if (node.getNodeType() == Node.ELEMENT_NODE) {
		Element element = (Element) node;
		System.out.println("env: " + getValue("env", element));
		System.out.println("protal:" +getValue("portal", element));
		System.out.println("url: " + getValue("url", element));
		System.out.println("username: " + getValue("username", element));
		System.out.println("password: " + getValue("password", element));
		}
		}
		} catch (Exception ex) {
		ex.printStackTrace();
		}
	
}
private static String getValue(String tag, Element element)
{
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
}
}