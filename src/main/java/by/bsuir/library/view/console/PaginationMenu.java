package by.bsuir.library.view.console;

import by.bsuir.library.view.item.NextPageAction;
import by.bsuir.library.view.item.PreviousPageAction;
import io.bretty.console.view.ViewConfig;

import java.util.List;


public class PaginationMenu extends LibraryMenuView{

    private static ViewConfig viewConfig = new ViewConfig.Builder()
            .setQuitMenuName("Back")
            .setQuitMessage("")
            .build();

    private List objects;
    private long position = 1;
    private long amount = 1;
    private String emptyMessage;

    public PaginationMenu(String runningTitle, List objects, long amount, String emptyMessage) {
        super(runningTitle, "", viewConfig);
        this.amount = amount;
        this.objects = objects;
        this.emptyMessage = emptyMessage;
    }

    private void displayList(){
        while(!this.getMenuItems().isEmpty()){
            this.removeMenuItem(0);
        }
        if (!objects.isEmpty()) {
            objects.stream()
                    .skip(position - 1)
                    .limit(amount)
                    .forEach(o -> this.addMenuItem(new BookViewItem(o)));
        } else {
            System.out.println(emptyMessage);
        }
        this.addMenuItem(new NextPageAction(this));
        this.addMenuItem(new PreviousPageAction(this));
    }

    @Override
    public void display() {
        displayList();
        super.display();
    }

    public void nextPage(){
        if(!(this.position + this.amount > this.objects.size())){
            this.position += this.amount;
        }
    }

    public void previousPage(){
        this.position -= this.amount;
        if(this.position < 1){
            this.position = 1;
        }
    }
}
