import java.util.Random;
import java.util.Scanner;

public class lsj20211484_mid1 {

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		//입력
		System.out.println("가위바위보 인원 수를 입력해주세요 :");
		int p_num = sc.nextInt();
		
		String[] arr1 = new String[p_num];
				
		System.out.println("컴퓨터 수를 입력해주세요 :");
		int c_num = sc.nextInt();
		
		System.out.println((p_num-c_num)+"번 입력해주세요");
		
		for(int i=0;i<p_num-c_num;i++) {
			System.out.println("가위, 바위, 보 중 하나를 입력해주세요 :");
			arr1[i] = sc.next();
		}
		
		//컴퓨터 가위바위보 생성
		for(int i=0;i<c_num;i++){
			int rannum = random.nextInt(3);
			
			if(rannum == 0) {
				arr1[i+(p_num-c_num)] = "가위";
			}else if(rannum == 1) {
				arr1[i+(p_num-c_num)] = "바위";
			}else if(rannum == 2) {
				arr1[i+(p_num-c_num)] = "보";
			}
		}
		
		//각자 낸 값 출력
		for(int i=0;i<p_num;i++) {
			if(i<p_num-c_num){System.out.println("사용자"+(i+1)+" : "+arr1[i]);
			}else {System.out.println("컴퓨터"+(i+1-(p_num-c_num))+" : "+arr1[i]);}
		}
		
		//무승부 여부 확인
		String comp1 = "none";
		String comp2 = "none";
		
		for(int i=0;i<p_num;i++) {
			
			if((comp1 == "none") || (comp1.equals(arr1[i]))) {
				comp1 = arr1[i];
			}else if((comp2 == "none") || (comp2.equals(arr1[i]))) {
				comp2 = arr1[i];
			}else {
				System.out.println("무승부입니다.");
				return;
			}	
		}
		
		if(comp2 == "none") {
			System.out.println("무승부입니다.");
			return;
			}
		
		//승패 경우 확인
		int comp1_win = 2;
		if((comp1.equals("가위") && comp2.equals("보")) || (comp1.equals("보") && comp2.equals("바위")) || (comp1.equals("바위") && comp2.equals("가위"))){
			comp1_win = 1;
		}else {comp1_win = 0;}

		//승자 출력
		System.out.println("가위바위보에서 이긴 사람입니다.");

		for(int i=0;i<p_num;i++) {
			if(comp1_win == 1 && (comp1.equals(arr1[i]))){
				if(i<p_num-c_num){System.out.println("사용자"+(i+1));
				}else {System.out.println("컴퓨터"+(i+1-(p_num-c_num)));}
	
			}else if(comp1_win == 0 && (comp2.equals(arr1[i]))){
				if(i<p_num-c_num){System.out.println("사용자"+(i+1));
				}else {System.out.println("컴퓨터"+(i+1-(p_num-c_num)));}
			}
		}
		
	}

}