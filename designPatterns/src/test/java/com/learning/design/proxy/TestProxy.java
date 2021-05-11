package com.learning.design.proxy;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.AbstractApplicationContext;

public class TestProxy {

    private static final Logger log = LoggerFactory.getLogger(TestProxy.class);

    @Test
    public void testPatoGordoProxy() {
        ProxyFactory factory = new ProxyFactory(new PatoGordo());
        factory.addInterface(IPato.class);

        IPato patito = (IPato) factory.getProxy();

        assertFalse(PatoGordo.class.isInstance(patito.getClass()));
        assertTrue(IPato.class.isAssignableFrom(patito.getClass()));
    }

    @Test
    public void testAdvice() {
        try (AbstractApplicationContext context = new AnnotationConfigApplicationContext(Configuration.class)) {

            Mensajeria mensajes = context.getBean(Mensajeria.class);
            log.info("AQUI... ENVIANDO UNA SEÑAL DE VIDA");
            mensajes.mensaje();

            log.info("AQUI... SALUDANDO");
            mensajes.mensaje("Hola a todos");
        }
    }

}

@org.springframework.context.annotation.Configuration
@ComponentScan(basePackages = { "com.learning.design.proxy" })
@EnableAspectJAutoProxy
class Configuration {

}
