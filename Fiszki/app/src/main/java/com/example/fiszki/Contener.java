package com.example.fiszki;

import android.content.SharedPreferences;

import java.util.ArrayList;

public class Contener {

    private int jezyk=0;
    private int przycisk=0;

    public int getJezyk() {
        return jezyk;
    }

    public int getPrzycisk() {
        return przycisk;
    }

    public void setJezyk(int jezyk) {
        this.jezyk = jezyk;
    }

    public void setPrzycisk(int przycisk) {
        this.przycisk = przycisk;
    }

    public String[] zwrocTablicePL(){
        if(przycisk==1)return new String[]{"Ja jestem", "Ty jesteś", "On jest", "Ona jest", "Ono jest", "My jesteśmy", "Wy jesteście", "Oni/One są"};
        else if(przycisk==2) return new String[]{"0 (zero)","1 (jeden)", "2 (dwa)", "3 (trzy)", "4 (cztery)", "5 (pięć)", "6 (sześć)", "7 (siedem)", "8 (osiem)","9 (dziewięć)","10 (dziesięć)"};
        else if(przycisk==3) return new String[] {"Pies","Kot", "Ptak", "Koń", "Krowa", "Ryba","Owca","Lis"};
        else if(przycisk==4) return new String[]  {"Chleb","Masło", "Woda", "Mleko", "Ser", "Lody","Owoce","Warzywa","Sól","Cukier"};
        else if(przycisk==5) return new String[]  {"Głowa","Oko", "Ucho", "Nos", "Usta", "Szyja","Ręka","Palec","Noga","Brzuch","Plecy","Stopa"};
        else if(przycisk==6) return new String[]  {"Piłka nożna","Jazda na rowerze", "Siatkówka", "Koszykówka", "Bieganie", "Skakanie"};
        else return null;
    }
    public String[]zwrocTabliceJezyk(){
        if(jezyk==1){
            if(przycisk==1)return new String[]{"I am", "You are", "He is", "She is", "It is", "We are", "You are", "They are"};
            else if(przycisk==2) return new String[]{"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight","Nine","Ten"};
            else if(przycisk==3) return new String[] {"Dog","Cat", "Bird", "Horse", "Cow", "Fish", "Sheep","Fox"};
            else if(przycisk==4) return new String[]  {"Bread","Butter", "Water", "Milk", "Chees", "Ice cream", "Fruits","Vegetables","Salt","Sugar"};
            else if(przycisk==5) return new String[]  {"Head","Eye", "Ear", "Nose", "Mouth", "Neck", "Hand","Finger","Leg","Stomach","Back","Foot"};
            else if(przycisk==6) return new String[]  {"Football","Cycling", "Volleyball", "Basketball", "Running", "Jumping"};
        }
        else if(jezyk==2){
            if(przycisk==1)return new String[]{"Ich bin", "Du bist", "Er ist", "Sie ist", "Es ist", "Wir sind", "Ihr seid", "Sie sind"};
            else if(przycisk==2) return new String[]{"Null","Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs", "Sieben", "Acht","Neun","Zehn"};
            else if(przycisk==3) return new String[] {"Hund","Katze", "Vogel", "Pferd", "Kuh", "Fisch", "Schaf","Fuchs"};
            else if(przycisk==4) return new String[]  {"Brot","Butter", "Wasser", "Milch", "Käse", "Eiscreme", "Früchte","Gemüse","Salz","Zucker"};
            else if(przycisk==5) return new String[]  {"Kopf","Auge", "Ohr", "Nase", "Mund", "Hals", "Hand","Finger","Bein","Bauch","Rücken","Fuß"};
            else if(przycisk==6) return new String[]  {"Fußball","Radfahren", "Volleyball", "Basketball", "Laufen", "Springen"};
        }
        else if(jezyk==3){
            if(przycisk==1)return new String[]{"Yo soy", "Tú eres", "El es", "Ella es", "Usted es", "Nosotros somos", "Vosotros sois", "Ellos/ellas son"};
            else if(przycisk==2) return new String[]{"Cero","Uno/una", "Dos", "Tres", "Cuatro", "Cinco", "Seis", "Siete", "Ocho","Nueve","Diez"};
            else if(przycisk==3) return new String[] {"Perro","Gato", "Pájaro", "Caballo", "Vaca", "Pez", "Oveja","Zorro"};
            else if(przycisk==4) return new String[]  {"Pan de molde","Mantequilla", "Agua", "Leche", "Queso", "Helado", "Frutas","Vegetales","Sal","Azúcar"};
            else if(przycisk==5) return new String[]  {"Cabeza","Ojo", "Oreja", "Nariz", "Boca", "Cuello", "Mano","Dedo","Pierna","Estómago","Espalda","Pie"};
            else if(przycisk==6) return new String[]  {"Fútbol americano","Ciclismo", "Vóleibol", "Baloncesto", "Corriendo", "Saltar"};
        }
        return null;
    }

    public ArrayList<Integer> zwrocIloscArray(){
        ArrayList<Integer> array=new ArrayList<Integer>();
        array.add(0);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        if(przycisk==1||przycisk==3){
            array.add(6);
            array.add(7);

        }
        else if(przycisk==2) {
            array.add(6);
            array.add(7);
            array.add(8);
            array.add(9);
            array.add(10);

        }

        else if(przycisk==4){
            array.add(6);
            array.add(7);
            array.add(8);
            array.add(9);

        }
        else if(przycisk==5){
            array.add(6);
            array.add(7);
            array.add(8);
            array.add(9);
            array.add(10);
            array.add(11);
        }
        return array;
    }

}
