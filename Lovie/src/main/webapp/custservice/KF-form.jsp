<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>Lovie 線上表單</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/formStyle.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/formInner.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/formCommon.css">   <!--字型-->
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
                    <li><a href="" title="問題回報線上表單" class="select">問題回報線上表單</a></li>
                </ul>
            </div>
        </div>
        
    	<!-- 右欄 -->
        <div class="right_frame">
            <!-- 問題回報線上表單內容 -->
            <div class="sub_title">
                <h1><em>問題回報</em>&nbsp 線上表單</h1>
            </div>
            
            <!-- 表單內容｜除聯絡信箱、電話、附件上傳以外，皆為必填欄位 -->
            <div class="form_detail">
            	<!-- 問題分類選單 -->
            	<form name="faq_form" id="faq_form" action="?pg=faq_form" method="post" enctype="multipart/form-data">
                <div class="select_form_cata">
                <select name="catalog" id="catalog" class="select_form_list">
                    	<option value=""  selected>選擇問題分類</option>
                    							
												<c:forEach items="${catagory }" var="catagoryVar">
													<option value="${catagoryVar.id }">${catagoryVar.catagory }</option>
												</c:forEach>
										</select>
              	</div>
              
            	<!-- 文字表單｜單欄限字數最多100字 -->
            	<div class="form_area" id="divRole"><lable>帳號</lable><input type="text" class="form_txt" name="role" id="role" placeholder="${loginmember.account }" value="" /></div>
                <div class="form_area"><lable>姓名</lable><input type="text" class="form_txt" name="username" id="username" placeholder="${loginmember.nickname} " value="" /></div>
                <div class="form_area"><lable>信箱</lable><input type="text" class="form_txt" name="email" id="email" placeholder="${loginmember.email }" value="" /></div>

                <!-- 文字表單｜多欄不限字數 -->
                <div class="form_area">
                  <textarea class="form_txtarea" name="description" placeholder="描述您的問題"></textarea>
                </div>
                
<!--                 上傳附件｜不限格式限制2MB內檔案 -->
<!--                 <div class="form_area"> -->
<!--                     <div id="container"> -->
<!--                          <label>照片:</label><input type="file" name="file1" id="photo"></div> -->
<!--                        <div class="form_error"> -->
<!--                 	<p>提醒 ： 附件上傳限制 2MB 內，JPG、PNG、GIF 檔案格式。</p> -->
<!--                 </div> -->
<!--                     <br /> -->
<!--                     <pre id="console"></pre> -->
                     
<!--                 </div> -->
                
               
                
				

				                
                <!-- 表單確認送出、取消按鈕 -->
                <div class="form_btn">
                    <div class="btn_send">
                    <input type="Hidden" name="method" value="add">
                    <a onclick="form_submit()" style="cursor: pointer;" title="確認送出">確認送出</a></div>
                    <div class="btn_cancel"><a onclick='document.getElementById("faq_form").reset()' style="cursor: pointer;" title="取消重填">取消重填</a></div>
                </div>
                </form>
                
                <!-- 提醒訊息 -->
                
                
                <div class="form_error" id="error_4" style="display:none">
                	<p>錯誤訊息 ： 請確實選擇 問題分類。</p>
                </div>

                </div>
                
                <div class="form_error" id="error_7" style="display:none">
                	<p>錯誤訊息 ： 請確實填寫 ID。</p>
                </div>
               
                <div class="form_error" id="error_1" style="display:none">
                	<p>錯誤訊息 ： 請確實填寫 E-Mail(E-Mail格式不正確)。</p>
                </div>
                
                <div class="form_error" id="error_2" style="display:none">
                	<p>錯誤訊息 ： 請確實填寫 聯絡電話。</p>
                </div>
                
                </div>
	        </div>
        </div>

 		<script type="text/javascript" src="http://code.jquery.com/jquery-1.10.1.min.js"></script>


		<script>
			
		/* 	$(document.getElementById("role").value)
			alert(document.getElementByName("username").value)
			alert(document.getElementByEmail("email").value)
			alert(document.getElementByPhoto("photo").value)  */
		

			function messageGo(){

			  //取得 "username" 欄位值

			  var Id = $('#Id').val();        

			   //取得 "message" 欄位值                                

			  var username = $('#username').val();                                           

			    $.ajax({

			        //告訴程式表單要傳送到哪裡                                         

			        url:"username.php",                                                              

			        //需要傳送的資料

			        data:"&username="+username+"&val="+val,  

			         //使用POST方法     

			        type : "POST",                                                                    

			        //接收回傳資料的格式
			        dataType:'json', 

			         //傳送失敗則跳出失敗訊息      

			        error:function(){                                                                 

			        //資料傳送失敗後就會執行這個function內的程式，可以在這裡寫入要執行的程式  

			        alert("失敗");

			        },

			        //傳送成功則跳出成功訊息

			        success:function(){                                                           

			        //資料傳送成功後就會執行這個function內的程式，可以在這裡寫入要執行的程式  

			        alert("成功");

			        }

			    }); 

			};
			
			
		</script>
	
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>