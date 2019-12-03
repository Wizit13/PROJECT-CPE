package com.example.projectcpe.ViewModel;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MissionDAO {
    @Query("select * from mission")
    List<Mission> getAllMission();
//
//    @Query("select * from mission")
//    List<Step> getAllStep();

    @Query("select * from mission where id=:id")
    int getDesMission(int id);

    @Query("select * from mission where id=:id")
    List<Mission> getAllinfoOfMission(int id);



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void create(Mission mission);

    @Update
    void update(Mission mission);

    @Delete
    void delete(Mission mission);
}
