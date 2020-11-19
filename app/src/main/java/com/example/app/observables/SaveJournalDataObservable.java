package com.example.app.observables;

import android.content.Context;

import com.example.app.db.DatabaseClient;
import com.example.app.db.JournalDB;
import com.example.app.model.Journal;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;

public class SaveJournalDataObservable {
    private static SaveJournalDataObservable mSaveJournalDataObservable;

    public static SaveJournalDataObservable getInstance()
    {
        if(mSaveJournalDataObservable==null)
        {
            mSaveJournalDataObservable=new SaveJournalDataObservable();
        }
        return mSaveJournalDataObservable;
    }

    public Single<Journal> saveJournalData(final Context mContext, final ArrayList<Journal> arrListJournalData){
        return Single.create(new SingleOnSubscribe<Journal>() {
            @Override
            public void subscribe(SingleEmitter<Journal> emitter) throws Exception {
                if(arrListJournalData!=null && arrListJournalData.size()>0){
                   // DatabaseClient databaseClient = DatabaseClient.getInstance(mContext);
                  //  JournalDB journalDatabase = databaseClient.getJournalDatabase();
                    JournalDB journalDatabase = JournalDB.Companion.getInstance(mContext);//.journalDao().getAllJournalData();

                    for (int i = 0; i < arrListJournalData.size(); i++) {
                        Journal journal = arrListJournalData.get(i);
                        journalDatabase.journalDao().saveJournalDB(journal);
                    }
                }

               /* if (mArrayListJournalData != null && mArrayListJournalData.size() > 0) {
                    DatabaseClient databaseClient = DatabaseClient.getInstance(mContext);
                    JournalDatabase journalDatabase = databaseClient.getJournalDatabase();
                    for (int i = 0; i < mArrayListJournalData.size(); i++) {
                        Journal journal = mArrayListJournalData.get(i);
                        journalDatabase.journalDao().insert(journal);
                    }
                }*/
            }
        });
    }
}
