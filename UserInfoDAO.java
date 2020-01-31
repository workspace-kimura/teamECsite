package com.internousdev.latte.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.latte.dto.UserInfoDTO;
import com.internousdev.latte.util.DBConnector;


public class UserInfoDAO {

	private UserInfoDTO userInfoDTO = new UserInfoDTO();
	//ユーザー情報入力機能
	//DTOは使わない
	//ユーザーが存在しているかしていないかを会員情報テーブルから確かめるメソッド
	public boolean countUserId(String userId){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		boolean result=false;
		String sql="SELECT COUNT(*)as count FROM user_info WHERE user_id=? ";
		PreparedStatement preparedStatement;
	try {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, userId);
		ResultSet resultSet=preparedStatement.executeQuery();

		while(resultSet.next()) {
			if(resultSet.getInt("count")>0) {
				result=true;
			}
		}

	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
	try {
		connection.close();
	}catch(Exception e) {
		e.printStackTrace();
	}
	}
	return result;

	}

	//マイページ機能戻り値DTO
	public UserInfoDTO getUserInfo(String userId){
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql="SELECT * FROM user_info where user_id=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				userInfoDTO.setFamilyName(resultSet.getString("family_name"));
				userInfoDTO.setFirstName(resultSet.getString("first_name"));
				userInfoDTO.setFamilyNameKana(resultSet.getString("family_name_kana"));
				userInfoDTO.setFirstNameKana(resultSet.getString("first_name_kana"));
				userInfoDTO.setSex(resultSet.getInt("sex"));
				userInfoDTO.setEmail(resultSet.getString("email"));
			}

			}catch(SQLException e) {
				e.printStackTrace();
			}try {
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}

		return userInfoDTO;
	}

	//パスワード再設定機能
			//ユーザーIDと現在のパスワードを見に行ってユーザーが存在しているかしていないか
	public boolean ressetCountUser(String userId,String password) {
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		boolean result=false;
		String sql="SELECT COUNT(*) as count FROM user_info WHERE user_id=? AND password=?";
		PreparedStatement preparedStatement;

		try {
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, password);
			ResultSet resultSet=preparedStatement.executeQuery();

			while(resultSet.next()) {
				if(resultSet.getInt("count")>0) {
					result=true;
				}
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}

		return result;
			}

	//パスワード再設定機能
	//新しいパスワードをupdateする
	public int updatePassword(String userId,String password) {
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql="UPDATE user_info set password=? where user_id=?";
		int result=0;

		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, password);
			preparedStatement.setString(2, userId);

			result=preparedStatement.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;

	}

	//ユーザー情報入力機能
	//マイページ機能
	//登録ボタンが押されると性、名、性ふりがな、名ふりがな、性別、メールアドレス
	//を会員情報テーブルにINSERTするメソッド
	public int createUser(String userId,String password,String familyName,String firstName,String familyNameKana,String firstNameKana,String sex,String email) {

		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		String sql="INSERT INTO user_info(user_id,password,family_name,first_name,family_name_kana,first_name_kana,"
				+ "sex,email,status,logined,regist_date,update_date)VALUES(?,?,?,?,?,?,?,?,?,?,now(),now())";

		int count=0;
		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);

			preparedStatement.setString(1,userId);
			preparedStatement.setString(2,password);
			preparedStatement.setString(3,familyName);
			preparedStatement.setString(4, firstName);
			preparedStatement.setString(5, familyNameKana);
			preparedStatement.setString(6, firstNameKana);
			preparedStatement.setString(7, sex);
			preparedStatement.setString(8, email);
			preparedStatement.setInt(9, 0);
			preparedStatement.setInt(10, 1);

			count=preparedStatement.executeUpdate();

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
		try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		return count;
	}

	//ログイン機能
	//ログインボタン押下　ユーザーIDとパスワードがテーブルにあるか見に行く
	public boolean isExistsUser(String userId,String password) {
		DBConnector dbConnector=new DBConnector();
		Connection connection=dbConnector.getConnection();
		boolean result = false;
		String sql="SELECT count(*) as count FROM user_info where user_id=? and password=?";

		try {
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2,password);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (resultSet.getInt("count") > 0) {
					result = true;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}




