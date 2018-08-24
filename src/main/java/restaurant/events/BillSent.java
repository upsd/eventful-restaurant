package restaurant.events;

import restaurant.actors.Table;

public class BillSent implements Event {

    private Table table;
    private double cost;

    public BillSent(Table table, double cost) {
        this.table = table;
        this.cost = cost;
    }

    @Override
    public EventType type() {
        return EventType.BILL_SENT;
    }

    public Table table() {
        return table;
    }

    public double cost() {
        return cost;
    }
}
