import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.util.Set;

public class ClasspathScanner {
    public void scan() {
        final Reflections reflections = new Reflections("org.projectx", new TypeAnnotationsScanner());
        Set<Class<?>> classes = reflections.getTypesAnnotatedWith(TimedIgnore.class);
        for (final Class<?> currentClass : classes) {
            final TimedIgnore timedIgnoreAnnotation = currentClass.getAnnotation(TimedIgnore.class);
            System.out.println("This foo " + currentClass.getClass().getName() + "has expires of: " + timedIgnoreAnnotation.expires());
        }
    }

}
