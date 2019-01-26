package com.pleo;

import com.pleo.configuration.SwaggerConfigTest;
import com.pleo.controller.HomeControllerTest;
import com.pleo.controller.WaterContainerControllerIT;
import com.pleo.controller.WaterContainerControllerTest;
import com.pleo.model.StructureDtoTest;
import com.pleo.service.WaterContainerServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationTest.class,
        SwaggerConfigTest.class,
        StructureDtoTest.class,
        HomeControllerTest.class,
        WaterContainerControllerTest.class,
        WaterContainerServiceTest.class,
        WaterContainerControllerIT.class,
})
public class TestSuite {
}
