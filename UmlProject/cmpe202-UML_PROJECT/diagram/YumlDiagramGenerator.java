package umlProject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class YumlDiagramGenerator {
	//define dependencies
	private final String[] dependencies = { "implements;-.-^", "extends;-^" ,"associations;-"};
	private static final String[] accessSymbol = { "public;+", "private;-", "protected;#" };
	private String[] stringArray;
	private Map<String,String> accessSymbolMap = new HashMap<>();
	private Map<String,String> dependencyMap = new HashMap<>();
	private String packageName;
	private String modifierName;
	private String classType;
	private String className;
	private ArrayList<String> attributeArray;
	private ArrayList<String> methodsArray;
	
	
	public YumlDiagramGenerator(){
		accessSymbolMap = new HashMap<>();
		String access;
		for(int i=0; i<accessSymbol.length; i++){
			access = accessSymbol[i];
			stringArray = access.split(";");
			for(int j=0; j<stringArray.length; j++){
				accessSymbolMap.put(stringArray[0], stringArray[1]);
			}
		}
		dependencyMap = new HashMap<>();
		String dependency;
		for(int i=0; i<dependencies.length; i++){
			dependency = dependencies[i];
			stringArray = dependency.split(";");
			for(int j=0; j<stringArray.length; j++){
				dependencyMap.put(stringArray[0], stringArray[1]);
			}
		}
		public void setClassFields(String packageName, String modifierName, String classType, String className,
				ArrayList<String> attributeArray, ArrayList<String> methodsArray) {
			this.packageName = packageName;
			this.modifierName = modifierName;
			this.classType = classType;
			this.className = className;
			this.attributeArray = attributeArray;
			this.methodsArray = methodsArray;
		}
	}
}
