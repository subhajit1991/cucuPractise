package renameFile;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Rename {
	
	public void abc() throws IOException {
		String FILE_PATH = "C:\\\\\\\\Users\\\\\\\\SUBROY\\\\\\\\Downloads\\\\\\\\Abhishek";
		String FILE_EXTENSION = "csv";
		DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss"); // add S if you need milliseconds
		String filename = FILE_PATH + df.format(new Date()) + "." + FILE_EXTENSION;
		System.out.println(filename);
		File file2 = new File(filename);
		File file = new File("C:\\\\\\\\\\\\\\\\Users\\\\\\\\\\\\\\\\SUBROY\\\\\\\\\\\\\\\\Downloads\\\\\\\\\\\\\\\\Abhishek.csv");
		// Rename file (or directory)
		boolean success = file.renameTo(file2);
		if (!success) {
		    System.out.println("File was not successfully renamed");
		}
		else {
			System.out.println("File was successfully renamed");
		}
		
		Runtime.getRuntime().exec("cmd start /c " +filename);
		
		/*
		File myCSVFile = filename; 
		String execString = "start excel " + myCSVFile.getAbsolutePath();
		Runtime run = Runtime.getRuntime();
		try {
		    Process pp = run.exec(execString);
		} catch(Exception e) {
		    e.printStackTrace();
		}
		*/
		/*
		//FileSystem fileSys = FileSystems.getDefault();
	    //Path srcPath = fileSys.getPath("C:\\Users\\SUBROY\\Documents\\Abhishek.csv");
		
	
*/
}

	
}