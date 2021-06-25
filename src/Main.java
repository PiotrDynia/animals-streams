import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        new Main();
    }

    public Main() throws IOException, InterruptedException {
        Map<String, AnimalCharacteristics> mapMammals;
        Stream<String> streamMammals = Files.lines(Paths.get("data/mammals.txt"));

        //reading the map
        mapMammals=streamMammals
                .map(x -> x.split(";"))
                .skip(1)
                .collect(Collectors.toMap(
                        x -> x[0],
                        x -> {
                                for (int i = 0; i < x.length; i++) {
                                    if (x[i].equals("NA")) {
                                        x[i] = "0";
                                    }
                                }
                                AnimalCharacteristics obiekt = new AnimalCharacteristics();
                                obiekt.setBody_wt(Double.parseDouble(x[1]));
                                obiekt.setBrain_wt(Double.parseDouble(x[2]));
                                obiekt.setNon_dreaming(Double.parseDouble(x[3]));
                                obiekt.setDreaming(Double.parseDouble(x[4]));
                                obiekt.setTotal_sleep(Double.parseDouble(x[5]));
                                obiekt.setLife_span(Double.parseDouble(x[6]));
                                obiekt.setGestation(Double.parseDouble(x[7]));
                                obiekt.setPredation(Integer.parseInt(x[8]));
                                obiekt.setExposure(Integer.parseInt(x[9]));
                                obiekt.setDanger(Integer.parseInt(x[10]));
                                return obiekt;
                        }
                ));
        streamMammals.close();

        //sorting the map
        Map<String, AnimalCharacteristics> sortedMap = new TreeMap<>(
                (s1, s2) -> {
                    if (s1.length() > s2.length()) {
                        return 1;
                    } else if (s1.length() < s2.length()) {
                        return -1;
                    } else {
                        return s1.compareTo(s2);
                    }
                });
        sortedMap.putAll(mapMammals);

        //printing the map
        for(Map.Entry<String, AnimalCharacteristics> entry : sortedMap.entrySet()){
            System.out.println(entry.getValue().toString());
        }

        //finding the biggest mammal
        System.out.println("\nMammal with biggest body weight: \n" + sortedMap
                .values()
                .stream()
                .max(Comparator.comparingDouble(AnimalCharacteristics::getBody_wt))
                .get().toString() + "\n");

        //finding 3 longest dreaming mammals
        System.out.println("3 longest dreaming mammals: ");

       sortedMap.values()
                .stream()
                .filter(x -> x.getDreaming()!=0)
                .filter(x -> x.getTotal_sleep()!=0)
                .sorted(Comparator.comparingDouble(AnimalCharacteristics::getDreamtoTotal).reversed())
                .limit(3)
                .forEach(x -> System.out.println(x.toString() +
                        "\nPercentage of dreams to total sleep: " +
                        x.round(x.getDreamtoTotal()) + "%"));

        System.out.println("\nAverage life span:");

         sortedMap.values()
                .stream()
                .mapToDouble(AnimalCharacteristics::getLife_span)
                .average()
                .ifPresent(System.out::println);

        Comparator<AnimalCharacteristics> compAnimals = new Comparator<>() {
            @Override
            public int compare(AnimalCharacteristics o1, AnimalCharacteristics o2) {
                if(o1.getBody_wt() > o2.getBody_wt()){
                    return -1;
                }else{
                    return 1;
                }
            }
        };

        //finding three biggest mammals
        System.out.println("\nBiggest mammals: ");
        List<AnimalCharacteristics> listMammals = sortedMap
                .values()
                .stream()
                .sorted(compAnimals)
                .limit(3)
                .collect(Collectors.toList());

        for(AnimalCharacteristics entry : listMammals){
            System.out.println(entry);
        }

        //performing the experiment
        System.out.println("\nExperiment: ");

        Thread mainThread = new Thread (() -> {
            double startMammal1weight = listMammals.get(0).getBody_wt();
            double startMammal2weight = listMammals.get(1).getBody_wt();
            double startMammal3weight = listMammals.get(2).getBody_wt();

            Thread th1 = new Thread(() -> {
                for (int i = 1; i <= 365; i++) {
                    listMammals.get(0).feed();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    listMammals.get(0).burn();
                    listMammals.get(0).feed();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    listMammals.get(0).burn();
                    System.out.println("Day " + i + " Current mammal1 weight: " +
                            listMammals.get(0).round(listMammals.get(0).getBody_wt()));
                }
            });
            Thread th2 = new Thread(() -> {
                for (int i = 1; i <= 365; i++) {
                    listMammals.get(1).feed();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    listMammals.get(1).burn();
                    listMammals.get(1).feed();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    listMammals.get(1).burn();
                    System.out.println("Day " + i + " Current mammal2 weight: " +
                            listMammals.get(1).round(listMammals.get(1).getBody_wt()));
                }
            });
            Thread th3 = new Thread(() -> {
                for (int i = 1; i <= 365; i++) {
                    listMammals.get(2).feed();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    listMammals.get(2).burn();
                    listMammals.get(2).feed();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    listMammals.get(2).burn();
                    System.out.println("Day " + i + " Current mammal3 weight: " +
                            listMammals.get(2).round(listMammals.get(2).getBody_wt()));
                }
            });
            th1.start();
            th2.start();
            th3.start();
            try{
                th1.join();
                th2.join();
                th3.join();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Weight of mammal1 before experiment: " +
                    startMammal1weight);
            System.out.println("Weight of mammal1 after experiment: " +
                    listMammals.get(0).round(listMammals.get(0).getBody_wt()));
            System.out.println("Weight of mammal2 before experiment: " +
                    startMammal2weight);
            System.out.println("Weight of mammal2 after experiment: " +
                    listMammals.get(1).round(listMammals.get(1).getBody_wt()));
            System.out.println("Weight of mammal3 before experiment: " +
                    startMammal3weight);
            System.out.println("Weight of mammal3 after experiment: " +
                    listMammals.get(2).round(listMammals.get(2).getBody_wt()));
        });
        mainThread.start();
        mainThread.join();
    }
}
