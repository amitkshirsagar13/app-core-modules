package io.k8cluster.microservices.modules.config.logging.filter;

import ch.qos.logback.classic.boolex.OnMarkerEvaluator;
import ch.qos.logback.classic.spi.ILoggingEvent;
import org.slf4j.Marker;

/**
 * return "onMatch" if no markers found on loggin event, otherwise "onMismatch"
 */
public class OnNoMarkerEvaluator extends OnMarkerEvaluator {

    @Override public boolean evaluate(ILoggingEvent event) {
        Marker eventsMarker = event.getMarker();
        if (eventsMarker == null) {
            return true;
        }
        return false;
    }
}
