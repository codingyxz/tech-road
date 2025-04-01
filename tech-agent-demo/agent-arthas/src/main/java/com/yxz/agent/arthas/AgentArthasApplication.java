package com.yxz.agent.arthas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgentArthasApplication {

    /**
     * -javaagent:/Users/linkk/codes/freestyle/tech-road/tech-agent-demo/agent-hotdev/target/agent-hotdev-1.0-SNAPSHOT-jar-with-dependencies.jar
     */
    public static void main(String[] args) {
        SpringApplication.run(AgentArthasApplication.class, args);
    }

}
