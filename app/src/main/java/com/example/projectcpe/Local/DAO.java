package com.example.projectcpe.Local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.projectcpe.ViewModel.Admin;
import com.example.projectcpe.ViewModel.Member;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

@Dao
public interface DAO {

    @Query("select * from member where id=:memberId")
    Flowable<Member> getMemberById(int memberId);

    @Query("select * from member ")
    Flowable<List<Member>> getAllMember();

    @Query("select * from admin ")
    Single<Admin> getPassword();

    @Insert
    void insertPassword(Admin... password);

    @Insert
    void insertUser(Member... members);

    @Update
    void updateUser(Member... members);

    @Update
    void updatePassword(Admin... password);

    @Delete
    void deleteUsers(Member member);




}
