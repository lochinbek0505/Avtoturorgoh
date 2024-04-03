package com.example.stayenka

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.stayenka.model.Item

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "stayanka"
        private const val TABLE_NAME = "items"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_LOCATION = "location"
        private const val COLUMN_PRICE = "price"
        private const val COLUMN_FROM_DATE = "from_date"
        private const val COLUMN_END_DATE = "end_date"
        private const val COLUMN_LIMIT = "limit"
        private const val COLUMN_NUMBER = "number"
        private const val COLUMN_QR_TEXT = "qr_text"
    }
    override fun onCreate(db: SQLiteDatabase) {
        val createTableQuery = ("CREATE TABLE $TABLE_NAME ("
                + "$COLUMN_ID INTEGER PRIMARY KEY,"
                + "$COLUMN_NAME TEXT,"
                + "$COLUMN_LOCATION TEXT,"
                + "$COLUMN_PRICE TEXT,"
                + "$COLUMN_FROM_DATE TEXT,"
                + "$COLUMN_END_DATE TEXT,"
                + "`$COLUMN_LIMIT` TEXT,"
                + "$COLUMN_NUMBER TEXT,"
                + "$COLUMN_QR_TEXT TEXT"
                + ")")
        db.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun addItem(item: Item): Long {
        val db = this.writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_NAME, item.name)
            put(COLUMN_LOCATION, item.location)
            put(COLUMN_PRICE, item.price)
            put(COLUMN_FROM_DATE, item.fromDate)
            put(COLUMN_END_DATE, item.endDate)
            put("`$COLUMN_LIMIT`", item.limit) // Escape "limit" column name
            put(COLUMN_NUMBER, item.number)
            put(COLUMN_QR_TEXT, item.qrText)
        }
        val id = db.insert(TABLE_NAME, null, values)
        db.close()
        return id
    }


    fun getAllItems(): ArrayList<Item> {
        val itemList = ArrayList<Item>()
        val selectQuery = "SELECT * FROM $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        try {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    val idIndex = cursor.getColumnIndex(COLUMN_ID)
                    val nameIndex = cursor.getColumnIndex(COLUMN_NAME)
                    val locationIndex = cursor.getColumnIndex(COLUMN_LOCATION)
                    val priceIndex = cursor.getColumnIndex(COLUMN_PRICE)
                    val fromDateIndex = cursor.getColumnIndex(COLUMN_FROM_DATE)
                    val endDateIndex = cursor.getColumnIndex(COLUMN_END_DATE)
                    val limitIndex = cursor.getColumnIndex(COLUMN_LIMIT)
                    val numberIndex = cursor.getColumnIndex(COLUMN_NUMBER)
                    val qrTextIndex = cursor.getColumnIndex(COLUMN_QR_TEXT)

                    if (idIndex >= 0 && nameIndex >= 0 && locationIndex >= 0 &&
                        priceIndex >= 0 && fromDateIndex >= 0 && endDateIndex >= 0 &&
                        limitIndex >= 0 && numberIndex >= 0 && qrTextIndex >= 0) {

                        val id = cursor.getInt(idIndex)
                        val name = cursor.getString(nameIndex)
                        val location = cursor.getString(locationIndex)
                        val price = cursor.getDouble(priceIndex)
                        val fromDate = cursor.getString(fromDateIndex)
                        val endDate = cursor.getString(endDateIndex)
                        val limit = cursor.getInt(limitIndex)
                        val number = cursor.getInt(numberIndex)
                        val qrText = cursor.getString(qrTextIndex)

                        val item = Item(
                            id,
                            name,
                            location,
                            price.toInt().toString(),
                            fromDate,
                            endDate,
                            limit.toString(),
                            number.toString(),
                            qrText
                        )
                        itemList.add(item)
                    }
                } while (cursor.moveToNext())
            }
        } finally {
            cursor?.close()
        }
        db.close()
        return itemList
    }

    // Implement other CRUD operations similar to addItem and getAllItems
}
