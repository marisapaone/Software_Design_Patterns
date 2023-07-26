package paone.cs655.p2;

public class Director {
    Builder builder;

    public UIProduct createUI(Builder builder) {
        this.builder = builder;
        builder.createHeader();
        builder.createSidebar();
        builder.createMainPanel();
        builder.createFooter();

        return builder.create();
    }


}
