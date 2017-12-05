/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnexion;

import HSMcontrollers.amenitiesController;
import HSMcontrollers.clientController;
import HSMcontrollers.departmentController;
import HSMcontrollers.employeeController;
import HSMcontrollers.roomController;
import HSMmodel.RoomType;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Noria soumbou
 */
public class hsmDatabase {
    // SQLite connection string
    //final private static String URL = "jdbc:sqlite:C://sqlite/db/hotelmanagement.db";
    final private static String URL = "jdbc:sqlite:hotelmanagement.db";
    
    /**
     * Create all the tables for project during installation
     */
    public static void DbInit() {
                
        // SQL statement for creating a new table hotel
        String sql = "CREATE TABLE IF NOT EXISTS hotel ( "
                +"idHotel INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"name varchar(50) NOT NULL,"
                +"adress text DEFAULT NULL,"
                +"email text DEFAULT NULL,"
                +"phone varchar(10) DEFAULT NULL"
                +") ;";
        
        // SQL statement for creating a new table
        String sql1 = "CREATE TABLE IF NOT EXISTS amenities ( "
                +"idAmenity INTEGER PRIMARY KEY AUTOINCREMENT, "
                +"title text NOT NULL,"
                +"desc_amenity text NOT NULL,"
                +"hoursOperation text DEFAULT NULL,"
                +"reserveFee int(11) DEFAULT NULL,"
                +"maxOccupancy int(11) DEFAULT NULL"
                +") ;";

 	
         // SQL statement for creating table amenities_reserve
        String sql2 = "CREATE TABLE IF NOT EXISTS amenities_reserve ( "
            +"idAmenity int(11) NOT NULL,"
            +"idAReserve INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"date text NOT NULL,"
            +"hoursBegin text NOT NULL,"
            +"hoursEnd text NOT NULL,"
            +"amountPaid varchar(10)  DEFAULT NULL,"
            +"PayStatus text  DEFAULT NULL,"
            +"reserveStatus text NOT NULL,"
            +"idClient int(11) NOT NULL,"
            +"TotalPrice double  DEFAULT NULL,"
            +"nbrGuest int(11) NOT NULL,"
           /* +"KEY idAmenity (idAmenity),"
            +"KEY idClient (idClient),"
            +"KEY date (date),"*/
            +"CONSTRAINT amenities_reserve_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE, "
            +"CONSTRAINT amenities_reserve_ibfk_2 FOREIGN KEY (idAmenity) REFERENCES amenities (idAmenity) ON DELETE CASCADE ON UPDATE CASCADE "
            +");";
        
	
         // SQL statement for creating a new table  assign_delivery
        String sql3 = "CREATE TABLE IF NOT EXISTS assign_delivery ("
            +"idDelivery int(11) NOT NULL,"
            +"idEmployee int(11) NOT NULL,"
            /*+"KEY idDelivery (idDelivery,idEmployee),"
            +"KEY idEmployee (idEmployee),"
            +"KEY idDelivery_2 (idDelivery,idEmployee),"*/
            +"CONSTRAINT assign_delivery_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE NO ACTION ON UPDATE CASCADE,"
            +"CONSTRAINT assign_delivery_ibfk_2 FOREIGN KEY (idDelivery) REFERENCES delivery (idDelivery) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ;";
        
        // SQL statement for creating a new table  assign_maint	
        String sql4 = "CREATE TABLE IF NOT EXISTS assign_maint ("
            +"idMaintenance int(11) NOT NULL,"
            +"idEmployee int(11) NOT NULL,"
            /*+"KEY idMaintenance (idMaintenance,idEmployee),"
            +"KEY idEmployee (idEmployee),"*/
            +"CONSTRAINT assign_maint_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE NO ACTION ON UPDATE CASCADE,"
            +"CONSTRAINT assign_maint_ibfk_2 FOREIGN KEY (idMaintenance) REFERENCES maintenance (idMaintenance) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";
       
        // SQL statement for creating a new table  assign_order	
        String sql5 = "CREATE TABLE IF NOT EXISTS assign_order ("
            +"idEmployee int(11) NOT NULL,"
            +"idorder int(11) NOT NULL,"
            /*+"KEY idEmployee (idEmployee,idorder),"
            +"KEY idorder (idorder),"*/
            +"CONSTRAINT assign_order_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE NO ACTION ON UPDATE CASCADE,"
            +"CONSTRAINT assign_order_ibfk_2 FOREIGN KEY (idorder) REFERENCES foodorder (idOrder) ON DELETE CASCADE ON UPDATE CASCADE "
            +"); ";

       
        // SQL statement for creating a new table  auto	
        String sql6 = "CREATE TABLE  IF NOT EXISTS auto ( "
            +"idAuto int(11) NOT NULL,"
            +"idAutotype int(11) NOT NULL,"
            +"feebyhours varchar(10) NOT NULL,"
            +"nbrPlace int(11) DEFAULT NULL,"
            +"status text"
            //+"KEY idAutotype (idAutotype)"
           +") ; ";

        
                // SQL statement for creating a table client	
        String sql7 ="CREATE TABLE IF NOT EXISTS client ("
            +"idClient INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"firstName text NOT NULL,"
            +"LastName text NOT NULL,"
            +"phone text,"
            +"email text NOT NULL,"
            +"password text NOT NULL"
            +") ; ";

        	
                // SQL statement for creating table delivery
        String sql8 = "CREATE TABLE IF NOT EXISTS delivery ("
            +"idDelivery INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"idorder int(11) DEFAULT NULL,"
            +"desc_delivery text,"
            +"idRoom int(11) NOT NULL,"
            +"type_delivery text NOT NULL,"
            +"status text,"
            +"dateRequest timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,"
            +"dateSolve int(11) DEFAULT NULL,"
            /*+"KEY idorder (idorder),"
            +"KEY idRoom (idRoom),"*/
            +"CONSTRAINT delivery_ibfk_1 FOREIGN KEY (idRoom) REFERENCES rooms (idRoom) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";

        	
        // SQL statement for creating table department
        String sql9 ="CREATE TABLE IF NOT EXISTS department ("
            +"idDepartment INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"nameDepartment text NOT NULL"
            /*+" UNIQUE KEY idManager_2 (idManager),"
            +" KEY idDepartment (idDepartment,idManager)"*/
            +") ; ";

        
        // SQL statement for creating a table employee
        String sql10 ="CREATE TABLE IF NOT EXISTS employee ("
            +"idEmployee INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"firstName varchar(15) NOT NULL,"
            +"lastName varchar(15) NOT NULL,"
            +"bdate text DEFAULT NULL NULL,"
            //+"bdate date DEFAULT NULL NULL,"
            +"gender varchar(8) DEFAULT NULL NULL,"
            +"phone varchar(15) DEFAULT NULL NULL,"
            +"ssn varchar(15) DEFAULT NULL NULL,"
            +"adress text DEFAULT NULL,"
            +"email varchar(50) DEFAULT NULL,"
            +"password varchar(20) DEFAULT NULL,"
            +"idManager int(11) DEFAULT NULL,"
            //+"KEY idManager (idManager),"
            //+"KEY firstName (firstName,LastName,email)"
            +"CONSTRAINT employee_ibfk_1 FOREIGN KEY (idManager) REFERENCES employee (idEmployee) ON DELETE SET NULL ON UPDATE CASCADE "
            +") ; ";

        
                // SQL statement for creating table event
        String sql11 = "CREATE TABLE IF NOT EXISTS event ("
            +"idEvent INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"title varchar(50) NOT NULL,"
            +"description text NOT NULL,"
            +"date date NOT NULL,"
            +"timeBegin text NOT NULL,"
            //+"timeBegin time NOT NULL,"
            +"timeEnd text NOT NULL,"
            //+"timeEnd time NOT NULL,"
            +"fee int(11) NOT NULL"
            //+"KEY Title (Title,date)"
            +") ; ";

        
        // SQL statement for creating table event_register
        String sql12 = "CREATE TABLE  IF NOT EXISTS event_register ( "
            +"idClient int(11) NOT NULL,"
            +"idEvent int(11) NOT NULL,"
            /*+"KEY idClient (idClient,idEvent),"
            +"KEY idEvent (idEvent),"*/
            +"CONSTRAINT event_register_ibfk_1 FOREIGN KEY (idEvent) REFERENCES event (idEvent) ON DELETE NO ACTION ON UPDATE CASCADE, "
            +"CONSTRAINT event_register_ibfk_2 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";

        	
                // SQL statement for creating table foodorder
        String sql13 = "CREATE TABLE IF NOT EXISTS foodorder ("
            +"idOrder INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"idClient int(11) NOT NULL,"
            +"Status varchar(15) NOT NULL,"
            /*+"KEY idClient (idClient),"
            +"KEY Status (Status),"*/
            +"CONSTRAINT foodorder_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE NO ACTION ON UPDATE CASCADE "
           +") ;";
        
        // SQL statement for creating a new table invoice
        String sql14 = "CREATE TABLE IF NOT EXISTS invoice ( "
            +"idInvoice INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"idClient int(11) NOT NULL,"
            +"idReservation int(11) NOT NULL,"
            +"bill double NOT NULL,"
            /*+"KEY idClient (idClient,idReservation),"
            +"KEY idReservation (idReservation),"*/
            +"CONSTRAINT invoice_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE, "
            +"CONSTRAINT invoice_ibfk_2 FOREIGN KEY (idReservation) REFERENCES room_reserve (IdResevation) ON DELETE CASCADE ON UPDATE CASCADE "
            +"); ";

       
                // SQL statement for creating a new table  in_out	
        String sql15 = "CREATE TABLE IF NOT EXISTS in_out ("
            +"idInOut INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"idEmployee int(11) NOT NULL,"
            +"checkin time DEFAULT NULL,"
            +"checkout time DEFAULT NULL,"
            +"breakin time DEFAULT NULL,"
            +"breakout time DEFAULT NULL,"
            +"dates date NOT NULL,"
            /*+"dates date NOT NULL,"
            /*+"KEY idEmployee (idEmployee),"
            +"KEY date (dates),"*/
            +"CONSTRAINT in_out_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";

       
                // SQL statement for creating a new table  maintenance	
        String sql16 =" CREATE TABLE IF NOT EXISTS maintenance ("
            +"idMaintenance INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"type text NOT NULL,"
            +"description text,"
            +"status varchar(15) DEFAULT NULL,"
            +"dateRequest timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
            +"dateSolve timestamp NULL DEFAULT NULL,"
            +"idClient int(11) NOT NULL,"
            +"idRoom int(11) NOT NULL,"
            /*+"KEY idClient (idClient,idRoom),"
            +"KEY Status (Status),"
            +"KEY idRoom (idRoom),"*/
            +"CONSTRAINT maintenance_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE, "
            +"CONSTRAINT maintenance_ibfk_2 FOREIGN KEY (idRoom) REFERENCES rooms (idRoom) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";

        
            //SQL statement for creating a new table manager	
        String sql17 = "CREATE TABLE IF NOT EXISTS manager ("
            +"idEmployee int(11) NOT NULL,"
            +"idDepartment int(11) NOT NULL,"
            +"CONSTRAINT manager_ibfk_1 FOREIGN KEY (idDepartment) REFERENCES department (idDepartment) ON DELETE CASCADE ON UPDATE CASCADE "
           +") ; ";

       	
                // SQL statement for creating a new table  menu
        String sql18 = "CREATE TABLE IF NOT EXISTS menu ("
            +"idMenu INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"nameMenu text NOT NULL"
            +") ; ";


        //menu_items	
        String sql20 ="CREATE TABLE IF NOT EXISTS menu_items ( "
            +"idMenuItem INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"idMenu int(11) NOT NULL,"
            +"nameItem varchar(20) NOT NULL,"
            +"price double NOT NULL,"
            +"qte int(11) NOT NULL,"
            +"CONSTRAINT menuhas_ibfk_1 FOREIGN KEY (idMenu) REFERENCES menu (idMenu) ON DELETE CASCADE ON UPDATE CASCADE"
            +") ; ";

        	
                // SQL statement for creating a new table orderhas
        String sql21 = " CREATE TABLE IF NOT EXISTS orderhas ("
            +"idMenuItem int(11) NOT NULL,"
            +"idorder int(11) NOT NULL,"
            /*+"KEY idMenuItem (idMenuItem,idorder),"
            +"KEY idorder (idorder),"*/
            +"CONSTRAINT orderhas_ibfk_1 FOREIGN KEY (idMenuItem) REFERENCES menu_items (idMenuItem) ON DELETE NO ACTION ON UPDATE CASCADE, "
            +"CONSTRAINT orderhas_ibfk_2 FOREIGN KEY (idorder) REFERENCES foodorder (idOrder) ON DELETE CASCADE ON UPDATE CASCADE "
           +") ; ";

      
                // SQL statement for creating a new table   payment	
        String sql22 = "CREATE TABLE IF NOT EXISTS payment ("
            +"idPayment INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"idReservation int(11) NOT NULL,"
            +"idInvoice int(11) NOT NULL,"
            +"idclient int(11) NOT NULL,"
            +"status varchar(15) DEFAULT NULL,"
            +"amountPaid varchar(10) DEFAULT NULL,"
            +"datePaid datetime DEFAULT NULL,"
            /*+"KEY idInvoice (idInvoice,idclient),"
            +"KEY idclient (idclient),"
            +"KEY idReservation (idReservation),"*/
            +"CONSTRAINT payment_ibfk_1 FOREIGN KEY (idclient) REFERENCES client (idClient) ON DELETE NO ACTION ON UPDATE CASCADE, "
            +"CONSTRAINT payment_ibfk_2 FOREIGN KEY (idInvoice) REFERENCES invoice (idInvoice) ON DELETE NO ACTION ON UPDATE CASCADE "
            +") ; ";

        
                // SQL statement for creating a new table rent_auto	
        String sql23 = "CREATE TABLE  IF NOT EXISTS rent_auto ("
            +"idAuto int(11) NOT NULL,"
            +"idClient int(11) NOT NULL,"
            +"dateBegin text NOT NULL,"
            +"dateEnd text NOT NULL,"
            +"timeStart text DEFAULT NULL,"
            +"timeEnd text DEFAULT NULL,"
            /* +"dateBegin date NOT NULL,"
            +"dateEnd date NOT NULL,"
            +"timeStart time DEFAULT NULL,"
            +"timeEnd time DEFAULT NULL,"
            /*+"KEY idAuto (idAuto,idClient),"
            +"KEY idAuto_2 (idAuto,idClient),"
            +"KEY idClient (idClient),"*/
            +"CONSTRAINT rent_auto_ibfk_1 FOREIGN KEY (idAuto) REFERENCES auto (idAuto) ON DELETE CASCADE ON UPDATE CASCADE, "
            +"CONSTRAINT rent_auto_ibfk_2 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";

       
                // SQL statement for creating a new table  rooms	
        String sql24 = "CREATE TABLE IF NOT EXISTS rooms ("
            +"idRoom INTEGER PRIMARY KEY AUTOINCREMENT,"
            +"description text,"
            +"location text NOT NULL,"
            +"idRoomType int(11) NOT NULL"
            //+"KEY idRoomType (idRoomType)"
            +") ; ";

        
                // SQL statement for creating a new table room_reserve	
        String sql27 = "CREATE TABLE IF NOT EXISTS room_reserve ("
            +" idResevation INTEGER PRIMARY KEY AUTOINCREMENT,"
            +" idRoom int(11) NOT NULL,"
            +" idClient int(11) NOT NULL,"
            +" dateReservation timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
            +" dateIn date NOT NULL,"
            +" dateOut date NOT NULL,"
            +" status text,"
            //+" KEY idRoom (idRoom,idClient),"
            //+" KEY idClient (idClient),"
            +" CONSTRAINT room_reserve_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE, "
            +" CONSTRAINT room_reserve_ibfk_2 FOREIGN KEY (idRoom) REFERENCES rooms (idRoom) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";

                // SQL statement for creating a new table room_type
        String sql25 = "CREATE TABLE IF NOT EXISTS room_type ( "
            +" idRoomType INTEGER PRIMARY KEY AUTOINCREMENT,"
            +" nameType varchar(15) NOT NULL,"
            +" pricePerNight double NOT NULL,"
            +" beds int(11) NOT NULL"
            +") ; ";

        	
                // SQL statement for creating a new table tour
        String sql26 = "CREATE TABLE IF NOT EXISTS tour ("
            +" idTour INTEGER PRIMARY KEY AUTOINCREMENT,"
            +" title varchar(50) NOT NULL,"
            +" description text NOT NULL,"
            +" date text NOT NULL,"
            +" timeEnd text NOT NULL,"
            +" timeBegin text NOT NULL,"
            +" max int(11) Default NULL,"
            +" fee int(11) Default NULL"
            /*+" date date NOT NULL,"
            +" timeEnd time NOT NULL,"
            +" timeBegin time NOT NULL,"*/
            //+" KEY idTour (idTour)"
            +") ;";

       
                // SQL statement for creating a new table  tour_register	
        String sql28 = "CREATE TABLE IF NOT EXISTS tour_register ("
            +" idClient int(11) NOT NULL,"
            +" idTour int(11) NOT NULL,"
            /*+" KEY idClient (idClient,idTour),"
            +" KEY idTour (idTour),"*/
            +" CONSTRAINT tour_register_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE, "
            +" CONSTRAINT tour_register_ibfk_2 FOREIGN KEY (idTour) REFERENCES tour (idTour) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";

       
                // SQL statement for creating a new table  transportation
        String sql29 =" CREATE TABLE IF NOT EXISTS transportation ("
            +" idTrans INTEGER PRIMARY KEY AUTOINCREMENT,"
            +" date date NOT NULL,"
            +" time text NOT NULL,"
            +" details text NOT NULL,"
            +" Status text NOT NULL,"
            +" idClient int(11) NOT NULL,"
            +" idRoom int(11) DEFAULT NULL,"
            +" CONSTRAINT transportation_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE, "
            +" CONSTRAINT transportation_ibfk_2 FOREIGN KEY (idRoom) REFERENCES rooms (idRoom) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";
            
        // SQL statement for creating a new table  wake up
        String sql30 = "CREATE TABLE IF NOT EXISTS wake ("
            +" idWake INTEGER PRIMARY KEY AUTOINCREMENT,"
            +" idRoom text NOT NULL,"
            +" date date NOT NULL,"
            +" time text NOT NULL,"
            +" client text NOT NULL,"
            +" more text DEFAULT NULL"
            +") ; ";
       
               // SQL statement for creating a new table  workfor
        String sql31 = "CREATE TABLE IF NOT EXISTS workfor ("
            +" idEmployee int(11) NOT NULL,"
            +" idDepartment int(11) NOT NULL,"
            /*+" KEY idEmployee (idEmployee),"
            +" KEY idDepartment (idDepartment),"*/
            +" CONSTRAINT workfor_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE CASCADE ON UPDATE CASCADE, "
            +" CONSTRAINT workfor_ibfk_2 FOREIGN KEY (idDepartment) REFERENCES department (idDepartment) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ; ";
        
            test(sql1); test(sql7);test(sql25);test(sql24);test(sql8);test(sql3);test(sql4);
            test(sql5);test(sql6);test(sql2);
            test(sql9);test(sql10);test(sql11);test(sql12);
            test(sql13);test(sql14);test(sql15);test(sql16);
            test(sql17);test(sql18);test(sql20);
            test(sql21);test(sql22);test(sql23);
            test(sql26);test(sql28);test(sql31);
            test(sql29);test(sql30);test(sql27);
        
        
    }
    
    public static void test(String a){
         try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement()) {
            stmt.execute(a);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void initContent(){       
        amenitiesController initamenity =  new amenitiesController();
        roomController initroom =  new roomController();
        RoomType initroomtype =  new RoomType();
        departmentController initdepartment = new departmentController();
        employeeController initemployee =  new employeeController();
        clientController initclient =  new clientController();
        
        initemployee.insertEmployee("John", "Doe", "test@gmail.com", "admintest");
        initemployee.insertEmployee("ELie", "Doe", "reception@gmail.com", "receptiontest");
        initemployee.insertEmployee("Jeanne", "Doe", "emp@gmail.com", "emptest");
        initclient.newClient("client", "testeur", "user@gmail.com", "clienttest");
        initdepartment.insertDepartment("Administration");
        initdepartment.insertDepartment("Maintenance");
        initdepartment.insertDepartment("Kitchen");
        initdepartment.insertDepartment("Delivery");
        initdepartment.insertDepartment("HouseKeeping");
        initdepartment.insertDepartment("Reception");
        initemployee.madeManager(1, 1);
        initemployee.assignDepartment(2, 6); // receptionnist
        initemployee.assignDepartment(3, 2); // employee
        
        initroomtype.roomNewType("King Suite",150,1);
        initroomtype.roomNewType("Double King Suite",130,2);
        initroomtype.roomNewType("Queen Suite",140,1);
        initroomtype.roomNewType("Double Queen Suite",120,2);
        
        initroom.newroom("king one bed room", "2nd floor", 1);
        initroom.newroom("king one bed room", "2nd floor", 1);
        initroom.newroom("king two beds room", "3nd floor", 2);
        initroom.newroom("Queen two beds room", "3nd floor", 4);
        initroom.newroom("Queen one bed room", "1nd floor", 3);
        initroom.newroom("Queen one room", "1nd floor", 3);
        
        ////////////////// amenities
        String br = "The AllSuites Ballroom is 7,600 square feet with a large 18â€™ ceiling. "
                + "The ballroom is beautifully appointed with crystal chandeliers and a creamy color palette that is sure "
                + "to compliment your chosen color scheme or preferred dÃ©cor. The ballroom can comfortably accommodate up "
                + "to 500 guests for a sit-down meal with ample room for a dance floor and staging for a bridal party head "
                + "table.";
        String pl = "One of the most popular features of our hotel is the Olympic-sized swimming pool. Many members join "
                + "for the pool alone, as it gives families a safe, supervised and healthy environment for their children.";
        String gr = "We offer a large variety of retro arcade games, including classic arcade games like Donkey Kong, Pacman"
                + " and Galaga. Our classic arcades are the original versions! We also have some of the all-time best fighting "
                + "games too! We have the largest selection of classic arcade games for rental for any occasion.Come and have Fun!!!";
        String cr = "Our conference rooms, training rooms & classroom space for rent at AllSuites feature high end boardroom "
                + "tables, training tables and chairs. Whether you are holding a deposition, a real estate closing, meeting "
                + "your next big client or making a presentation to your team, our conference rooms and training rooms will "
                + "meet your business needs.";
        initamenity.insert("Ballroom", br, "Mon-fri: 6:00pm to 12:00am, Sat-Sun: 6:00pm to 3:00am", 1500, 500);
        initamenity.insert("Pool", pl,"Mon-Sun: 9:00am to 6:00pm", 150, 200);
        initamenity.insert("Game room", gr, "Mon-fri: 9:00am to 8:00am, Sat-Sun: 9:00am to 12:00am", 200, 200);
        initamenity.insert("Conference room", cr, "Mon-fri: 6:00pm to 12:00am", 750, 500);
        
        ////////////////// Menu
        String m1 = "INSERT INTO menu(nameMenu) VALUES('Entry')";
        String m2 = "INSERT INTO menu(nameMenu) VALUES('Side')";
        String m3 = "INSERT INTO menu(nameMenu) VALUES('Dessert')";
        String m4 = "INSERT INTO menu(nameMenu) VALUES('Drink')";
        
        test(m1);test(m2);test(m3);test(m4);
    }
    
}
  