package generic;

import java.io.FileInputStream;
import java.util.Properties;

public class propertyutility {
	
	
	
	FileInputStream fis;
	public Object driver;
	public String readDataProperFromproperty(String key)throws Exception
	{
		
		fis=new FileInputStream("./src/test/resources/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(key);
	}
	

}
