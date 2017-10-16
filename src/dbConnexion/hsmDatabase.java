/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbConnexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Noria soumbou
 */
public class hsmDatabase {
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C://sqlite/db/hotelmanagement.db";
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS warehouses (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text NOT NULL,\n"
                + "	capacity real\n"
                + ");";
        
        // SQL statement for creating a new table
        String sql1 = "CREATE TABLE IF NOT EXISTS amenities ( \n"
                +"idAmenity int(11) NOT NULL AUTO_INCREMENT, \n"
                +"title text NOT NULL,\n"
                +"desc_amenity text NOT NULL,\n"
                +"hoursOperation text NOT NULL,\n"
                +"reserveFee varchar(10) DEFAULT NULL,\n"
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
        
 assign_delivery	
         // SQL statement for creating a new table
        String sql3 = "CREATE TABLE IF NOT EXISTS assign_delivery (\n"
            +"idDelivery int(11) NOT NULL,\n"
            +"idEmployee int(11) NOT NULL,\n"
            +"KEY idDelivery (idDelivery,idEmployee),\n"
            +"KEY idEmployee (idEmployee),\n"
            +"KEY idDelivery_2 (idDelivery,idEmployee),\n"
            +"CONSTRAINT assign_delivery_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE NO ACTION ON UPDATE CASCADE,\n"
            +"CONSTRAINT assign_delivery_ibfk_2 FOREIGN KEY (idDelivery) REFERENCES delivery (idDelivery) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8\n;";
        
        assign_maint	
        // SQL statement for creating a new table
        String sql4 = "CREATE TABLE IF NOT EXISTS assign_maint (\n"
            +"idMaintenance int(11) NOT NULL,\n"
            +"idEmployee int(11) NOT NULL,\n"
            +"KEY idMaintenance (idMaintenance,idEmployee),\n"
            +"KEY idEmployee (idEmployee),\n"
            +"CONSTRAINT assign_maint_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE NO ACTION ON UPDATE CASCADE,\n"
            +"CONSTRAINT assign_maint_ibfk_2 FOREIGN KEY (idMaintenance) REFERENCES maintenance (idMaintenance) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        assign_order	
                // SQL statement for creating a new table
        String sql5 =CREATE TABLE `assign_order (\n"
 +"idEmployee` int(11) NOT NULL,\n"
 +"idorder` int(11) NOT NULL,\n"
 +"KEY `idEmployee` (`idEmployee`,`idorder`),\n"
 +"KEY `idorder` (`idorder`),\n"
 +"CONSTRAINT `assign_order_ibfk_1` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`idEmployee`) ON DELETE NO ACTION ON UPDATE CASCADE,
 +"CONSTRAINT `assign_order_ibfk_2` FOREIGN KEY (`idorder`) REFERENCES `foodorder` (`idOrder`) ON DELETE CASCADE ON UPDATE CASCADE
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        auto	
                // SQL statement for creating a new table
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
            +"CONSTRAINT delivery_ibfk_1` FOREIGN KEY (idRoom) REFERENCES rooms (idRoom) ON DELETE CASCADE ON UPDATE CASCADE \n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        	
        // SQL statement for creating table department
        String sql9 ="CREATE TABLE IF NOT EXISTS department (\n"
            +"idDepartment int(11) NOT NULL AUTO_INCREMENT,\n"
            +"nameDepartment text NOT NULL,\n"
            +"idManager int(11) NOT NULL,\n"
            +" PRIMARY KEY (idDepartment),\n"
            +" UNIQUE KEY idManager_2 (idManager),\n"
            +" KEY idManager (idManager),\n"
            +" KEY idDepartment (idDepartment,idManager)\n"
            +") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        
        // SQL statement for creating a table employee
        String sql10 ="CREATE TABLE IF NOT EXISTS employee (\n"
            +"idEmployee int(11) NOT NULL,\n"
            +"firstName varchar(15) NOT NULL,\n"
            +"LastName varchar(15) NOT NULL,\n"
            +"bdate date NOT NULL,\n"
            +"sex varchar(8) NOT NULL,\n"
            +"phone varchar(15) NOT NULL,\n"
            +"adress text,\n"
            +"email varchar(50) DEFAULT NULL,\n"
            +"password text,\n"
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
        String sql12 = "CREATE TABLE  IF NOT EXISTS event_register` (\n"
 +"idClient int(11) NOT NULL,\n"
 +"idEvent int(11) NOT NULL,\n"
 +"KEY idClient (idClient,idEvent),\n"
 +"KEY idEvent (idEvent),\n"
 +"CONSTRAINT event_register_ibfk_1 FOREIGN KEY (idEvent) REFERENCES event (idEvent) ON DELETE NO ACTION ON UPDATE CASCADE, \n"
 +"CONSTRAINT event_register_ibfk_2 FOREIGN KEY (idClient) REFERENCES client (idClient) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        	
                // SQL statement for creating table foodorder
        String sql13 =CREATE TABLE IF NOT EXISTS foodorder` (\n"
 +"idOrder` int(11) NOT NULL,\n"
 +"idClient` int(11) NOT NULL,\n"
 +"Status` varchar(15) NOT NULL,\n"
 +"PRIMARY KEY (`idOrder`),\n"
 +"KEY `idClient` (`idClient`),\n"
 +"KEY `idClient_2` (`idClient`),\n"
 +"KEY `Status` (`Status`),\n"
 +"CONSTRAINT `foodorder_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        invoice
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS invoice` (\n"
 +"idInvoice` int(11) NOT NULL AUTO_INCREMENT,\n"
 +"idClient` int(11) NOT NULL,\n"
 +"idReservation` int(11) NOT NULL,\n"
 +"PRIMARY KEY (`idInvoice`),\n"
 +"KEY `idClient` (`idClient`,`idReservation`),\n"
 +"KEY `idReservation` (`idReservation`),\n"
 +"CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
 +"CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`idReservation`) REFERENCES `room_reserve` (`IdResevation`) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

       
                // SQL statement for creating a new table  in_out	
        String sql = "CREATE TABLE IF NOT EXISTS in_out (\n"
 +"idInOut int(11) NOT NULL AUTO_INCREMENT,\n"
 +"idEmployee int(11) NOT NULL,\n"
 +"checkin time DEFAULT NULL,\n"
 +"checkout time DEFAULT NULL,\n"
 +"date date NOT NULL,\n"
 +"PRIMARY KEY (idInOut),\n"
 +"KEY idEmployee (`idEmployee),\n"
 +"KEY date (date),\n"
 +"CONSTRAINT in_out_ibfk_1 FOREIGN KEY (idEmployee) REFERENCES employee (idEmployee) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8; \n";

        maintenance	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS maintenance` (\n"
 +"idMaintenance` int(11) NOT NULL AUTO_INCREMENT,\n"
 +"type` int(11) NOT NULL,\n"
 +"Description` text,\n"
 +"Status` varchar(15) DEFAULT NULL,\n"
 +"dateRequest` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
 +"dateSolve` timestamp NULL DEFAULT NULL,\n"
 +"idClient` int(11) NOT NULL,\n"
 +"idRoom` int(11) NOT NULL,\n"
 +"PRIMARY KEY (`idMaintenance`),\n"
 +"KEY `type` (`type`),\n"
 +"KEY `idClient` (`idClient`,`idRoom`),\n"
 +"KEY `Status` (`Status`),\n"
 +"KEY `idRoom` (`idRoom`),\n"
 +"CONSTRAINT `maintenance_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
 +"CONSTRAINT `maintenance_ibfk_2` FOREIGN KEY (`idRoom`) REFERENCES `rooms` (`idRoom`) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        manager	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS manager` (\n"
 +"idEmployee` int(11) NOT NULL,\n"
 +"idDepartment` int(11) NOT NULL,\n"
 +"idManager` int(11) NOT NULL,\n"
 +"PRIMARY KEY (`idManager`),\n"
 +"KEY `idDepartment` (`idDepartment`),\n"
 +"KEY `idEmployee` (`idEmployee`),\n"
 +"CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`idDepartment`) REFERENCES `department` (`idDepartment`) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        menu	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS menu` (\n"
 +"idMenu` int(11) NOT NULL,\n"
 +"nameMenu` text NOT NULL,\n"
 +"PRIMARY KEY (`idMenu`)\n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8

        menuhas	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS menuhas` (
 +"idMenuItem` int(11) NOT NULL,\n"
 +"idMenu` int(11) NOT NULL,\n"
 +"KEY `idMenuItem` (`idMenuItem`,`idMenu`),\n"
 +"KEY `idMenu` (`idMenu`),\n"
 +"CONSTRAINT `menuhas_ibfk_1` FOREIGN KEY (`idMenu`) REFERENCES `menu` (`idMenu`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
 +"CONSTRAINT `menuhas_ibfk_2` FOREIGN KEY (`idMenuItem`) REFERENCES `menu_items` (`idMenuItem`) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        //menu_items	
                String sql ="CREATE TABLE IF NOT EXISTS menu_items` (
 +"idMenuItem int(11) NOT NULL AUTO_INCREMENT,\n"
 +"nameItem varchar(20) NOT NULL,\n"
 +"price int(11) NOT NULL,\n"
 +"qte int(11) NOT NULL,\n"
 +"PRIMARY KEY (idMenuItem),\n"
 +"KEY nameItem (nameItem)\n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        orderhas	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS orderhas` (\n"
 +"idMenuItem` int(11) NOT NULL,\n"
 +"idorder` int(11) NOT NULL,\n"
 +"KEY `idMenuItem` (`idMenuItem`,`idorder`),\n"
 +"KEY `idorder` (`idorder`),\n"
 +"CONSTRAINT `orderhas_ibfk_1` FOREIGN KEY (`idMenuItem`) REFERENCES `menu_items` (`idMenuItem`) ON DELETE NO ACTION ON UPDATE CASCADE, \n"
 +"CONSTRAINT `orderhas_ibfk_2` FOREIGN KEY (`idorder`) REFERENCES `foodorder` (`idOrder`) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        payment	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS payment` (\n"
 +"idPayment` int(11) NOT NULL AUTO_INCREMENT,\n"
 +"idReservation` int(11) NOT NULL,\n"
 +"idInvoice` int(11) NOT NULL,\n"
 +"idclient` int(11) NOT NULL,\n"
 +"status` varchar(15) DEFAULT NULL,\n"
 +"amountPaid` varchar(10) DEFAULT NULL,\n"
 +"datePaid` datetime DEFAULT NULL,\n"
 +"PRIMARY KEY (`idPayment`),\n"
 +"KEY `idInvoice` (`idInvoice`,`idclient`),\n"
 +"KEY `idclient` (`idclient`),\n"
 +"KEY `idReservation` (`idReservation`),\n"
 +"CONSTRAINT `payment_ibfk_1` FOREIGN KEY (`idclient`) REFERENCES `client` (`idClient`) ON DELETE NO ACTION ON UPDATE CASCADE, \n"
 +"CONSTRAINT `payment_ibfk_2` FOREIGN KEY (`idInvoice`) REFERENCES `invoice` (`idInvoice`) ON DELETE NO ACTION ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        rent_auto	
                // SQL statement for creating a new table
        String sql =CREATE TABLE  IF NOT EXISTS rent_auto` (v
 +"idAuto` int(11) NOT NULL,\n"
 +"idClient` int(11) NOT NULL,\n"
 +"dateBegin` date NOT NULL,\n"
 +"dateEnd` date NOT NULL,\n"
 +"timeStart` time DEFAULT NULL,\n"
 +"timeEnd` time DEFAULT NULL,\n"
 +"KEY `idAuto` (`idAuto`,`idClient`),\n"
 +"KEY `idAuto_2` (`idAuto`,`idClient`),\n"
 +"KEY `idClient` (`idClient`),\n"
 +"CONSTRAINT `rent_auto_ibfk_1` FOREIGN KEY (`idAuto`) REFERENCES `auto` (`idAuto`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
 +"CONSTRAINT `rent_auto_ibfk_2` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        rooms	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS rooms` (\n"
 +"idRoom` int(11) NOT NULL,\n"
 +"description` text,\n"
 +"location` text NOT NULL,\n"
 +"idRoomType` int(11) NOT NULL,\n"
 +"PRIMARY KEY (`idRoom`),\n"
 +"KEY `idRoomType` (`idRoomType`)\n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        room_reserve	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS room_reserve` (\n"
 +"IdResevation` int(11) NOT NULL AUTO_INCREMENT,\n"
 +"idRoom` int(11) NOT NULL,\n"
 +"idClient` int(11) NOT NULL,\n"
 +"dateReservation` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP, \n"
 +"dateIn` date NOT NULL,\n"
 +"dateOut` date NOT NULL,\n"
 +"Status` text,\n"
 +"PRIMARY KEY (`IdResevation`),\n"
 +"KEY `idRoom` (`idRoom`,`idClient`),\n"
+" KEY `idClient` (`idClient`),\n"
+" CONSTRAINT `room_reserve_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
+" CONSTRAINT `room_reserve_ibfk_2` FOREIGN KEY (`idRoom`) REFERENCES `rooms` (`idRoom`) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        room_type
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS room_type` (\n"
+" `idRoomType` int(11) NOT NULL,\n"
+" `nameType` varchar(15) NOT NULL,\n"
+" `pricePerNight` varchar(10) NOT NULL,\n"
+" `beds` int(11) NOT NULL,\n"
+" PRIMARY KEY (`idRoomType`),\n"
+" UNIQUE KEY `idRoomType_2` (`idRoomType`),\n"
+" KEY `idRoomType` (`idRoomType`)\n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        tour	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS tour` (\n"
+" `idTour` int(11) NOT NULL AUTO_INCREMENT,\n"
+" `Title` varchar(50) NOT NULL,\n"
+" `Description` text NOT NULL,\n"
+" `date` date NOT NULL,\n"
+" `timeEnd` time NOT NULL,\n"
+" `timeBegin` time NOT NULL,\n"
+" `fee` int(11) NOT NULL,\n"
+" PRIMARY KEY (`idTour`),\n"
+" KEY `idTour` (`idTour`)\n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        tour_register	
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS tour_register` (\n"
+" `idClient` int(11) NOT NULL,\n"
+" `idTour` int(11) NOT NULL,\n"
+" KEY `idClient` (`idClient`,`idTour`),\n"
+" KEY `idTour` (`idTour`),\n"
+" CONSTRAINT `tour_register_ibfk_1` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
+" CONSTRAINT `tour_register_ibfk_2` FOREIGN KEY (`idTour`) REFERENCES `tour` (`idTour`) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        transportation
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS transportation` (\n"
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
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"

        workfor
                // SQL statement for creating a new table
        String sql =CREATE TABLE IF NOT EXISTS workfor` (\n"
+" `idEmployee` int(11) NOT NULL,\n"
+" `idDepartment` int(11) NOT NULL,\n"
+" KEY `idEmployee` (`idEmployee`),\n"
+" KEY `idDepartment` (`idDepartment`),\n"
+" CONSTRAINT `workfor_ibfk_1` FOREIGN KEY (`idEmployee`) REFERENCES `employee` (`idEmployee`) ON DELETE CASCADE ON UPDATE CASCADE, \n"
+" CONSTRAINT `workfor_ibfk_2` FOREIGN KEY (`idDepartment`) REFERENCES `department` (`idDepartment`) ON DELETE CASCADE ON UPDATE CASCADE \n"
+") ENGINE=InnoDB DEFAULT CHARSET=utf8\n"
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
