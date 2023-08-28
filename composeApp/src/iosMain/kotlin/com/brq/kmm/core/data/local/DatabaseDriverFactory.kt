package com.brq.kmm.core.data.local

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import com.brq.kmm.database.TmdbDatabase

actual class DatabaseDriverFactory {
    actual fun create(): SqlDriver {
        return NativeSqliteDriver(TmdbDatabase.Schema,  "tmdb.db")
    }
}