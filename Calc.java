import java.util.Random;

public class Calc {
	public static void main(String [] args){
	Random rand = new Random();

	int  n = rand.nextInt(50000);
	int n1;
	float i;
	if(n<50000){
		n1=(50000-n)*100;
		i=n1/50000;
		System.out.println(i);
	}
	
	}
}
