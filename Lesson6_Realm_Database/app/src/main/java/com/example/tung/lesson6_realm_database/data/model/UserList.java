package com.example.tung.lesson6_realm_database.data.model;

/**
 * Created by tung on 5/30/17.
 */

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class UserList implements Parcelable {

    @SerializedName("total_count")
    private Integer totalCount;

    @SerializedName("incomplete_results")
    private Boolean incompleteResults;

    @SerializedName("items")
    private List<User> users = null;

    public final static Creator<UserList> CREATOR = new Creator<UserList>() {

        @SuppressWarnings({
                "unchecked"
        })
        public UserList createFromParcel(Parcel in) {
            UserList instance = new UserList();
            instance.totalCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
            instance.incompleteResults = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
            in.readList(instance.users, (User.class.getClassLoader()));
            return instance;
        }

        public UserList[] newArray(int size) {
            return (new UserList[size]);
        }
    };

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Boolean getIncompleteResults() {
        return incompleteResults;
    }

    public void setIncompleteResults(Boolean incompleteResults) {
        this.incompleteResults = incompleteResults;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(totalCount);
        dest.writeValue(incompleteResults);
        dest.writeList(users);
    }

    public int describeContents() {
        return 0;
    }
}
