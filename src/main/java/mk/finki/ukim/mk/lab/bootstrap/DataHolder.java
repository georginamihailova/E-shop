package mk.finki.ukim.mk.lab.bootstrap;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.Manufacturer;
import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.model.BalloonType;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Balloon> balloons = new ArrayList<>(10);
    public static List<Order> orders = new ArrayList<>();
    public static List<BalloonType> balloonTypes = new ArrayList<>();

    public static List<Manufacturer> manufacturers = new ArrayList<>();

//    @PostConstruct
//    public void init() throws ServletException{
//        Manufacturer manufacturer1 = new Manufacturer("BalloonCompany1Manufacturer","USA","Minneta Street 34");
//        Manufacturer manufacturer2 = new Manufacturer("BalloonCompany2Manufacturer","USA","Minneta Street 33");
//        Manufacturer manufacturer3 = new Manufacturer("BalloonCompany3Manufacturer","USA","Minneta Street 32");
//        Manufacturer manufacturer4 = new Manufacturer("BalloonCompany4Manufacturer","USA","Minneta Street 31");
//        Manufacturer manufacturer5 = new Manufacturer("BalloonCompany5Manufacturer","USA","Minneta Street 30");
//        manufacturers.add(manufacturer1);
//        manufacturers.add(manufacturer2);
//        manufacturers.add(manufacturer3);
//        manufacturers.add(manufacturer4);
//        manufacturers.add(manufacturer5);
//        Type type1 = new Type("Heart");
//        Type type2 = new Type("Circle");
//        Type type3 = new Type("Rectangle");
//        Type type4 = new Type("Square");
//
//        types.add(type1);
//        types.add(type2);
//        types.add(type3);
//        types.add(type4);
//
//     balloons.add(new Balloon("Pink balloon","Pink balloon description",manufacturer1,type1));
//     balloons.add(new Balloon("Yellow balloon","Yellow balloon description",manufacturer2,type2));
//     balloons.add(new Balloon("Purple balloon","Purple balloon description",manufacturer3,type3));
//     balloons.add(new Balloon("Green balloon","Green balloon description",manufacturer4,type2));
//     balloons.add(new Balloon("Red balloon","Red balloon description",manufacturer5,type4));
//
//}
}
