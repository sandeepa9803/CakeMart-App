package com.example.mymadproject.Database;

import android.provider.BaseColumns;

public final class OrderCake {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private OrderCake() {}

    /* Inner class that defines the table contents */
    public static class Orders implements BaseColumns {
        public static final String TABLE_NAME = "OrderInfo";
        public static final String COLUMN_1 = "OrderType";
        public static final String COLUMN_2 = "OrderName";
        public static final String COLUMN_3 = "Weight";
        public static final String COLUMN_4 = "Quantity";
        public static final String COLUMN_5 = "OrderedDate";
        public static final String COLUMN_6 = "Price";
        public static final String COLUMN_7 = "PaymentMethod";


    }
}