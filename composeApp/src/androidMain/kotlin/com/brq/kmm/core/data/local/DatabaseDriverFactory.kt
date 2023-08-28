package com.brq.kmm.core.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.brq.kmm.AndroidApp
import com.brq.kmm.database.TmdbDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return AndroidSqliteDriver(TmdbDatabase.Schema, AndroidApp.INSTANCE, "tmdb.db")
    }
}