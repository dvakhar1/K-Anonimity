import java.io.IOException;

public class DataCreation {

			ReadFiles rf = new ReadFiles();
		

	public void getInfo() throws IOException {
		// TODO Auto-generated method stub
		rf.readNameGender();	
		rf.readDate();
		rf.readUsername();
		rf.readRelationship();
		rf.readHobbies();
		rf.readZipCode();
		rf.readEmployer();
		rf.readTechnicalSkills();
		rf.writeNameGender();
		
	}

}
