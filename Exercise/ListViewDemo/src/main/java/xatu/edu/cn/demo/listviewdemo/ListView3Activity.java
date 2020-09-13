package xatu.edu.cn.demo.listviewdemo;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.provider.ContactsContract.CommonDataKinds.Phone;

import java.io.InputStream;
import java.util.ArrayList;

public class ListView3Activity extends Activity {
    private ListView listView;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        getPhoneContacts();
        initList();
        textView=(TextView)findViewById(R.id.TextView01);
        listView=(ListView)findViewById(R.id.ListView01);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                   ContactEntity entity= (ContactEntity)parent.getItemAtPosition(position);
                   textView.setText(entity.getName()+":"+entity.getNumber());
            }
        });
    }

    /** 联系人名称 **/
    private ArrayList<ContactEntity> mContacts = new ArrayList<ContactEntity>();

    private static final String[] PHONES_PROJECTION = new String[] {
            Phone.DISPLAY_NAME,
            Phone.NUMBER,
            Phone.PHOTO_ID,
            Phone.CONTACT_ID };

    /** 联系人显示名称 **/
    private static final int PHONES_DISPLAY_NAME_INDEX = 0;

    /** 电话号码 **/
    private static final int PHONES_NUMBER_INDEX = 1;

    /** 头像ID **/
    private static final int PHONES_PHOTO_ID_INDEX = 2;

    /** 联系人的ID **/
    private static final int PHONES_CONTACT_ID_INDEX = 3;

    private void getPhoneContacts() {
        ContentResolver resolver = getContentResolver();
        try {
            // 获取手机联系人
            Cursor phoneCursor = resolver.query(Phone.CONTENT_URI,
                    PHONES_PROJECTION, null, null, null);
            if (phoneCursor != null) {

                while (phoneCursor.moveToNext()) {
                    // 得到手机号码
                    String phoneNumber = phoneCursor
                            .getString(PHONES_NUMBER_INDEX);
                    // 当手机号码为空的或者为空字段 跳过当前循环
                    if (TextUtils.isEmpty(phoneNumber))
                        continue;

                    // 得到联系人名称
                    String contactName = phoneCursor
                            .getString(PHONES_DISPLAY_NAME_INDEX);

                    // 得到联系人ID
                    Long contactid = phoneCursor
                            .getLong(PHONES_CONTACT_ID_INDEX);

                    // 得到联系人头像ID
                    Long photoid = phoneCursor.getLong(PHONES_PHOTO_ID_INDEX);

                    // 得到联系人头像Bitamp
                    Bitmap contactPhoto = null;

                    // photoid 大于0 表示联系人有头像 如果没有给此人设置头像则给他一个默认的
                    if (photoid > 0) {
                        Uri uri = ContentUris.withAppendedId(
                                ContactsContract.Contacts.CONTENT_URI,
                                contactid);
                        InputStream input = ContactsContract.Contacts
                                .openContactPhotoInputStream(resolver, uri);
                        contactPhoto = BitmapFactory.decodeStream(input);
                    } else {
                        contactPhoto = BitmapFactory.decodeResource(
                                getResources(), R.drawable.yaoming);
                    }
                    ContactEntity mContact = new ContactEntity(contactName,
                            phoneNumber, contactPhoto);
                    mContacts.add(mContact);
                }
                phoneCursor.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initList() {
        ListView lv = (ListView) findViewById(R.id.ListView01);
        lv.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            if (mContacts != null && mContacts.size() > 0) {
                return mContacts.size();
            } else {
                return 0;
            }
        }

        @Override
        public Object getItem(int position) {
            if (mContacts != null && mContacts.size() > 0) {
                return mContacts.get(position);
            } else {
                return null;
            }
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(ListView3Activity.this).inflate(
                        R.layout.item_contact, null);
                holder.name = (TextView) convertView.findViewById(R.id.tv_name);
                holder.number = (TextView) convertView
                        .findViewById(R.id.tv_number);
                holder.photo = (ImageView) convertView
                        .findViewById(R.id.iv_photo);
                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();
            }
            ContactEntity contact = mContacts.get(position);
            holder.name.setText(contact.getName()+"");
            holder.number.setText(contact.getNumber()+"");
            holder.photo.setImageBitmap(contact.getPhoto());
            return convertView;
        }

        class ViewHolder {
            TextView name;
            TextView number;
            ImageView photo;
        }
    }
}