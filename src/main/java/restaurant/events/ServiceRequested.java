package restaurant.events;

import restaurant.actors.Table;

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
