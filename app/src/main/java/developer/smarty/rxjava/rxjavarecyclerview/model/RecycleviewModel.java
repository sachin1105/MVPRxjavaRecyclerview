package developer.smarty.rxjava.rxjavarecyclerview.model;

import java.util.ArrayList;
import java.util.List;

import developer.smarty.rxjava.rxjavarecyclerview.contract.RecyclerviewContract;

public class RecycleviewModel implements RecyclerviewContract.Model {
    @Override
    public List<String> gameNameList() {

        List<String> list= new ArrayList<>();
        list.add("Sachin Dhingra");
        list.add("Smarty Singh");
        list.add("Sarita Dhingra");
        list.add("Vaidehi Dhingra");
        list.add("Vedika Dhingra");
        list.add("Vanshika Dhingra");
        return list;


    }//end of method

}//end of class
