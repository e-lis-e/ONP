package br.com.politics.ONP;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ServerPortListener implements ApplicationListener<WebServerInitializedEvent> {

    private int port;

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.port = event.getWebServer().getPort();
        System.out.println("Server está rodando!! 🚀🚀 na porta: http://localhost:" + this.port + "/");
    }

    public int getPort() {
        return port;
    }
}
