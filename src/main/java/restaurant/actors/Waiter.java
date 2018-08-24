package restaurant.actors;

import restaurant.events.EventStore;
import restaurant.events.BillRequested;
import restaurant.events.BillSent;
import restaurant.events.EventType;
import restaurant.events.ServiceRequested;
import restaurant.output.Console;

public class Waiter {

    private EventStore eventStore;
    private Console console;

    public Waiter(EventStore eventStore, Console console) {
        this.eventStore = eventStore;
        this.console = console;

        registerEventListeners();
    }

    private void registerEventListeners() {
        eventStore.listenFor(EventType.BILL_REQUESTED, e -> {
            BillRequested event = (BillRequested) e;
            String description = event.table().description();
            console.println("As the waiter, I must fetch the bill for " + description + ".");
        });

        eventStore.listenFor(EventType.SERVICE_REQUESTED, e -> {
            ServiceRequested event = (ServiceRequested) e;
            String description = event.table().description();
            console.println("As the waiter, I must deliver the food to " + description + ".");
        });
    }

    public void issueBillFor(Table table, double cost) {
        eventStore.add(new BillSent(table, cost));
    }
}
