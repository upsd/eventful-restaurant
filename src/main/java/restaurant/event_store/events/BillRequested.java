package restaurant.event_store.events;

import restaurant.actors.Table;
import restaurant.event_store.Event;
import restaurant.event_store.EventType;

public class BillRequested implements Event {

    private Table table;

    public BillRequested(Table table) {
        this.table = table;
    }

    @Override
    public EventType type() {
        return EventType.BILL_REQUESTED;
    }

    public Table table() {
        return table;
    }
}
