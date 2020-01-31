<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/latte.css">
<link rel="stylesheet" href="./css/table.css">
<link rel="stylesheet" href="./css/input.css">
<link rel="stylesheet" href="./css/message.css">
<title>パスワード再設定</title>
</head>
<body>

	<jsp:include page="header.jsp" />
	<div id="contents">
		<h1>パスワード再設定画面</h1>

		<s:if test="errorUserId!=null && errorUserId.size()>0">

			<div class="error-message">
				<s:iterator value="errorUserId">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:if test="errorPassword!=null && errorPassword.size()>0">

			<div class="error-message">
				<s:iterator value="errorPassword">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>
		<s:if test="errorNewPassword!=null && errorNewPassword.size()>0">

			<div class="error-message">
				<s:iterator value="errorNewPassword">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:if
			test="errorReconfirmPassword!=null && errorReconfirmPassword.size()>0">

			<div class="error-message">
				<s:iterator value="errorReconfirmPassword">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:if
			test="idPasswordDifferent!=null && !idPasswordDifferent.isEmpty()">

			<div class="error-message">
				<s:property value="idPasswordDifferent" />
				<br>
			</div>

		</s:if>
		<s:if test="newPaDifferent!=null && !newPaDifferent.isEmpty()">

			<div class="error-message">
				<s:property value="newPaDifferent" />
				<br>
			</div>

		</s:if>

		<s:form action="ResetPasswordConfirmAction">
			<table class="c-table">
				<tr>
					<th scope="row">ユーザーID</th>
					<td><s:textfield name="userId"
							value="%{#session.userIdForResetPassword}" placeholder="ユーザーID"
							class="txt" autocomplete="off" /></td>
				</tr>
				<tr>
					<th scope="row"><s:label value="現在のパスワード" /></th>
					<td><s:password name="password" value=""
							placeholder="現在のパスワード" class="txt" autocomplete="off" /></td>
				</tr>

				<tr>
					<th scope="row"><s:label value="新しいパスワード" /></th>
					<td><s:password name="newPassword" value=""
							placeholder="新しいパスワード" class="txt" autocomplete="off" /></td>
				<tr>
					<th scope="row"><s:label value="新しいパスワード(再確認)" /></th>
					<td><s:password name="reconfirmPassword" value=""
							placeholder="新しいパスワード(再確認)" class="txt" autocomplete="off"/></td>
				</tr>
			</table>
			<div class="submit_btn_box">
				<s:submit value="確認" class="submit_btn" />
			</div>
		</s:form>
	</div>

</body>
</html>