$(document).ready(function(){
	size=5;	
$.ajax({type:'GET',dataType:'json',url:url_jax(0,size),success:function(datasize){
	var p0=1;
	var max=datasize['totalPages']-size+1;
	next=()=>{
		p0=p0>=max?max:p0+1;
		paginer(p0,size);
	}
	perv=()=>{
		p0=p0<=1?1:p0-1;
		paginer(p0,size);
	}
charge(p0,size); 
paginer(p0,size);
}});
});

