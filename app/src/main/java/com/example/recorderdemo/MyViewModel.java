package com.example.recorderdemo;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel{
    //private MutableLiveData<Integer> scoreA;
    //private MutableLiveData<Integer> scoreB;
    private int aBack, bBack;
    public SavedStateHandle handle;
    public MyViewModel(SavedStateHandle handle){
        this.handle = handle;
    }

    public MutableLiveData<Integer> getScoreA() {
        if(!handle.contains(MainActivity.A_Score)){
            handle.set(MainActivity.A_Score, 0);
        }
        return handle.getLiveData(MainActivity.A_Score);
    }

    public MutableLiveData<Integer> getScoreB() {
        if(!handle.contains(MainActivity.B_Score)){
            handle.set(MainActivity.B_Score, 0);
        }
        return handle.getLiveData(MainActivity.B_Score);
    }

    public void teamAadd(int n){
        aBack = getScoreA().getValue();
        bBack = getScoreB().getValue();

        getScoreA().setValue(getScoreA().getValue() + n);

    }

    public void teamBadd(int m){
        aBack = getScoreA().getValue();
        bBack = getScoreB().getValue();

        getScoreB().setValue(getScoreB().getValue() + m);
    }

    public  void reset(){
        aBack = getScoreA().getValue();
        bBack = getScoreB().getValue();

        getScoreA().setValue(0);
        getScoreB().setValue(0);
    }

    public void undo(){
        getScoreA().setValue(aBack);
        getScoreB().setValue(bBack);
    }
}
