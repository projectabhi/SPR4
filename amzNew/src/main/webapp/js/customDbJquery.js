/**
 * 
 */
$(document).ready(function(){ 
	$(".dropdown-menu").on("click", "a", function(e){
		alert('hi');
	    e.preventDefault();
	   var $this = $(this).attr("href");
	   alert($this);
	    $("#search_concept").html($this);
	});
});
