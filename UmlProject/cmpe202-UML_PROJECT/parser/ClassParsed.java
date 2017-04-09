package umlProject;

public class ClassParsed {
	private String packageName;
	private String modifierName;
	private String classType;
	private String className;
	public ClassParsed(String packageName,String modifierName,
			String classType,  String className){
		this.packageName = packageName;
		this.modifierName = modifierName;
		this.classType = classType;
		this.className = className;
	}
	public String getPackageName() {
		return packageName;
	}

	public String getModifierName() {
		return modifierName;
	}

	public String getClassType() {
		return classType;
	}
	public String getClassName() {
		return className;
	}
}
