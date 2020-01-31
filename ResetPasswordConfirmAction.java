package com.internousdev.latte.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.latte.dao.UserInfoDAO;
import com.internousdev.latte.util.CommonUtility;
import com.internousdev.latte.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordConfirmAction extends ActionSupport implements SessionAware {

	//現在のユーザID
	private String userId;
	//現在のパスワード
	private String password;
	//新しいパスワード
	private String newPassword;
	//新しいパスワード（再確認）
	private String reconfirmPassword;
	//新しいパスワードと再確認用のパスワードがあっているかのメッセージ
	private String newPaDifferent;
	//ユーザーが存在していないかのメッセージ
	private String idPasswordDifferent;
	//パスワードを隠す変数
	private String concealePassword;

	private Map<String, Object> session;
	private List<String> errorUserId;
	private List<String> errorPassword;
	private List<String> errorNewPassword;
	private List<String> errorReconfirmPassword;

	public String execute() {
		InputChecker ic = new InputChecker();
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		String result = ERROR;

		session.put("userIdForResetPassword", userId);

		errorUserId = ic.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false);
		errorPassword = ic.doCheck("現在のパスワード", password, 1, 16, true, false, false, true, false, false);
		errorNewPassword = ic.doCheck("新しいパスワード", newPassword, 1, 16, true, false, false, true, false, false);
		errorReconfirmPassword = ic.doCheck("新しいパスワード（再確認)", reconfirmPassword, 1, 16, true, false, false, true, false,
				false);
		if (errorUserId.size() > 0
				|| errorPassword.size() > 0
				|| errorNewPassword.size() > 0
				|| errorReconfirmPassword.size() > 0) {
			return result;
		}
		//新しいパスワードと新しいパスワード（再確認）が一致しているか
		newPaDifferent = ic.doPasswordCheck(newPassword, reconfirmPassword);
		if (newPaDifferent != null) {
			return result;
		}
		//DBの会員情報テーブルにユーザーが存在するかチェック
		if (!userInfoDAO.ressetCountUser(userId, password)) {
			idPasswordDifferent = "ユーザーIDまたは現在のパスワードが異なります。";
		} else {
			CommonUtility commonUtility = new CommonUtility();
			concealePassword = commonUtility.concealPassword(newPassword);
			session.put("newPassword", newPassword);
			result = SUCCESS;

		}
		return result;

	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getReconfirmPassword() {
		return reconfirmPassword;
	}

	public void setReconfirmPassword(String reconfirmPassword) {
		this.reconfirmPassword = reconfirmPassword;
	}

	public String getNewPaDifferent() {
		return newPaDifferent;
	}

	public void setNewPaDifferent(String newPaDifferent) {
		this.newPaDifferent = newPaDifferent;
	}

	public String getConcealePassword() {
		return concealePassword;
	}

	public void setConcealePassword(String concealePassword) {
		this.concealePassword = concealePassword;
	}

	public String getIdPasswordDifferent() {
		return idPasswordDifferent;
	}

	public void setIdPasswordDifferent(String idPasswordDifferent) {
		this.idPasswordDifferent = idPasswordDifferent;
	}

	public void setErrorUserId(List<String> errorUserId) {
		this.errorUserId = errorUserId;
	}

	public List<String> getErrorUserId() {
		return errorUserId;
	}

	public void setErrorPassword(List<String> errorPassword) {
		this.errorPassword = errorPassword;
	}

	public List<String> getErrorPassword() {
		return errorPassword;
	}

	public void setErrorNewPassword(List<String> errorNewPassword) {
		this.errorNewPassword = errorNewPassword;
	}

	public List<String> getErrorNewPassword() {
		return errorNewPassword;
	}

	public void setErrorReconfirmPassword(List<String> errorReconfirmPassword) {
		this.errorReconfirmPassword = errorReconfirmPassword;
	}

	public List<String> getErrorReconfirmPassword() {
		return errorReconfirmPassword;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}