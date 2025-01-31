package com.project.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.model.dto.Player;

public class PlayerService {
	
	//필드
	
	// 입력시 필요한 객체
	private Scanner sc = new Scanner(System.in);
	
	// 선수를 저장할 목록 List
	private List<Player> fifa = new ArrayList<Player>(); 
	
	// playerService 객체가 생성될 때 fifa List에 4명의 선수 등록
	public PlayerService() {
		fifa.add(new Player("박지성", 30, "MF", "맨체스터유나이티드", "강철체력" ));
		fifa.add(new Player("손흥민", 27, "FW", "토트넘 핫스퍼", "빠른 스피드" ));
		fifa.add(new Player("이강인", 30, "MF", "파리 생제르망", "섬세한 드리블" ));
		fifa.add(new Player("황희찬", 30, "FW", "울버햄트 원더러스", "강한 힘" ));
	}
	
	
	// 메서드
	public void displayMenu() {
		
		
		try {
			
			int menuNum = 0;
			
			do {
				
				System.out.println("****선수 정보 프로그램****");
				System.out.println("1. 선수 등록");
				System.out.println("2. 선수 조회");
				System.out.println("3. 선수 수정");
				System.out.println("4. 선수 삭제");
				
				System.out.println("메뉴를 입력하세요 : ");
				menuNum = sc.nextInt();
				
				switch(menuNum) {
				case 1 : addPlayer(); break;
				
				
				case 2 : showPlayerList(fifa); break;
				
				
				case 3 : editPlayer(); break;
				 
				
				case 4 : deletePlayer(); break;
				
				
				
				case 0 : System.out.println("종료되었습니다."); break;
				default : System.out.println("메뉴에 있는 번호만 입력하세요!"); break;
				}
			
				
			} while (menuNum !=0 );
			
			
		} catch (Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace(); // 
		}
		
		
	}
	
	/**
	 * 선수 추가 메서드
	 * */
	public void addPlayer() {
		
		System.out.println("========선수 등록=========");
		System.out.print("선수 이름 : ");
		String playerName = sc.nextLine();
		sc.nextLine(); // 입력버퍼에 남은 개행문자 제거용
		
		System.out.print("선수 나이 : ");
		int age = sc.nextInt();
		
		System.out.print("선수 포지션 : ");
		String position = sc.nextLine();
		sc.nextLine(); // 입력버퍼에 남은 개행문자 제거용
		
		System.out.print("소속팀 : ");
		String team = sc.nextLine();
		sc.nextLine(); // 입력버퍼에 남은 개행문자 제거용
		
		System.out.print("선수 특징 : ");
		String character = sc.next();
		
		
		Player newPlayer = new Player(playerName, age, position, team, character);
		
		fifa.add(newPlayer);
		
		System.out.println("등록완료");
		
	}
	
	/** 도서 목록 조회용 메서드
	 * 
	 * @param (매개변수) List<Player> == Player로 제한되어 있는 List
	 */
	public void showPlayerList(List<Player> list) {
		
		if(list.isEmpty()) {
			System.out.println("등록된 선수가 없습니다. 선수를 등록해주세요!");
			
		}else {
			
			//list를 순회하면서 각 Player 객체를 출력
			// 향상된 for문 사용
			for(Player temp : list) {
				System.out.println(temp); // Player.toString();
			}
		
			
		}
		
	}
	
	/** 선수 수정용 메서드
	 * @return
	 */
	public void editPlayer() {
		
		showPlayerList(fifa); // 등록된 도서를 출력하기
		
		System.out.println("======선수 수정========");
		
		int editMenu = 0; // 수정 메뉴 선택용 변수
		
		System.out.print("수정할 선수를 입력하세요 : ");
		String playerName = sc.nextLine();
		sc.nextLine();
		
		boolean flag = true;
		 
		for(Player temp : fifa) {
			
			if(temp.getPlayerName() == playerName) { 
				// 입력한 선수이름과 선수 목록의 선수 이름이 일치하는걸 찾았을때
			
				flag = false;
				
				System.out.println("1. 선수 나이");
				System.out.println("2. 포지션");
				System.out.println("3. 소속팀");
				System.out.println("4. 특징");
				System.out.println("0. 수정 종료");
				System.out.print("어떤 정보를 수정하시겠습니까? ");
				
				editMenu = sc.nextInt();
				sc.nextLine(); // 입력버퍼에 남은 개행문자 제거
				
				switch(editMenu) {
				case 1 : 
					System.out.println("=== 선수 나이 수정 ===");
					System.out.print("수정할 선수나이를 입력하세요 : ");
					int age  = sc.nextInt();
					temp.setAge(age);
					break;
					
				case 2 :
					System.out.println("=== 선수 포지션 수정===");
					System.out.print("수정할 포지션을 입력하세요 : ");
					String position = sc.nextLine();
					temp.setPosition(position);
					break;
					
				case 3 :
					System.out.println("=== 선수 소속팀 수정 ===");
					System.out.print("수정할 소속팀을 입력하세요 : ");
					String team = sc.next();
					temp.setTeam(team);
					break;
					
				case 4 :
					System.out.println("=== 선수 특징 수정 ===");
					System.out.print("수정할 특징을 입력하세요 : ");
					String character = sc.nextLine();
					temp.setCharacter(character);
					break;
					
				case 0 : System.out.println("종료합니다..."); break;
				default : System.out.println("메뉴에 있는 번호만 선택하세요"); break;
				}
				
			}
		}
		
		if(flag) {
			System.out.println("일치하는 선수 이름이 없습니다.");
		}
		
		System.out.println("수정 완료");
	}
	
	/** 선수 삭제용 메서드
	 * @return
	 */
	public void deletePlayer() {
		System.out.println("====선수 삭제=====");
		
		showPlayerList(fifa);
		
		System.out.print("삭제할 선수의 이름을 입력하세요 : ");
		String deleteName = sc.nextLine();
		
		for(Player temp : fifa) {
			
			if(temp.getPlayerName() == deleteName) {
				int index = fifa.indexOf(temp);
				// int List.indexOf(Object) : List에 일치하는 객체가 있으면 그 객체가 있는 index번호 반환
				
				System.out.println("index 번호 : " + index);
				
				System.out.print("정말 삭제하시겠습니까? (Y/N) : ");
				
				char answer = sc.next().toUpperCase().charAt(0); // "y" -> "Y" -> 'Y'
				
				if(answer == 'Y') {
					fifa.remove(index);
					System.out.println("선수가 삭제되었습니다.");
					break;
				} else {
					System.out.println("삭제를 진행하지 않습니다");
				}
				return; // 삭제 후 메서드 종료
			}
			
		}
		
		System.out.println("삭제할 선수를 찾을 수 없습니다.");
	}
	
	
	
	

}
