package com.pleo;

import com.pleo.controller.HomeControllerTest;
import com.pleo.controller.WaterContainerControllerTest;
import com.pleo.service.WaterContainerServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ApplicationTest.class,
        HomeControllerTest.class,
        WaterContainerControllerTest.class,
        WaterContainerServiceTest.class
})
public class TestSuite {
}
