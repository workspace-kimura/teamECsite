<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="./css/latte.css">
<link rel="stylesheet" type="text/css" href="./css/table.css">
<link rel="stylesheet" type="text/css" href="./css/input.css">
<link rel="stylesheet" type="text/css" href="./css/message.css">
<title>ユーザー情報入力</title>
</head>
<body>
	<jsp:include page="header.jsp" />
	<div id="contents">

		<h1>ユーザー情報入力画面</h1>

		<s:if test="errorFamilyName!=null&&errorFamilyName.size()>0">

			<div class="error-message">
				<s:iterator value="errorFamilyName">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:if test="errorFirstName!=null&&errorFirstName.size()>0">

			<div class="error-message">
				<s:iterator value="errorFirstName">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:if test="errorFamilyNameKana!=null&&errorFamilyNameKana.size()>0">

			<div class="error-message">
				<s:iterator value="errorFamilyNameKana">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:if test="errorFirstNameKana!=null&&errorFirstNameKana.size()>0">

			<div class="error-message">
				<s:iterator value="errorFirstNameKana">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:if test="errorEmail!=null&&errorEmail.size()>0">

			<div class="error-message">
				<s:iterator value="errorEmail">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>


		<s:if test="errorUserId!=null&&errorUserId.size()>0">

			<div class="error-message">
				<s:iterator value="errorUserId">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:if test="errorPassword!=null&&errorPassword.size()>0">

			<div class="error-message">
				<s:iterator value="errorPassword">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:if test="tourokuError!=null && !tourokuError.isEmpty()">

			<div class="error-message">
				<s:iterator value="tourokuError">
					<s:property />
					<br>
				</s:iterator>
			</div>

		</s:if>

		<s:form action="CreateUserConfirmAction">
			<table class="c-table">
				<tbody>
					<tr>
						<th scope="row">姓</th>
						<td><s:textfield name="familyName"
								value="%{#session.familyName}" placeholder="姓" class="txt" autocomplete="off" /></td>
					</tr>

					<tr>
						<th scope="row">名</th>
						<td><s:textfield name="firstName"
								value="%{#session.firstName}" placeholder="名" class="txt" autocomplete="off" /></td>
					</tr>

					<tr>
						<th scope="row">姓ふりがな</th>
						<td><s:textfield name="familyNameKana"
								value="%{#session.familyNameKana}" placeholder="姓ふりがな"
								class="txt" autocomplete="off" /></td>
					</tr>

					<tr>
						<th scope="row">名ふりがな</th>
						<td><s:textfield name="firstNameKana"
								value="%{#session.firstNameKana}" placeholder="名ふりがな"
								class="txt" autocomplete="off" /></td>
					</tr>

					<tr>
						<th scope="row">性別</th>
						<td class="row5"><s:radio name="sex"
								list="%{#session.sexList}" value="%{#session.sex}"
								placeholder="性別" class="row5" /></td>
					</tr>

					<tr>
						<th scope="row">メールアドレス</th>
						<td><s:textfield name="email" value="%{#session.email}"
								placeholder="メールアドレス" class="txt" autocomplete="off" /></td>
					</tr>

					<tr>
						<th scope="row">ユーザーID</th>
						<td><s:textfield name="userId"
								value="%{#session.userIdForCreateUser}" placeholder="ユーザーID"
								class="txt" autocomplete="off" /></td>
					</tr>

					<tr>
						<th scope="row">パスワード</th>
						<td><s:password name="password" value="" placeholder="パスワード"
								class="txt" autocomplete="off" /></td>
					</tr>
				</tbody>
			</table>

			<div class="submit_btn_box">
				<s:submit value="確認" class="submit_btn" />
			</div>
		</s:form>
	</div>

</body>
</html>