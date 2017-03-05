package mainCom;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import diagramGenerator.UMLImageRender;
import parser.ClassParser;
import parser.MethodDeclarationStructure;
import parser.ParsedClass;



public class UMLParser {

	private static String JavaProjectPath;
	public static String UMLDiagramPath;	
	private static ArrayList<ParsedClass> pc;
	private static boolean testFlag = false;

	public static void main(String[] args) throws IOException, ParseException {
		intln("--------------------------------------------------------------------------");
	}
}
