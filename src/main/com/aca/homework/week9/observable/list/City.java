package com.aca.homework.week9.observable.list;

public class City {
    private ObservableList<Human> population = new ArrayObservableList<>();

    private City() {
    }

    public static City create(){

        City city = new City();
        city.population.addListener(new ListChangeListener<Human>() {
            @Override
            public void onAdded(Human item) {
                System.out.println(("A new joiner is: " + item.toString()));
            }
        });
        city.population.addListener(new ListChangeListener<Human>() {
            @Override
            public void onAdded(Human item) {
                System.out.println("applause");
                pause500ms();
                System.out.println("applause");
            }

            private void pause500ms() {
                long start = System.currentTimeMillis();
                while (System.currentTimeMillis() != start + 500);
            }
        });

        return city;
    }

    public void addHuman(Human human) {
        population.add(human);
    }

}
