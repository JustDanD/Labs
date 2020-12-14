import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

public class Input implements AutoCloseable
{
	private FileInputStream reportIn;
	private Properties prop = new Properties();
	private File report;
	
	public Input(String path)
	{
		try 
		{
			report = new File("report.properties");
			reportIn = new FileInputStream(report);
			prop.load(reportIn);
		}  
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * @apiNote 
	 * Keys: БубуБабаБубубубабабиби
	 * <li>carlson - убит ли Карлсон (false/true)
	 * <li>carlsonKilledBy - как убит Карлсон (false - жив; killed - убит; poisoned - отравлен)
	 * <li>gangTry - как пытался убить Карслона киллер (kill - убить; poison - отравить; both - оба варианта)
	 * <li>gang - убит ли киллер (false/true)
	 * <li>gangName - имя киллер (тип String)
	 */
	public Map<String, String> read()
	{
		Map<String, String> map = new LinkedHashMap<String, String>();
		for (String name : prop.stringPropertyNames())
		{
		    map.put(name, prop.getProperty(name));
		}
		return map;
	}
	
	@Override
	public void close() throws Exception 
	{
		reportIn.close();
	}
}
