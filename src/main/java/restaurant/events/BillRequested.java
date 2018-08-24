package restaurant.events;

import restaurant.actors.Table;

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
