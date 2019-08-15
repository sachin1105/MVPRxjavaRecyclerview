package developer.smarty.rxjava.rxjavarecyclerview.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import developer.smarty.rxjava.rxjavarecyclerview.R;
import developer.smarty.rxjava.rxjavarecyclerview.adaptor.RecyclerviewAdaptor;
import developer.smarty.rxjava.rxjavarecyclerview.contract.RecyclerviewContract;
import developer.smarty.rxjava.rxjavarecyclerview.presenter.RecyclerviewPresenter;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Sachin Dhingra on 2019/08/15
 * This activty is responsible for displaying data in recyclerview with the help of Rxjava
 */
public class MainActivity extends AppCompatActivity implements RecyclerviewContract.View {

    private static final String TAG = MainActivity.class.getSimpleName();


    @BindView(R.id.mRecyclerview)
    RecyclerView mRecyclerview;

    private LinearLayoutManager linearLayoutManager;
    private RecyclerviewAdaptor recyclerviewAdaptor;

    private RecyclerviewContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mPresenter = new RecyclerviewPresenter(MainActivity.this);
        mPresenter.creatingObservable();

       linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerview.setLayoutManager(linearLayoutManager);

    }//end of onCreate()


    @Override
    public void displayData(List<String> gameNameList) {

        Log.e(TAG, "displayData: "+gameNameList );
        final Observable<List<String>> listObservable = Observable.just(gameNameList);

        listObservable.subscribe(new Observer<List<String>>() {
            @Override
            public void onSubscribe(Disposable d) {

                Log.e(TAG, "onSubscribe: " );

            }

            @Override
            public void onNext(List<String> strings) {

                Log.e(TAG, "onNext: ");

                recyclerviewAdaptor = new RecyclerviewAdaptor(MainActivity.this,strings);
                mRecyclerview.setAdapter(recyclerviewAdaptor);

            }

            @Override
            public void onError(Throwable e) {

                Log.e(TAG, "onError: "+e);
            }

            @Override
            public void onComplete() {

                Log.e(TAG, "onComplete: ");

            }
        });
    }//end of method

}//end of activity
