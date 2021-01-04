package designpatterns.example.creation.singleton;

/**
 * Concept:
 * Lazy initialization for the object, and create only one instance.
 * <p>
 * Why you should use the pattern::
 * Since we are creating only one global instance of the object when needed, we will have better
 * memory management.
 * <p>
 * Why you shouldn't use the pattern:
 * Because we creating one global instance we need to be concerned about the instance variables state
 * in general accessing global variables can cause side effects
 * Anther point is that global variables in general are not easy to be tested
 * <p>
 * Use Case:
 * <p>
 * A good use case will be a global configurations, or global context (similar to spring context)
 */

public class GlobalConfiguration {

    private int numberOfInstances = 0;

    private static GlobalConfiguration instance;

    private GlobalConfiguration() {

    }

    public static GlobalConfiguration getInstance() {
        if (instance == null) {
            synchronized (GlobalConfiguration.class) {
                if (instance == null) {
                    instance = new GlobalConfiguration();
                    int noi = instance.getNumberOfInstances();
                    instance.setNumberOfInstances(++noi);
                }
            }

        }
        return instance;
    }

    public void setNumberOfInstances(int numberOfInstances) {
        this.numberOfInstances = numberOfInstances;
    }

    public int getNumberOfInstances() {
        return numberOfInstances;
    }
}
