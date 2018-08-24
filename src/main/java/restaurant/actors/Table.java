package restaurant.actors;

import restaurant.events.EventStore;
import restaurant.events.BillRequested;
import restaurant.events.OrderPlaced;
import restaurant.menu.MenuItem;

public class Table {

    private EventStore eventStore;
    private String name;

    public Table(EventStore eventStore, String name) {
        this.eventStore = eventStore;
        this.name = name;
    }

    public void placeOrderOf(MenuItem item) {
        eventStore.add(new OrderPlaced(item, this));
    }

    public void requestBill() {
        eventStore.add(new BillRequested(this));
    }

    public String description() {
        return name;
    }
}
