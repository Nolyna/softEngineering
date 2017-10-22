/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnexion;

import HSMcontrollers.departmentController;
import HSMcontrollers.employeeController;
import HSMcontrollers.roomController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Noria soumbou
 */
public class hsmDatabase {
    // SQLite connection string
    final private static String URL = "jdbc:sqlite:C://sqlite/db/hotelmanagement.db";
    
    public static void hsmDbInit() {
                
        // SQL statement for creating a new table hotel
        String sql = "CREATE TABLE IF NOT EXISTS hotel ( "
                +"idHotel int(11) NOT NULL AUTO_INCREMENT, "
                +"name varchar(50) NOT NULL,"
                +"adress text DEFAULT NULL,"
                +"email text DEFAULT NULL,"
                +"phone varchar(10) DEFAULT NULL,"
                +"PRIMARY KEY (idHotel)"
                +") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        
        // SQL statement for creating a new table
        String sql1 = "CREATE TABLE IF NOT EXISTS amenities ( "
                +"idAmenity int(11) NOT NULL AUTO_INCREMENT, "
                +"title text NOT NULL,"
                +"desc_amenity text NOT NULL,"
                +"hoursOperation text NOT NULL,"
                +"reserveFee varchar(10) DEFAULT NULL,"
                +"maxOccupancy int(11) DEFAULT NULL,\n"
                +"PRIMARY KEY (idAmenity)\n"
                +") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

 	
         // SQL statement for creating table amenities_reserve
        String sql2 = "CREATE TABLE IF NOT EXISTS amenities_reserve ( \n"
            +"idAmenity int(11) NOT NULL,\n"
            +"idAReserve int(11) NOT NULL AUTO_INCREMENT,\n"
            +"date` date NOT NULL,\n"
            +"hoursBegin time NOT NULL,\n"
            +"hoursEnd time NOT NULL,\n"
            +"amountPaid varchar(10) NOT NULL,\n"
            +"PayStatus text NOT NULL,\n"
            +"reserveStatus text NOT NULL,\n"
            +"idClient int(11) NOT NULL,\n"
            +"TotalPrice varchar(10) NOT NULL,\n"
            +"nbrGuest int(11) NOT NULL,\n"
            +"PRIMARY KEY (idAReserve),\n"
            +"KEY idAmenity (idAmenity),\n"
            +"KEY idClient (idClient),\n"
            +"KEY date (date),\n"
            +"CONSTRAINT amenities_reserve_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE, \n"
            +"CONSTRAINT amenities_reserve_ibfk_2 FOREIGN KEY (idAmenity) REFERENCES amenities (idAmenity) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +");";
        
	
         // SQL statement for creating a new table  assign_delivery
        String sql3 = "CREATE TABLE IF NOT EXISTS assign_delivery (\n"
            +"idDelivery int(11) NOT NULL,\n"
            +"idEmployee int(11) NOT NULL,\n"
            +"KEY idDelivery (idDelivery,idEmployee),\n"
            +"KEY idEmployee (idEmployee),\n"
            +"KEY idDelivery_2 (idDelivery,idEmployee),\n"
            +"CONSTRAINT assign_delivery_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE NO ACTION ON UPDATE CASCADE,\n"
            +"CONSTRAINT assign_delivery_ibfk_2 FOREIGN KEY (idDelivery) REFERENCES delivery (idDelivery) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8\n;";
        
        // SQL statement for creating a new table  assign_maint	
        String sql4 = "CREATE TABLE IF NOT EXISTS assign_maint (\n"
            +"idMaintenance int(11) NOT NULL,\n"
            +"idEmployee int(11) NOT NULL,\n"
            +"KEY idMaintenance (idMaintenance,idEmployee),\n"
            +"KEY idEmployee (idEmployee),\n"
            +"CONSTRAINT assign_maint_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE NO ACTION ON UPDATE CASCADE,\n"
            +"CONSTRAINT assign_maint_ibfk_2 FOREIGN KEY (idMaintenance) REFERENCES maintenance (idMaintenance) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";
       
        // SQL statement for creating a new table  assign_order	
        String sql5 = "CREATE TABLE assign_order (\n"
            +"idEmployee int(11) NOT NULL,\n"
            +"idorder int(11) NOT NULL,\n"
            +"KEY idEmployee (idEmployee,idorder),\n"
            +"KEY idorder (idorder),\n"
            +"CONSTRAINT assign_order_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE NO ACTION ON UPDATE CASCADE,"
            +"CONSTRAINT assign_order_ibfk_2 FOREIGN KEY (idorder) REFERENCES foodorder (idOrder) ON DELETE CASCADE ON UPDATE CASCADE "
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8, ";

       
        // SQL statement for creating a new table  auto	
        String sql6 = "CREATE TABLE  IF NOT EXISTS auto ( \n"
            +"idAuto int(11) NOT NULL,\n"
            +"idAutotype int(11) NOT NULL,\n"
            +"feebyhours varchar(10) NOT NULL,\n"
            +"nbrPlace int(11) DEFAULT NULL,\n"
            +"status text,\n"
            +"PRIMARY KEY (idAuto`),\n"
            +"KEY idAutotype (idAutotype)\n"
           +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        
                // SQL statement for creating a table client	
        String sql7 ="CREATE TABLE IF NOT EXISTS client (\n"
            +"idClient int(11) NOT NULL,\n"
            +"firstName text NOT NULL,\n"
            +"LastName text NOT NULL,\n"
            +"phone text,\n"
            +"email text NOT NULL,\n"
            +"password text NOT NULL,\n"
            +"PRIMARY KEY (idClient)\n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        	
                // SQL statement for creating table delivery
        String sql8 = "CREATE TABLE IF NOT EXISTS delivery (\n"
            +"idDelivery int(11) NOT NULL AUTO_INCREMENT,\n"
            +"idorder int(11) DEFAULT NULL,\n"
            +"desc_delivery text,\n"
            +"idRoom int(11) NOT NULL,\n"
            +"type_delivery text NOT NULL,\n"
            +"status text,\n"
            +"dateRequest timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,\n"
            +"dateSolve int(11) DEFAULT NULL,\n"
            +"PRIMARY KEY (idDelivery),\n"
            +"KEY idorder (idorder),\n"
            +"KEY idRoom (idRoom),\n"
            +"CONSTRAINT delivery_ibfk_1 FOREIGN KEY (idRoom) REFERENCES rooms (idRoom) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        	
        // SQL statement for creating table department
        String sql9 ="CREATE TABLE IF NOT EXISTS department (\n"
            +"idDepartment int(11) NOT NULL AUTO_INCREMENT,\n"
            +"nameDepartment text NOT NULL,\n"
            +"idManager int(11) DEFAULT NULL,\n"
            +" PRIMARY KEY (idDepartment),\n"
            +" UNIQUE KEY idManager_2 (idManager),\n"
            +" KEY idManager (idManager),\n"
            +" KEY idDepartment (idDepartment,idManager)\n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        
        // SQL statement for creating a table employee
        String sql10 ="CREATE TABLE IF NOT EXISTS employee (\n"
            +"idEmployee int(11) NOT NULL AUTO_INCREMENT,\n"
            +"firstName varchar(15) NOT NULL,\n"
            +"lastName varchar(15) NOT NULL,\n"
            +"bdate date DEFAULT NULL NULL,\n"
            +"sex varchar(8) DEFAULT NULL NULL,\n"
            +"phone varchar(15) DEFAULT NULL NULL,\n"
            +"adress text DEFAULT NULL,\n"
            +"email varchar(50) DEFAULT NULL,\n"
            +"password varchar(20) DEFAULT NULL,\n"
            +"idManager int(11) DEFAULT NULL,\n"
            +"PRIMARY KEY (idEmployee),\n"
            +"KEY idManager (idManager),\n"
            +"KEY firstName (firstName,LastName,email),\n"
            +"CONSTRAINT employee_ibfk_1 FOREIGN KEY (idManager) REFERENCES employee (idEmployee) ON DELETE SET NULL ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        
                // SQL statement for creating table event
        String sql11 = "CREATE TABLE IF NOT EXISTS event (\n"
            +"idEvent int(11) NOT NULL DEFAULT '0',\n"
            +"Title varchar(50) NOT NULL,\n"
            +"Description text NOT NULL,\n"
            +"date date NOT NULL,\n"
            +"timeBegin time NOT NULL,\n"
            +"timeEnd time NOT NULL,\n"
            +"fee int(11) NOT NULL,\n"
            +"PRIMARY KEY (idEvent),\n"
            +"KEY Title (Title,date)\n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        
        // SQL statement for creating table event_register
        String sql12 = "CREATE TABLE  IF NOT EXISTS event_register ( "
            +"idClient int(11) NOT NULL,\n"
            +"idEvent int(11) NOT NULL,\n"
            +"KEY idClient (idClient,idEvent),\n"
            +"KEY idEvent (idEvent),\n"
            +"CONSTRAINT event_register_ibfk_1 FOREIGN KEY (idEvent) REFERENCES event (idEvent) ON DELETE NO ACTION ON UPDATE CASCADE, \n"
            +"CONSTRAINT event_register_ibfk_2 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        	
                // SQL statement for creating table foodorder
        String sql13 = "CREATE TABLE IF NOT EXISTS foodorder (\n"
            +"idOrder int(11) NOT NULL,\n"
            +"idClient int(11) NOT NULL,\n"
            +"Status varchar(15) NOT NULL,\n"
            +"PRIMARY KEY (idOrder),\n"
            +"KEY idClient (idClient),\n"
            +"KEY idClient_2 (idClient),\n"
            +"KEY Status (Status),\n"
            +"CONSTRAINT foodorder_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE NO ACTION ON UPDATE CASCADE \n"
           +") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
        
        // SQL statement for creating a new table invoice
        String sql14 = "CREATE TABLE IF NOT EXISTS invoice ( "
            +"idInvoice int(11) NOT NULL AUTO_INCREMENT,\n"
            +"idClient int(11) NOT NULL,\n"
            +"idReservation int(11) NOT NULL,\n"
            +"PRIMARY KEY (idInvoice),\n"
            +"KEY idClient (idClient,idReservation),\n"
            +"KEY idReservation (idReservation),\n"
            +"CONSTRAINT invoice_ibfk_1 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE, \n"
            +"CONSTRAINT invoice_ibfk_2 FOREIGN KEY (idReservation) REFERENCES room_reserve (IdResevation) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +"); ";

       
                // SQL statement for creating a new table  in_out	
        String sql15 = "CREATE TABLE IF NOT EXISTS in_out (\n"
            +"idInOut int(11) NOT NULL AUTO_INCREMENT,\n"
            +"idEmployee int(11) NOT NULL,\n"
            +"checkin time DEFAULT NULL,\n"
            +"checkout time DEFAULT NULL,\n"
            +"dates date NOT NULL,\n"
            +"PRIMARY KEY (idInOut),\n"
            +"KEY idEmployee (idEmployee),\n"
            +"KEY date (dates),\n"
            +"CONSTRAINT in_out_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

       
                // SQL statement for creating a new table  maintenance	
        String sql16 =" CREATE TABLE IF NOT EXISTS maintenance (\n"
            +"idMaintenance int(11) NOT NULL AUTO_INCREMENT,\n"
            +"type int(11) NOT NULL,\n"
            +"Description text,\n"
            +"Status varchar(15) DEFAULT NULL,\n"
            +"dateRequest timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP, "
            +"dateSolve timestamp NULL DEFAULT NULL,\n"
            +"idClient int(11) NOT NULL,\n"
            +"idRoom int(11) NOT NULL,\n"
            +"PRIMARY KEY (`idMaintenance`),\n"
            +"KEY `type` (`type`),\n"
            +"KEY `idClient` (`idClient`,`idRoom`),\n"
            +"KEY `Status` (`Status`),\n"
            +"KEY `idRoom` (`idRoom`),\n"
            +"CONSTRAINT `maintenance_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
            +"CONSTRAINT `maintenance_ibfk_2` FOREIGN KEY (`idRoom`) REFERENCES `rooms` (`idRoom`) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

        
                /*/ SQL statement for creating a new table manager	
        String sql17 = "CREATE TABLE IF NOT EXISTS manager` (\n"
            +"idEmployee int(11) NOT NULL,\n"
            +"idDepartment int(11) NOT NULL,\n"
            +"idManager int(11) NOT NULL,\n"
            +"PRIMARY KEY (`idManager`),\n"
            +"KEY `idDepartment` (`idDepartment`),\n"
            +"KEY `idEmployee` (`idEmployee`),\n"
            +"CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`idDepartment`) REFERENCES `department` (`idDepartment`) ON DELETE CASCADE ON UPDATE CASCADE \n"
           +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";*/

       	
                // SQL statement for creating a new table  menu
        String sql18 = "CREATE TABLE IF NOT EXISTS menu (\n"
            +"idMenu int(11) NOT NULL,\n"
            +"nameMenu text NOT NULL,\n"
            +"PRIMARY KEY (`idMenu`)\n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

        
                // SQL statement for creating a new table menuhas	
        String sql19 ="CREATE TABLE IF NOT EXISTS menuhas ( "
            +"idMenuItem int(11) NOT NULL,\n"
            +"idMenu int(11) NOT NULL,\n"
            +"KEY `idMenuItem` (`idMenuItem`,`idMenu`),\n"
            +"KEY `idMenu` (`idMenu`),\n"
            +"CONSTRAINT `menuhas_ibfk_1` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
            +"CONSTRAINT `menuhas_ibfk_2` FOREIGN KEY (`idMenuItem`) REFERENCES `menu_items` (`idMenuItem`) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

        //menu_items	
        String sql20 ="CREATE TABLE IF NOT EXISTS menu_items ( "
            +"idMenuItem int(11) NOT NULL AUTO_INCREMENT,\n"
            +"nameItem varchar(20) NOT NULL,\n"
            +"price int(11) NOT NULL,\n"
            +"qte int(11) NOT NULL,\n"
            +"PRIMARY KEY (idMenuItem),\n"
            +"KEY nameItem (nameItem)\n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

        	
                // SQL statement for creating a new table orderhas
        String sql21 = " CREATE TABLE IF NOT EXISTS orderhas (\n"
            +"idMenuItem int(11) NOT NULL,\n"
            +"idorder int(11) NOT NULL,\n"
            +"KEY `idMenuItem` (`idMenuItem`,`idorder`),\n"
            +"KEY `idorder` (`idorder`),\n"
            +"CONSTRAINT `orderhas_ibfk_1` FOREIGN KEY (`idMenuItem`) REFERENCES `menu_items` (`idMenuItem`) ON DELETE NO ACTION ON UPDATE CASCADE, \n"
            +"CONSTRAINT `orderhas_ibfk_2` FOREIGN KEY (`idorder`) REFERENCES `foodorder` (`idOrder`) ON DELETE CASCADE ON UPDATE CASCADE \n"
           +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

      
                // SQL statement for creating a new table   payment	
        String sql22 = "CREATE TABLE IF NOT EXISTS payment (\n"
            +"idPayment int(11) NOT NULL AUTO_INCREMENT,\n"
            +"idReservation int(11) NOT NULL,\n"
            +"idInvoice int(11) NOT NULL,\n"
            +"idclient int(11) NOT NULL,\n"
            +"status varchar(15) DEFAULT NULL,\n"
            +"amountPaid varchar(10) DEFAULT NULL,\n"
            +"datePaid datetime DEFAULT NULL,\n"
            +"PRIMARY KEY (`idPayment`),\n"
            +"KEY `idInvoice` (`idInvoice`,`idclient`),\n"
            +"KEY `idclient` (`idclient`),\n"
            +"KEY `idReservation` (`idReservation`),\n"
            +"CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`idclient`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE CASCADE, \n"
            +"CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`idInvoice`) REFERENCES `invoice` (`idInvoice`) ON DELETE NO ACTION ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

        
                // SQL statement for creating a new table rent_auto	
        String sql23 = "CREATE TABLE  IF NOT EXISTS rent_auto ("
            +"idAuto int(11) NOT NULL,\n"
            +"idClient int(11) NOT NULL,\n"
            +"dateBegin date NOT NULL,\n"
            +"dateEnd date NOT NULL,\n"
            +"timeStart time DEFAULT NULL,\n"
            +"timeEnd time DEFAULT NULL,\n"
            +"KEY `idAuto` (`idAuto`,`idClient`),\n"
            +"KEY `idAuto_2` (`idAuto`,`idClient`),\n"
            +"KEY `idClient` (`idClient`),\n"
            +"CONSTRAINT `rent_auto_ibfk_1` FOREIGN KEY (`idAuto`) REFERENCES `auto` (`idAuto`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
            +"CONSTRAINT `rent_auto_ibfk_2` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

       
                // SQL statement for creating a new table  rooms	
        String sql24 = "CREATE TABLE IF NOT EXISTS rooms (\n"
            +"idRoom int(11) NOT NULL AUTO_INCREMENT,\n"
            +"description` text,\n"
            +"location text NOT NULL,\n"
            +"idRoomType int(11) NOT NULL,\n"
            +"PRIMARY KEY (`idRoom`),\n"
            +"KEY `idRoomType` (`idRoomType`)\n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

        
                // SQL statement for creating a new table room_reserve	
        String sql27 = "CREATE TABLE IF NOT EXISTS room_reserve (\n"
            +" idResevation int(11) NOT NULL AUTO_INCREMENT,\n"
            +" idRoom int(11) NOT NULL,\n"
            +" idClient int(11) NOT NULL,\n"
            +" dateReservation timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, \n"
            +" dateIn date NOT NULL,\n"
            +" dateOut date NOT NULL,\n"
            +" status text,\n"
            +" PRIMARY KEY (`IdResevation`),\n"
            +" KEY `idRoom` (`idRoom`,`idClient`),\n"
            +" KEY `idClient` (`idClient`),\n"
            +" CONSTRAINT `room_reserve_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
            +" CONSTRAINT `room_reserve_ibfk_2` FOREIGN KEY (`idRoom`) REFERENCES `rooms` (`idRoom`) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

                // SQL statement for creating a new table room_type
        String sql25 = "CREATE TABLE IF NOT EXISTS room_type ( \n"
            +" `idRoomType` int(11) NOT NULL AUTO_INCREMENT,"
            +" `nameType` varchar(15) NOT NULL,"
            +" `pricePerNight` int(11) NOT NULL,\n"
            +" `beds` int(11) NOT NULL,\n"
            +" PRIMARY KEY (`idRoomType`),\n"
            +" UNIQUE KEY `idRoomType_2` (`idRoomType`),\n"
            +" KEY `idRoomType` (`idRoomType`)\n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

        	
                // SQL statement for creating a new table tour
        String sql26 = "CREATE TABLE IF NOT EXISTS tour (\n"
            +" `idTour` int(11) NOT NULL AUTO_INCREMENT,\n"
            +" `Title` varchar(50) NOT NULL,\n"
            +" `Description` text NOT NULL,\n"
            +" `date` date NOT NULL,\n"
            +" `timeEnd` time NOT NULL,\n"
            +" `timeBegin` time NOT NULL,\n"
            +" `fee` int(11) NOT NULL,\n"
            +" PRIMARY KEY (`idTour`),\n"
            +" KEY `idTour` (`idTour`)\n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8;";

       
                // SQL statement for creating a new table  tour_register	
        String sql28 = "CREATE TABLE IF NOT EXISTS tour_register (\n"
            +" `idClient` int(11) NOT NULL,\n"
            +" `idTour` int(11) NOT NULL,\n"
            +" KEY `idClient` (`idClient`,`idTour`),\n"
            +" KEY `idTour` (`idTour`),\n"
            +" CONSTRAINT `tour_register_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
            +" CONSTRAINT `tour_register_ibfk_2` FOREIGN KEY (`idTour`) REFERENCES `tour` (`idTour`) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

       
                // SQL statement for creating a new table  transportation
        String sql29 =" CREATE TABLE IF NOT EXISTS transportation (\n"
            +" `idTrans` int(11) NOT NULL AUTO_INCREMENT,\n"
            +" `date` date NOT NULL,\n"
            +" `timeLeave` time NOT NULL,\n"
            +" `timeBack` time NOT NULL,\n"
            +" `nbrGuest` int(11) NOT NULL,\n"
            +" `Status` int(11) NOT NULL,\n"
            +" `idClient` int(11) NOT NULL,\n"
            +" `idRoom` int(11) DEFAULT NULL,\n"
            +" PRIMARY KEY (`idTrans`),\n"
            +" KEY `idClient` (`idClient`,`idRoom`),\n"
            +" KEY `idRoom` (`idRoom`),\n"
            +" CONSTRAINT `transportation_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
            +" CONSTRAINT `transportation_ibfk_2` FOREIGN KEY (`idRoom`) REFERENCES `rooms` (`idRoom`) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";

       
                // SQL statement for creating a new table  workfor
        String sql30 = "CREATE TABLE IF NOT EXISTS workfor (\n"
            +" `idEmployee` int(11) NOT NULL,\n"
            +" `idDepartment` int(11) NOT NULL,\n"
            +" KEY `idEmployee` (`idEmployee`),\n"
            +" KEY `idDepartment` (`idDepartment`),\n"
            +" CONSTRAINT `workfor_ibfk_1` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`idEmployee`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
            +" CONSTRAINT `workfor_ibfk_2` FOREIGN KEY (`idDepartment`) REFERENCES `department` (`idDepartment`) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; ";
        
        try (Connection conn = DriverManager.getConnection(URL);
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql1);stmt.execute(sql2);stmt.execute(sql3);stmt.execute(sql4);
            stmt.execute(sql5);stmt.execute(sql6);stmt.execute(sql7);stmt.execute(sql8);
            stmt.execute(sql9);stmt.execute(sql10);stmt.execute(sql11);stmt.execute(sql12);
            stmt.execute(sql13);stmt.execute(sql14);stmt.execute(sql15);stmt.execute(sql16);
            /*stmt.execute(sql17);*/stmt.execute(sql18);stmt.execute(sql19);stmt.execute(sql20);
            stmt.execute(sql21);stmt.execute(sql22);stmt.execute(sql23);stmt.execute(sql24);
            stmt.execute(sql25);stmt.execute(sql26);stmt.execute(sql27);stmt.execute(sql28);
            stmt.execute(sql29);stmt.execute(sql30);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void initContent(){        
        roomController initroom =  new roomController();
        roomController initroomtype =  new roomController();
        departmentController initdepartment = new departmentController();
        employeeController initemployee =  new employeeController();
        //initemployee.insertEmployee(x);
        initdepartment.insertDepartment("Administration");
        
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
    }
    
}
  