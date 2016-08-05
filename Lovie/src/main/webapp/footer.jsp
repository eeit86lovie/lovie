<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div id="notifications-bottom-right"></div>
<footer class="footer-distributed">
	<div class="footer-left">
		<h3>
			<img id="logo" height="60"
				src="${pageContext.request.contextPath}/image/icon/logo.png">
		</h3>
		<p class="footer-links">
			<a href="#">首頁</a> · <a href="#">約會</a> · <a href="#">電影</a> · <a
				href="#">會員</a> · <a href="#">討論</a> · <a href="#">感興趣</a>
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
		<p>
			所登載的內容係屬本會版權所有<br />
		</p>
		在未取得本會書面同意前 不得做片面、全面使用，拷貝、列印、轉載於任何媒體
		<p>
			<span><a href="/FFPage.aspx?ff_sqno=5&fm_sqno=49">隱私權聲明</a></span>
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
		
		
		
		
		<sec:authorize access="!hasRole('USER') and !hasRole('GOLD') and !hasRole('ADMIN')">
			var socket = new SockJS('/Lovie/stomp');
	        stompClient = Stomp.over(socket);
	        stompClient.connect({}, function(frame) {
	        	//setConnected(true);
	            //console.log('Connected: ' + frame);
	            stompClient.subscribe('/topic/guest', function(message){
	            	showBroadcast(JSON.parse(message.body).message);
	            });
	            stompClient.subscribe('/user/queue/chat', function(message){
	            	if(JSON.parse(message.body).sender!=${loginmember.account}){
	            		showMessageTip(JSON.parse(message.body));	
	            	}
	            });
	        });
		</sec:authorize>
		
		
		<sec:authorize access="hasRole('GOLD') and !hasRole('ADMIN')">
			var socket = new SockJS('/Lovie/stomp');
	        stompClient = Stomp.over(socket);
	        stompClient.connect({}, function(frame) {
	            stompClient.subscribe('/topic/user', function(message){
	            	showBroadcast(JSON.parse(message.body).message);
	            });
	            stompClient.subscribe('/user/queue/chat', function(message){
	            	if(JSON.parse(message.body).sender!=${loginmember.account}){
	            		showMessageTip(JSON.parse(message.body));	
	            	}
	            	
	            });
	        });
		</sec:authorize>
	
		<sec:authorize access="hasRole('USER') and !hasRole('GOLD') and !hasRole('ADMIN')">
			var socket = new SockJS('/Lovie/stomp');
	        stompClient = Stomp.over(socket);
	        stompClient.connect({}, function(frame) {
	            stompClient.subscribe('/topic/gold', function(message){
	            	showBroadcast(JSON.parse(message.body).message);
	            });
	            stompClient.subscribe('/user/queue/chat', function(message){
	            	if(JSON.parse(message.body).sender!=${loginmember.account}){
	            		showMessageTip(JSON.parse(message.body));	
	            	}
	            });
	        });
		</sec:authorize>
		
		
		
	

		function showBroadcast(message){
			swal(message)
		}
		function refresh_close(){
			$('.close').click(function(){$(this).parent().fadeOut(200);});
			}
			refresh_close();
		
		function showMessageTip(message){
			$.ajax({
			    url: '${pageContext.request.contextPath}/member/nickname/'+message.sender,
			    type: 'GET',
			    async: false,
			    success: function(response) {
			        nickname = response['nickname'];
			        $("#notifications-bottom-right").html();
					$("#notifications-bottom-right").html('<a href="${pageContext.request.contextPath}/chat/sender='+message.sender+'"><div id="notifications-bottom-right-tab"><div id="notifications-bottom-right-tab-close" class="close"><span class="iconb" data-icon="&#xe20e;"></span></div><div id="notifications-bottom-right-tab-avatar"><img src="${pageContext.request.contextPath}/photo/member/account/'+message.sender+'" width="70" height="70" /></div><div id="notifications-bottom-right-tab-right"><div id="notifications-bottom-right-tab-right-title"><span>'+nickname+'</span> 發給你一個訊息</div><div id="notifications-bottom-right-tab-right-text">'+message.message+'</div></div></div></a>');
					$("#notifications-bottom-right-tab").addClass('animated ' + $('#effects').val());
					refresh_close();
			    }
			  });
			
			
		}
		
		
		
		
	</script>
	
	<script>
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
	</script>


