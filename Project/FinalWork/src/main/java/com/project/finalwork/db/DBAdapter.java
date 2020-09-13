package com.project.finalwork.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import com.project.finalwork.instance.StudentInfoEntities;

public class DBAdapter {

    private String DB_NAME = "student_info.db";
    private String DB_TABLE = "student_info";

    private String name;
    private String student_id;
    private String id_number;
    private String sex;
    private String native_place;
    private String birthday;
    private String school;
    private String major;
    private String student_class;
    private String phone;
    private String email;
    private String weixin_number;
    private String special_skill;

    private int VERSION = 1;

    private SQLiteDatabase db;
    private DBopenHelper dbOpenHelper;
    private Context context;

    public DBAdapter(Context context) {
        this.context = context;
    }


    public void open() {
        if( dbOpenHelper == null )
            dbOpenHelper = new DBopenHelper(context,DB_NAME,null,VERSION);
        db = dbOpenHelper.getWritableDatabase();
    }

    public void close() {
        if( db != null ) {
            db.close();
            db = null;
        }
    }

    public long insert(StudentInfoEntities student) {
        ContentValues newValues = new ContentValues();

        newValues.put("name",student.getName());
        newValues.put("student_id", student.getStudent_id());
        newValues.put("id_number", student.getId_number());
        newValues.put("sex", student.getSex());
        newValues.put("native_place", student.getNative_place());
        newValues.put("birthday", student.getBirthday());
        newValues.put("school", student.getSchool());
        newValues.put("major", student.getMajor());
        newValues.put("student_class", student.getStudent_class());
        newValues.put("phone", student.getPhone());
        newValues.put("email", student.getEmail());
        newValues.put("weixin_number", student.getWeixin_number());
        newValues.put("special_skill", student.getSpecial_skill());

        long add_length = db.insert(DB_TABLE, null, newValues);
        if(add_length>0)
            Toast.makeText(context,"成功添加学生信息",Toast.LENGTH_SHORT).show();
        return add_length;
    }
    public class DBopenHelper extends SQLiteOpenHelper {

        public DBopenHelper(Context context,String name,SQLiteDatabase.CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE " + DB_TABLE + "(" +
                            "ID INTEGER PRIMARY KEY autoincrement," +
                            "name TEXT," +
                            "student_id TEXT," +
                            "id_number TEXT," +
                            "sex TEXT," +
                            "native_place TEXT," +
                            "birthday TEXT," +
                            "school TEXT," +
                            "major TEXT," +
                            "student_class TEXT," +
                            "phone TEXT," +
                            "email TEXT," +
                            "weixin_number TEXT," +
                            "special_skill TEXT" + ");"
            );
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + DB_TABLE);
            onCreate(db);
        }
    }
}
