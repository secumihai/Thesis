package com;

import com.gui.log.LogIn;
import com.gui.working.OpenWord;

import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {

       /*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Account account = new Account("admin","Secu Mihail","123","Care este numele primului Dvs. animal de companie","Rex",true);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();*/


      LogIn logIn = new LogIn();
      logIn.start();

       /* SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Account account = new Account("secuion","Secu Ion","ionsecu","Care este numele primului Dvs. animal de companie","Barsic",true);
        Account account1 = new Account("secumaria","Secu Maria","mariasecu","Care este numele primului Dvs. animal de companie","Artur",true);
        Image image = new Image("D:\\proba 141 bijudetrii edxrf\\RI-xx pr.25-1 25-9\\142___03\\IMG_4828.JPG","25-4","Set inele si cercei",account);
        Image image1 = new Image("D:\\proba 141 bijudetrii edxrf\\RI-xx pr.25-1 25-9\\142___03\\IMG_4829.JPG","25-5","Set inele si cercei",account);
        Image image2 = new Image("D:\\proba 141 bijudetrii edxrf\\RI-xx pr.25-1 25-9\\142___03\\IMG_4830.JPG","25-6","Set inele si cercei",account);
        Image image3 = new Image("D:\\proba 141 bijudetrii edxrf\\RI-xx pr.25-1 25-9\\142___03\\IMG_4831.JPG","25-7","Set inele si cercei",account1);
        Image image4 = new Image("D:\\proba 141 bijudetrii edxrf\\RI-xx pr.25-1 25-9\\142___03\\IMG_4832.JPG","25-8","Set inele si cercei",account1);
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.save(account1);
        session.save(image);
        session.save(image1);
        session.save(image2);
        session.save(image3);
        session.save(image4);
        session.getTransaction().commit();
        session.close();*/






       /* ManageEdxrfDB manageEdxrfDB = new ManageEdxrfDB();
        List<EdxrfDB> edxrfDBS = new ArrayList<>();
        edxrfDBS= manageEdxrfDB.listFiles("141_5_1 piatra_raport_cantitativ");
        System.out.println(edxrfDBS.get(0).getPath());*/

       /* ManageEdxrfDB manageEdxrfDB = new ManageEdxrfDB();
        ManageAccount manageAccount = new ManageAccount();
        List<Account> account = manageAccount.listUsers("secumihai");
        manageEdxrfDB.addNewFile("D:\\proba 141 bijudetrii edxrf\\RI-xx pr.25-1 25-9\\03_martie\\05.03.2020", "25-8 metal_raport_cantitativ", account.get(0));
        manageEdxrfDB.addNewFile("D:\\proba 141 bijudetrii edxrf\\RI-xx pr.25-1 25-9\\03_martie\\05.03.2021", "25-7 metal_raport_cantitativ", account.get(0));
        manageEdxrfDB.addNewFile("D:\\proba 141 bijudetrii edxrf\\RI-xx pr.25-1 25-9\\03_martie\\05.03.2022", "25-6 metal_raport_cantitativ", account.get(0));
        List<Account> accounts = manageAccount.listUsers("niculae");
        manageEdxrfDB.addNewFile("D:\\proba 141 bijudetrii edxrf\\RI-xx pr.25-1 25-9\\03_martie\\05.03.2020", "25-9 metal_raport_cantitativ", accounts.get(0));
*/


       /* ManageAccount manageAccount = new ManageAccount();
        List<Account> user = manageAccount.listAnswers("admin","Barsic");
        if(!(user.isEmpty())) {
            for (Account u : user) {
                System.out.println(u.getPassword());
            }
        }else {
            System.out.println("error1!!");
        }*/
       /* ManageAccount manageAccount = new ManageAccount();
        manageAccount.addNewUser("gabita", "Gabi balas", "gabon1", "Care este numele localităţii în care v-aţi născut?","Chisinau",true);
        manageAccount.addNewUser("gabita2", "Gabi balas2", "gabon2", "Care este numele localităţii în care v-aţi născut?","Hincesti",true);*/
      /*
      ManageAccount manageAccount = new ManageAccount();
        List<Account> user = manageAccount.listUsers("nicu");
        if(!(user.isEmpty())) {
                for (Account u : user) {
                    System.out.println("Name=" + u.getName());
                    System.out.println("Password" + u.getPassword());
                }
        }else {
            System.out.println("error1!!");
        }*/



        /*SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Account account = new Account("admin","Secu Mihail","liahimuces","Care este numele primului Dvs. animal de companie","Rex");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(account);
        session.getTransaction().commit();
        session.close();*/



       /* SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserDetails [] user = new UserDetails[9];
        for (int i = 0; i < user.length; i++) {
            user[i]= new UserDetails();
            user[i] =(UserDetails) session.get(UserDetails.class,(i+1));
            System.out.println("User id: "+user[i].getUserId()+", user name:"+user[i].getUserName());
        }
        session.close();*/

      /* UserDetails [] user1 = new UserDetails[10];
        for (int i = 0; i < user1.length ; i++) {
            user1[i]= new UserDetails();
            user1[i].setUserId(i);
            user1[i].setUserName("Mihai al "+i);

            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(user1[i]);
            session.getTransaction().commit();
            session.close();
        }*/


      /*  BufferedReader reader = new BufferedReader(new FileReader("D:\\hibernatproject\\src\\Periodic_table.txt"));

        PeriodicTable [] periodicTable = new PeriodicTable[120];

        String line;
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        for (int j = 0; j <periodicTable.length ; j++) {
            periodicTable[j] = new PeriodicTable();
            line=reader.readLine();
            line = line.trim();
            line = line.replaceAll("\\s+", "@");
            String elementAndSymbol[] = line.split("@");
            periodicTable[j].setId(j+1);
            periodicTable[j].setElement(elementAndSymbol[0]);
            periodicTable[j].setSymbol(elementAndSymbol[1]);
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(periodicTable[j]);
            session.getTransaction().commit();
            session.close();
        }
        reader.close();*/



    }
}
