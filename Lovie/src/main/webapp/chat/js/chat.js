var stompClient = null;

        

        function connect() {
            var socket = new SockJS('/Lovie/stomp');
            stompClient = Stomp.over(socket);
            stompClient.connect({}, function(frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/user/queue/chat', function(message){
                	appendRight(JSON.parse(message.body));
                	appendPeople(JSON.parse(message.body));
                	
                });
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            console.log("Disconnected");
        }

        

        