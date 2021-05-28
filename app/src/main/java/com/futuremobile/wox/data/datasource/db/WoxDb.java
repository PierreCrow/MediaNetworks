package com.futuremobile.wox.data.datasource.db;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.futuremobile.wox.data.datasource.db.dao.AreaGrupoDAO;
import com.futuremobile.wox.data.datasource.db.dao.LineaTiempoDAO;
import com.futuremobile.wox.data.datasource.db.dao.TrazaDAO;
import com.futuremobile.wox.data.datasource.db.dao.WorkOrderDAO;
import com.futuremobile.wox.data.datasource.db.model.DbAreaGrupo;
import com.futuremobile.wox.data.datasource.db.model.DbLineaTiempo;
import com.futuremobile.wox.data.datasource.db.model.DbTraza;
import com.futuremobile.wox.data.datasource.db.model.DbWorkOrder;
import com.futuremobile.wox.presentation.utiles.Converters;

@Database(entities = {
        DbWorkOrder.class,
        DbLineaTiempo.class,
        DbTraza.class,
        DbAreaGrupo.class
        },
        version =4 ,
        exportSchema = false)
@TypeConverters({Converters.class})

public abstract class WoxDb extends RoomDatabase {

    private static WoxDb INSTANCE;
    public static final String DB_NAME = "wox.db";
    private static Context mContext;

    public static WoxDb getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (WoxDb.class) {
                if (INSTANCE == null) {
                    mContext = context.getApplicationContext();
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WoxDb.class, DB_NAME)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries() // SHOULD NOT BE USED IN PRODUCTION !!!
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    // Log.i(TAG, "populating with data...");
//                                    new PopulateDbAsync(INSTANCE).execute();
                                }
                            }).build();
                }
            }
        }
        return INSTANCE;
    }


    public abstract WorkOrderDAO workOrderDAO();

    public abstract LineaTiempoDAO lineaTiempoDAO();

    public abstract TrazaDAO trazaDAO();

    public abstract AreaGrupoDAO areaGrupoDAO();

}
