package developer.smarty.rxjava.rxjavarecyclerview.contract;

import java.util.List;

public interface RecyclerviewContract {

    interface View{
        void displayData(List<String> gameNameList);
    }

    interface Model{

         List<String> gameNameList();

    }

    interface Presenter{

        void creatingObservable();

    }



}//end of interface
