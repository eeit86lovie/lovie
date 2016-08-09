<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>Lovie 線上客服</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/formStyle.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/formInner.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/formCommon.css">

	    	    	    <script type="text/javascript" src="${pageContext.request.contextPath}/KF-JS/admin.js"></script>
        <!-- fancybox -->
        <!-- fancybox -->
        <script>
            var brow;
            brow = getInternetExplorerVersion();
            function getInternetExplorerVersion() {
                var rv = -1;
                if (navigator.appName == 'Microsoft Internet Explorer') {
                    var ua = navigator.userAgent;
                    var re = new RegExp("MSIE ([0-9]{1,}[\.0-9]{0,})");
                    if (re.exec(ua) != null)
                        rv = parseFloat(RegExp.$1);
                }
                else if (navigator.appName == 'Netscape') {
                    var ua = navigator.userAgent;
                    var re = new RegExp("Trident/.*rv:([0-9]{1,}[\.0-9]{0,})");
                    if (re.exec(ua) != null)
                        rv = parseFloat(RegExp.$1);
                }
                return rv;
            }
        </script>
  
        <!-- fancybox -->
        <!-- fancybox -->        

        <link type="text/css" href="${pageContext.request.contextPath}/KF-CSS/chatSheets.css" rel="stylesheet"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/KF-JS/underscore-min.js"></script>

        <script type="text/javascript" charset="utf-8">
       //     var site_url = 'http://www.zuvio.com.tw/';


            function client_chat() {
                console.log('client_chat_check : ' + client_chat_check);
                if (client_chat_check) {
                    client_chat_check = false;
                    $.ajax({
                        url: site_url + '/chat/clientChats',
                        type: "POST",
                        data: {
                            id_dt: id_dt
                        },
                        dataType: "json"
                    }).success(function (json_data) {
                        console.log(json_data);
                        underscore_data = json_data.chats;
                        console.log('underscore_data : ');
                        console.log(underscore_data);
                        if (underscore_data != null) {
                            $('#chats_div').append(_.template($('#unshwo_chat_tmp').html()));
                            $('#chats_div').scrollTop($('#chats_div').height());
                            console.log('chats_div : ' + $('#chats_div').height());
                        }
                        client_chat_check = true;
                    });
                }
            }

            function client_submit() {
                var message = $('#message').val();
                var is_ok = true;
                var err_msg = "";

                if (is_ok && message == "") {
                    is_ok = false;
                    err_msg = "请输入留言";
                }

                if (is_ok) {
                    $('#message').val('');

                    $.ajax({
                        url: site_url + '/chat/clientSubmit',
                        type: "POST",
                        data: {
                            id_dt: id_dt,
                            message: message
                        },
                        dataType: "json"
                    }).success(function (json_data) {
                        error_msg('.message', '');
                        console.log(json_data);
                    });
                }
            }
            function checkEnter(e) {
                if (e.keyCode == 13) {
                    client_submit();
                    return false;
                }
            }
        </script>

</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
	<div class="container">
   
    <!-- 內容區塊 -->
    <div class="content">
    	<!-- 左欄 -->
    	<div class="left_frame">
        	<h1>客戶中心</h1>
            <!-- 左欄選單 -->
            <div class="left_menu">
            	<ul>
                	<li><a href="KF-FAQ.jsp" title="常見問題FAQ">常見問題FAQ</a></li>
                    <li><a href="custServiceForm" title="問題回報線上表單">問題回報線上表單</a></li>
                    <li><a href="KF-chat.jsp" title="線上客服" class="select">線上客服</a></li>
                </ul>
            </div>
        </div>
        
    	<!-- 右欄 -->
        <div class="right_frame">
            <!-- 問題回報線上表單內容 -->
            <div class="sub_title">
                <h1><em>問題回報</em>&nbsp 線上客服</h1>
            </div>
<div id="header">

				<div class="white">
					<div class="profile"><img src="http://www.zuvio.com.tw/../public/images/ver_3.0/img_customerservice.png"></div>
					<div class="p_info">
						<div class="name">
							<label>客服小姐</label>
						</div>
						<div class="status">
							<label>有什麼我能為你解決的嗎？</label>
						</div>
					</div>
				</div>
			</div>
			<div id="content">
				<div id="chats_div">
					 <div class="message">
					 	<div class="time">07/26 11:44:38</div>
					 	<div class="text">Lovie線上客服：有什麼可以幫您的嗎？</div>
					 </div>
				</div>
				<div class="input_form">
					<div class="textarea_box">
						<div class="textarea_div">
							<textarea
							 data-autoresize id="message" placeholder="請輸入您的問題與意見" onkeypress="return checkEnter(event)"></textarea>
						</div>
					</div>
					<div class="button_box">
						<div class="button single" onclick="client_submit()">
							<label>送出</label>
						</div>
					</div>
				</div>
			</div>
		
		</div>
	</div>
		</div>
	
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>