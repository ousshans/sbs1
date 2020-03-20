package com.ozd.extract;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.io.*;
import java.util.regex.*;


//@Copyright Mac-de-Zak

public class ReaderData {
	
	
	
	private static Pattern pattern_mot;
    private static Matcher matcher_mot;

        
    
	
	static String path = "/Users/mac/Desktop/PFE";
	//static String path = "/Users/mac/Desktop/PFE/cbgescli.4gl";

	//static String path = "";
	public static File folder = new File(path);
	static String temp = "";
	
	public static void main(String[] args) {
        
         
        String regex_word = "[a-zA-Z0-9]{2,60}";
        //String email ="salam56F";
        Pattern pattern = Pattern.compile(regex_word);
        /*Matcher matcher = pattern.matcher(email);
        System.out.println(email +" : "+ matcher.matches());*/
        
		
		System.out.println("Reading files under the folder "+ folder.getAbsolutePath()+"\n");
		listFilesForFolder(folder);
	    File file = new File(path);
		Scanner scan = null;
		try {
			scan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//Commentaires
		
		while(scan.hasNext()) {
			
			
			String requette;
			String next = scan.next();
			String nextLine = scan.nextLine();
			switch (next) {
			case "#":
				System.out.println("ceci sont des commentaires");
				System.out.println("\t"+nextLine);
				break;
			case "DEFINE":
				System.out.println("ceci sont des variables");
				System.out.println("\t"+nextLine);
				break;
				
			case "display":
				System.out.println("ceci sont des messages");
				System.out.println("\t"+next);
				break;
				
			case "UPDATE":
			requette = "\tUPDATE ";
				requette+=nextLine;
				System.out.println("requette sql update\n"+requette);
					
				break;
				
			case "INSERT":
				requette = "\tINSERT ";
					requette+=nextLine;
					System.out.println("requette sql update\n"+requette);
						
					break;
					
			case "DELETE":
				requette = "\tDELETE ";
					requette+=nextLine;
					System.out.println("requette sql update\n"+requette);
						
					break;
				
					
			case "CALL":
				requette = "\tCALL ";
					requette+=nextLine;
					System.out.println("Les fonctions appelés sont : \n"+requette);
					break;
			default:
				//System.out.println("Rien trouvé\n");
				break;
			}
		}
		measureTime("Files.readAllLines()", ReaderData::readAllLines, path);
	}
	
		private static void measureTime(String name, Function<String, List<String>> fn, String path) {
	        System.out.println("-----------------------------------------------------------");
	        System.out.println("run: " + name);
	        long startTime = System.nanoTime();
	        List<String> l = fn.apply(path);
	        long estimatedTime = System.nanoTime() - startTime;
	        System.out.println("lines: " + l.size());
	        System.out.println("estimatedTime: " + estimatedTime / 1_000_000_000.);
	    }
		
		private static List<String> readAllLines(String path) {
	        try {
	            return Files.readAllLines(Paths.get(path));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
		
		
		public static void listFilesForFolder(final File folder) {
			for (final File fileEntry : folder.listFiles()) {
				if (fileEntry.isDirectory()) {
					// System.out.println("Reading files under the folder "+folder.getAbsolutePath());
					listFilesForFolder(fileEntry);
				}else {
					if (fileEntry.isFile()) {
						temp = fileEntry.getName();
						//on choisi l'extesion avec l'aquelle on va selectionné pour scanné
						String extension = "4gl";
						if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals(extension))
						{
							path = ""+folder.getAbsolutePath()+ "/" + fileEntry.getName();
							System.out.println(folder.getAbsolutePath()+ "/" + fileEntry.getName());
						}
					}
				}
	    	}
	  	}
}




    



