package restaurant.actors;

import restaurant.event_store.EventStore;
import restaurant.event_store.events.BillRequested;
import restaurant.event_store.events.OrderPlaced;
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
