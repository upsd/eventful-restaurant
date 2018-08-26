import org.junit.Test;
import restaurant.actors.Restaurant;
import restaurant.actors.Table;
import restaurant.actors.Waiter;
import restaurant.event_store.EventStore;
import restaurant.menu.ChickenSoup;
import restaurant.output.Console;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RestaurantShould {

    @Test
    public void provide_table_service() {
        Console console = mock(Console.class);
        EventStore eventStore = new EventStore();
        Restaurant restaurant = new Restaurant(eventStore, console);
        Table table = new Table(eventStore, "Roger");
        Waiter waiter = new Waiter(eventStore, console);


        table.placeOrderOf(new ChickenSoup());

        restaurant.deliverTo(table);

        table.requestBill();

        waiter.issueBillFor(table, 53.54);


        verify(console).println("Come on chef, we must cook a Chicken Soup for Roger.");
        verify(console).println("As the waiter, I must deliver the food to Roger.");
        verify(console).println("As the waiter, I must fetch the bill for Roger.");
        verify(console).println("We have sent a bill to Roger for the amount of £53.54");
    }
}
