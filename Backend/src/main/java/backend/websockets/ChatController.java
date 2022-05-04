package backend.websockets;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import org.springframework.stereotype.Controller;


@Controller
@ServerEndpoint(value="/chat/{username}")
public class ChatController
{

    // Store all socket session and their corresponding username.
    private static Map<Session, String> sessionUsernameMap = new Hashtable<>();
    private static Map<String, Session> usernameSessionMap = new Hashtable<>();

    private Chatbot chatbot = new Chatbot();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username)
            throws IOException {
        sessionUsernameMap.put(session, username);
        usernameSessionMap.put(username, session);
        String message = "User:" + username + " has Joined the Chat";
        broadcast(message);
    }


    @OnMessage
    public void onMessage(Session session, String message) throws IOException {

        String username = sessionUsernameMap.get(session);

        if(message.toLowerCase().startsWith("bot "))
            broadcast("bot: " + chatbot.message(message));

        // Direct message to a user using the format "@username <message>"
        if (message.startsWith("@")) {
            String destUsername = message.split(" ")[0].substring(1);

            // send the message to the sender and receiver
            sendMessageToPArticularUser(destUsername, "[DM] " + username + ": " + message);
            sendMessageToPArticularUser(username, "[DM] " + username + ": " + message);

        }
        else { // broadcast
            broadcast(username + ": " + message);
        }

        // Saving chat history to repository
//        msgRepo.save(new Message(username, message));
    }


    @OnClose
    public void onClose(Session session) throws IOException
    {
        // remove the user connection information
        String username = sessionUsernameMap.get(session);
        sessionUsernameMap.remove(session);
        usernameSessionMap.remove(username);

        // broadcase that the user disconnected
        String message = username + " disconnected";
        broadcast(message);
    }


    @OnError
    public void onError(Session session, Throwable throwable) {
        throwable.printStackTrace();
    }


    private void sendMessageToPArticularUser(String username, String message) {
        try {
            usernameSessionMap.get(username).getBasicRemote().sendText(message);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void broadcast(String message) {
        sessionUsernameMap.forEach((session, username) -> {
            try {
                session.getBasicRemote().sendText(message);
            }
            catch (IOException e) {
                e.printStackTrace();
            }

        });

    }
}
