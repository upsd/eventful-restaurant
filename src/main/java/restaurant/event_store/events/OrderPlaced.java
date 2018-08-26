package restaurant.event_store.events;

import restaurant.actors.Table;
import restaurant.event_store.Event;
import restaurant.event_store.EventType;
import restaurant.menu.MenuItem;

public class OrderPlaced implements Event {

    private MenuItem item;
    private Table table;

    public OrderPlaced(MenuItem item, Table table) {
        this.item = item;
        this.table = table;
    }

    @Override
    public EventType type() {
        return EventType.ORDER_PLACED;
    }

    public MenuItem item() {
        return item;
    }

    public Table table() {
        return table;
    }
}
