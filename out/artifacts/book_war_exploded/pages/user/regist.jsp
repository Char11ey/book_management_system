<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>尚硅谷会员注册页面</title>
    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@include file="/pages/common/head.jsp"%>
	<script type="text/javascript">
		$(function () {
			$("#code_img").click(function () {
				this.src = "${basePath}kaptcha.jpg?d=" + new Date();
			});

			$("#sub_btn").click(function () {
				//判断用户名是否合法
				let regExp1 = /^\w{5,12}$/;
				let username = $("#username").val();
				if(!regExp1.test(username)){
					$("span.errorMsg").text("用户名不合法!");
					return false;
				}
				//判断密码是否合法
				let password = $("#password").val();
				if(!regExp1.test(password)){
					$("span.errorMsg").text("密码不合法!");
					return false;
				}
				//确认密码是否正确
				let repwd = $("#repwd").val();
				if(repwd !== password){
					$("span.errorMsg").text("两次密码不一致!");
					return false;
				}
				//判断电子邮件格式是否正确
				let email = $("#email").val();
				let regExp2 = /\w+([- +.]\w)*@\w+([-.]\w+)*\.\w+([-.]\w+)*/;
				if(!regExp2.test(email)){
					$("span.errorMsg").text("电子邮件格式错误!");
					return false;
				}
				//判断验证码是否输入正确
				let code = $("#code").val();
				code = code.trim();
				if(code == null || code === ""){
					$("span.errorMsg").text("验证码错误!");
					return false;
				}
			})
		})
	</script>
<style type="text/css">
	.login_form{
		height:420px;
		margin-top: 25px;
	}
	
</style>
</head>
<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">
									${requestScope.msg}
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist">
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名"
										   value="${requestScope.username}"
										   autocomplete="off" tabindex="1" name="username" id="username"/>
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off"
										   value="admin" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off"
										   value="admin" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off"
										   value="${requestScope.email}" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 80px;" id="code" name="code"/>
									<img id="code_img" alt="" src="kaptcha.jpg" style="float: right; margin-right: 40px; width: 110px; height: 30px">
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
		<%-- 静态包含页脚 --%>
		<%@include file="/pages/common/footer.jsp"%>
</body>
</html>