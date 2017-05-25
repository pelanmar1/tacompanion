package com.example.tacompanion.tacompanion.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Pedro Lanzagorta M on 11/25/2016.
 */
public class Session {

    @SerializedName("num_guests")
            int numGuests;
    @SerializedName("user_id")
            int userId;
    @SerializedName("restaurant_id")
            int restaurantId;

    public int getNumGuests() {
        return numGuests;
    }

    public void setNumGuests(int numGuests) {
        this.numGuests = numGuests;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
