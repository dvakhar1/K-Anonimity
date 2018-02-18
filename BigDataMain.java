import java.io.IOException;

public class BigDataMain {

	
		
		public static void main(String[] args) throws IOException{
			
			//	System.out.println("Hello World");
				DataCreation dCreation = new DataCreation();
				DataMask dm = new DataMask();
				
			   dCreation.getInfo();
			dm.readContent();
			//	dm.readAll();
			}


}
