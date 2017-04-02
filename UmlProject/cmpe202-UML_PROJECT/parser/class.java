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
}	