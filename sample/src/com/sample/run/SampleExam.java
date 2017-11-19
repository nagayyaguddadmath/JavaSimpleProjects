package com.sample.run;

public class SampleExam {

	public static void main(String[] args) {
		//		System.out.println("Hello...");
		//		SampleChild c = new SampleChild();
		//		SampleChild2 b = new SampleChild2();
		//		b= c;

		//int x = 3&5;
		//int y = 3|5;
		//System.out.println(x + "dd" + y);

		boolean b1= true;
		boolean b2 = false;
		boolean b3 = true;
		if (b1 | b2)
			System.out.println("true");
		if (b1 & b2 | b2 & b3 | b2)
			System.out.println("Hello...");
		if (b1 & b2 | b2&b3 | b2 | b1)
			System.out.println("Helloada...");
		
	}

	public int minmoves(int[] avg) {
        int n =avg.length;
        int temp = 0;
        int moves = 0;
       
        for(int i=0; i < n; i++){
                for(int j=1; j < (n-i); j++){
                       
                        if(avg[j-1] < avg[j]){
                                //swap the elements!
                                temp = avg[j-1];
                                avg[j-1] = avg[j];
                                avg[j] = temp;
                                moves++;
                        }
                       
                }
        }
		return moves;

	}
}
