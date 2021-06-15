package sample;

import java.util.Locale;
import java.lang.String;

public class calcoloCodiceFiscale {

    public static void main(String[] args) {
        String codice_fiscale=CF_automatico("Lucrezia", "Vetro", "A089", "2000-03-05","F");
        System.out.println("Il codice fiscale è: "+ codice_fiscale);
    }

    public static String vocali (String nome) {
        String vocali=new String();
        int l=nome.length();
        for (int i=0; i<l; i++) {
            Character temp=nome.charAt(i);
            if (temp=='A'  || temp=='a' || temp=='E'  || temp=='e' ||temp=='I'  || temp=='i' ||temp=='O'  || temp=='o' ||temp=='U'  || temp=='u') {
                vocali = vocali + temp;
            }
        }
        return vocali;
    }

    public static String consonanti (String nome) {
        String consonanti=new String();
        int l=nome.length();
        for (int i=0; i<l; i++) {
            Character temp=nome.charAt(i);
            if (!(temp=='A'  || temp=='a' || temp=='E'  || temp=='e' ||temp=='I'  || temp=='i' ||temp=='O'  || temp=='o' ||temp=='U'  || temp=='u')) {
                consonanti = consonanti + temp;
            }
        }
        return consonanti;
    }

    public static String controllo (String CF1) {
        String pari=new String();
        String dispari=new String();
        String lettera=new String();
        int l=CF1.length();
        for (int i=0; i<l; i++) {
            if ((i+1)%2==0)
                pari=pari+CF1.charAt(i);
            else
                dispari=dispari+CF1.charAt(i);
        }
        int di=dispari.length();
        int somma_dispari=0;
        for (int i=0; i<di; i++) {
            char temp=dispari.charAt(i);
            if (temp=='0' || temp=='A')
                somma_dispari=somma_dispari+1;
            else if (temp=='1' || temp=='B')
                somma_dispari=somma_dispari+0;
            else if (temp=='2' || temp=='C')
                somma_dispari=somma_dispari+5;
            else if (temp=='3' || temp=='D')
                somma_dispari=somma_dispari+7;
            else if (temp=='4' || temp=='E')
                somma_dispari=somma_dispari+9;
            else if (temp=='5' || temp=='F')
                somma_dispari=somma_dispari+13;
            else if (temp=='6' || temp=='G')
                somma_dispari=somma_dispari+15;
            else if (temp=='7' || temp=='H')
                somma_dispari=somma_dispari+17;
            else if (temp=='8' || temp=='I')
                somma_dispari=somma_dispari+19;
            else if (temp=='9' || temp=='J')
                somma_dispari=somma_dispari+21;
            else if (temp=='K')
                somma_dispari=somma_dispari+2;
            else if (temp=='L')
                somma_dispari=somma_dispari+4;
            else if (temp=='M')
                somma_dispari=somma_dispari+18;
            else if (temp=='N')
                somma_dispari=somma_dispari+20;
            else if (temp=='O')
                somma_dispari=somma_dispari+11;
            else if (temp=='P')
                somma_dispari=somma_dispari+3;
            else if (temp=='Q')
                somma_dispari=somma_dispari+6;
            else if (temp=='R')
                somma_dispari=somma_dispari+8;
            else if (temp=='S')
                somma_dispari=somma_dispari+12;
            else if (temp=='T')
                somma_dispari=somma_dispari+14;
            else if (temp=='U')
                somma_dispari=somma_dispari+16;
            else if (temp=='V')
                somma_dispari=somma_dispari+10;
            else if (temp=='W')
                somma_dispari=somma_dispari+22;
            else if (temp=='X')
                somma_dispari=somma_dispari+25;
            else if (temp=='Y')
                somma_dispari=somma_dispari+24;
            else
                somma_dispari=somma_dispari+23;
        }
        // cifre pari
        int pa=pari.length();
        int somma_pari=0;
        for (int i=0; i<pa; i++) {
            char temp=pari.charAt(i);
            if (temp=='0' || temp=='A')
                somma_pari=somma_pari+0;
            else if (temp=='1' || temp=='B')
                somma_pari=somma_pari+1;
            else if (temp=='2' || temp=='C')
                somma_pari=somma_pari+2;
            else if (temp=='3' || temp=='D')
                somma_pari=somma_pari+3;
            else if (temp=='4' || temp=='E')
                somma_pari=somma_pari+4;
            else if (temp=='5' || temp=='F')
                somma_pari=somma_pari+5;
            else if (temp=='6' || temp=='G')
                somma_pari=somma_pari+6;
            else if (temp=='7' || temp=='H')
                somma_pari=somma_pari+7;
            else if (temp=='8' || temp=='I')
                somma_pari=somma_pari+8;
            else if (temp=='9' || temp=='J')
                somma_pari=somma_pari+9;
            else if (temp=='K')
                somma_pari=somma_pari+10;
            else if (temp=='L')
                somma_pari=somma_pari+11;
            else if (temp=='M')
                somma_pari=somma_pari+12;
            else if (temp=='N')
                somma_pari=somma_pari+13;
            else if (temp=='O')
                somma_pari=somma_pari+14;
            else if (temp=='P')
                somma_pari=somma_pari+15;
            else if (temp=='Q')
                somma_pari=somma_pari+16;
            else if (temp=='R')
                somma_pari=somma_pari+17;
            else if (temp=='S')
                somma_pari=somma_pari+18;
            else if (temp=='T')
                somma_pari=somma_pari+19;
            else if (temp=='U')
                somma_pari=somma_pari+20;
            else if (temp=='V')
                somma_pari=somma_pari+21;
            else if (temp=='W')
                somma_pari=somma_pari+22;
            else if (temp=='X')
                somma_pari=somma_pari+23;
            else if (temp=='Y')
                somma_pari=somma_pari+24;
            else
                somma_pari=somma_pari+25;
        }
        int somma=somma_dispari+somma_pari;
        int resto=somma%26;
        if (resto==0)
            lettera="A";
        else if (resto==1)
            lettera="B";
        else if (resto==2)
            lettera="C";
        else if (resto==3)
            lettera="D";
        else if (resto==4)
            lettera="E";
        else if (resto==5)
            lettera="F";
        else if (resto==6)
            lettera="G";
        else if (resto==7)
            lettera="H";
        else if (resto==8)
            lettera="I";
        else if (resto==9)
            lettera="J";
        else if (resto==10)
            lettera="K";
        else if (resto==11)
            lettera="L";
        else if (resto==12)
            lettera="M";
        else if (resto==13)
            lettera="N";
        else if (resto==14)
            lettera="O";
        else if (resto==15)
            lettera="P";
        else if (resto==16)
            lettera="Q";
        else if (resto==17)
            lettera="R";
        else if (resto==18)
            lettera="S";
        else if (resto==19)
            lettera="T";
        else if (resto==20)
            lettera="U";
        else if (resto==21)
            lettera="V";
        else if (resto==22)
            lettera="W";
        else if (resto==23)
            lettera="X";
        else if (resto==24)
            lettera="Y";
        else if (resto==25)
            lettera="Z";
        return lettera;
    }


    public static String CF_automatico(String nome, String cognome, String catasto, String dataN, String sesso) {

        String CF=new String();
        System.out.println("Consonanti di "+ nome + ": " + consonanti(nome));
        System.out.println("Consonanti di "+ cognome + ": " + consonanti(cognome));
        String nome_cons=consonanti(nome);
        String cognome_cons=consonanti(cognome);
        String nome_voc=vocali(nome);
        String cognome_voc=vocali(cognome);
        int l_nome=nome_cons.length();
        int l_cognome=cognome_cons.length();
        // prime lettere cognome
        if (l_cognome>=3) {
            CF=CF + cognome_cons.charAt(0) + cognome_cons.charAt(1) + cognome_cons.charAt(2);
        }
        else if (l_cognome==2 || cognome_voc.length()>=2) {
            CF=CF + cognome_cons.charAt(0) + cognome_cons.charAt(2) + cognome_voc.charAt(0);
        }
        else if (l_cognome==1 || cognome_voc.length()>=2) {
            CF=CF + cognome_cons.charAt(0) + cognome_voc.charAt(0) + cognome_voc.charAt(1);
        }
        else if (l_cognome==1 || cognome_voc.length()==1) {
            CF=CF + cognome_cons.charAt(0) + cognome_voc.charAt(0) + 'X';
        }

        //prime lettere nome
        if (l_nome>=4) {
            CF=CF + nome_cons.charAt(0) + nome_cons.charAt(2) + nome_cons.charAt(3);
        }
        else if (l_nome==3  || l_nome==2|| nome_voc.length()>=2) {
            CF=CF + nome_cons.charAt(0) + nome_cons.charAt(1) + nome_voc.charAt(0);
        }
        else if (l_nome==1 || nome_voc.length()>=2) {
            CF=CF + nome_cons.charAt(0) + nome_voc.charAt(0) + nome_voc.charAt(1);
        }
        else if (l_nome==1 || nome_voc.length()==1) {
            CF=CF + nome_cons.charAt(0) + nome_voc.charAt(0) + 'X';
        }

        CF=CF + dataN.charAt(2) + dataN.charAt(3);
        String mese=new String();
        mese=mese+ dataN.charAt(5) + dataN.charAt(6);

        if (mese.equals("01"))
            CF=CF+"A";
        else if (mese.equals("02"))
            CF=CF+"B";
        else if (mese.equals("03"))
            CF=CF+"C";
        else if (mese.equals("04"))
            CF=CF+"D";
        else if (mese.equals("05"))
            CF=CF+"E";
        else if (mese.equals("06"))
            CF=CF+"H";
        else if (mese.equals("07"))
            CF=CF+"L";
        else if (mese.equals("08"))
            CF=CF+"M";
        else if (mese.equals("09"))
            CF=CF+"P";
        else if (mese.equals("10"))
            CF=CF+"R";
        else if (mese.equals("11"))
            CF=CF+"S";
        else if (mese.equals("12"))
            CF=CF+"T";

        String giorno_settimana=new String();
        giorno_settimana= giorno_settimana+ dataN.charAt(8) + dataN.charAt(9);
        Integer giorno=Integer.parseInt(giorno_settimana);
        if (sesso.equals("F"))
            giorno=giorno+40;
        CF=CF+ giorno;
        CF=CF+catasto;
        String lettera=controllo(CF.toUpperCase());
        CF=CF+lettera;
        return CF.toUpperCase();
    }
}
