package ExceptionForms.PrimeiraSolucaoMuitoRuim;

import Model.entities.Reservados;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainPrimeiraOpcao {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Numero do quarto: ");
        int numeroQuarto = scanner.nextInt();

        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = sdf.parse(scanner.next());

        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = sdf.parse(scanner.next());

        if(!checkOut.after(checkIn)){
            System.err.println("Error in reservation: Check-out date must be after check-in date");
        } else {
            Reservados reservation = new Reservados(numeroQuarto, checkIn, checkOut);
            System.out.println("Reservado: "+ reservation);

            System.out.println();

            System.out.println("Atualize a data da reserva: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());

            Date now = new Date();
            if(checkIn.before(now) || checkOut.before(now)){
                System.err.println("Error in reservation: Reservation dates for update must be future dates");

            } else if (!checkOut.after(checkIn)){
                System.err.println("Error in reservation: Check-out date must be after check-in date");

            } else {
                reservation.updateDate(checkIn,checkOut);
                System.out.println("Reservado: "+ reservation);

            }


        }



        scanner.close();
    }

}
