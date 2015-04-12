package ru4pda.news.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table ARTICLE.
*/
public class ArticleDao extends AbstractDao<Article, Long> {

    public static final String TABLENAME = "ARTICLE";

    /**
     * Properties of entity Article.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Server_id = new Property(1, Long.class, "server_id", false, "SERVER_ID");
        public final static Property Date = new Property(2, java.util.Date.class, "date", false, "DATE");
        public final static Property Title = new Property(3, String.class, "title", false, "TITLE");
        public final static Property Description = new Property(4, String.class, "description", false, "DESCRIPTION");
        public final static Property Position = new Property(5, Integer.class, "position", false, "POSITION");
        public final static Property Category = new Property(6, String.class, "category", false, "CATEGORY");
    };


    public ArticleDao(DaoConfig config) {
        super(config);
    }
    
    public ArticleDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'ARTICLE' (" + //
                "'_id' INTEGER PRIMARY KEY ," + // 0: id
                "'SERVER_ID' INTEGER," + // 1: server_id
                "'DATE' INTEGER," + // 2: date
                "'TITLE' TEXT," + // 3: title
                "'DESCRIPTION' TEXT," + // 4: description
                "'POSITION' INTEGER," + // 5: position
                "'CATEGORY' TEXT);"); // 6: category
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'ARTICLE'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Article entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long server_id = entity.getServer_id();
        if (server_id != null) {
            stmt.bindLong(2, server_id);
        }
 
        java.util.Date date = entity.getDate();
        if (date != null) {
            stmt.bindLong(3, date.getTime());
        }
 
        String title = entity.getTitle();
        if (title != null) {
            stmt.bindString(4, title);
        }
 
        String description = entity.getDescription();
        if (description != null) {
            stmt.bindString(5, description);
        }
 
        Integer position = entity.getPosition();
        if (position != null) {
            stmt.bindLong(6, position);
        }
 
        String category = entity.getCategory();
        if (category != null) {
            stmt.bindString(7, category);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Article readEntity(Cursor cursor, int offset) {
        Article entity = new Article( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // server_id
            cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)), // date
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // title
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // description
            cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5), // position
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // category
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Article entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setServer_id(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setDate(cursor.isNull(offset + 2) ? null : new java.util.Date(cursor.getLong(offset + 2)));
        entity.setTitle(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setDescription(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setPosition(cursor.isNull(offset + 5) ? null : cursor.getInt(offset + 5));
        entity.setCategory(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Article entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Article entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
