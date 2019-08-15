package developer.smarty.rxjava.rxjavarecyclerview.presenter;

import android.util.Log;

import java.util.List;

import developer.smarty.rxjava.rxjavarecyclerview.contract.RecyclerviewContract;
import developer.smarty.rxjava.rxjavarecyclerview.model.RecycleviewModel;

public class RecyclerviewPresenter implements RecyclerviewContract.Presenter {


    private static final String TAG = RecyclerviewPresenter.class.getSimpleName();

    private RecyclerviewContract.View mView;
    private RecyclerviewContract.Model mModel;

    public RecyclerviewPresenter(RecyclerviewContract.View mView) {
        this.mView = mView;
        Initialise();
    }

    private void Initialise(){

        mModel = new RecycleviewModel();


    }//end of method

    @Override
    public void creatingObservable() {
        List<String> mList = mModel.gameNameList();
        Log.e(TAG, "creatingObservable: "+mList );
        mView.displayData(mList);
    }

   /* @Override
    public void creatingObservable() {

        List<String> mList = mModel.gameNameList();
        Log.e(TAG, "creatingObservable: "+mList );
        mView.displayData(mList);

    }//end of method
*/

}//end of Class
