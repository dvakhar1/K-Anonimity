import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.GregorianCalendar;
	import java.util.Random;
	
public class ReadFiles {
	



		
		int limit = 50000;
		int index = 0;
		GregorianCalendar gc = null;
		Random rd = new Random();
		BufferedReader br = null;
		BufferedWriter wrs = null;
		BufferedWriter wrp = null;
		FileWriter ws = null;
		FileWriter wp = null;
		String readcsvFile = null;
		String writeSocial = null;
		String writeProfessional = null;
		String line = null;
		ArrayList<String> holdName = new ArrayList<String>();
		ArrayList<String> holdGender = new ArrayList<String>();
		ArrayList<String> holdAllName = new ArrayList<String>();
		ArrayList<String> holdAllGender = new ArrayList<String>();
		ArrayList<String> holdAllDate = new ArrayList<String>();
		ArrayList<String> holdZipCode = new ArrayList<String>(); 
		ArrayList<String> holdAllZipCode = new ArrayList<String>(); 
		ArrayList<String> holdAllUsername = new ArrayList<String>(); 
		ArrayList<String> holdRelationship = new ArrayList<String>();
		ArrayList<String> holdAllRelationship = new ArrayList<String>();
		ArrayList<String> holdHobbies = new ArrayList<String>();
		ArrayList<String> holdAllHobbies = new ArrayList<String>();
		ArrayList<String> holdTechnicalSkills = new ArrayList<String>();
		ArrayList<String> holdAllTechnicalSkills = new ArrayList<String>(); 
		ArrayList<String> holdEmployer = new ArrayList<String>();
		ArrayList<String> holdAllEmployer = new ArrayList<String>();
		
		
		void readNameGender() throws IOException{
			
			br = readCSV("../Big/NameGender.csv");
			
			while ((line = br.readLine()) != null){
				String[] holdAll = line.split(",");
				holdName.add(holdAll[0]);
				holdGender.add(holdAll[1]);
			}
			
			//System.out.println(holdName + " " + holdGender);
			
			generateNameGender();
		}
		
		void generateNameGender(){
			
			for(int i=0;i<limit;i++){
				index = rd.nextInt(holdName.size());
				holdAllName.add(i, holdName.get(index));
				holdAllGender.add(i, holdGender.get(index));
			}
			
			//System.out.println(holdAllName + " " + holdAllGender);
			
		}
		
		void writeNameGender() throws IOException{
			writeSocial = "../Big/Social.csv";
			writeProfessional = "../Big/Professional.csv";
			ws = new FileWriter(writeSocial);
			wp = new FileWriter(writeProfessional);
			wrs = new BufferedWriter(ws);
			wrp = new BufferedWriter(wp);
			
			wrs.write("Name,Gender,Date,Zip Code,Hobbies,Relationship" + "\n");
			wrp.write("Name,Gender,Date,Zip Code,Username,Technical Skills,Employer" + "\n");
			
			for(int i =0;i<limit;i++)
			{
				//fw.write(holdAllName.get(i) + "," + holdAllGender.get(i) + "\n");
				
				wrs.write(holdAllName.get(i) + "," + holdAllGender.get(i) +  "," + holdAllDate.get(i) + "," + holdAllZipCode.get(i) + 
						"," + holdAllHobbies.get(i) + "," + holdAllRelationship.get(i) + "\n");
				
				
				
			}
			for(int i= 0;i<limit;i++)
			{
				wrp.write(holdAllName.get(i) + "," + holdAllGender.get(i) +  "," + holdAllDate.get(i) + "," + holdAllZipCode.get(i) + 
						"," + holdAllUsername.get(i) + "," + holdAllTechnicalSkills.get(i) + "," + holdAllEmployer.get(i) + "\n");
				
				
			}
			wrs.close();
			wrp.close();
			
			
			
		}
		
		void readDate() {
			
			
			gc = new GregorianCalendar();
			for(int i = 0; i< limit;i++){

		        int year = 1970 + rd.nextInt(1);
		        gc.set(Calendar.YEAR, year);
		        int dayOfYear = 1+rd.nextInt(gc.getActualMaximum(Calendar.DAY_OF_YEAR)+1);
		        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);
		        String holdDate = (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH) + "-" + gc.get(gc.YEAR);
		       // System.out.println(holdDate);
		        holdAllDate.add(holdDate);
		        
		       // System.out.println((gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH) + "-" + gc.get(gc.YEAR));
		        
			}
			
			//Calendar.
			//System.out.println(gc.getActualMaximum(Calendar.DAY_OF_YEAR));
			//System.out.println(Calendar.MONTH);
			//System.out.println(holdAllDate);
		}
		
		void readZipCode() throws IOException{
			
			
			br = readCSV("../Big/ZipCode.csv");
					
			while((line = br.readLine()) != null){
				holdZipCode.add(line);
			}
			//System.out.println(holdZipCode);
			generateZipCode();
		}
		
		void generateZipCode(){
			
			
			for(int i = 0; i< limit; i++)
			{
				index = rd.nextInt(holdZipCode.size());
				holdAllZipCode.add(i,holdZipCode.get(index));
				
			}
			//System.out.println(holdAllZipCode);
		}
		

		public void readUsername() {

			for(int i = 0 ;i< limit;i++){
				index = rd.nextInt(900) + 100;
				holdAllUsername.add(i,holdAllName.get(i) + index);
			}
			//System.out.println(holdAllUsername);
			
		}
		
		void readRelationship() {
			holdRelationship.add(0,"Single");
			holdRelationship.add(1,"Married");
			for(int i = 0; i< limit;i++){
				index = rd.nextInt(2);
				holdAllRelationship.add(i,holdRelationship.get(index));
			}
		//System.out.println(holdAllRelationship);	
		}
		
		BufferedReader readCSV(String readCSV) throws FileNotFoundException{
			
			BufferedReader buffRead = new BufferedReader(new FileReader(readCSV));
			
			return buffRead;
			
		}
		void readHobbies() throws IOException{
			
			br = readCSV("../Big/Hobbies.csv");
			
			while((line = br.readLine()) != null){
				holdHobbies.add(line);
			}
			
			generateHobbies();
		}
		
		void generateHobbies() {
			
			for(int i = 0 ; i < limit ; i++){
				index = rd.nextInt(holdHobbies.size());
				holdAllHobbies.add(i,holdHobbies.get(index));
			}
			
			//System.out.println(holdAllHobbies);
		}
		
		void readTechnicalSkills() throws IOException{

			br = readCSV("../Big/TechnicalSkills.csv");
			
			while((line = br.readLine()) != null){
				holdTechnicalSkills.add(line);
			}
			
			//System.out.println(holdTechnicalSkills.size());
			
			generateTechnicalSkills();
		}
		
		void generateTechnicalSkills() {
			
			for(int i = 0 ; i < limit ; i++){
				index = rd.nextInt(holdTechnicalSkills.size());
				holdAllTechnicalSkills.add(i,holdTechnicalSkills.get(index));
			}
			
			//System.out.println(holdAllTechnicalSkills);
		}
		
		void readEmployer() throws IOException{

			br = readCSV("../Big/Employer.csv");
			
			while((line = br.readLine()) != null){
				holdEmployer.add(line);
			}
			
			generateEmployer();
		}
		
		void generateEmployer() {
			
			for(int i = 0 ; i < limit ; i++){
				index = rd.nextInt(holdEmployer.size());
				holdAllEmployer.add(i,holdEmployer.get(index));
			}
			
			//System.out.println(holdAllEmployer);
		}
		
		
		
	}

