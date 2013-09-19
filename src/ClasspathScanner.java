import org.reflections.Reflections;
import org.reflections.scanners.TypeAnnotationsScanner;

import java.util.Set;

public class ClasspathScanner {
    public void scan() {
        final Reflections reflections = new Reflections("org.projectx", new TypeAnnotationsScanner());
        Set<Class<?>> theFoos = reflections.getTypesAnnotatedWith(TimedIgnore.class);
        for (final Class<?> theFoo : theFoos) {
            final TimedIgnore annotation = theFoo.getAnnotation(TimedIgnore.class);
            System.out.println("This foo " + theFoo.getClass().getName() + "has expires of: "+annotation.expires());
        }
    }

}
