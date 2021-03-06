package com.example.rules;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

public class ServerHandler {

    private OkHttpClient client;
    private WebSocket ws;
    private WebSocketListener listener;

    private String message = "";

    public ServerHandler() {
        init();
    }

    private void init() {
        client = new OkHttpClient();
        listener = new SocketListener();
    }

    public void start() {
        Request request = new Request.Builder().url("ws://10.0.0.46:8080").build();
        ws = client.newWebSocket(request, listener);
    }

    public void sendMessage(String message) {
        ws.send(message);
        System.out.println("DEADPOOL sent" + message);
    }

    public String getMessage() {
        System.out.println("BATMAN " + message);
        String msg = message;
        message = "";
        return msg;
    }

    public void resetMessage() { message = ""; }

    public void closeConnection() {
        client.dispatcher().executorService().shutdown();
    }

    private final class SocketListener extends WebSocketListener {

        @Override
        public void onMessage(WebSocket webSocket, String text) {
            message = text;
        }

        @Override
        public void onClosing(WebSocket webSocket, int code, String reason) {
            webSocket.close(1000, null);
        }
    }

}
