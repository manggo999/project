package com.project.model.dto;

public class Player {
	
	// 필드
	private String playerName; // 선수 이름
	private int age; // 나이
	private String position; // 포지션
	private String team; // 소속팀
	private String character; // 선수 특징
	
	
	// 생성자
	public Player() {} // 기본 생성자
	
    // 매개변수 생성자
	public Player(String playerName, int age, String position, String team, String character) {
		super();
		this.playerName = playerName;
		this.age = age;
		this.position = position;
		this.team = team;
		this.character = character;
	}
	
    // 메서드
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlyerName(String playerName) {
		this.playerName = playerName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	

	@Override
	public String toString() {
		 return "선수이름 : " + playerName + " [나이 : " + age + " / 포지션 : " + position + " / 소속팀 : " + team + " / 특징 : " + character + "]";
	
	}
	
	
	
	
	

}
