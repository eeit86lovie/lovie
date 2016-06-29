	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<%@page pageEncoding="UTF-8" %>
	<footer class="footer-distributed">
	<div class="footer-left">
		<h3>
			<img id="logo" height="60" src="./image/icon/logo.png">
		</h3>
		<p class="footer-links">
			<a href="#">首頁</a> · <a href="#">約會</a> · <a href="#">電影</a>
			· <a href="#">會員</a> · <a href="#">討論</a> · <a href="#">感興趣</a>
		</p>
		<p class="footer-company-name">Lovie &copy; 2015</p>
	</div>
	<div class="footer-center">
		<div>
			<i class="fa fa-map-marker"></i>
			<p>
				<span>復興南路一段390號</span> 台北市,大安區
			</p>
		</div>
		<div>
			<i class="fa fa-phone"></i>
			<p>02 66316599</p>
		</div>
		<div>
			<i class="fa fa-envelope"></i>
			<p>
				<a href="mailto:support@company.com">support@Lovie.com</a>
			</p>
		</div>
	</div>
	<div class="footer-right">
		<p class="footer-company-about">
			<span>版權聲明</span> 
			<p>所登載的內容係屬本會版權所有<br /></p>
             在未取得本會書面同意前
             不得做片面、全面使用，拷貝、列印、轉載於任何媒體
             <p><span><a href="/FFPage.aspx?ff_sqno=5&fm_sqno=49">隱私權聲明</a></span>
		</p>
		<div class="footer-icons">
			<a href="#"><i class="fa fa-facebook"></i></a> <a href="#"><i
				class="fa fa-twitter"></i></a> <a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-github"></i></a>
		</div>
	</div>
	</footer>
	<script>
		$(function() {
			// Stick the #nav to the top of the window
			var nav = $('#nav');
			var navHomeY = nav.offset().top;
			var isFixed = false;
			var $w = $(window);
			$w.scroll(function() {
				var scrollTop = $w.scrollTop();
				var shouldBeFixed = scrollTop > navHomeY;
				if (shouldBeFixed && !isFixed) {
					nav.css({
						position : 'fixed',
						top : 0,
						
						left : nav.offset().left,
						width : nav.width()
					});
					isFixed = true;
				} else if (!shouldBeFixed && isFixed) {
					nav.css({
						position : 'static'
					});
					isFixed = false;
				}
			});
		});
		
		
		<c:if test="${empty LoginOK }">
		/**************login**********/
		$('input[type="submit"]').mousedown(function(){
			  $(this).css('background', '#2ecc71');
			});
			$('input[type="submit"]').mouseup(function(){
			  $(this).css('background', '#1abc9c');
			});

			$('#loginform').click(function(){
			  $('.login').fadeToggle('slow');
			  $(this).toggleClass('green');
			});



			$(document).mouseup(function (e)
			{
			    var container = $(".login");

			    if (!container.is(e.target) // if the target of the click isn't the container...
			        && container.has(e.target).length === 0) // ... nor a descendant of the container
			    {
			        container.hide();
			        $('#loginform').removeClass('green');
			    }
			});
			
			account_error = $('#account_error');
			password_error = $('#password_error');
			login_error = $('#login_error');
			
			function login(){
				account_error.text("");
				password_error.text("");
				login_error.text("");
				account = $('#login_account').val();
				password = $('#login_password').val();
				xhr = new XMLHttpRequest();
				xhr.onreadystatechange = login_callback;
				xhr.open("post", "login.do")
				xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
				xhr.send("account="+account+"&password="+password+"&uri=${requestScope['javax.servlet.forward.request_uri']}");
	
			}
		
			function login_callback(){
				if(xhr.readyState == 4 && xhr.status==200){
					loginMsgs = JSON.parse(xhr.responseText);
					if(loginMsgs.LoginSuccess){
						
						window.location.replace(loginMsgs.LoginSuccess);
					}
					account_error.text(loginMsgs.AccountEmptyError);
					password_error.text(loginMsgs.PasswordEmptyError);
					login_error.text(loginMsgs.LoginFailError);
				}
				
			}
		
		</c:if>
		
	</script>
	
	
	