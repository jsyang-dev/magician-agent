package me.study.agent;

import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.implementation.FixedValue;

import java.lang.instrument.Instrumentation;

import static net.bytebuddy.matcher.ElementMatchers.*;

public class MagicianAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        new AgentBuilder.Default()
                .type(any())
                .transform((builder, typeDescription, classLoader, javaModule) ->
                        builder.method(named("pullOut")).intercept(FixedValue.value("Rabbit!")))
                .installOn(inst);
    }
}
