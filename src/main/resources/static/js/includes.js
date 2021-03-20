var URL='http://localhost:5500/';
request=(url_)=>{
	$.ajax({type:'GET',dataType:'json',url:url_,success:function(data0){
		var data=data0['content'];
		var x='<tbody>';
		for(var i=0;i<data.length;i++)
			x+='<tr><td>'+data[i]['idPers']+'</td><td>'+data[i]['name']+'</td><td>'+data[i]['email']+'</td><td>'+data[i]['city']['design']+'</td></tr>';	
		x+='</tbody>';
			$('tbody').remove();
			$('.table').append(x);
	}});
};
paginer=(p,size)=>{
pg=' \
<ul class="pagination"> \
<li> \
<a href="#" onClick="perv()" aria-label="Previous"> \
<span aria-hidden="true">&laquo;</span> \
</a> \
</li> \
<li class="active"><a class="pagin" href="#">'+p+'</a></li> \
<li ><a class="pagin" href="#">'+(p+1)+'</a></li> \
<li  ><a class="pagin" href="#">'+(p+2)+'</a></li> \
<li ><a class="pagin" href="#">'+(p+3)+'</a></li> \
<li  ><a class="pagin" href="#">'+(p+4)+'</a></li> \
<li> \
<a href="#" onClick="next()" aria-label="Next"> \
<span aria-hidden="true">&raquo;</span> \
</a> </li> </ul>';
$('.pagination').remove();
$('.nav-pagination').append(pg);
$('.pagin').click(function(){
	charge($(this).text(),size); 
});
$('.pagination li').click(function(){
	$('.pagination li').removeClass('active');
	$(this).addClass('active');
});
};		
charge=(page,size)=>{	
	page--;
/*	$.ajax({type:'GET',dataType:'json',url:url_jax(page,size),success:function(data0){
		var data=data0['content'];
		var x='<tbody>';
		for(var i=0;i<data.length;i++)
			x+='<tr><td>'+data[i]['idPers']+'</td><td>'+data[i]['name']+'</td><td>'+data[i]['email']+'</td><td>'+data[i]['city']['design']+'</td></tr>';	
		x+='</tbody>';
			$('tbody').remove();
			$('.table').append(x);
	}});*/
request(url_jax(page,size));
}

url_jax=(page,size)=>{
	return URL+'pers?page='+page+'&size='+size;
}
search=()=>{//http://localhost:5500/fullpers?key=ahmed15
	//console.clear();
	request(URL+'fullpers?key='+$('.t_srch').val());
//	console.log($('.t_srch').val());
}