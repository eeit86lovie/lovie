<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>

<style>
.col-lg-12 label {
	margin: 10px;
}

#div1{
	position: absolute;
	z-index: 1;
}

.col-md-3 a img{
	height: 280px;
}

.col-md-3{
	margin-bottom: 20px;
}
</style>

<title>最新電影</title>




</head>


<body>

	<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>






	<div class="container">

		<div class="row">
			<div class="col-lg-12">
				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="劇情"><span
					class="genrefilter__item-indicator"></span>劇情</label> <label><input
					class="genre_filter" type="checkbox" name="genrefilter__item"
					value="喜劇"><span class="genrefilter__item-indicator"></span>喜劇</label>

				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="記錄"><span
					class="genrefilter__item-indicator"></span>記錄</label> <label><input
					class="genre_filter" type="checkbox" name="genrefilter__item"
					value="奇幻"><span class="genrefilter__item-indicator"></span>奇幻</label>

				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="驚悚"><span
					class="genrefilter__item-indicator"></span>驚悚</label> <label><input
					class="genre_filter" type="checkbox" name="genrefilter__item"
					value="犯罪"><span class="genrefilter__item-indicator"></span>犯罪</label>

				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="動作"><span
					class="genrefilter__item-indicator"></span>動作</label> <label><input
					class="genre_filter" type="checkbox" name="genrefilter__item"
					value="溫馨"><span class="genrefilter__item-indicator"></span>溫馨</label>

				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="科幻"><span
					class="genrefilter__item-indicator"></span>科幻</label> <label><input
					class="genre_filter" type="checkbox" name="genrefilter__item"
					value="懸疑"><span class="genrefilter__item-indicator"></span>懸疑</label>

				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="動畫"><span
					class="genrefilter__item-indicator"></span>動畫</label> <label><input
					class="genre_filter" type="checkbox" name="genrefilter__item"
					value="戰爭"><span class="genrefilter__item-indicator"></span>戰爭</label>

				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="愛情"><span
					class="genrefilter__item-indicator"></span>愛情</label> <label><input
					class="genre_filter" type="checkbox" name="genrefilter__item"
					value="歷史"><span class="genrefilter__item-indicator"></span>歷史</label>

				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="音樂"><span
					class="genrefilter__item-indicator"></span>音樂</label> <label><input
					class="genre_filter" type="checkbox" name="genrefilter__item"
					value="冒險"><span class="genrefilter__item-indicator"></span>冒險</label>

				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="傳記"><span
					class="genrefilter__item-indicator"></span>傳記</label> <label><input
					class="genre_filter" type="checkbox" name="genrefilter__item"
					value="家庭"><span class="genrefilter__item-indicator"></span>家庭</label>

				<label><input class="genre_filter" type="checkbox"
					name="genrefilter__item" value="其他"><span
					class="genrefilter__item-indicator"></span>其他</label> 
					
				<label><input id="txtSearch" class="genre_filter" type="text"
					name="genrefilter__item" placeholder="電影名稱" ><div id="div1"></div></label> 
				


			</div>
		</div>








		<c:forEach var="movie" items="${movies}" varStatus="theCount">
			<div class="movie_item" data-genres="${genres[movie.id]}">
				<div class="col-md-3 col-sm-4 col-xs-12 portfolio-item">
					<a href="movie.do?mID=${movie.id}"> <img
						class="img-responsive" src="photo.do?type=Movie&id=${movie.id}" alt=""></a>
					<h3>
						<a href="/movies/selectMovie?mID=${movie.id}">${movie.name}</a>
					</h3>
					<p>上映時間：${movie.startTime}</p>
				</div>
			</div>
		</c:forEach>

	</div>

	
	<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>



	<script type="text/javascript">
		$(function() {
			$('.genre_filter').bind('change',function() {$('.movie_item').show();
		$('.movie_item').each(function() {var movie = this;
		$('.genre_filter').each(function() {if ($(this).prop("checked")&& $(movie).data('genres').indexOf($(this).val()) == -1) {
		$(movie).hide();
		}})});
		});
		});
	</script>
	
	<script>
	var datas=[<c:forEach var="movie" items="${movies}">'${movie.name}',</c:forEach>];
	var show;
	window.addEventListener("load", init, false);
	function init() {
		var txt = document.getElementById("txtSearch");
		txt.addEventListener("keyup", getData, false);
		show = document.getElementById("div1");
	}
	function getData() {
		
		var keyword = $('#txtSearch').val();
		
		
		show.style.display = "block";
		if (show.childNodes.length > 0) {
			show.removeChild(show.childNodes[0]);
		}
		var eleDiv = document.createElement("div");
		eleDiv.className = "list-group";
		for (var j = 0, max = datas.length; j < max; j++) {
		if(datas[j].match(keyword)){	
			var txtBtn = document.createTextNode(datas[j]);
			var eleBtn = document.createElement("button");
			eleBtn.className = "list-group-item";
			eleBtn.setAttribute("type", "button");
			eleBtn.appendChild(txtBtn);

			eleBtn.addEventListener("click", function() {
				//keyword.value = this.firstChild.nodeValue;
				//show.style.display = "none";
				window.location="http://localhost:8080/Lovie/moviename.do?mName="+this.firstChild.nodeValue;
				
				
				
			}, false)
			eleDiv.appendChild(eleBtn);
		}
		show.appendChild(eleDiv);
		}
		if (keyword =="" && show.childNodes.length > 0) {
			show.removeChild(show.childNodes[0]);
		}
	}
	</script>

</body>
</html>