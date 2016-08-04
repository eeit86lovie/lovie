<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import charEncoding="UTF-8" url="/meta.jsp"></c:import>
<title>標題</title>
<style>
#buttonType{
	min-width:150px;
}


#div1{
	position: absolute;
	z-index: 1;
}

#menuCity{
	position: absolute;
	z-index: 1001;
	text-align: center;
	margin-bottom: 2px;
	cursor:pointer;
}


</style>

</head>
<body>
<c:import charEncoding="UTF-8" url="/header.jsp"></c:import>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h1 class="page-header" style="font-size: 28px;">${myBean.nickname} 新增約會</h1>
			</div>
		</div>
		<div class="row">
		</div>
		
		<div class="row">
			<div class="col-md-12">
				
					<div class="row">
						<div class="col-md-3">
							<img style="width:200px;margin:10px;" src="${myBean.photoUrl }">
						</div>
						<div class="col-md-3">
						 	<div style="margin:5px 0px; font-size: 20px;">
								${myBean.nickname}<br/>
								${myBean.city}&nbsp;${myBean.district}<br/>
								${myBean.constellation }
								${myBean.birthday}
							</div>
						</div>
						<div class="col-md-3" id="preMoviePhoto">
							
						</div>
						<div class="col-md-3">
							<div style="margin:5px 0px; font-size: 20px;">
							<div id="preMovieName"></div>
							<div id="preTheaterName"></div>
							<div id="preTheaterCity"></div>
							<div id="preShowtimeTime"></div>
							
							</div>
						</div>
					</div>
				
			</div>
		</div>
		
		<hr>
		
		<div class="row">
		
				<div class="col-md-3" style="float: left; margin-right: 20px">
					<button class="btn btn-default  type="button"
						id="buttonType"  onclick="chooseMovie()">
						選擇電影</span>
					</button>
					
				</div>
				
				<div class="col-md-3" id="choosedMovie"></div>
				<div class="col-md-3" id="choosedTheater"></div>
				<div class="col-md-3" id="choosedShowtime"></div>
				
		</div>
		<hr/>
		<div id="chooseArea">
			
		
		</div>
		
	</div>
		
		
		
	
	
		
	
<c:import charEncoding="UTF-8" url="/footer.jsp"></c:import>

<script>
	var picked_movie = "";
	var picked_theater = "";
	var theaters = [];
	var chooseArea = $("#chooseArea");
	var movies = [<c:forEach var="movie" items="${movies}">"${movie.name}",</c:forEach>];
	var movies_map = {<c:forEach var="movie" items="${movies}">"${movie.name}":"${movie.id}",</c:forEach>};
	var all_theaters = {<c:forEach var="theater" items="${theaters}">"${theater.name}":"${theater.city}",</c:forEach>};
	var citys = [];
	
	function chooseMovie(){
		reset();
		chooseArea.empty();
		chooseArea.append("<row><label><input id='txtSearch' type='text' placeholder='電影名稱' ><div id='div1'></div></label></row><hr>")
		for(i=0;i<movies.length;i++){
			chooseArea.append("<div class='col-md-3' onclick='choosedMovie(this)'>"+movies[i]+"</col-md-3>");
		}
		init();
	}
	
	function appendCity(citys){
		chooseArea.empty();
		var fragment = $(document.createDocumentFragment());
		var div_row = $('<div></div').addClass('row');
		var div_theater = $('<div></div>').addClass('col-md-3').css({'float':'left','margin-bottom':'10px'});
		var button_theater = $('<button></button>').addClass('btn').addClass('btn-default').addClass('dropdown-toggle').attr('data-toggle','dropdown').html("&nbsp;&nbsp;城市&nbsp;&nbsp; <span class='caret'/>");
		var ul_theater = $('<ul></ul>').addClass('dropdown-menu').attr('id','menuCity');
		$.each(citys, function(){
			var div_city = $('<div></div>').addClass('subcity');
			var li_city = $('<li></li>').attr('onClick', 'choosedCity(this)').text(this);
			div_city.append(li_city);
			ul_theater.append(div_city);
		})
		
		div_row.append(div_theater);
		div_theater.append(button_theater);
		div_theater.append(ul_theater);
		fragment.append(div_row);
		var hr = $('<hr>')
		chooseArea.append(fragment).append(hr);
		
	}
	
	
	
	function init() {
		var txt = document.getElementById("txtSearch");
		txt.addEventListener("keyup", getData, false);
		show = document.getElementById("div1");
	}
	
	
	
	function getData() {
		
		var keyword = $('#txtSearch');
		
		
		show.style.display = "block";
		if (show.childNodes.length > 0) {
			show.removeChild(show.childNodes[0]);
		}
		var eleDiv = document.createElement("div");
		eleDiv.className = "list-group";
		for (var j = 0, max = movies.length; j < max; j++) {
		if(movies[j].match(keyword.val())){	
			var txtBtn = document.createTextNode(movies[j]);
			var eleBtn = document.createElement("button");
			eleBtn.className = "list-group-item";
			eleBtn.setAttribute("type", "button");
			eleBtn.appendChild(txtBtn);

			eleBtn.addEventListener("click", function() {
				choosedMovie(this);
				keyword.val("");
				show.style.display = "none";
				if (show.childNodes.length > 0) {
					show.removeChild(show.childNodes[0]);
				}
			}, false)
			eleDiv.appendChild(eleBtn);
		}
		show.appendChild(eleDiv);
		}
		if (keyword =="" && show.childNodes.length > 0) {
			show.removeChild(show.childNodes[0]);
		}
	}
	
	function choosedMovie(target){
		theaters = [];
		citys =[];
		picked_movie = $(target).text();
		$('#choosedMovie').html("<button class='btn btn-default'>"+$(target).text()+"</button>");
		$('#preMovieName').text($(target).text());
		var movieId = movies_map[$(target).text()];
		$('#preMoviePhoto').html("<img style='width:200px;margin:10px;' src='photo.do?type=movie&id="+movieId+"'>");
		
		$.ajax({
			'type':'get',
			'url':'${pageContext.request.contextPath}/showtimeJsonByMovie.do',
			'data':{'MovieName':$(target).text()},
			'success': function(data){
				
				
				chooseArea.empty();
				for(i=0; i<data.length; i++){
					theaters.push(data[i].theaterName);
				}
				
				
				
 				//Distinct Theater Names
				theaters = $.grep(theaters, function(v, k){
				    return $.inArray(v ,theaters) === k;
				});
				
 				
 				for(i=0;i<theaters.length;i++){
 				    citys.push(all_theaters[theaters[i]]);
 				}
 				citys = citys.filter(onlyUnique);
 				
				appendCity(citys);
				appendTheater(theaters);
			}
		})
		
	}
	
	function appendTheater(theaterArray){
		$.each(theaterArray, function(index, value){
			var theater = $('<div></div>').addClass('col-md-3').attr('onClick', 'choosedTheater(this)').css({'float':'left','margin-bottom':'10px'}).text(value);
			chooseArea.append(theater);
		})
	}
	
	
	function choosedCity(city){
		var temp_theaters = [];
		for(i=0;i<theaters.length;i++){
			var t = theaters[i]
			if(all_theaters[theaters[i]]==$(city).text()){
				temp_theaters.push(theaters[i]);
			}
		}
		chooseArea.empty();
		appendCity(citys);
		appendTheater(temp_theaters);	 
	}
	
	function choosedTheater(theater){
		picked_theater = $(theater).text();
		$('#preTheaterName').text(picked_theater);
		$('#preTheaterCity').text(all_theaters[picked_theater]);
		$('#choosedTheater').html("<button class='btn btn-default'>"+$(theater).text()+"</button>");
		$.ajax({
			'type':'get',
			'url': '${pageContext.request.contextPath}/services/showtime/both',
			'data':{'MovieName':picked_movie, 'TheaterName':picked_theater},
			'success':function(data){
				appendShowtime(data);
			}
			
			
		})
		
	}
	
	function appendShowtime(showtimesData){
		chooseArea.empty();
		var showtimes = [];
		for(i=0;i<showtimesData.length;i++){
			showtimes.push(showtimesData[i].showtimeDate+" "+showtimesData[i].showtimeTime);
		}
		 showtime_div = $('<div></div>').addClass('col-md-3');
		$.each(showtimes, function(index, value){
			var showtime =$('<div></div>').attr('onClick', 'choosedShowtime(this)').css({'float':'left','margin-bottom':'10px', 'cursor':'pointer'}).text(value);
			showtime_div.append(showtime);
		})
		chooseArea.append(showtime_div);
	}
	
	function choosedShowtime(showtime){
		
		$('#preShowtimeTime').text($(showtime).text());
	}
	
	
	function onlyUnique(value, index, self) { 
	    return self.indexOf(value) === index;
	}
	
	function reset(){
		$('#preTheaterName').text("");
		$('#preMovieName').text("");
		$('#preTheaterCity').text("");
		$('#preShowtimeTime').text("");
		$('#preMoviePhoto').html("");
	}
	


</script>


</body>
</html>