var randomData;

var socket = new SockJS('/amzNew/dbmain/random');
var client = Stomp.over(socket);

client.connect('user', 'password', function(frame) {

  client.subscribe("/data", function(message) {

	  if($("#serverMsg").val() != '' || $("#serverMsg").val() != null)
		  $("#serverMsg").val();
    $("#serverMsg").val(message.body);
  });

});