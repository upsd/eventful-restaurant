package restaurant.event_store;

import com.sun.tools.javac.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class EventStore {

    private List<Pair<EventType, Consumer>> listeners;
    private List<Event> events;

    public EventStore() {
        listeners = new ArrayList<>();
        events = new ArrayList<>();
    }

    public void add(Event event) {
        this.events.add(event);

        executeListenersFor(event);
    }

    public void listenFor(EventType event, Consumer<Event> functionToRun) {
        Pair<EventType, Consumer> listener = new Pair<>(event, functionToRun);
        this.listeners.add(listener);
    }

    private void executeListenersFor(Event event) {
        listeners.stream()
                .filter(p -> p.fst == event.type())
                .forEach(p -> p.snd.accept(event));
    }
}