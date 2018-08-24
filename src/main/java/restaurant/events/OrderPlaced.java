package restaurant.events;

import restaurant.menu.MenuItem;
import restaurant.actors.Table;

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
