package com.internousdev.latte.dto;

public class UserInfoDTO {
	//会員情報テーブル

	//ID
	public int id;

	//ユーザーID
	public String userId;

	//パスワード
	public String password;

	//性
	public String familyName;

	//名
	public String firstName;

	//性　かな
	public String familyNameKana;

	//名　かな
	public String firstNameKana;

	//性別
	public int sex;

	//メールアドレス
	public String email;

	//ログインフラグ
	public int logined;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId=userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

	public String getFamilyName() {
		return familyName;
	}
	public void setFamilyName(String familyName) {
		this.familyName=familyName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
		this.familyNameKana=familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana=firstNameKana;
	}

	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex=sex;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}

	public int getLogined() {
		return logined;
	}
	public void setLogined(int logined) {
		this.logined=logined;
	}

}
