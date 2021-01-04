package designpatterns.example.creation.factory;

/**
 * Concept:
 * Separate object creation from object implementation, So you can create object type
 * instead of creating specific implementation. In this way client take control of choosing the object type
 * but he loses control of choosing the implementation
 * <p>
 * Why you should use the pattern::
 * We use the pattern when we are not certain about the implementation and we need to be able to change and
 * version implementation without side effects.
 * Also we can use factory pattern if we think in the future object types can be extended and we could have
 * more types than we have at the moment
 * <p>
 * Why you shouldn't use the pattern:
 * We should not use factory pattern if we create creating class will not regularly change using a factory
 * will consider as over engineering
 * <p>
 * Use Case:
 * <p>
 * Create a work flow engine with several stages and according to which stage we are in the work flow will
 * create instance to execute specific algorithm which could be change or be extended over time
 */
public class PenFactory {

    public Pen createPen(PenColor penColor) {
        switch (penColor) {
            case RED:
                return new RedPen();
            case BLUE:
                return new BluePen();
            case GREEN:
                return new GreenPen();
            default:
                throw new RuntimeException("Color is not supported");
        }
    }

}
