



import java.util.*;
public class A4p1 {
	
	static int []yn=new int [2];
			
	public static void main(String[] args) {
		int a=Integer.parseInt(args[0]);
		int b=Integer.parseInt(args[1]);
		int n=Integer.parseInt(args[2]); 
		/* Scanner obj=new Scanner(System.in);
		int a=obj.nextInt();
		int b=obj.nextInt();
		int n=obj.nextInt();*/
		int cast=b-a;
		
		int [] range= new int[cast];
		int j=0;
		
		for(int i=a;i<=b;i++) {
			if(i%2!=0) {
			range[j]=i;
			j++;
			}
			
		}
		System.out.print("Using "+n+" threads.\n");
		
		TaskC []TaskO=new TaskC[n];
		Thread []arrT=new Thread[n];
			
		int div=(cast/n);
		int Lb=0; int Ub=div;
		for(int i=0;i<n;i++) {
		TaskO[i]=new TaskC(range,Ub,Lb);
		arrT[i]=new Thread(TaskO[i]);
		arrT[i].start();
		Lb+=div;
		Ub+=div;
		}
		
		for(int i=0;i<n;i++) {
			try {
				arrT[i].join();	}
			catch (InterruptedException e) {
				System.out.println(arrT[i].getName()+"failed to join.");
			}
		}
		System.out.println("Count for (A) is "+yn[1]+".");
		System.out.println("Count for (B) is "+yn[0]+".");
	}

static class TaskC implements Runnable{
	private int[]range;
	private int Ubound;
	private int Lbound;
	
	public TaskC(int[]v,int k,int j) {
	range=v;
	Ubound=k;
	Lbound=j;
}
	@Override
	public void run() {
	
		for(int i=Lbound;i<Ubound;i++) {
			if(range[i]==0) {
				break;
			}
			if(ListC(range[i])){	
				yn[0]++;
			}
			if(ListC(range[i])==false){	
				yn[1]++;
			}
			
		}
	}
}

 public static boolean ListC(int b) {
	
	int listlength=0;
	
	for(int i=b;i>1;){
		
		if(i%2!=0) {
		i=(3*i+1)/2;
		listlength++;
		}
		
		if(i%2==0) {
		i=i/2; 
		listlength++;
		}
	}
	
if(listlength%2==0) {
  return true; 
}else {
  return false;
}
 }
}