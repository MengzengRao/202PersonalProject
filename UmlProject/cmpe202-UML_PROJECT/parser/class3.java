package parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.Node;
import com.github.javaparser.ast.body.ConstructorDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.TypeDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import mainCom.ParseString;
import utilities.UtilitiesFunctions;
public final class Class {

	private static Map<String, String> accessModifierMap = new HashMap<>();
	private static Map<String, String> accessModifierCoveterMap = new HashMap<>();
	private static Map<String, String> dataTypesMap = new HashMap<>();
	private static Map<String, String> otherModifierMap = new HashMap<>();
	private static ArrayList<MethodDeclarationStructure> methodsArray;
	private static ArrayList<MethodDeclarationStructure> constructorArray;
	private static ArrayList<VariableDeclarationStructure> attributesArray;
	private static String variableAccessModifier;
	private static String[] variableType;
	private static String variableName;
	private static ArrayList<String> methodAttributes = new ArrayList<String>();
	private static ArrayList<String> otherVariableModifiers;
	private static  Map<String, String> allClassNames;
	//private static final String[] accessModifiersConverter = { "1;public", "2;private", "5;protected","0;package" };
	private static final String[] accessModifiers = { "public;public", "private;private", "protected;protected","package;package" };
	private static final String[] dataTypes = { "int;int", "byte;byte", "short;short", "long;long", "float;float","double;double", "boolean;boolean", "char;char", "String;String","Map;Map","List;List","ArrayList;ArrayList" };
	private static final String[] otherModifiers = {"static;static","synchronized;synchronized","final;final","abstract;abstract"};
	
	private ClassAttributesParser() {
	}
	public static void setupClass() {
		String[] tempStringArray = {};
		methodsArray  = new ArrayList<MethodDeclarationStructure>();
		constructorArray = new ArrayList<MethodDeclarationStructure>();
		attributesArray = new ArrayList<VariableDeclarationStructure>();
		methodAttributes = new ArrayList<String>();
		
		accessModifierMap = new HashMap<>();
		for (String modifiers : accessModifiers) {
			tempStringArray = modifiers.split(";");
			for (int x = 0; x < tempStringArray.length; x++) {
				accessModifierMap.put(tempStringArray[0], tempStringArray[1]);
			}
		}
		dataTypesMap = new HashMap<>();
		for (String dataType : dataTypes) {
			tempStringArray = dataType.split(";");
			for (int x = 0; x < tempStringArray.length; x++) {
				dataTypesMap.put(tempStringArray[0], tempStringArray[1]);
			}
		}

		otherModifierMap = new HashMap<>();
		for (String modifiers : otherModifiers) {
			tempStringArray = modifiers.split(";");
			for (int x = 0; x < tempStringArray.length; x++) {
				otherModifierMap.put(tempStringArray[0], tempStringArray[1]);
			}
		}
	}
public static ArrayList<String> getAttributesDeclarations(CompilationUnit cu, Map<String, String> classNames) {
		
		allClassNames = classNames;
		attributesArray.clear();
		methodAttributes.clear();
		new AttributeList().visit(cu, null);
		

		return methodAttributes;
	}
public static ArrayList<MethodDeclarationStructure> getMethodDeclarations(CompilationUnit cu) {
		methodsArray.clear();
		new MethodList().visit(cu, null);
		return (ArrayList<MethodDeclarationStructure>) methodsArray.clone();
	}

	public static ArrayList<MethodDeclarationStructure> getConstructorDeclarations(CompilationUnit cu) {
		constructorArray.clear();
		new ConstructorList().visit(cu, null);
		return (ArrayList<MethodDeclarationStructure>) constructorArray.clone();
	}

	public static MethodDeclarationStructure sanitizeMethodDeclarations(String methodString,String methodBody) {
		MethodDeclarationStructure localmethod = null;
		String accessModifier = null;//public,private
		ArrayList<String> otherModifiers = null;//Static,Sync
		String returnType = null;
		String methodName = null;
		boolean itemSetFlag = false;
		String parameterString = null;
		String[] parameterArray = null;
		ArrayList<String> parameters = null;

		try {
			String[] methodArray = methodString.split(" ");
			for(String item : methodArray) {
				itemSetFlag = false;
				if(accessModifierMap.containsKey(item) && (accessModifier == null || accessModifier == "")) {
					accessModifier = item;
					itemSetFlag = true;
				}
				if(otherModifierMap.containsKey(item) && !itemSetFlag) {
					if(otherModifiers == null)
						otherModifiers = new ArrayList<String>();
					otherModifiers.add(item);
					itemSetFlag = true;
				}
				if((returnType == null || returnType == "") && !itemSetFlag) {
					returnType = item;
					itemSetFlag = true;
				}
				if((methodName == null || methodName == "") && !itemSetFlag && item.indexOf("(")>0 && returnType != null) {
					methodName = item.substring(0, item.indexOf("("));
				}
			}

			if(methodName != null && methodName != "" && returnType != null && returnType != "") {
				parameterString = methodString.substring(methodString.indexOf("(")+1, methodString.indexOf(")"));
				if(parameterString != null && parameterString != "" && parameterString.length()>0) {
					parameterArray = parameterString.split(",");
					for(String parameter : parameterArray) {
						parameter = parameter.trim();
						if(parameters == null)
							parameters = new ArrayList<String>();
						parameters.add(parameter);	
					}	
				}
				localmethod = new MethodDeclarationStructure(accessModifier,otherModifiers,returnType,methodName,parameters,methodBody);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {}
		return localmethod;
	}
	
}	