package restaurant.event_store.events;

import restaurant.actors.Table;
import restaurant.event_store.Event;
import restaurant.event_store.EventType;

public class ServiceRequested implements Event {

    private Table table;

    public ServiceRequested(Table table) {
        this.table = table;
    }

    @Override
    public EventType type() {
        return EventType.SERVICE_REQUESTED;
    }

    public Table table() {
        return table;
    }
}
