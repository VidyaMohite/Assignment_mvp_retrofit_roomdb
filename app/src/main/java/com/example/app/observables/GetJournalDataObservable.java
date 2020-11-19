package com.example.app.observables;

import android.content.Context;

import com.example.app.db.DatabaseClient;
import com.example.app.db.JournalDB;
import com.example.app.model.Journal;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class GetJournalDataObservable {
    private static GetJournalDataObservable mGetJournalDataObservable;

    public static GetJournalDataObservable getInstance()
    {
        if(mGetJournalDataObservable==null)
        {
            mGetJournalDataObservable = new GetJournalDataObservable();
        }
        return mGetJournalDataObservable;
    }

    public Single<ArrayList<Journal>> getAllJournalData(final Context context) {
        return Single.create(new SingleOnSubscribe<ArrayList<Journal>>() {
            @Override
            public void subscribe(SingleEmitter<ArrayList<Journal>> emitter) throws Exception {
                try {
                    //DatabaseClient databaseClient = DatabaseClient.getInstance(context);
                    //JournalDB journalDatabase = databaseClient.getJournalDatabase();
                    JournalDB journalDatabase = JournalDB.Companion.getInstance(context);//.journalDao().getAllJournalData();
                    List<Journal> journalListData = journalDatabase.journalDao().getAllJournalData();
                    //ArrayList<Journal> list_competition = DatabaseHelper.getInstance(context).getCompetitionForHot();

                    emitter.onSuccess((ArrayList<Journal>) journalListData);
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        });
    }
}
