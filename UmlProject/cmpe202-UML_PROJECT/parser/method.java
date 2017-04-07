package umlProject;

import java.util.ArrayList;

public class method {
	private String accessModifier;//public,private
	private String returnType;
	private String methodName;
	private ArrayList<String> parameters;
	private String methodBody;
	public method(String accessModifier, String returnType, String methodName, ArrayList<String> parameters,
			String methodBody){
		if(accessModifier != null){
			this.accessModifier = accessModifier;
		}else{
			this.accessModifier = "public";
		}
		this.returnType = returnType;
		this.methodName = methodName;
		this.parameters = parameters;
		this.methodBody = methodBody;
	}
	public String getAccessModifier() {
		return accessModifier;
	}
	public String getReturnType() {
		return returnType;
	}
	public String getMethodName() {
		return methodName;
	}
	public ArrayList<String> getParameters() {
		return parameters;
	}
}
