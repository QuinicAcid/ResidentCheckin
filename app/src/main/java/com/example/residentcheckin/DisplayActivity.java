package com.example.residentcheckin;

public class DisplayActivity extends Resident
{

    private ArrayList<String> arraylist=new ArrayList<String>();
    private SQLiteDatabase MYdatabase;
    ListView listView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        listView=(ListView)findViewById(R.id.listView1);

        DatabaseHelper db=new DatabaseHelper(this);
        MYdatabase=db.getWritableDatabase();
        try {
            Cursor c=MYdatabase.rawQuery("SELECt * FROM Student", null);
            if(c!=null)
            {
                if(c.moveToFirst())
                {
                    do {
                        String name=c.getString(c.getColumnIndex("NAME"));
                        String age=c.getString(c.getColumnIndex("AGE"));
                        String address=c.getString(c.getColumnIndex("ADDRESS"));
                        arraylist.add("Name :"+name+"\n"+"Age :"+age+"\n"+"Address :"+address+"\n");

                    } while (c.moveToNext());
                }
            }

            c.close();
            c.deactivate();

        } catch (SQLiteException e) {

            Log.d(getClass().getSimpleName(), "could not create"+"or open the database");

        }
        finally
        {
            if(MYdatabase!=null)
            {
                MYdatabase.close();
            }
        }
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arraylist));
    }
    public void Back(View v)
    {
        Intent back=new Intent(DisplayActivity.this,DbExampleActivity.class);
        startActivity(back);
    }
}