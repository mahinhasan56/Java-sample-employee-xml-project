package xmlPro;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class EmployeeRead {

	public static void main(String[] args) throws ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		try
		{
			Document document = builder.parse(new File("Employee.xml"));
			NodeList list1 = document.getElementsByTagName("Employee");
			System.out.println("Length at 1st level "+list1.getLength());
			
			int length =list1.getLength();
			
			for(int i=0; i<length; i++)
			{
				NodeList list2 = list1.item(i).getChildNodes();
				System.out.println("Length at 2nd level "+list2.getLength());

				for(int j=0; j<list2.getLength(); j++)
				{
					NodeList list3 = list2.item(j).getChildNodes();
					System.out.println("Length at 3rd level "+list3.getLength());
					
					for(int k=0; k<list3.getLength(); k++)
					{
						NodeList list4 = list3.item(k).getChildNodes();
						System.out.println("Length at 4th level "+list4.getLength());
						for(int l=0; l<list4.getLength(); l++)
						{
						   if(list4.item(l).getNodeType()== Node.TEXT_NODE)
					       {
						       System.out.println(list4.item(l).getNodeValue()+"\t");
					       }
						}
					}
				}				
			}			
		}
        catch(SAXException | IOException e)
		{
			System.err.println(e);
		}
		

	}

}
