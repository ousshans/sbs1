package com.ozd.extract;


//-----------------------------------------
import java.io.File;
import java.text.SimpleDateFormat;

//-----------------------------------------
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class GetFileLastModified
{
	
	public GetFileLastModified(String path) {
		File file = new File(path);//v

		String format = "MM/dd/yyyy HH:mm:ss";

		//Format of last modified of the file
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		
		//Format of time right now
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
		
		//Time right now
		LocalDateTime now = LocalDateTime.now();
		
		//extract numbers from the format of last modified
		int mM = Integer.parseInt( sdf.format(file.lastModified()).substring(0, 2));
		int dd = Integer.parseInt(sdf.format(file.lastModified()).substring(3, 5));
		int yyyy = Integer.parseInt(sdf.format(file.lastModified()).substring(6, 10));
		int hh = Integer.parseInt(sdf.format(file.lastModified()).substring(11, 13));
		int mm = Integer.parseInt(sdf.format(file.lastModified()).substring(14, 16));
		int ss = Integer.parseInt(sdf.format(file.lastModified()).substring(17, 19));
		System.out.println("LastModified : "+mM+"/"+dd+"/"+yyyy+" "+hh+":"+mm+":"+ss);
		
		//extract numbers from the format of now
		int mM_now = Integer.parseInt( dtf.format(now).substring(0, 2));
		int dd_now = Integer.parseInt(dtf.format(now).substring(3, 5));
		int yyyy_now = Integer.parseInt(dtf.format(now).substring(6, 10));
		int hh_now = Integer.parseInt(dtf.format(now).substring(11, 13));
		int mm_now = Integer.parseInt(dtf.format(now).substring(14, 16));
		int ss_now = Integer.parseInt(dtf.format(now).substring(17, 19));
		System.out.println("Now          : "+mM_now+"/"+dd_now+"/"+yyyy_now+" "+hh_now+":"+mm_now+":"+ss_now);
		
		
		if( (yyyy_now == yyyy) && (mM == mM_now)) {
			if((dd == dd_now))
			{
				//les fichiers à scannés
				System.out.println("had lfichier khas nscaniwh neeefs nhar");
				ReaderData datareader = new ReaderData(path);
			}else if((Math.abs(dd - dd_now) < 2)) {
				if(hh_now < hh) {
					System.out.println("had lfichier khas nscaniwh machi nefs nhar mais 9l mn 24h");
					ReaderData datareader = new ReaderData(path);
				}
			}else {
				System.out.println("hadchi 9dim almerdi");
			}
		}
	}
}
