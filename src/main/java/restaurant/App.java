package restaurant;

import restaurant.actors.Restaurant;
import restaurant.actors.Table;
import restaurant.actors.Waiter;
import restaurant.events.EventStore;
import restaurant.menu.ChickenSoup;
import restaurant.output.Console;

public class App {

    public static void main(String[] args) {
        EventStore eventStore = new EventStore();
        Restaurant restaurant = new Restaurant(eventStore, new Console());
        Table table = new Table(eventStore, "Roger");
        Waiter waiter = new Waiter(eventStore, new Console());


        table.placeOrderOf(new ChickenSoup());

        restaurant.deliverTo(table);

        table.requestBill();

        waiter.issueBillFor(table, 53.54);
    }
}
