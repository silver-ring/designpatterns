package designpatterns.example.creation.singleton;

import org.junit.jupiter.api.Test;

import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GlobalConfigurationTest {

    private int EXPECTED_NUMBER_OF_INSTANCES = 1;

    @Test
    public void checkIfWeWillGetSameInstance() {
        GlobalConfiguration globalConfiguration1 = GlobalConfiguration.getInstance();
        GlobalConfiguration globalConfiguration2 = GlobalConfiguration.getInstance();
        assertEquals(globalConfiguration1, globalConfiguration2);
        assertEquals(EXPECTED_NUMBER_OF_INSTANCES, globalConfiguration1.getNumberOfInstances());
        assertEquals(EXPECTED_NUMBER_OF_INSTANCES, globalConfiguration2.getNumberOfInstances());
    }

    @Test
    public void testSynchronized() throws InterruptedException {
        int noThreads = 100;
        ExecutorService executor = Executors.newFixedThreadPool(noThreads);
        Vector<GlobalConfiguration> vector = new Vector<>();
        for (int i = 0; i < noThreads; i++) {
            executor.submit(() -> {
                GlobalConfiguration globalConfiguration = GlobalConfiguration.getInstance();
                vector.add(globalConfiguration);
            });
        }

        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.SECONDS);
        GlobalConfiguration refObj = vector.get(0);
        for (GlobalConfiguration obj : vector) {
            assertEquals(obj, refObj);
            assertEquals(EXPECTED_NUMBER_OF_INSTANCES, refObj.getNumberOfInstances());
            assertEquals(EXPECTED_NUMBER_OF_INSTANCES, obj.getNumberOfInstances());
        }

    }


}