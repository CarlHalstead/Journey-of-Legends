package aginsun.taleofkingdoms.core.handlers;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import aginsun.taleofkingdoms.TaleOfKingdoms;


/**sets all the gold values for the vanilla items
 * and also any mod items that I want to be added.
 * 
 * note: Evydder did the old system!
 * @author Aginsun, Evydder
 * 
 *
 */

public class GoldValues 
{
	public static HashMap<String, Integer> goldValues = new HashMap<String, Integer>();
	
	public static void setGoldValues()
	{
		InputStream input = TaleOfKingdoms.class.getResourceAsStream("/mods/TaleOfKingdoms/GoldValues.txt");
		try{
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(input));
			String gold = null;
			while((gold = bufferedReader.readLine()) != null)
			{
				gold = gold.trim();
				String[] values = gold.split(":");
				goldValues.put(values[0], Integer.parseInt(values[1]));
				System.out.printf("Set %s with goldvalue %s \n", values[0], values[1]);
			}
		}catch(Exception e){}
	}
	
	public static int getGoldValue(String s)
	{
		if(goldValues.containsKey(s))
			return goldValues.get(s);
		return 0;
	}
}
