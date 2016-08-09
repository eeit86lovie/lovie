<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>Lovie 常見問題FAQ</title>



<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/formCommon.css"> 
<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/inner.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/KF-CSS/colorbox.css" />

<script src="KF-JS/jquery.colorbox.js"></script>
<script src="KF-JS/jquery.min.js"></script>

<script>
    (function (i, s, o, g, r, a, m) {
        i['GoogleAnalyticsObject'] = r; i[r] = i[r] || function () {
            (i[r].q = i[r].q || []).push(arguments)
        }, i[r].l = 1 * new Date(); a = s.createElement(o),
        m = s.getElementsByTagName(o)[0]; a.async = 1; a.src = g; m.parentNode.insertBefore(a, m)
    })(window, document, 'script', 'https://www.google-analytics.com/analytics.js', 'ga');


    ga('create', 'UA-79281311-1', 'auto', { 'allowLinker': true });
    ga('require', 'linker');
    ga('linker:autoLink', ['www.gnjoy.com.tw', 'member.gnjoy.com.tw', 'ro.gnjoy.com.tw', 'ro.gnjoy.com']);
    ga('send', 'pageview');
</script>

    <script>
        function open_list(i, j) {
            if (document.getElementById(i).style.display == "none") {
                document.getElementById(i).style.display = "block";
                document.getElementById(j).className = 'select';
            }
            else {
                document.getElementById(i).style.display = "none";
                document.getElementById(j).className = '';
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
                	<li><a href="KF-FAQ.jsp" title="常見問題FAQ" class="select">常見問題FAQ</a></li>
                    <li><a href="" title="問題回報線上表單" >問題回報線上表單</a></li>
                </ul>
            </div>
        </div>
 
        <div class="right_frame">
          

 	<!-- 右欄 -->
        <div class="right_frame">
            <!-- 常見問題FAQ內容 -->
           <div class="sub_title">
                <h1><em>常見問題</em>&nbsp FAQ</h1>
            </div>
            <!-- 常見問題列表 -->
            <div class="list">
            	<ul>
                                        <li><a id="q_38" style="cursor: pointer;" onclick="open_list('ans_38','q_38');"> Q  我可以免費註冊 LOVIE 嗎？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_38" style="display:none;">
                        <p>是的，您可以免費註冊 LOVIE，馬上可以開始瀏覽在您附近的其他電影邀約。</p>
                        <p> 我們免費提供有限存取的網站，所以您不用訂閱就能夠瀏覽會員及一覽 LOVIE 的功能。</p>
                        <p> 然而，你必須成為訂戶才能使用熱門的功能像是傳送訊息、聊天、回覆以及與其他檢閱過您的對象結識。</p>
                    </div>
                                        <li><a id="A1" style="cursor: pointer;" onclick="open_list('ans_37','q_37');"> Q  如何註冊 LOVIE？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_37" style="display:none;">
                        <p>選取「註冊」將會要求您輸入您的電子郵件地址，並回答幾個簡短問題，關於您的所在位置及性別，</p>
                        <p>您也有閱覽我們隱私權政策及使用者條款的機會。</p>
                    </div>
                	                    <li><a id="q_47" style="cursor: pointer;" onclick="open_list('ans_47','q_47');"> Q  我可以註冊幾個帳號？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_47" style="display:none;">
                        <p>	為了防範分身，一組電子信箱只能註冊一個LOVIE帳號喔！</p>
                    </div>
                                        <li><a id="q_46" style="cursor: pointer;" onclick="open_list('ans_46','q_46');"> Q  註冊時選錯性別怎麼辦？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_46" style="display:none;">
                        <p>在註冊時選錯性別後是沒辦法變更的，如果在註冊時選錯性別，可能要麻煩住戶重新申請一次帳號喔！</p>
                    </div>
                                        <li><a id="q_42" style="cursor: pointer;" onclick="open_list('ans_42','q_42');"> Q  請問我要怎麼取消LOVIE的帳號？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_42" style="display:none;">
                        <p>帳號關閉刪除您可登入您的帳號後，點選管理頁左側的管理工具功能，</p>

                        <p>利用帳號管理>>>帳號永久刪除功能，刪除帳號。</p>

                        <p>刪除帳號資料之確認信會寄到您當初一開始認證公寓帳號的認證信箱，而非後來修改的信箱。</p>

                        <p>如您無法登入您帳號或當初認證信信箱無法使用了，請您至用戶服務中心的表單下載頁面下載住戶變更申請表，</p>

                        <p>傳真申請帳號關閉刪除。</p>
                    </div>
                                        <li><a id="q_41" style="cursor: pointer;" onclick="open_list('ans_41','q_41');"> Q  快速註冊和完整註冊有什麼不同呢？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_41" style="display:none;">
                        <p>LOVIE會員註冊分為兩種方式 : </p>
                        <p>1.  快速註冊：申請資料→信箱認證→完成快速註冊 </p>
                        <p>2.  完整註冊：申請資料→個人檔案→擇友條件→興趣描述→個人照片→信箱認證→完整註冊</p>
                    </div>
                                        <li><a id="q_45" style="cursor: pointer;" onclick="open_list('ans_45','q_45');"> Q  忘記「密碼」時應該怎麼辦？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_45" style="display:none;">
                        <p>會員要查詢帳號跟密碼，請您至LOVIE登入頁使用「忘記帳號」、「忘記密碼」功能來查詢即可。</p>
                    </div>
                                        <li><a id="q_44" style="cursor: pointer;" onclick="open_list('ans_44','q_44');"> Q  為什麼我一直收不到認證信？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_44" style="display:none;">
                        <p>有可能是下列原因：</p>

                        <p>1. Email信箱填錯，請使用 [重新補寄認證信] 修改，重新發送註冊信。</p>

                        <p>2. 您填的Email正確，但您的信箱容量已超過而被退信。</p>

                        <p>3. 您的E-mail信箱有擋信功能，信件被擋掉。</p>

                        <p>4. 請將上述的情形確實處理之後，再使用[重新補寄認證信]，到您的信箱收取新寄送的認證信，完成認證動作。 </p>


                    </div>
                                        <li><a id="q_43" style="cursor: pointer;" onclick="open_list('ans_43','q_43');"> Q  為什麼一直無法登入？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_43" style="display:none;">
                        <p class="MsoNormal"><span>當您登入不成功無法進入公寓，可能有以下幾種情形，還請您參考以下說明，並確認看看。</span></p>
                        <p class="MsoNormal"><font color="#fa6699"><strong><span style="FONT-FAMILY: 新細明體">系統顯示帳號密碼錯誤</span></strong></font></p>
                        <p class="MsoNormal"><span>如出現上述的訊息，代表您的帳號或是密碼記錯了，排除方式如下：</span><span lang="EN-US"><br />
                        </span><span style="FONT-FAMILY: 新細明體">[ 使用忘記帳號查詢 ] </span></a><span>的功能</span></p>
                        <p class="MsoNormal"><font color="#fa6699"><strong><span style="FONT-FAMILY: 新細明體">如果您的帳號密碼都沒有錯，系統仍然顯示帳號密碼錯誤訊息：</span></strong></font><span lang="EN-US"><br />
                        </span><span>可能是您的帳號密碼設定的字元全形半形的關係</span><span lang="EN-US"><br />
                        </span><span>全形字元：<span style="COLOR: red">１２３４５６</span></span><span lang="EN-US"><br />
                        </span><span>半形字元：</span><span style="COLOR: red" lang="EN-US">123456<o:p></o:p></span></p>
                        <p class="MsoNormal"><span>是完全不一樣的密碼，請特別注意。</span><span><br />
                        </span><span>建議您可以先用<span style="FONT-FAMILY: 新細明體"> [ 忘記密碼查詢 ]  </span>的功能來確認看看您的密碼，是不是不小心設定成全形了，如果是全形密碼也請您盡量不要使用，變更密碼您可以在<span style="FONT-FAMILY: 新細明體"> [ 編輯個人資料 ] </span>的地方來修改，以免在登入LOVIE輸入密碼的時候，因為全形半形在您電腦上切換的關係，而使您的密碼始終無法正確輸入，那您當然也就無法登入了。</span></p>

                    </div>

                                        <li><a id="q_40" style="cursor: pointer;" onclick="open_list('ans_40','q_40');"> Q  認證信連結無法點選</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_40" style="display:none;">
                        <p>當您收到認證信後，信件中的連結無法點選來啟動您的帳號時，</p>

                        <p>請複製信件中的連結(有下底線___________的連結程式碼)，然後再貼到瀏覽器的網址送出，</p>

                        <p>瀏覽器的網址是指您上網時頁面最上方的欄位，</p>

                        <p>有一個顯示http://XXXXXXX的欄位，</p>

                        <p>請將連結反白複製後，貼於瀏覽器的網址列上送出，即可完成信箱認證。</p>
                    </div>
                                        

                                        <li><a id="A2" style="cursor: pointer;" onclick="open_list('ans_36','q_36');"> Q  如何變更我的電子郵件地址？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_36" style="display:none;">
                        <p>欲變更您的電子郵件地址，請依照下列的指引。</p>
                        <p>在電腦上變更您的電子郵件地址，欲在電腦上變更您的電子郵件地址：</p>
                        <p>請開啟網頁瀏覽器，前往LOVIE頁面，登入您的 LOVIE 帳號。</p>
                        <p>請在螢幕右上角按一下您的 LOVIE 顯示名稱。</p>
                        <p>從下拉式選單中選取「「設定」」。此動作會將你帶往帳號管理頁面。</p>
                        <p>於電子郵件旁選取「編輯」</p>
                        <p>輸入新的電子郵件地址，然後按一下「儲存」。將會寄送一封電子郵件確認函至所提供的電子ˋ郵件地址。</p>
                        <p>按一下電子郵件中的連結以確認您的電子郵件地址。</p>
                    </div>
                                        <li><a id="A3" style="cursor: pointer;" onclick="open_list('ans_35','q_35');"> Q  如何建立及編輯我的個人檔案?</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_35" style="display:none;">
                        <p>在螢幕右上角按一下您的 LOVIE 顯示名稱。</p>
                        <p>選擇「編輯個人檔案」</p>
                        <p>此動作會將您帶到「個人檔案」頁面，</p>
                        <p>您可以點擊在資訊旁的「編輯」和「新增」按鈕來檢視或</p>
                        <p>編輯您的相片、基本資訊、自我介紹、理想速配對象及理想約會。</p>
                    </div>
                                        
                                        <li><a id="A5" style="cursor: pointer;" onclick="open_list('ans_33','q_33');"> Q  如何封鎖其他會員或舉發濫用？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_33" style="display:none;">
                        <p>在 MOVIE，我們社群中的這一群誠實的線上約會者，是讓我們這個網站變得對每個人而言都是好地方的重要因素之一。</p>
                        <p>請用正確的判斷力及使用舉發／封鎖選項來舉發可疑或言行不當者，以保護您自己及其他 Zoosk 會員。</p>
                        <p>若要封鎖會員，請依照下列的指引舉發和封鎖某人。</p>
                        <p>舉發濫用及封鎖一位會員時，請首先造訪該位會員的個人檔案。</p>
                        <p>接著，按一下位於該會員顯示名稱旁的灰色箭頭。</p>
                        <p>然後，選取「舉發／封鎖」。</p>
                    </div>
                                        <li><a id="A6" style="cursor: pointer;" onclick="open_list('ans_32','q_32');"> Q  如何連絡我感興趣的對象？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_32" style="display:none;">
                        <p>在 Zoosk 中，有很多種可以聯絡感興趣對象的方法。</p>
                        <p>您可以使用最喜愛的方式或是多種方式與人們進行聯絡。</p>
                        <p>請注意，使用 Zoosk 的功能，例如傳送訊息及聊天，是需要付費訂閱。</p>
                        <p>付費訂戶及免費會員可以購買 Zoosk 代幣來解鎖和存取數樣特殊功能，</p>
                        <p>例如與隨機配對中對您釋出好感的對象聯絡。深入了解訂戶權益。</p>
                        <p>當您找到感興趣的對象時，前往他或她的個人檔案。</p>
                        <p>於此您可以傳送訊息、放電或傳送聊天邀請。</p>
                        <p><span style="FONT-FAMILY: 新細明體">訊息</span></p>
                        <p>在 Zoosk 上傳送訊息給某人是最直接的自我介紹方式，也是表達好感的方式。</p>
                        <p>欲傳送訊息，只要在白色訊息方塊開始撰寫訊息，然後送出。</p>
                        <p><span style="FONT-FAMILY: 新細明體"> 放電</span></p>
                        <p>對某人放電是對他或她表達您好感的有趣方法。一旦你選擇了「放電」，將會傳送一封簡訊給該對象：有人放電。</p>
                        <p><span style="FONT-FAMILY: 新細明體"> 聊天邀請</span></p>
                        <p>傳送聊天邀請是讓對方知道您想聊聊的好辦法。一旦您選擇了「新增」，會通知對方您的邀請，</p>
                        <p>也會將他或她加入您的新朋友中，您就可以開始聊天。</p>
                    </div>
                                        <li><a id="A7" style="cursor: pointer;" onclick="open_list('ans_31','q_31');"> Q  我如何才能建造出一個超棒的 LOVIE 個人檔案？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_31" style="display:none;">
                        <p>要吸引你感興趣對象最好辦法就是在您的個人檔案中提供豐富的資訊加上很多相片，幫助人家對您的了解。</p>
                        <p>當在建立您的個人檔案時，這裡有些技巧給您參考：</p>

                        <p><span style="FONT-FAMILY: 新細明體">選一張檔案相片</span></p>
                        <p>您的個人檔案相片通常都是讓大家了解您的第一種方式。選一張清楚、近期所拍攝且可看清楚您的臉並帶點個人特質的相片。</p>

                        <p><span style="FONT-FAMILY: 新細明體">多加幾張其他相片</span></p>
                        <p>加超過一張照片到您的個人檔案中，讓您有更多可展現自我不同面貌的機會。試著使用一張您與朋友或家人一起拍攝，或是您正在做些您喜愛事情時的相片。</p>

                        <p><span style="FONT-FAMILY: 新細明體">分享些關於自己的事</span></p>
                        <p>使用個人檔案中的自我介紹、理想速配對象和理想約會的區塊來描述自己和您在尋找什麼樣的對象。想想那些事情對你而言是重要的、什麼讓您感到開心，以及為何您加入 Zoosk。</p>

                        <p><span style="FONT-FAMILY: 新細明體">匯入您的興趣</span></p>
                        <p>如果您有在用 Facebook，您可以直接匯入您的興趣讓其他 Zoosk 的用戶知道您喜愛哪種類型的書籍、電影、運動和遊戲。</p>

                        <p><span style="FONT-FAMILY: 新細明體">回答匹配程度問題</span></p>
                        <p>當您回答了些匹配程度問題後，您可看見與您答案相襯的其他會員。這是個好玩、快速的方法了解您對約會和關係的看法。</p>
                    </div>
                    <li><a id="A8" style="cursor: pointer;" onclick="open_list('ans_30','q_30');"> Q  在進行線上約會時我該怎麼保護自己？</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_30" style="display:none;">
                        <p>在 LOVIE，我相信約會應該要是安全、有趣和怡人的。</p>
                        <p>當您開始線上約會時，是一個可以讓您想想自己想要什麼樣感情關係的時機。</p>
                        <p>也能讓您想想該如何安全地與新朋友相見與互動。</p>
                        <p>您的線上和離線安全是您自身的責任，並且應該至於優先考量。</p>
                        <p>LOVIE 並不會定期審查會員、調查會員的背景、嘗試驗證會員所提供的資訊，</p>
                        <p>或進行會員犯罪審查。</p>
                        <p>請造訪我們的線上約會安全提示以獲得提示，</p>
                        <p>在尋找美滿愛戀的同事也別忘了以保持良好的判斷力以保安全。</p>
                    </div>
                    <li><a id="q_39" style="cursor: pointer;" onclick="open_list('ans_39','q_39');"> Q  為什麼都沒人理我</a></li>
                    <!-- 答案｜內容無限展開 -->
                                        <div class="list_content" id="ans_39" style="display:none;">
                        <p>如果您開通了更高階級的會員，將可以使您的曝光度大大提升，</p>
                        <p>如此一來也許就會有較多的人前來關注您唷。</p>
                    </div>
               </ul>
            </div>
            
    <br />
  		<!-- 返回最上層 -->


    </div>
 </div>
</div>
	
	</div>
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>
</body>
</html>