package pl.drefos.electrolearn;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pl.drefos.electorlearn.R;
import pl.drefos.electrolearn.dictionary.DataBase;
import pl.drefos.electrolearn.dictionary.DictionaryElement;
import pl.drefos.electrolearn.dictionary.DictionaryElementFragment;
import pl.drefos.electrolearn.navmenu.AboutAppFragment;
import pl.drefos.electrolearn.navmenu.DictionaryListFragment;
import pl.drefos.electrolearn.navmenu.FirstPageFragment;
import pl.drefos.electrolearn.navmenu.Kirchhoff_1;
import pl.drefos.electrolearn.navmenu.Kirchhoff_2;
import pl.drefos.electrolearn.navmenu.NullatorListFragment;
import pl.drefos.electrolearn.navmenu.ParallelResistorsFragment;
import pl.drefos.electrolearn.navmenu.PerfectCapacitorFragment;
import pl.drefos.electrolearn.navmenu.PerfectCoilFragment;
import pl.drefos.electrolearn.navmenu.PerfectResistorFragment;
import pl.drefos.electrolearn.navmenu.SEMFragment;
import pl.drefos.electrolearn.navmenu.SerialResistorsFragment;
import pl.drefos.electrolearn.nullators.NullatorElement;
import pl.drefos.electrolearn.nullators.NullatorElementFragment;

public class MainActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener,
        DictionaryListFragment.OnItemClicked,
        DictionaryElementFragment.LoadDictionaryElement,
        NullatorListFragment.OnNullerClick,
        NullatorElementFragment.LoadNullatorElement,
        AboutAppFragment.LoadFab {

    private static final String FIRST_START = "first_start";
    private List<String> views; // list to save titles of views
    public static DataBase dataBase;
    public static int dictionaryItemId = -1; // actual choose dictionary entry
    public static int nullerId = -1; // actual choose nuller
    private int main=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBase = new DataBase();

        //Create toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        views = new ArrayList<>();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        checkIfFirstStart();

        // load main page
        selectedHome();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(main==0) {
                System.exit(0);
            }
            else if(views.size()== 1) {

                super.onBackPressed();
            }
            else if(views.size()== 2) {
                views.clear();
                main=0;
                FirstPageFragment firstPage = new FirstPageFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.conteiner, firstPage, "main").commit();
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                toolbar.setTitle(R.string.app_name);
                views.add(getSupportActionBar().getTitle().toString());
            }
            else if(views.size()>1) {
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                views.remove(views.size()-1);
                toolbar.setTitle(views.get(views.size()-1));
                super.onBackPressed();
            } else {
                System.exit(0);
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            selectedHome();
        } else if (id == R.id.nav_dictionary) {
            selectedDictionary();
        } else if (id == R.id.nav_nullator) {
            selectedNullator();
        } else if (id == R.id.nav_serial_connections_resistors) {
            selectedSerialResistors();
        } else if (id == R.id.nav_parallel_connections_resistors) {
            selectedParallelResisitors();
        } else if (id == R.id.nav_Kirchhoff_1) {
            selectedKirchhoff1();
        } else if (id == R.id.nav_Kirchhoff_2) {
            selectedKirchhoff2();
        } else if (id == R.id.nav_SEM){
            selectedSEM();
        } else if (id == R.id.nav_perfect_resistor) {
            selectedPerfectResistor();
        } else if (id == R.id.nav_perfect_coil) {
            selectedPerfectCoil();
        } else if (id == R.id.nav_perfect_capacitor) {
            selectedPerfectCapacitor();
        } else if (id == R.id.nav_about_app) {
            selectedAbout();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    // create dictionary entry view
    @Override
    public void click(){
            String key = dataBase.getDictionaryId(dictionaryItemId);
            DictionaryElement element = dataBase.getElement(key);

            DictionaryElementFragment fragment = new DictionaryElementFragment();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.addToBackStack(null);
            transaction.replace(R.id.conteiner, fragment).commit();
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            toolbar.setTitle(element.getName());
            views.add(getSupportActionBar().getTitle().toString());
    }


    // load dictionary entry
    @Override
    public void load() {
        String key = dataBase.getDictionaryId(dictionaryItemId);
        DictionaryElement element = dataBase.getElement(key);


        if(element.getImage()!=0) {
            ImageView image = (ImageView) findViewById(R.id.image_id);
            image.setImageResource(element.getImage());
        }
        if(element.getDescription()!=null) {
            TextView description = (TextView) findViewById(R.id.desc);
            description.setText(element.getDescription());
        }
        if(element.getImage2()!=0) {
            ImageView image2 = (ImageView) findViewById(R.id.image_id2);
            image2.setImageResource(element.getImage2());
        }
        if(element.getDescription2()!=null) {
            TextView description2 = (TextView) findViewById(R.id.desc2);
            description2.setText(element.getDescription2());
        }
        if(element.getImage3()!=0) {
            ImageView image3 = (ImageView) findViewById(R.id.image_id3);
            image3.setImageResource(element.getImage3());
        }
        if(element.getDescription3()!=null) {
            TextView description3 = (TextView) findViewById(R.id.desc3);
            description3.setText(element.getDescription3());
        }
        if(element.getImage4()!=0) {
            ImageView image4 = (ImageView) findViewById(R.id.image_id4);
            image4.setImageResource(element.getImage4());
        }
    }

    // create nuller view
    @Override
    public void nullClick() {
        String key = dataBase.getNullatorId(nullerId);
        NullatorElement element = dataBase.getNullator(key);

        NullatorElementFragment fragment = new NullatorElementFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, fragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(element.getName());
        views.add(getSupportActionBar().getTitle().toString());
    }

    // load choose nuller view
    @Override
    public void loadNullers() {
        String key = dataBase.getNullatorId(nullerId);
        NullatorElement element = dataBase.getNullator(key);

        if(element.getImg1()!=0) {
            ImageView image = (ImageView) findViewById(R.id.nullator_img_1);
            image.setImageResource(element.getImg1());
        }
        if(element.getDesc1()!=null) {
            TextView text = (TextView) findViewById(R.id.nullator_desc_1);
            text.setText(element.getDesc1());
        }
        if(element.getImg2()!=0) {
            ImageView image = (ImageView) findViewById(R.id.nullator_img_2);
            image.setImageResource(element.getImg2());
        }
        if(element.getDesc2()!=null) {
            TextView text = (TextView) findViewById(R.id.nullator_desc_2);
            text.setText(element.getDesc2());
        }
        if(element.getImg3()!=0) {
            ImageView image = (ImageView) findViewById(R.id.nullator_img_3);
            image.setImageResource(element.getImg3());
        }
        if(element.getDesc3()!=null) {
            TextView text = (TextView) findViewById(R.id.nullator_desc_3);
            text.setText(element.getDesc3());
        }
        if(element.getImg4()!=0) {
            ImageView image = (ImageView) findViewById(R.id.nullator_img_4);
            image.setImageResource(element.getImg4());
        }
    }

    // speed menu
    public void dcButton(View v) {
        DCFragment fragment = new DCFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack("main");
        transaction.replace(R.id.conteiner, fragment).commit();
        main=1;
    }

    // speed menu
    public void acButton(View v) {
        ACFragment fragment = new ACFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack("main");
        transaction.replace(R.id.conteiner, fragment).commit();
        main=1;
    }

    // set first page view
    private void selectedHome() {
        views.clear();
        FirstPageFragment firstPage = new FirstPageFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, firstPage, "main").commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        views.add(getSupportActionBar().getTitle().toString());
        main=0;
    }

    public void dictionaryButton(View v) {
        DictionaryListFragment dictionaryListFragment = new DictionaryListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, dictionaryListFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.dictionary);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set dictionary view
    private void selectedDictionary() {
        DictionaryListFragment dictionaryListFragment = new DictionaryListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, dictionaryListFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.dictionary);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }


    public void serialResistorsButton(View v) {
        SerialResistorsFragment serialResistorsFragment = new SerialResistorsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, serialResistorsFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.serial_connections_resistors);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set serial resistors connection view
    private void selectedSerialResistors() {
        SerialResistorsFragment serialResistorsFragment = new SerialResistorsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, serialResistorsFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.serial_connections_resistors);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }


    public void parallelResistorsButton(View v) {
        ParallelResistorsFragment parallelResistorsFragment = new ParallelResistorsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, parallelResistorsFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.parallel_connections_resistors);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set parallel resistors connection view
    private void selectedParallelResisitors() {
        ParallelResistorsFragment parallelResistorsFragment = new ParallelResistorsFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, parallelResistorsFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.parallel_connections_resistors);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    public void kirchhoff1Button(View v) {
        Kirchhoff_1 kirchhoff_1 = new Kirchhoff_1();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, kirchhoff_1).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.kirchhoff_1);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set kirchhoff 1 view
    private void selectedKirchhoff1() {
        Kirchhoff_1 kirchhoff_1 = new Kirchhoff_1();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, kirchhoff_1).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.kirchhoff_1);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    public void kirchhoff2Button(View v) {
        Kirchhoff_2 kirchhoff_2 = new Kirchhoff_2();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, kirchhoff_2).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.kirchhoff_2);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set kirchhoff 2 view
    private void selectedKirchhoff2() {
        Kirchhoff_2 kirchhoff_2 = new Kirchhoff_2();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, kirchhoff_2).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.kirchhoff_2);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    public void semButton(View v) {
        SEMFragment semFragment = new SEMFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, semFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.SEM);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set SEM view
    private void selectedSEM() {
        SEMFragment semFragment = new SEMFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, semFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.SEM);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    public void perfectResistorButton(View v) {
        PerfectResistorFragment perfectResistorFragment = new PerfectResistorFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, perfectResistorFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.perfect_resistor);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set perfect resistor view
    private void selectedPerfectResistor() {
        PerfectResistorFragment perfectResistorFragment = new PerfectResistorFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, perfectResistorFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.perfect_resistor);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    public void perfectCoilButton(View v) {
        PerfectCoilFragment perfectCoilFragment = new PerfectCoilFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, perfectCoilFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.perfect_coil);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set perfect coil view
    private void selectedPerfectCoil() {
        PerfectCoilFragment perfectCoilFragment = new PerfectCoilFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, perfectCoilFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.perfect_coil);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    public void perfectCapacitorButton(View v) {
        PerfectCapacitorFragment perfectCapacitorFragment = new PerfectCapacitorFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, perfectCapacitorFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.perfect_capacitor);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set perfect capacitor view
    private void selectedPerfectCapacitor() {
        PerfectCapacitorFragment perfectCapacitorFragment = new PerfectCapacitorFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, perfectCapacitorFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.perfect_capacitor);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    public void nullatorButton(View v) {
        NullatorListFragment nullatorFragment = new NullatorListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.conteiner, nullatorFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.nullator);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set nullator view
    private void selectedNullator() {
        NullatorListFragment nullatorFragment = new NullatorListFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, nullatorFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.nullator);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // set about view
    private void selectedAbout() {
        AboutAppFragment aboutAppFragment = new AboutAppFragment();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.conteiner, aboutAppFragment).commit();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.about_app);
        views.add(getSupportActionBar().getTitle().toString());
        main=1;
    }

    // if it is the first start, show "hello" message
    private void checkIfFirstStart() {
        SharedPreferences sharedPreferences = getSharedPreferences(FIRST_START, MODE_PRIVATE);
        boolean first = sharedPreferences.getBoolean(FIRST_START, true);
        if(first) {
            SharedPreferences.Editor edytor = sharedPreferences.edit();
            edytor.putBoolean(FIRST_START, false).commit();
            FirstStartDialogFragment firstStartDialogFragment = new FirstStartDialogFragment();
            firstStartDialogFragment.show(getFragmentManager(), null);
        }
    }

    // send mail to me on fab click
    @Override
    public void loadFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","DrefosApps@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "ElectroLearn");
                startActivity(Intent.createChooser(emailIntent, "Send email"));
            }
        });
    }

}
