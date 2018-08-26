package restaurant.actors;

import restaurant.event_store.EventStore;
import restaurant.event_store.EventType;
import restaurant.event_store.events.BillSent;
import restaurant.event_store.events.OrderPlaced;
import restaurant.event_store.events.ServiceRequested;
import restaurant.output.Console;

public class Restaurant {

    private EventStore eventStore;
    private Console console;

    public Restaurant(EventStore eventStore, Console console) {
        this.eventStore = eventStore;
        this.console = console;

        registerEventListeners();
    }

    public void deliverTo(Table table) {
        this.eventStore.add(new ServiceRequested(table));
    }

    private void registerEventListeners() {
        eventStore.listenFor(EventType.ORDER_PLACED, e -> {
            OrderPlaced event = (OrderPlaced) e;
            String description = event.item().description();
            String tableName = event.table().description();
            console.println("Come on chef, we must cook a " + description + " for " + tableName + ".");
        });

        eventStore.listenFor(EventType.BILL_SENT, e -> {
            BillSent event = (BillSent) e;
            String description = event.table().description();
            double cost = event.cost();
            console.println("We have sent a bill to " + description + " for the amount of £" + cost);
        });
    }
}
