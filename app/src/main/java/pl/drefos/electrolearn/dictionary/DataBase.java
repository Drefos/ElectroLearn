package pl.drefos.electrolearn.dictionary;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import pl.drefos.electorlearn.R;
import pl.drefos.electrolearn.dictionary.DictionaryElement;
import pl.drefos.electrolearn.nullators.NullatorElement;

public class DataBase {
    private List<String> dictionary;
    private Map<String, DictionaryElement> elements;
    private List<String> nullator_list;
    private Map<String, NullatorElement> nullator_map;

    public DataBase() {
        dictionary = new ArrayList<>();
        addDictionary();

        elements = new TreeMap<>();
        addElements();

        nullator_list = new ArrayList<>();
        addNullatorNames();
        nullator_map = new TreeMap<>();
        addNullators();
    }

    public  List<String> getDictionary() {
        return  dictionary;
    }
    public  String getDictionaryId(int pos) {
        return dictionary.get(pos);
    }
    public DictionaryElement getElement(String key) {
        return elements.get(key);
    }

    public List<String> getNullators() { return nullator_list; }
    public String getNullatorId(int id) { return nullator_list.get(id);}
    public NullatorElement getNullator(String key) { return nullator_map.get(key);}

    private void addNullatorNames() {
        nullator_list.add("");
        nullator_list.add("");
        nullator_list.add("Szeregowy RL");
        nullator_list.add("Szeregowy RC");
        nullator_list.add("Równoległy RL");
        nullator_list.add("Równoległy RC");
        nullator_list.add("Szeregowy RLC");
        nullator_list.add("Równoległy RLC");

        Collections.sort(nullator_list);
    }

    private void addNullators() {
        nullator_map.put("Szeregowy RL", new NullatorElement("Szeregowy RL", R.drawable.nuller_serial_rl_1, "W dwójniku szeregowym RL prąd płynący przez rezystor oraz cewkę jest taki sam. Napięcie i prąd na rezystorze są w fazie natomiast napięcie na cewce wyprzedza prąd o kąt 90°.", R.drawable.nuller_serial_rl_2, "Wartość skuteczna napięcia tego dwójnika jest sumą geometryczną spadków napięć na rezystorze i cewce:", R.drawable.nuller_serial_rl_3, "Na podstawie trójkąta napięć możemy wyznaczyć trójkąt impedancji.", R.drawable.nuller_serial_rl_4));
        nullator_map.put("Szeregowy RC", new NullatorElement("Szeregowy RC", R.drawable.nuller_serial_rc_1, "W dwójniku szeregowym RC prąd płynący przez rezystor oraz kondensator jest taki sam. Napięcie i prąd na rezystorze są w fazie natomiast na kondensatorze prąd wyprzedza napięcie o kąt 90°.", R.drawable.nuller_serial_rc_2, "Wartość skuteczna napięcia tego dwójnika jest sumą geometryczną spadków napięć na rezystorze i kondensatorze:", R.drawable.nuller_serial_rc_3, "Na podstawie trójkąta napięć możemy wyznaczyć trójkąt impedancji.", R.drawable.nuller_serial_rc_4));
        nullator_map.put("Szeregowy RLC", new NullatorElement("Szeregowy RLC", R.drawable.nuller_serial_rlc_1, "W dwójniku szeregowym RLC prąd płynący przez rezystor, cewkę oraz kondensator jest taki sam. Na rezystorze prąd i napięcie są w fazie, na cewce napięcie wyprzedza prąd, a na kondensatorze prąd wyprzedza napięcie.", R.drawable.nuller_serial_rlc_2, "Wartość skuteczna napięcia tego dwójnika jest sumą geometryczną spadków napięć na rezystorze i różnicą między napięceim cewki, a napięciem kondensatora:", R.drawable.nuller_serial_rlc_3, "Ponieważ występuje równocześnie spadek napięcia na cewce i kondensatorze o przeciwnych fazach, dlatego możemy rozwarzać dwa przypadki trójkątów napięć i trójkątów impedancji. W pierwszym przypadku (po lewej stronie) spadek napięcia na cewce jest większy niż na kondensatorze, a co za tym idzie reaktancja indukcyjna jest większa niż reaktancja pojemnościowa. Taki przypadek nazywamy obwodem o charakterze indukcyjnym. W drugim przypadku (po prawej stronie) spadek napięcia na cewce jest mniejszy niż na kondensatorze, a co za tym idzie reaktancja indukcyjna jest mniejsza niż reaktancja pojemnościowa. Taki przypadek nazywamy obwodem o charakterze pojemnościowym.", R.drawable.nuller_serial_rlc_4, "W pierwszym przypadku przesunięcie fazowe przyjmuje wartości dodatnie (φ>0), a w drugim przypadku wartości ujemne (φ<0)."));
        nullator_map.put("Równoległy RL", new NullatorElement("Równoległy RL", R.drawable.nuller_parallel_rl_1, "W dwójniku równoległym RL spadki napięć na rezystorze i cewce są takie same. Napięcie i prąd na rezystorze są w fazie, a na cewce napięcie wyprzedza prąd o kąt 90°.", R.drawable.nuller_parallel_rl_2, "Watrość skuteczna prądu tego dwójnika jest sumą geometryczną prądów płynących przez rezystor i cewkę:", R.drawable.nuller_parallel_rl_3, "Na podstawie trójkąta prądów możemy wyznaczyć trójkąt admitancji.", R.drawable.nuller_parallel_rl_4));
        nullator_map.put("Równoległy RC", new NullatorElement("Równoległy RC", R.drawable.nuller_parallel_rc_1, "W dwójniku równoległym RC spadki napięć na rezystorze i kondensatorze są takie same. Napięcie i prąd na rezystorze są w fazie, natomiast na kondensatorze prąd wyprzedza napięcie o kąt 90°", R.drawable.nuller_parallel_rc_2, "Wartość skuteczna prądu tego dwójnika jest sumą geometryczną prądów płynących przez rezystor i kondensator:", R.drawable.nuller_parallel_rc_3, "Na podstawie trójkąta prądów możemy wyznaczyć trójkąt admitancji.", R.drawable.nuller_parallel_rc_4));
        nullator_map.put("Równoległy RLC", new NullatorElement("Równoległy RLC", R.drawable.nuller_parallel_rlc_1, "W dwójniku równoległym RLC spadki napięć na rezystorze, cewce i kondensatorze są takie same. Napięcie i prąd na rezystorze są w fazie, na cewce napięcie wyprzedza prąd, a na kondensatorze prąd wyprzedza napięcie.", R.drawable.nuller_parallel_rlc_2, "Wartość skuteczna prądu tego dwójnika jest sumą geometryczną prądów płynących przez rezystor i różnicą między prądem kondensatora, a prądem cewki:", R.drawable.nuller_parallel_rlc_3, "Ponieważ występują równocześnie prądy na cewce i kondensatorze o przeciwnych fazach, dlatego możemy rozwarzać dwa przypadki trójkątów prądów i trójkątów admitancji. W pierwszysm przypadku (po lewej stronie) prąd na kondensatorze jest większy niż na cewce, a co za tym idzie susceptancja pojemnościowa jest większa niż susceptancja indukcyjna. W drugim przypadku (po prawej stronie) prąd na kondensatorze jest mniejszy niż na cewce, a co za tym idzie susceptancja pojemnościowa jest mniejsza niż susceptancja indukcyjna.", R.drawable.nuller_parallel_rlc_4, "W pierwszym przypadku przesunięcie fazowe przyjmuje wartości ujemne (φ<0), a w drugim przypadku wartości dodatnie (φ>0)."));
    }

    private void addDictionary() {
        dictionary.add("");
        dictionary.add("");
        dictionary.add("Rezystancja");
        dictionary.add("Napięcie elektryczne");
        dictionary.add("Natężenie prądu");
        dictionary.add("Pojemność elektryczna");
        dictionary.add("Indukcyjność");
        dictionary.add("Konduktancja");
        dictionary.add("Gęstość prądu");
        dictionary.add("Reaktancja");
        dictionary.add("Susceptancja");
        dictionary.add("Impedancja");
        dictionary.add("Admitancja");
        dictionary.add("Prąd stały - DC");
        dictionary.add("Prąd przemienny - AC");
        dictionary.add("Moc w obwodach DC");
        dictionary.add("Moc w obwodach AC");
        dictionary.add("Wartość skuteczna");
        dictionary.add("Przesunięcie fazowe");
        dictionary.add("Zasada \"CiuL\"");
        dictionary.add("Dwójnik");

        Collections.sort(dictionary);
    }

    private void addElements() {
        elements.put("Rezystancja", new DictionaryElement("Rezystancja", "Rezystancja (opór elektryczny) to wielkość charakteryzująca stosunek napięcia U[V] do natężenia prądu elektrycznego I[A] w obwodach prądu stałego. Rezystancję oznaczamy wielką literą R. Jednostką rezystancji jest ohm [Ω]", R.drawable.rezystancja,
                "R – rezystancja [Ω - ohm]\n" +
                "U – napięcie [V – volt]\n" +
                "I – natężenie prądu [A – amper]"));

        elements.put("Napięcie elektryczne", new DictionaryElement("Napięcie elektryczne", "Napięcie elektryczne to różnica potencjałów elektrycznych między dwoma punktami. Można powiedzieć, że jest to siła sprawiająca, że elektrony zaczynają się przemieszczać i przepływa prąd.", R.drawable.napiecie,
                "U - napięcie [V - volt]\n" +
                "I - natężenie [A - amper]\n" +
                "R - rezystancja [Ω - ohm]"));

        elements.put("Prąd stały - DC", new DictionaryElement("Prąd stały - DC", "Prąd stały (oznaczany skrótowo DC) charakteryzuje się stałym zwrotem oraz kierunkiem przepływu ładunków elektrycznych. Wartość prądu nie zmienia się w czasie, jest stała - stąd pochodzi jego nazwa.", R.drawable.prad_staly));

        elements.put("Prąd przemienny - AC", new DictionaryElement("Prąd przemienny - AC", "Prąd przemienny to charakterystyczny przypadek prądu elektrycznego okresowo zmiennego, w którym wartości chwilowe podlegają zmianom w powtarzalny, okresowy sposób, z określoną częstotliwością. Wartości chwilowe natężenia prądu przemiennego przyjmują naprzemiennie wartości dodatnie i ujemne (stąd nazwa przemienny).", R.drawable.prad_przemienny));

        elements.put("Natężenie prądu", new DictionaryElement("Natężenie prądu", "Natężenie prądu to ładunek elektryczny przepływający przez poprzeczny przekrój przewodnika w określonym czasie. Możemy przyrównać to do ilości wody przepływającej przez rurę.", R.drawable.natezenie,
                "Q – ładunek elektryczny [C – kulomb]\n" +
                "I – natężenie prądu [A – amper]\n" +
                "t – czas przepływu prądu [s – sekunda]\n"));

        elements.put("Impedancja", new DictionaryElement("Impedancja", "Impedancja to wielkość charakteryzująca zależność między natężeniem prądu i napięciem w obwodach prądu zmiennego.\nImpedancja jest uogólnieniem oporu elektrycznego, charakteryzującego tę zależność w obwodach prądu stałego. Impedancja jest wielkością zespoloną. Część rzeczywista impedancji opisuje opór związany z prądem płynącym w fazie zgodnej z przyłożonym napięciem, część urojona – z prądem przesuniętym w fazie, który wyprzedza przyłożone napięcie lub jest opóźniony względem niego.", R.drawable.impedancja,
                "Z - impedancja [Ω]\n" +
                "R – rezystancja [Ω]\n" +
                "X - reaktancja [Ω]", R.drawable.impedancja_trojkat));

        elements.put("Admitancja", new DictionaryElement("Admitancja", "Admitancja to odwrotność impedancji, całkowita przewodność elektryczna w obwodach prądu przemiennego. Admitancja jest liczbą zespoloną, jej część rzeczywista to konduktancja (G), a urojona to susceptancja (B):", R.drawable.admitancja, R.drawable.admitancja2));

        elements.put("Gęstość prądu", new DictionaryElement("Gęstość prądu", "Gęstość prądu określa ilość nośników ładunku przemieszczającego się w jednym kierunku przez pole przekroju poprzecznego. Czyli jest to zagęszczenie nośników ładunku na jednostkę powierzchni.", R.drawable.gestosc_pradu,
                "J – gęstość prądu [A/m^2  – amper na metr kwadratowy]\n" +
                "I – natężenie prądu [A – amper]\n" +
                "S – pole powierzchni przekroju poprzecznego [m² - metr kwadratowy]"));

        elements.put("Reaktancja", new DictionaryElement("Reaktancja", "Reaktancja (opór bierny) to wielkość charakteryzująca obwód elektryczny zawierający element o charakterze pojemnościowym (np. kondensator) lub element o charakterze indukcyjnym (np. cewkę). Jednostką reaktancji jest ohm [Ω]. Jest częścią urojoną impedancji.", R.drawable.reaktancja, R.drawable.reaktancja2, R.drawable.reaktancja3,
                "ꙍ=2πf - pulsacja/prędkość kątowa [rad/s]\n" +
                "L - indukcyjność [H - henr]\n" +
                "C - pojemność elektryczna [F - farad]"));

        elements.put("Indukcyjność", new DictionaryElement("Indukcyjność", "Indukcyjność określa zdolność obwodu do wytwarzania strumienia pola magnetycznego Φ powstającego w wyniku przepływu przez obwód prądu elektrycznego I. Oznaczana jest symbolem L.", R.drawable.indukcyjnosc,
                "Φ - strumień indukcji magnetycznej\n" +
                "L - indukcyjność [H - henr, H = Ω * s]\n" +
                "I - natężenie prądu [A - amper]"));

        elements.put("Konduktancja", new DictionaryElement("Konduktancja", "Konduktancja (przewodność elektryczna) jest odwrotnością rezystancji. Jest więc miarą podatności elementu na przepływ prądu elektrycznego. Jednostką konduktancji jest Simens [S]", R.drawable.konduktancja));

        elements.put("Pojemność elektryczna", new DictionaryElement("Pojemność elektryczna", "Jeżeli dowolny izolowany przedmiot metalowy (przewodnik) naładujemy ładunkiem Q to ten przewodnik uzyska pewien potencjał elektryczny U. O tym jak duży będzie to potencjał przy ustalonym ładunku Q decyduje  pojemność elektryczna C przewodnika.", R.drawable.pojemnosc_elektryczna,
                "C - pojemność elektryczna [F - farad]\n" +
                "Q - ładunek elektryczny [C - kulomb]\n" +
                "U - napięcie [V - volt]"));

        elements.put("Susceptancja", new DictionaryElement("Susceptancja", "Susceptancja to część urojona admitancji, czyli przewodność bierna. Susceptancja jest odwrotnością reaktancji.", R.drawable.susceptancja, R.drawable.admitancja2,
                "B - susceptancja [S - simens]\n" +
                "X - reaktancja [Ω - ohm]\n" +
                "Y - admitancja [S]\n" +
                "G - konduktancja [S]"));

        elements.put("Moc w obwodach DC", new DictionaryElement("Moc w obwodach DC", "Moc elektryczna to praca jaką wykonuje energia elektryczna w jednostce czasu. Wykorzystując prawo Ohma (U=I*R) wzór na moc elektryczną można przedstawić również jako:", R.drawable.moc_dc, R.drawable.moc_dc2,
                "P - moc elektryczna [W - wat]\n" +
                "U - napięcie [V - volt]\n" +
                "I - natężenie [A - amper]\n" +
                "R - rezystancja [Ω - ohm]"));

        elements.put("Moc w obwodach AC", new DictionaryElement("Moc w obwodach AC", "W obwodach prądu przemiennego elementy zdolne do gromadzenia energii takie jak induktancja i pojemność powodują, że kierunek przepływu energii jest zmienny. Część energii jaka zostaje zamieniona w ciepło lub pracę określa się mianem mocy czynnej P. Jednakże, rozpatrując jeden przebieg okresu zmiennego prądu elektrycznego, układ pobiera ze źródła więcej energii, którą następnie ponownie do źródła oddaje. Tę część określa się jako moc bierna Q. Jeśli przedstawiamy wielkości mocy czynnej i biernej jako wartości wektorowe względem siebie prostopadłe na płaszczyźnie zespolonej, to ich sumę wektorową nazywamy mocą pozorną S", R.drawable.moc_ac, R.drawable.moc_ac2,
                "P=U*I*cosφ\n" +
                "Q=U*I*sinφ\n" +
                "S=U*I",
                "P - moc czynna [W - wat]\n" +
                "Q - moc bierna [var]\n" +
                "S - moc pozorna [V*A - volt*amper]\n" +
                "U - napięcie skuteczne [V]\n" +
                "I - natężenie skuteczne [A]\n" +
                "φ - przesunięcie fazowe"));

        elements.put("Wartość skuteczna", new DictionaryElement("Wartość skuteczna", "Wartością skuteczną prądu sinusoidalnego o okresie T nazywamy taką wartość prądu stałego, który przepływając przez rezystancję R w czasie jednego okresu T powoduje wydzielenie takiej ilości energii cieplnej, jak prąd sinusoidalny w tym czasie. Powyżej znajdują się wzory na prąd oraz napięcie skuteczne, gdzie Im, Um to odpowiednio amplituda prądu oraz napięcia.", R.drawable.wartosc_skuteczna));

        elements.put("Przesunięcie fazowe", new DictionaryElement("Przesunięcie fazowe", R.drawable.fazy, "Kąt przesunięcia fazowego to różnica faz początkowych prądu i napięcia oznaczane literą φ. Rysunek poniżej przedstawia sinusoidę napięciową i prądową mające te same miejsca zerowe, wektory wodzące napięcia i prądu pokrywają się. W takim przypadku mówimy, że prąd i napięcie są w fazie.", R.drawable.fazy1, "Gdy wektor wodzący napięcia porusza się przed wektorem wodzącym prądu mówimy, że napięcie wyprzedza prąd.", R.drawable.fazy2, "A w przypadku gdy wektor wodzący prądu porusza się przed wektorem wodzącym napięcia mówimy, że prąd wyprzedza napięcie.", R.drawable.fazy3));

        elements.put("Zasada \"CiuL\"", new DictionaryElement("Zasada \"CiuL\"", "Jest to łatwy sposób na zapamiętanie przesunięć fazowych dla cewek i kondensatorów. Patrząc od lewej na kondensatorze (C) prąd (\"i\") wyprzedza napięcie (\"u\"). A patrząc od prawej na cewce (L) to napięcie (\"u\") wyprzedza prąd (\"i\").", R.drawable.ciul));

        elements.put("Dwójnik", new DictionaryElement("Dwójnik", "Dwójnik to element (lub układ) elektroniczny, który posiada dwa zaciski (końcówki), które przy pełnym włączeniu elementu do obwodu staną się dwoma węzłami."));
    }


}


