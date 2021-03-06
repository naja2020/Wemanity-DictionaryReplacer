package Kata;

import java.util.Map;

public class DictionaryReplacer {
	
	private String output ="";
	private String[] inputs;
	private String key="";

	public String replace(String input, Map<String, String> dictionry) {
		
		if(input.length() <=0) {
			output = "Empty";
			return output;
		}
		else {
		
			replaceKeys(input,dictionry);
			
		}
		return output.trim();
		
	}
	
	public void replaceKeys(String input, Map<String, String> dictionry) {
		
		String chaine="";
		inputs = input.split(" ");
		
		for(int i=0; i<inputs.length;i++) {
			chaine=inputs[i];
			if(input.contains(chaine))
			 if(testKey(chaine)) {
				 key = getKey(chaine);
				 if(dictionry.containsKey(key)) {
					 replaceKey(dictionry);
					 output += key+" ";
					 
				 }
				
			 }
			 else {
				 output += chaine+" ";
			 
		 } 
		}	
	}
	
	private boolean testKey(String chaine) {
		return chaine.charAt(0) =='$' &&  chaine.charAt(chaine.length()-1) =='$';
	}
	
	private String getKey(String input) {
		return input.substring(input.indexOf('$')+1, input.lastIndexOf('$'));
	}
	
	private void replaceKey(Map<String, String> dictionary) {
		key=key.replace(key, dictionary.get(key));
	}

}
