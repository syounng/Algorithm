import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	
	public static void main(String [] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N, total; //N은 게시판 개수, total 입력수
		Student students[]= new Student[101];
		List<Student> list= new ArrayList<>();
		
		//입력
		N= Integer.parseInt(br.readLine());
		total= Integer.parseInt(br.readLine());
		
		st= new StringTokenizer(br.readLine());
		int num;
		for(int i=0; i<total; i++) {
			num= Integer.parseInt(st.nextToken());
			//1.처음 추천 입력받은 학생이라면
			if(students[num]==null) {
				students[num]= new Student(num, 0, 0, false);
			}
			
			//2.이미 게시된 경우
			if(students[num].isPosted) {
				students[num].cnt++;
			}
			//3.게시된 적 없음
			else {
				//3-1.게시판이 꽉 찬 경우
				if(list.size()==N) {
					//추천수 적은 친구->같으면 오래된 친구
					Collections.sort(list, new Comparator<Student>() {
						public int compare(Student o1, Student o2) {
							if(o1.cnt==o2.cnt) {
								return o1.time-o2.time;
							}
							return o1.cnt-o2.cnt;
						}
					});
					list.get(0).isPosted=false;
					list.remove(0);
				}
				students[num].cnt=1;
				students[num].time=i;
				students[num].isPosted=true;
				list.add(students[num]);
			}
		}//for
		
		//오름차순 출력
		Collections.sort(list, (o1, o2) -> o1.idx-o2.idx);
		for(Student i: list) {
			System.out.print(i.idx+" ");
		}
		
	}//main
	
	static class Student{
		int idx; //학생 번호
		int cnt; //추천수
		int time; //입력받은 순서
		boolean isPosted; //게시판에 게재되었는가?
		
		public Student(int idx, int cnt, int time, boolean isPosted) {
			this.idx = idx;
			this.cnt = cnt;
			this.time = time;
			this.isPosted = isPosted;
		}
	}// class Student
	
}