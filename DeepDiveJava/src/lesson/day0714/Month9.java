package lesson.day0714;

public class Month9 {
	public void viewMonth(){
		// 탭을 몇 번 줄 것인지
		// 며칟날이 마지막 날인지 
		int startDay = 3;
		int tab = startDay%7;
		int lastDay = 31;
		
		System.out.println("\t\t\t9월");
		System.out.println("일\t월\t화\t수\t목\t금\t토\t");
		
		// tab처리 
		for(int i = 0; i < tab; i++) {
			System.out.print("\t");
		}
		
		// day처리
		for(int i = 1; i < lastDay+1; i++) {
			System.out.print(i+"\t");
			if((tab+i)%7==0) {
				System.out.println("\n");
			}
		}
		
	}
}
