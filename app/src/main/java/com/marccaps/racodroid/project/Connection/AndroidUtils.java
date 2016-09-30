package com.marccaps.racodroid.project.Connection;

/**
 * Created by mcabezas on 10/02/16.
 */


import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Aquesta classe no conté cap vista però ens farà servei per posar operacions
 * comunes o útils a diferents classes
 */
public class AndroidUtils {

    //Domains
    public static final String DOMAIN_UPC = "http://www.upc.edu";
    public static final String DOMAIN_FIB_UPC = "http://www.fib.upc.edu";
    public static final String DOMAIN_RACO_FIB_UPC = "https://raco.fib.upc.edu";
    public static final String DOMAIN_RACO_LOGIN = "https://raco.fib.upc.edu/cas/login?service=https%3A%2F%2Fraco.fib.upc.edu";

    //HTML
    public static final String HTML_INITKEYS = DOMAIN_RACO_LOGIN + "%2Fservlet%2Fraco.webservices.InitKeys"; //CUSTOM
    public static final String HTML_PROFILE = DOMAIN_RACO_LOGIN + "%2Fperfil.jsp"; //CUSTOM
    public static final String HTML_TIMETABLE = DOMAIN_RACO_LOGIN + "%2Fhorari.jsp"; //CUSTOM
    public static final String HTML_STUDENT_SEARCH = DOMAIN_RACO_LOGIN + "%2Fcomunitat%2Fcercar-estudiants.jsp"; //CUSTOM
    public static final String HTML_QUOTAS = DOMAIN_RACO_LOGIN + "%2Fserveis%2Fquotes.jsp"; //CUSTOM
    public static final String HTML_USER_RECORD = DOMAIN_RACO_LOGIN + "%2Fgestio%2Fexpedient"; //CUSTOM

    //RSS
    public static final String URL_NEWS_RSS = "http://www.fib.upc.edu/fib/rss.rss";
    public static final String URL_LOGIN_SUBJECT_NEWS_RSS = "/extern/rss_avisos.jsp"; //LOGIN
    public static final String URL_LOGIN_CALENDAR_PORTAL_RSS = "/ical/portada.rss"; //LOGIN

    //JSON
    public static final String URL_LOGIN_USER_SUBJECTS_JSON = "/api/assigList"; //LOGIN
    public static final String URL_JSON_SUBJECT_LIST = DOMAIN_RACO_FIB_UPC + "/api/assigListFIB?KEY=public"; //PUBLIC
    public static final String URL_JSON_SUBJECT_INFO = DOMAIN_RACO_FIB_UPC + "/api/assignatures/info.json"; //PUBLIC
    public static final String URL_JSON_EMPTY_CLASSROOMS = DOMAIN_RACO_FIB_UPC + "/api/aules/places-lliures.json"; //PUBLIC

    // Per carregar imatges en la primera vista
    public String URL_AVISOS_IMATGE = "http://www.fib.upc.edu/docroot/androidMobile/assignatures_foto.jpg";
    public String URL_CORREU_IMATGE = "http://www.fib.upc.edu/docroot/androidMobile/correo_foto.jpg";
    public String URL_IMATGE_DEFAULT = "http://www.fib.upc.edu/docroot/androidMobile/default.png";

    // URL'S comunes
    public String URL_LOGIN = "https://raco.fib.upc.edu/cas/login?service=https%3A%2F%2Fraco.fib.upc.edu%2Fservlet%2Fraco.webservices.InitKeys&loginDirecte=true&";
    public String URL_NOTICIES = "http://www.fib.upc.edu/fib/rss.rss";
    public String URL_CORREU = "https://webmail.fib.upc.edu/horde/imp/check_mail/resum_mail_json.php";
    public String URL_AVISOS = "https://raco.fib.upc.edu/extern/rss_avisos.jsp?KEY=";

    public String URL_AULA_A5 = "https://raco.fib.upc.edu/mapa_ocupades.php?mod=a5";
    public String URL_AULA_B5 = "https://raco.fib.upc.edu/mapa_ocupades.php?mod=b5";
    public String URL_AULA_C6 = "https://raco.fib.upc.edu/mapa_ocupades.php?mod=c6";
    public String URL_HORARI_RACO = "https://raco.fib.upc.edu/ical/horari.ics?KEY=";

    // Per saber si en tenim de pendents o no
    public String NOTIFICATION_COUNTER = "NUMERO_NOTIFICACIONS";
    // Constants
    public static final int TIPUS_NOTICIA = 0;
    public static final int TIPUS_CORREU = 1;
    public static final int TIPUS_AVISOS = 2;
    // INICIAL
    public static final int TIPUS_ASSIG = 4;
    public static final int TIPUS_AGENDA_RACO = 5; // AGENDA
    public static final int TIPUS_AULES_I_OCUPACIO_RACO = 6;
    public static final int TIPUS_CLASSES_DIA_RACO = 7; // ASSIGNATURES A LA

    public final String KEY_AVISOS = "KEY_AVISOS";
    public final String KEY_ASSIG_FIB = "KEY_ASSIG_FIB";
    public final String KEY_AGENDA_RACO_XML = "KEY_AGENDA_RACO_XML";
    public final String KEY_AGENDA_RACO_CAL = "KEY_AGENDA_RACO_CAL";
    public final String KEY_ASSIGS_RACO = "KEY_ASSIGS_RACO";
    public final String KEY_HORARI_RACO = "KEY_HORARI_RACO";
    public final String KEY_NOTIFICACIONS_REGISTRAR = "KEY_NOTIFICACIONS_REGISTRAR";
    public final String KEY_NOTIFICACIONS_DESREGISTRAR = "KEY_NOTIFICACIONS_DESREGISTRAR";


    // UTILS
    public final int TEMPS_REFRESC = 5; // minuts

    private static AndroidUtils sInstancia = null;

    // Formatters

    // creador sincronizado para protegerse de posibles problemas multi-hilo
    // otra prueba para evitar instanciación múltiple
    private synchronized static void newInstance() {
        if (sInstancia == null) {
            sInstancia = new AndroidUtils();
        }
    }

    public static AndroidUtils getInstance() {
        if (sInstancia == null)
            newInstance();
        return sInstancia;
    }

}