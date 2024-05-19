import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class lsj20211484_mid2 {

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		
		//입력
		System.out.println("가위바위보 인원 수를 입력해주세요:");
		int p_num = sc.nextInt();
		
		String[] arr1 = new String[p_num];
		String[] arr2 = new String[p_num];
		
		System.out.println("컴퓨터 수를 입력해주세요 :");
		int c_num = sc.nextInt();
		
		System.out.println((p_num-c_num)+"번 입력해주세요");
		
		for(int i=0;i<p_num-c_num;i++) {
			System.out.println("가위, 바위, 보 중 하나를 입력해주세요(오른손) :");
			arr1[i] = sc.next();
			System.out.println("가위, 바위, 보 중 하나를 입력해주세요(왼 손) :");
			arr2[i] = sc.next();
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
		
		for(int i=0;i<c_num;i++){
			int rannum = random.nextInt(3);
			
			if(rannum == 0) {
				arr2[i+(p_num-c_num)] = "가위";
			}else if(rannum == 1) {
				arr2[i+(p_num-c_num)] = "바위";
			}else if(rannum == 2) {
				arr2[i+(p_num-c_num)] = "보";
			}
		}
		
		//각자 낸 값 출력
		for(int i=0;i<p_num;i++) {
			if(i<p_num-c_num){System.out.println("사용자"+(i+1)+" : "+arr1[i]+" / "+arr2[i]);
			}else {System.out.println("컴퓨터"+(i+1-(p_num-c_num))+" : "+arr1[i]+" / "+arr2[i]);}
		}
		
		int[] sco = new int[p_num];

        List<String> combinations = new ArrayList<>();
        generateComb(arr1, arr2, 0, "", combinations);

        // 각 조합을 출력
        for (String combo : combinations) {
        	
        	String[] comp = new String[p_num];
        	
        	for(int i=0;i<p_num;i++) {
        		comp[i] = combo.split(",")[i].trim();
        	}
        	for(int i=0;i<p_num;i++) {
        		System.out.print(comp[i]+" ");
        	}
        	System.out.println();
        	
    		//무승부 여부 확인
    		String comp1 = "none";
    		String comp2 = "none";
    		int comp1_win = 0;
    		
    		for(int i=0;i<p_num;i++) {
    			
    			if((comp1 == "none") || (comp1.equals(comp[i]))) {
    				comp1 = comp[i];
    			}else if((comp2 == "none") || (comp2.equals(comp[i]))) {
    				comp2 = comp[i];
    			}else {
    				comp1_win = 2;
    				break;
    			}	
    		}
    		
    		if(comp2 == "none") {
				comp1_win = 2;
    			}
    		
    		if(comp1_win == 2) {
    			
    		}else if((comp1.equals("가위") && comp2.equals("보")) || (comp1.equals("보") && comp2.equals("바위")) || (comp1.equals("바위") && comp2.equals("가위"))){
    			comp1_win = 1;
    		}else {comp1_win = 0;}
    		
    		
    		for(int i=0;i<p_num;i++) {
    			if(comp1_win == 1 && (comp1.equals(comp[i]))){
    				sco[i] += 5;
    			}else if(comp1_win == 0 && (comp2.equals(comp[i]))){
    				sco[i] += 5;
    			}else if(comp1_win == 2 ){
    				break;
    			}else{ sco[i] -= 3; }
    		}
    		
        }
        
		for(int i=0;i<p_num;i++) {
			if(i<p_num-c_num){System.out.println("사용자"+(i+1));
				}else{System.out.println("컴퓨터"+(i+1-(p_num-c_num))+" / 점수 :"+sco[i]);}
		}
		
	}
	
    public static void generateComb(String[] arr1, String[] arr2, int index, String current, List<String> combinations) {
        if (index == arr1.length) {
            combinations.add(current);
            return;
        }

        // arr1[index] 선택
        generateComb(arr1, arr2, index + 1, current + arr1[index] + ", ", combinations);

        // arr2[index] 선택
        generateComb(arr1, arr2, index + 1, current + arr2[index] + ", ", combinations);
    }

}