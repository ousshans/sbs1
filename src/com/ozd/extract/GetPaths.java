package com.ozd.extract;

import java.io.File;

//Java program to Print root to leaf path WITHOUT 
//using recursion 


public class GetPaths {
	//variable qu'il doit être initialiser par l'utilisateur (browse..)
	static String path = "/Users/mac/Desktop/PFE";
	public static File folder = new File(path);
	static String temp = "";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Reading files under the folder "+ folder.getAbsolutePath()+"\n");
		listFilesForFolder(folder);
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
						System.out.println(folder.getAbsolutePath()+ "/" + fileEntry.getName());
				}
			}
    	}
  	}

}
