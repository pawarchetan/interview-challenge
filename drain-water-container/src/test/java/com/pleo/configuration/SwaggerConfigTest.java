package com.pleo.configuration;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class SwaggerConfigTest {

    private SwaggerConfig swaggerConfig;

    @Before
    public void setUp() {
        swaggerConfig = new SwaggerConfig();
    }

    @Test
    public void shouldInstantiateSwagger() {
        assertNotNull(swaggerConfig.apiDocket());
    }

}
