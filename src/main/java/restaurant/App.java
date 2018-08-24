package restaurant;

import restaurant.actors.Restaurant;
import restaurant.actors.Table;
import restaurant.actors.Waiter;
import restaurant.events.EventStore;
import restaurant.menu.ChickenSoup;
import restaurant.menu.FishAndChips;
import restaurant.menu.Steak;
import restaurant.output.Console;

public class App {

    public static void main(String[] args) {
        EventStore eventStore = new EventStore();
        Restaurant restaurant = new Restaurant(eventStore, new Console());
        Table table = new Table(eventStore, "The dreaded table");
        Waiter waiter = new Waiter(eventStore, new Console());


        table.placeOrderOf(new ChickenSoup());
        table.placeOrderOf(new FishAndChips());
        table.placeOrderOf(new Steak());

        restaurant.deliverTo(table);

        table.requestBill();

        waiter.issueBillFor(table, 150);
    }
}
