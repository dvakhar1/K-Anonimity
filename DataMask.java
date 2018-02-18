import java.awt.List;
	import java.io.BufferedReader;
	import java.io.BufferedWriter;
	import java.io.FileNotFoundException;
	import java.io.FileReader;
	import java.io.FileWriter;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.Collection;
	import java.util.Collections;
	
public class DataMask {
		
		
			
			BufferedReader buffRead = null;
			BufferedWriter bw = null;
			String holdFilePath = null;
			String holdLine = null;
			String writeMasked = null;
			FileWriter wm = null;
			ArrayList<String> holdAllName = new ArrayList<>();
			ArrayList<String> holdAllGender = new ArrayList<>();
			ArrayList<String> holdAllDate = new ArrayList<>();
			ArrayList<String> holdAllZipCode = new ArrayList<>(); 
			ArrayList<String> holdAllHobbies = new ArrayList<>();
			ArrayList<String> holdAllRelationship = new ArrayList<>(); 
			ArrayList<Integer> holdIndex = new ArrayList<>(); 
			ArrayList<String> holdAll = new ArrayList<>(); 
			ArrayList<String> holdFinalZip = new ArrayList<>(); 
			
			void readAll(){
				
				String csvFile = "../Big/Social.csv";
				BufferedReader br = null;
				
				BufferedWriter bw = null;
				FileWriter fw = null;
				
				String line = "";
				String cvsSplitBy = ",";

				ArrayList<String> name =new ArrayList<String>();
				ArrayList<String> last =new ArrayList<String>();
				
				ArrayList<String> al =new ArrayList<String>();
				
				

				// ArrayList with starred zip codes 
				ArrayList<String> al1 = new ArrayList<String>();
				try {
					
					fw = new FileWriter("../Big/SocialMasked.csv");
					bw = new BufferedWriter(fw);

					br = new BufferedReader(new FileReader(csvFile));
					int j=0;
					while ((line = br.readLine()) != null) {

						// use comma as separator
						String[] data = line.split(cvsSplitBy);

						if (j!=0) {
							name.add(data[0]);
							al.add(data[1] + data[2] + data[3]);
							last.add("\""+data[4]+"\""+ "," +"\""+data[5]);
						}
						j++;
					}
					
					System.out.println("al size : "+al.size());
					System.out.println("name size: "+name.size());
					System.out.println("last size: "+last.size());
					System.out.println(al.get(0));
					System.out.println(al.get(1));
					//iterate through the ArrayList<String>

					System.out.println("starring the repeated values");

					int i=0;
					while(al.size()>i){

						if((Collections.frequency(al, al.get(i)))>10){
							al1.add(al.get(i).toString().substring(0, al.get(1).length()-1)+"*");
						}

						else
							al1.add(al.get(i).toString());

						i++;

					}
					System.out.println("starring repeated values done");

					System.out.println("al1 size: "+al1.size());
					System.out.println("al size : "+al.size());
					System.out.println("name size: "+name.size());
					System.out.println("last size: "+last.size());

					i=0;
					bw.write("Name,Gender,DOB,ZipCode,Hobbies,Relationship\n"); 
					
					while(al1.size()>i){
						String content = null;
						content=name.get(i)+","+al1.get(i).toString().substring(0, 1)+","+al1.get(i).toString().substring(1, 9)+","+al1.get(i).toString().substring(9, 14)+","+last.get(i)+"\""+"\n";
						bw.write(content);
						i++;
					}
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					if (br != null) {
						try {
							br.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					
					}
					try {

						if (bw != null)
							bw.close();

						if (fw != null)
							fw.close();

					} catch (IOException ex) {

						ex.printStackTrace();

					}
				}

				System.out.println("Done");
			
			}
			void readContent() throws IOException{
				buffRead = readCSVFile("../Big/Social.csv");
				int k = 0;
				while((holdLine = buffRead.readLine()) != null){
					String [] eachEnrty = holdLine.split(",");
					
					//System.out.println(eachEnrty[0] + eachEnrty[1] + eachEnrty[2] + eachEnrty[3] + eachEnrty[4] + eachEnrty[5]);
					
					
					holdAllName.add(k,eachEnrty[0]);
					holdAllGender.add(k,eachEnrty[1]);
					holdAllDate.add(k,eachEnrty[2]);
					holdAllZipCode.add(k,eachEnrty[3]);
					holdAllHobbies.add(k,eachEnrty[4]);
					holdAllRelationship.add(k,eachEnrty[5]);
					
					k++;
				}
				
				
				
				  for(int j= 0 ;j< holdAllName.size();j++)
				 
				{

					System.out.println(j+ "  " + holdAllName.get(j)+ "," +holdAllGender.get(j) +  "," + holdAllDate.get(j) + "," + holdAllZipCode.get(j)
					
							+ "," + holdAllHobbies.get(j) + "," + holdAllRelationship.get(j) );
				}
				  /*
				  
				  if(holdAllDate.get(10).toString().equals(holdAllDate.get(680).toString()))
				  {
					  System.out.println("yes" + holdAllDate.get(10).toString() + " " + holdAllDate.get(680).toString());
				  }
				  else{
					  System.out.println(holdAllDate.get(10).toString() + " " + holdAllDate.get(680).toString());
				  }
				//  System.out.println(holdAllName.size() + holdAllGender.size() + holdAllDate.size() + holdAllZipCode.size() + holdAllHobbies.size()
				  
				//		  + holdAllRelationship.size());
			/*	int count = 0;
				int i = 0;
				int j = 0;
				int n = 50002;
				String holdMainDate = null;
				String holdNextDate = null;
				String[] holdDateString = new String[n];
			*/	
				/*
				for(i=0;i<holdAllDate.size();i++){
					
					holdDateString[i] = holdAllDate.get(i);
					
				}
				*/
				
			/*	for(i=0;i<holdDateString.length;i++)
				{
					System.out.println(holdDateString[i]);
				}
			*/	/*
				  for(i=0;i<holdAllDate.size()-1;i++){
						
						
						count = 0;
						for(j=i+1;j<holdAllDate.size(); j++){
							
							
							if(holdAllDate.get(i).equals(holdAllDate.get(j)))
							{
								count++;
								
							}
							
						}
						System.out.println(count + " " + holdAllDate.get(i));
					}
				  */
				
				for(int i=0;i<holdAllGender.size();i++)
				{
					holdAll.add(holdAllGender.get(i).toString()+holdAllDate.get(i).toString()+holdAllZipCode.get(i).toString());
				//	System.out.println(holdAll.get(i));
				}
				
				int j =0;
				int num = 0;
				//System.out.println(holdAll.toString());
			//	String [] holdmax = (String[]) holdAll.toArray();
				
				
			//	num = Collections.frequency(holdAll, holdAll.get(3).toString());
				//
				//System.out.println(num);
				
				while(holdAll.size()>j)
				{
					if(( num = Collections.frequency(holdAll, holdAll.get(j).toString())  ) >10){
						
						holdFinalZip.add(holdAllZipCode.get(j).toString().substring(0, holdAllZipCode.get(j).length()-1)+"*");
						System.out.println(num + "   " +holdAll.get(j) + "    " + holdFinalZip.get(j).toString());
					}
					else
					{
						holdFinalZip.add(holdAllZipCode.get(j).toString());
					}
					//System.out.println(holdFinalZip.get(j));
					j++;
					
					
				}
				 
				
				  /*
				int count = 0;
				for(int i=1;i<holdAllGender.size()-1;i++){
					
					holdIndex.add(i);
					for(int j1=i+1;j1<holdAllGender.size(); j1++){
						
						
						if(holdAllGender.get(i).toString().equals(holdAllGender.get(j1).toString()) && holdAllDate.get(i).toString().equals(holdAllDate.get(j1).toString()) && holdAllZipCode.get(i).toString().equals(holdAllZipCode.get(j1).toString()))
						{
							
								count ++;
								holdIndex.add(j1);
							
						}
						
					}
					
					if(count>10){
						System.out.println(count+ "     " +  holdAllZipCode.get(i));
						StringBuilder holdTempZipCode = new StringBuilder(holdAllZipCode.get(i).toString());
								
						
						holdTempZipCode.setCharAt(4,'*');
						//System.out.println(holdIndex.size());
						
						for(int m : holdIndex)
						{
							holdAllZipCode.set(m, holdTempZipCode.toString());
						}
						/*
						for(int m =0 ;m<holdIndex.size();m++)
						{
							
							holdAllZipCode.set(holdIndex.get(m), holdTempZipCode.toString());
						}
						
						//System.out.println(holdTempZipCode.toString());
					//	System.out.println();
					}
					
					}
					for(int b = 0 ; b<holdIndex.size() ;b++)
					{
						holdIndex.remove(b);
					}
					holdIndex.clear();
					count = 0;
					//System.out.println(holdIndex);
				}
				
			*/		
				writeMasked();
			
			}
			
			public BufferedReader readCSVFile(String filePath) throws FileNotFoundException{
				
				BufferedReader br = new BufferedReader(new FileReader(filePath));
				
				return br;
			}
			
			
			
			void writeMasked() throws IOException{
				writeMasked = "../Big/SocialMasked.csv";
				
				wm = new FileWriter(writeMasked);
				bw = new BufferedWriter(wm);
				
			//	wm.write("Name,Gender,Date,Zip Code,Hobbies,Relationship" + "\n");
				
				System.out.println(holdAllName.size());
				for(int i =0;i<holdAllName.size();i++)
				{
					//fw.write(holdAllName.get(i) + "," + holdAllGender.get(i) + "\n");
					
					bw.write(holdAllName.get(i).toString() + "," + holdAllGender.get(i).toString() +  "," + holdAllDate.get(i).toString() + "," + holdFinalZip.get(i).toString() + 
							"," + holdAllHobbies.get(i).toString() + "," + holdAllRelationship.get(i).toString() + "\n");
					System.out.println(i);
					
					
				}
				
				bw.close();
				
				
				
			}
		
	}
