var randomData;

var socket = new SockJS('/amzNew/dbmain/random');
var client = Stomp.over(socket);

client.connect('user', 'password', function(frame) {

  client.subscribe("/data", function(message) {

	  if($("#serverMsg").html() != '' || $("#serverMsg").html() != null)
		  $("#serverMsg").html();
    $("#serverMsg").html(message.body);
  });

});