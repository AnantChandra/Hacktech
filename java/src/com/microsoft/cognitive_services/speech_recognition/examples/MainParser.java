package com.microsoft.cognitive_services.speech_recognition.examples;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;


public class MainParser {
	public String line;
   
	public MainParser(speechInput si) {
		if(si.getNBest() == null){
			System.out.println("fuck");
		}
		this.line = si.getNBest().get(0).getDisplay();
	}
	
    public void run()
    {
    	FileWriter fw = null;
    	BufferedWriter bw = null  ;
    	Stack<String> s = new Stack();
		try {
			fw = new FileWriter("outpupt.txt");
			bw = new BufferedWriter(fw);
			bw.write("public class HackTech");
			bw.write("{\n");
			bw.write("public static void main(String[] args)");
			bw.write("{\n");
			
			System.out.print("public class HackTech");
			System.out.print("{\n");
			System.out.print("public static void main(String[] args)");
			System.out.print("{\n");
			
			s.push("{");
			s.push("{");
			String[] commands = line.split("next line");
			for(int i =0 ; i < commands.length; i++ ) {
	        	code(commands[i],bw,s);
	        	System.out.println(commands[i]);
	        }
			cmpCurly(s,bw);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(bw != null) {
					bw.close();
				}
				if(fw != null) {
					fw.close();
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
    	//Stack<char> s new Stack<char>();
    	
   
     //   System.out.println(wordsSplitUp.length);
     //   System.out.println(wordsSplitUp[0]);
        
        
        
        
        
        
        
        /*if(wordsSplitUp[0].equals("nextline")) {
        		System.out.println("");
        }
        
        else if(wordsSplitUp[0].equalsIgnoreCase("print")) {
        		        }
        
        else if(wordsSplitUp[0].equals("if")) {
        		System.out.print("if(" + wordsSplitUp[1]);
        		if(wordsSplitUp[3].equals("greater") || wordsSplitUp[3].equals("more")) {
        			System.out.print(">");
        			System.out.print(wordsSplitUp[5] + ");");
        		}
        		else if(wordsSplitUp[3].equals("less")) {
        			System.out.print("<");
        			System.out.print(wordsSplitUp[5] + ");");
        		}
        		else if(wordsSplitUp[3].equals("equal")) {
        			System.out.print("=");
        			System.out.print(wordsSplitUp[5] + ");");
        		}
        		
        		else if(wordsSplitUp[3].equals("not") && wordsSplitUp[4].equals("equal")) {
        			System.out.print("!=");
        			System.out.print(wordsSplitUp[6] + ");");        			
        		}	
        }
        
        else if(wordsSplitUp[0].equals("while"))
        {
        		System.out.print("while(");
        		String var1 = wordsSplitUp[1];
        		System.out.print(var1);
        		
        		if(wordsSplitUp[3].equals("greater"))
        		{
        			System.out.print(">");
        		}
        		else if(wordsSplitUp[3].equals("equals"))
        		{
        			System.out.print("=");
        		}
        		else if(wordsSplitUp[3].equals("less"))
        		{
        			System.out.print("<");
        		}
        		else if(wordsSplitUp[3].equals("not") && wordsSplitUp[3].equals("equal"))
        		{
        			System.out.print("!=");
        		}
        		
        		String var2 = wordsSplitUp[5];
        		System.out.print(var2);
        		System.out.println(") {");
        	}
        
        else if(wordsSplitUp[0].equals("initialise") || wordsSplitUp[0].equals("initialize"))
        {
        		if(wordsSplitUp[1].equals("string")) {
        			System.out.print("String " + wordsSplitUp[2] + " = " + wordsSplitUp[4] + ";");
        		}
        		
        		else if(wordsSplitUp[1].equals("variable")) {
        			System.out.print("var " + wordsSplitUp[2] + " = " + wordsSplitUp[4] + ";");
        		}
        		
        		else if(wordsSplitUp[1].equals("number")) {
        			System.out.print("int " + wordsSplitUp[2] + " = " + wordsSplitUp[4] + ";");
        		}
        }
        
        else if(wordsSplitUp[0].equals("for"))
        {
        		System.out.print("for(");
        		String var1 = wordsSplitUp[1];
        		System.out.print("int " + var1);
        		System.out.print(" = ");
        		String start = wordsSplitUp[3];
        		String end = wordsSplitUp[5];
        		System.out.print(start + "; " + var1 + " < " + end + "; " + var1 + "++)");
        }
        
        else{
    		System.out.println("");
        }*/
    }
    
    
    private void code(String cmd, BufferedWriter bw,Stack<String> s) {
        String[] wordsSplitUp = cmd.split("\\s");
        try {
			commandChooser(0,bw,wordsSplitUp,s);

        }
        catch(IOException e) {
        	e.printStackTrace();
        }
    }
	public void commandChooser(int keywrd,BufferedWriter bw,String[] wrds, Stack<String> s) throws IOException {
		
		List<String> og_commands= new ArrayList();
		og_commands.add("print");		
		og_commands.add("if");		
		og_commands.add("while");		
		og_commands.add("next line");		
		//={,"if","else","while","next line"};
		if(wrds[keywrd].equalsIgnoreCase("print")) {
			bw.write("System.out.println("+"\"");
			//System.out.print("System.out.println("+"\"");
    		for (int x=keywrd; x< wrds.length; x++) {
    			bw.write(wrds[x] + " ");
    			//System.out.print(wrds[x] + " ");
    		}
    		bw.write("\");\n");
    		//System.out.print("\");\n");
		}
		else if(wrds[keywrd].equalsIgnoreCase("if")) {
			boolean comp = false;
			bw.write("if (");
			for(int i=0;i < wrds.length;i++) {
				for(int j=0; j < og_commands.size(); i++) {
					if(wrds[i].equalsIgnoreCase(og_commands.get(j)));
						for (int x=keywrd; x< i; x++) {
			    			bw.write(wrds[x] + " ");
						}
						bw.write(") ");
						bw.write("{\n");
						//s.push("{");
			    		commandChooser(i,bw,wrds,s);
			    		bw.write("}\n");
			    		comp = true;
				}
			}
			if(!comp) {
				for (int x=keywrd; x< wrds.length; x++) {
	    			bw.write(wrds[x] + " ");
				}
				bw.write(") \n");
			}
			
		}
		else if(wrds[keywrd].equalsIgnoreCase("else")) {
			
		}
		else if(wrds[keywrd].equalsIgnoreCase("while")) {
			boolean comp = false;
			bw.write("while (");
			for(int i=0;i < wrds.length;i++) {
				for(int j=0; j < og_commands.size(); i++) {
					if(wrds[i].equalsIgnoreCase(og_commands.get(j)));
						for (int x=keywrd; x< i; x++) {
			    			bw.write(wrds[x] + " ");
						}
						bw.write(") ");
						bw.write("{\n");
						//s.push("{");
			    		commandChooser(i,bw,wrds,s);
			    		bw.write("}\n");
			    		comp = true;
				}
			}
			if(!comp) {
				for (int x=keywrd; x< wrds.length; x++) {
	    			bw.write(wrds[x] + " ");
				}
				bw.write(") \n");
			}
		}
		else if(wrds[keywrd].equalsIgnoreCase("next line") || wrds[keywrd].equalsIgnoreCase("nextline")) {
			
		}else {
			
		}
    }
	public void cmpCurly(Stack<String> s,BufferedWriter bw) {
		for(int i =0; i < s.size(); i++) {
			try {
				bw.write("}\n");
				System.out.print("}\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}