package pdx2sqlite;

import org.postgresql.util.PSQLException;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.Properties;


public class DbSQLite {
    //Глобальные структуры и переменные
    private List<String> AddressData = new ArrayList<>();
    private List<String> Data = new ArrayList<>();
    String url = "jdbc:postgresql://127.0.0.1/kip";

    Properties props = new Properties();

    Connection c = null;
    Statement stmt = null;

    /////////////////////////////
//Рабочие методы
    void clearTable() {
        props.setProperty("user", "mizgir");
        props.setProperty("password", "mizgir");
        props.setProperty("ssl", "false");

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, props);
            System.out.println("Удаление таблиц PostgreSQL");

            stmt = c.createStatement();
            String sql4 = "DROP TABLE IF EXISTS objects, data";
            stmt.executeUpdate(sql4);
            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Таблицы пошли по пизде");
    }

    //-----------------------
    void fillNill() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:kip.db");
            c.setAutoCommit(false);
            System.out.println("Чистим SQLite");
            stmt = c.createStatement();
            String sql = "DELETE FROM data WHERE date='null'";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Почистили SQLite");
    }//-----------------------
    void cloneSQLiteAddressDataToList() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:kip.db");
            c.setAutoCommit(false);
            System.out.println("Копируем объекты в память: ");
            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM objects")) {
                while (rs.next()) {
                    String ID = new String(rs.getString("_id"));
                    String N_dinam = rs.getString("N_dinam");
                    String Adres_Doma = rs.getString("Adres_Doma");
                    String Num_Doma = rs.getString("Num_Doma");
                    String Num_korp = rs.getString("Num_korp");
                    String Num_Jeu = rs.getString("Num_Jeu");
                    String Sistema = rs.getString("Sistema");
                    String IMG_GVS = rs.getString("IMG_GVS");
                    String IMG_OT = rs.getString("IMG_OT");
                    String a_snyat = rs.getString("a_snyat");
                    String a_otvezen = rs.getString("a_otvezen");
                    String a_Privesen = rs.getString("a_Privesen");
                    String a_Postavlen = rs.getString("a_Postavlen");
                    String Marka_Pribor = rs.getString("Marka_Pribor");
                    String Naim_Podr = rs.getString("Naim_Podr");
                    String Data_Vipuska_IVB = rs.getString("Data_Vipuska_IVB");
                    String Data_Ustanovki = rs.getString("Data_Ustanovki");
                    String Shema = rs.getString("Shema");
                    String Num_IVB = rs.getString("Num_IVB");
                    String Typ_PPR = rs.getString("Typ_PPR");
                    String Num_PPR1 = rs.getString("Num_PPR1");
                    String Num_PPR2 = rs.getString("Num_PPR2");
                    String Num_PPR3 = rs.getString("Num_PPR3");
                    String Diam_1 = rs.getString("Diam_1");
                    String Diam_2 = rs.getString("Diam_2");
                    String Diam_3 = rs.getString("Diam_3");
                    String TYP_TSP_GVS = rs.getString("TYP_TSP_GVS");
                    String TYP_TSP_OT = rs.getString("TYP_TSP_OT");
                    String Num_TSP1 = rs.getString("Num_TSP1");
                    String Num_TSP2 = rs.getString("Num_TSP2");
                    String Num_TSP3 = rs.getString("Num_TSP3");
                    String XV_prog = rs.getString("XV_prog");
                    String prog_XV = rs.getString("prog_XV");
                    String Num_TSP4 = rs.getString("Num_TSP4");
                    String Num_TSP5 = rs.getString("Num_TSP5");
                    String Diap_GVS = rs.getString("Diap_GVS");
                    String Diap_OT = rs.getString("Diap_OT");
                    String Status_GVS = rs.getString("Status_GVS");
                    String Status_OT = rs.getString("Status_OT");
                    String Data_Post_Uch_GVS = rs.getString("Data_Post_Uch_GVS");
                    String Data_Sn_Uch_GVS = rs.getString("Data_Sn_Uch_GVS");
                    String Data_Post_Uch_OT = rs.getString("Data_Post_Uch_OT");
                    String Data_Sn_Uch_OT = rs.getString("Data_Sn_Uch_OT");
                    String Data_Poverki_IVB = rs.getString("Data_Poverki_IVB");
                    String Data_Sled_Poverki_IVB = rs.getString("Data_Sled_Poverki_IVB");
                    String Data_Poverki_RSM = rs.getString("Data_Poverki_RSM");
                    String Data_Sled_Poverki_RSM = rs.getString("Data_Sled_Poverki_RSM");
                    String Data_SN_Poverka = rs.getString("Data_SN_Poverka");
                    String Data_Privoza_S_Poverki = rs.getString("Data_Privoza_S_Poverki");
                    String Naim_poveritelya = rs.getString("Naim_poveritelya");
                    String Status_Poverki = rs.getString("Status_Poverki");
                    String Num_REG_OT = rs.getString("Num_REG_OT");
                    String Num_REG_GVS = rs.getString("Num_REG_GVS");
                    String Ploschad_Doma = rs.getString("Ploschad_Doma");
                    String Kol_Jilcov = rs.getString("Kol_Jilcov");
                    String Kol_kvartir = rs.getString("Kol_kvartir");
                    String Kommentarii = rs.getString("Kommentarii");
                    String Select_Dom = rs.getString("Select_Dom");
                    String Pr_Q_GVS = rs.getString("Pr_Q_GVS");
                    String Pr_V_GVS = rs.getString("Pr_V_GVS");
                    String Pr_Q_OT = rs.getString("Pr_Q_OT");
                    String Pr_V_OT = rs.getString("Pr_V_OT");
                    String POVERKA_TSP_GVS = rs.getString("POVERKA_TSP_GVS");
                    String SL_POVERKA_TSP_GVS = rs.getString("SL_POVERKA_TSP_GVS");
                    String POVERKA_TSP_OT = rs.getString("POVERKA_TSP_OT");
                    String SL_POVERKA_TSP_OT = rs.getString("SL_POVERKA_TSP_OT");
                    String Mgnov_proekt_GVS = rs.getString("Mgnov_proekt_GVS");
                    String Mgnov_proekt_OT = rs.getString("Mgnov_proekt_OT");
                    String Mgnov_BERN_GVS = rs.getString("Mgnov_BERN_GVS");
                    String Mgnov_BERN_OT = rs.getString("Mgnov_BERN_OT");
                    String Num_INVENT = rs.getString("Num_INVENT");
                    String Period_IVB = rs.getString("Period_IVB");
                    String Period_TSPGVS = rs.getString("Period_TSPGVS");
                    String Period_TSPOT = rs.getString("Period_TSPOT");
                    String Period_RSM = rs.getString("Period_RSM");
                    String Etalon = rs.getString("Etalon");
                    String Seriya = rs.getString("Seriya");
                    String Tepov_Nagr = rs.getString("Tepov_Nagr");
                    String Teplov_Nagr1 = rs.getString("Teplov_Nagr1");
                    String SIM1 = rs.getString("SIM1");
                    String SIM2 = rs.getString("SIM2");
                    String SIM3 = rs.getString("SIM3");

                    AddressData.add(ID);
                    AddressData.add(N_dinam);
                    AddressData.add(Adres_Doma);
                    AddressData.add(Num_Doma);
                    AddressData.add(Num_korp);
                    AddressData.add(Num_Jeu);
                    AddressData.add(Sistema);
                    AddressData.add(IMG_GVS);
                    AddressData.add(IMG_OT);
                    AddressData.add(a_snyat);
                    AddressData.add(a_otvezen);
                    AddressData.add(a_Privesen);
                    AddressData.add(a_Postavlen);
                    AddressData.add(Marka_Pribor);
                    AddressData.add(Naim_Podr);
                    AddressData.add(Data_Vipuska_IVB);
                    AddressData.add(Data_Ustanovki);
                    AddressData.add(Shema);
                    AddressData.add(Num_IVB);
                    AddressData.add(Typ_PPR);
                    AddressData.add(Num_PPR1);
                    AddressData.add(Num_PPR2);
                    AddressData.add(Num_PPR3);
                    AddressData.add(Diam_1);
                    AddressData.add(Diam_2);
                    AddressData.add(Diam_3);
                    AddressData.add(TYP_TSP_GVS);
                    AddressData.add(TYP_TSP_OT);
                    AddressData.add(Num_TSP1);
                    AddressData.add(Num_TSP2);
                    AddressData.add(Num_TSP3);
                    AddressData.add(XV_prog);
                    AddressData.add(prog_XV);
                    AddressData.add(Num_TSP4);
                    AddressData.add(Num_TSP5);
                    AddressData.add(Diap_GVS);
                    AddressData.add(Diap_OT);
                    AddressData.add(Status_GVS);
                    AddressData.add(Status_OT);
                    AddressData.add(Data_Post_Uch_GVS);
                    AddressData.add(Data_Sn_Uch_GVS);
                    AddressData.add(Data_Post_Uch_OT);
                    AddressData.add(Data_Sn_Uch_OT);
                    AddressData.add(Data_Poverki_IVB);
                    AddressData.add(Data_Sled_Poverki_IVB);
                    AddressData.add(Data_Poverki_RSM);
                    AddressData.add(Data_Sled_Poverki_RSM);
                    AddressData.add(Data_SN_Poverka);
                    AddressData.add(Data_Privoza_S_Poverki);
                    AddressData.add(Naim_poveritelya);
                    AddressData.add(Status_Poverki);
                    AddressData.add(Num_REG_OT);
                    AddressData.add(Num_REG_GVS);
                    AddressData.add(Ploschad_Doma);
                    AddressData.add(Kol_Jilcov);
                    AddressData.add(Kol_kvartir);
                    AddressData.add(Kommentarii);
                    AddressData.add(Select_Dom);
                    AddressData.add(Pr_Q_GVS);
                    AddressData.add(Pr_V_GVS);
                    AddressData.add(Pr_Q_OT);
                    AddressData.add(Pr_V_OT);
                    AddressData.add(POVERKA_TSP_GVS);
                    AddressData.add(SL_POVERKA_TSP_GVS);
                    AddressData.add(POVERKA_TSP_OT);
                    AddressData.add(SL_POVERKA_TSP_OT);
                    AddressData.add(Mgnov_proekt_GVS);
                    AddressData.add(Mgnov_proekt_OT);
                    AddressData.add(Mgnov_BERN_GVS);
                    AddressData.add(Mgnov_BERN_OT);
                    AddressData.add(Num_INVENT);
                    AddressData.add(Period_IVB);
                    AddressData.add(Period_TSPGVS);
                    AddressData.add(Period_TSPOT);
                    AddressData.add(Period_RSM);
                    AddressData.add(Etalon);
                    AddressData.add(Seriya);
                    AddressData.add(Tepov_Nagr);
                    AddressData.add(Teplov_Nagr1);
                    AddressData.add(SIM1);
                    AddressData.add(SIM2);
                    AddressData.add(SIM3);
                }
            }
            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Копирование объектов в память завершено.");
    }           // Копирование таблицы с описанием приборов из базы Paradox во временный массив
    void cloneSQLiteDataToList() {
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:kip.db");
            c.setAutoCommit(false);
            System.out.println("Копируем показания в память: ");
            stmt = c.createStatement();
            try (ResultSet rs = stmt.executeQuery("SELECT * FROM data")) {
                while (rs.next()) {
                    String ID = rs.getString("_id");
                    String id = rs.getString("ivb");
                    String ss = rs.getString("system");
                    String dp = rs.getString("date");
                    String vp = rs.getString("time");
                    String q1 = rs.getString("q1");
                    String q2 = rs.getString("q2");
                    String v1 = rs.getString("v1");
                    String v2 = rs.getString("v2");
                    String g1 = rs.getString("g1");
                    String g2 = rs.getString("g2");
                    String t1 = rs.getString("t1");
                    String t2 = rs.getString("t2");
                    String t3 = rs.getString("t3");
                    String tw = rs.getString("tw");
                    Data.add(ID);
                    Data.add(id);
                    Data.add(ss);
                    Data.add(dp);
                    Data.add(vp);
                    Data.add(q1);
                    Data.add(q2);
                    Data.add(v1);
                    Data.add(v2);
                    Data.add(g1);
                    Data.add(g2);
                    Data.add(t1);
                    Data.add(t2);
                    Data.add(t3);
                    Data.add(tw);
                }
            }
            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Показания скопированы в память.");
    }                  // Копирование таблицы с показаниями приборов из базы Paradox во временный массив
    void createPSQLTables() {
        props.setProperty("user", "mizgir");
        props.setProperty("password", "mizgir");
        props.setProperty("ssl", "false");

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, props);
            System.out.println("Создаём таблицы в PostgreSQL");

            stmt = c.createStatement();
            String sql = "CREATE TABLE objects " +
                    "(_id INT PRIMARY KEY NOT NULL," +
                    " N_dinam TEXT NOT NULL, " +
                    " Adres_Doma TEXT NOT NULL, " +
                    " Num_Doma TEXT NOT NULL, " +
                    " Num_korp TEXT NOT NULL, " +
                    " Num_Jeu TEXT NOT NULL, " +
                    " Sistema TEXT NOT NULL, " +
                    " IMG_GVS TEXT NOT NULL, " +
                    " IMG_OT TEXT NOT NULL, " +
                    " a_snyat TEXT NOT NULL, " +
                    " a_otvezen TEXT NOT NULL, " +
                    " a_Privesen TEXT NOT NULL, " +
                    " a_Postavlen TEXT NOT NULL, " +
                    " Marka_Pribor TEXT NOT NULL, " +
                    " Naim_Podr TEXT NOT NULL, " +
                    " Data_Vipuska_IVB TEXT NOT NULL, " +
                    " Data_Ustanovki TEXT NOT NULL, " +
                    " Shema TEXT NOT NULL, " +
                    " Num_IVB TEXT NOT NULL, " +
                    " Typ_PPR TEXT NOT NULL, " +
                    " Num_PPR1 TEXT NOT NULL, " +
                    " Num_PPR2 TEXT NOT NULL, " +
                    " Num_PPR3 TEXT NOT NULL, " +
                    " Diam_1 TEXT NOT NULL, " +
                    " Diam_2 TEXT NOT NULL, " +
                    " Diam_3 TEXT NOT NULL, " +
                    " TYP_TSP_GVS TEXT NOT NULL, " +
                    " TYP_TSP_OT TEXT NOT NULL, " +
                    " Num_TSP1 TEXT NOT NULL, " +
                    " Num_TSP2 TEXT NOT NULL, " +
                    " Num_TSP3 TEXT NOT NULL, " +
                    " XV_prog TEXT NOT NULL, " +
                    " prog_XV TEXT NOT NULL, " +
                    " Num_TSP4 TEXT NOT NULL, " +
                    " Num_TSP5 TEXT NOT NULL, " +
                    " Diap_GVS TEXT NOT NULL, " +
                    " Diap_OT TEXT NOT NULL, " +
                    " Status_GVS TEXT NOT NULL, " +
                    " Status_OT TEXT NOT NULL, " +
                    " Data_Post_Uch_GVS TEXT NOT NULL, " +
                    " Data_Sn_Uch_GVS TEXT NOT NULL, " +
                    " Data_Post_Uch_OT TEXT NOT NULL, " +
                    " Data_Sn_Uch_OT TEXT NOT NULL, " +
                    " Data_Poverki_IVB TEXT NOT NULL, " +
                    " Data_Sled_Poverki_IVB TEXT NOT NULL, " +
                    " Data_Poverki_RSM TEXT NOT NULL, " +
                    " Data_Sled_Poverki_RSM TEXT NOT NULL, " +
                    " Data_SN_Poverka TEXT NOT NULL, " +
                    " Data_Privoza_S_Poverki TEXT NOT NULL, " +
                    " Naim_poveritelya TEXT NOT NULL, " +
                    " Status_Poverki TEXT NOT NULL, " +
                    " Num_REG_OT TEXT NOT NULL, " +
                    " Num_REG_GVS TEXT NOT NULL, " +
                    " Ploschad_Doma TEXT NOT NULL, " +
                    " Kol_Jilcov TEXT NOT NULL, " +
                    " Kol_kvartir TEXT NOT NULL, " +
                    " Kommentarii TEXT NOT NULL, " +
                    " Select_Dom TEXT NOT NULL, " +
                    " Pr_Q_GVS TEXT NOT NULL, " +
                    " Pr_V_GVS TEXT NOT NULL, " +
                    " Pr_Q_OT TEXT NOT NULL, " +
                    " Pr_V_OT TEXT NOT NULL, " +
                    " POVERKA_TSP_GVS TEXT NOT NULL, " +
                    " SL_POVERKA_TSP_GVS TEXT NOT NULL, " +
                    " POVERKA_TSP_OT TEXT NOT NULL, " +
                    " SL_POVERKA_TSP_OT TEXT NOT NULL, " +
                    " Mgnov_proekt_GVS TEXT NOT NULL, " +
                    " Mgnov_proekt_OT TEXT NOT NULL, " +
                    " Mgnov_BERN_GVS TEXT NOT NULL, " +
                    " Mgnov_BERN_OT TEXT NOT NULL, " +
                    " Num_INVENT TEXT NOT NULL, " +
                    " Period_IVB TEXT NOT NULL, " +
                    " Period_TSPGVS TEXT NOT NULL, " +
                    " Period_TSPOT TEXT NOT NULL, " +
                    " Period_RSM TEXT NOT NULL, " +
                    " Etalon TEXT NOT NULL, " +
                    " Seriya TEXT NOT NULL, " +
                    " Tepov_Nagr TEXT NOT NULL, " +
                    " Teplov_Nagr1 TEXT NOT NULL, " +
                    " SIM1 TEXT NOT NULL, " +
                    " SIM2 TEXT NOT NULL, " +
                    " SIM3 TEXT NOT NULL)";
            stmt.executeUpdate(sql);
            String sql2 = "CREATE TABLE data " +
                    "(_id INT PRIMARY KEY  NOT NULL," +
                    " ivb            TEXT NOT NULL, " +
                    " system         TEXT NOT NULL, " +
                    " date           DATE NOT NULL, " +
                    " time           TEXT NOT NULL, " +
                    " q1             TEXT NOT NULL, " +
                    " q2             TEXT," +
                    " v1             TEXT NOT NULL, " +
                    " v2             TEXT, " +
                    " g1             TEXT NOT NULL, " +
                    " g2             TEXT, " +
                    " t1             TEXT NOT NULL, " +
                    " t2             TEXT NOT NULL, " +
                    " t3             TEXT, " +
                    " tw             TEXT NOT NULL)";
            stmt.executeUpdate(sql2);

            stmt.close();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Таблицы в PostgreSQL созданы");
    }                     // Создание таблиц Objects(Приборы) Data(Показания) в базе SQLite
    void cloneAddressDataToPSQLObjects() {
        props.setProperty("user", "mizgir");
        props.setProperty("password", "mizgir");
        props.setProperty("ssl", "false");

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, props);
            c.setAutoCommit(false);
            System.out.println("Вставляем объекты из памяти в PostgreSQL БД:");
            stmt = c.createStatement();


            int y = 1;
            for (int i = 0; i <= AddressData.size() - 2; ++i) {
                String sql =
                        "INSERT INTO objects (_ID, N_dinam, Adres_Doma, Num_Doma, Num_korp, Num_Jeu, Sistema, IMG_GVS, IMG_OT, " +
                                "a_snyat, a_otvezen, a_Privesen, a_Postavlen, Marka_Pribor, Naim_Podr, Data_Vipuska_IVB," +
                                "Data_Ustanovki, Shema, Num_IVB, Typ_PPR, Num_PPR1, Num_PPR2, Num_PPR3, Diam_1, Diam_2, Diam_3, " +
                                "TYP_TSP_GVS,TYP_TSP_OT,Num_TSP1,Num_TSP2,Num_TSP3,XV_prog,prog_XV,Num_TSP4,Num_TSP5, " +
                                "Diap_GVS,Diap_OT, Status_GVS, Status_OT, Data_Post_Uch_GVS,Data_Sn_Uch_GVS,Data_Post_Uch_OT,Data_Sn_Uch_OT, " +
                                "Data_Poverki_IVB, Data_Sled_Poverki_IVB, Data_Poverki_RSM, Data_Sled_Poverki_RSM, " +
                                "Data_SN_Poverka, Data_Privoza_S_Poverki, Naim_poveritelya, Status_Poverki, Num_REG_OT, " +
                                "Num_REG_GVS, Ploschad_Doma, Kol_Jilcov, Kol_kvartir, Kommentarii, Select_Dom, Pr_Q_GVS, " +
                                "Pr_V_GVS, Pr_Q_OT, Pr_V_OT, POVERKA_TSP_GVS, SL_POVERKA_TSP_GVS, POVERKA_TSP_OT, " +
                                "SL_POVERKA_TSP_OT, Mgnov_proekt_GVS, Mgnov_proekt_OT, Mgnov_BERN_GVS, Mgnov_BERN_OT, " +
                                "Num_INVENT, Period_IVB, Period_TSPGVS, Period_TSPOT, Period_RSM, Etalon, Seriya, Tepov_Nagr, " +
                                "Teplov_Nagr1, SIM1, SIM2, SIM3) " + "VALUES(" + (y) + "," +
                                "'" + AddressData.get(i + 1) + "'," +
                                "'" + AddressData.get(i + 2) + "'," +
                                "'" + AddressData.get(i + 3) + "'," +
                                "'" + AddressData.get(i + 4) + "'," +
                                "'" + AddressData.get(i + 5) + "'," +
                                "'" + AddressData.get(i + 6) + "'," +
                                "'" + AddressData.get(i + 7) + "'," +
                                "'" + AddressData.get(i + 8) + "'," +
                                "'" + AddressData.get(i + 9) + "'," +
                                "'" + AddressData.get(i + 10) + "'," +
                                "'" + AddressData.get(i + 11) + "'," +
                                "'" + AddressData.get(i + 12) + "'," +
                                "'" + AddressData.get(i + 13) + "'," +
                                "'" + AddressData.get(i + 14) + "'," +
                                "'" + AddressData.get(i + 15) + "'," +
                                "'" + AddressData.get(i + 16) + "'," +
                                "'" + AddressData.get(i + 17) + "'," +
                                "'" + AddressData.get(i + 18) + "'," +
                                "'" + AddressData.get(i + 19) + "'," +
                                "'" + AddressData.get(i + 20) + "'," +
                                "'" + AddressData.get(i + 21) + "'," +
                                "'" + AddressData.get(i + 22) + "'," +
                                "'" + AddressData.get(i + 23) + "'," +
                                "'" + AddressData.get(i + 24) + "'," +
                                "'" + AddressData.get(i + 25) + "'," +
                                "'" + AddressData.get(i + 26) + "'," +
                                "'" + AddressData.get(i + 27) + "'," +
                                "'" + AddressData.get(i + 28) + "'," +
                                "'" + AddressData.get(i + 29) + "'," +
                                "'" + AddressData.get(i + 30) + "'," +
                                "'" + AddressData.get(i + 31) + "'," +
                                "'" + AddressData.get(i + 32) + "'," +
                                "'" + AddressData.get(i + 33) + "'," +
                                "'" + AddressData.get(i + 34) + "'," +
                                "'" + AddressData.get(i + 35) + "'," +
                                "'" + AddressData.get(i + 36) + "'," +
                                "'" + AddressData.get(i + 37) + "'," +
                                "'" + AddressData.get(i + 38) + "'," +
                                "'" + AddressData.get(i + 39) + "'," +
                                "'" + AddressData.get(i + 40) + "'," +
                                "'" + AddressData.get(i + 41) + "'," +
                                "'" + AddressData.get(i + 42) + "'," +
                                "'" + AddressData.get(i + 43) + "'," +
                                "'" + AddressData.get(i + 44) + "'," +
                                "'" + AddressData.get(i + 45) + "'," +
                                "'" + AddressData.get(i + 46) + "'," +
                                "'" + AddressData.get(i + 47) + "'," +
                                "'" + AddressData.get(i + 48) + "'," +
                                "'" + AddressData.get(i + 49) + "'," +
                                "'" + AddressData.get(i + 50) + "'," +
                                "'" + AddressData.get(i + 51) + "'," +
                                "'" + AddressData.get(i + 52) + "'," +
                                "'" + AddressData.get(i + 53) + "'," +
                                "'" + AddressData.get(i + 54) + "'," +
                                "'" + AddressData.get(i + 55) + "'," +
                                "'" + AddressData.get(i + 56) + "'," +
                                "'" + AddressData.get(i + 57) + "'," +
                                "'" + AddressData.get(i + 58) + "'," +
                                "'" + AddressData.get(i + 59) + "'," +
                                "'" + AddressData.get(i + 60) + "'," +
                                "'" + AddressData.get(i + 61) + "'," +
                                "'" + AddressData.get(i + 62) + "'," +
                                "'" + AddressData.get(i + 63) + "'," +
                                "'" + AddressData.get(i + 64) + "'," +
                                "'" + AddressData.get(i + 65) + "'," +
                                "'" + AddressData.get(i + 66) + "'," +
                                "'" + AddressData.get(i + 67) + "'," +
                                "'" + AddressData.get(i + 68) + "'," +
                                "'" + AddressData.get(i + 69) + "'," +
                                "'" + AddressData.get(i + 70) + "'," +
                                "'" + AddressData.get(i + 71) + "'," +
                                "'" + AddressData.get(i + 72) + "'," +
                                "'" + AddressData.get(i + 73) + "'," +
                                "'" + AddressData.get(i + 74) + "'," +
                                "'" + AddressData.get(i + 75) + "'," +
                                "'" + AddressData.get(i + 76) + "'," +
                                "'" + AddressData.get(i + 77) + "'," +
                                "'" + AddressData.get(i + 78) + "'," +
                                "'" + AddressData.get(i + 79) + "'," +
                                "'" + AddressData.get(i + 80) + "'," +
                                "'" + AddressData.get(i + 81) + "');";
                stmt.executeUpdate(sql);
                i = i + 81;
                y++;
            }

            stmt.close();
            c.commit();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Вставка объектов в PostgreSQL БД завершена.");
    }         // Копирование таблицы с описанием приборов из временного массива в базу SQLite
    void cloneDataListToPSQLObjects() {
        props.setProperty("user", "mizgir");
        props.setProperty("password", "mizgir");
        props.setProperty("ssl", "false");

        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection(url, props);
            c.setAutoCommit(false);
            System.out.println("Вставляем показания из памяти в PostgreSQL БД:");
            stmt = c.createStatement();
            int y = 1;
            for (int i = 0; i <= Data.size() - 2; ++i) {

                String sql = "INSERT INTO data (_id,ivb,system,date,time,q1,q2,v1,v2,g1,g2,t1,t2,t3,tw) " +
                        "VALUES('" + (y) + "', '" + (Data.get(i + 1)) + "', '" + Data.get(i + 2) + "', '" + Data.get(i + 3) + "', '"
                        + Data.get(i + 4) + "', '" + Data.get(i + 5) + "', '" + Data.get(i + 6) + "', '" + Data.get(i + 7) + "', '"
                        + Data.get(i + 8) + "', '" + Data.get(i + 9) + "', '" + Data.get(i + 10) + "', '" + Data.get(i + 11) + "', '"
                        + Data.get(i + 12) + "', '" + Data.get(i + 13) + "', '" + Data.get(i + 14) + "' );";
                stmt.executeUpdate(sql);
                i = i + 14;
                y++;
            }

            stmt.close();
            c.commit();
            c.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        System.out.println("Показания записаны в PostgreSQL БД.");
    }            // Копирование таблицы с показаниями приборов из временного массива в базу SQLite

}
