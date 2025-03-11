package ExceptionForms.SegundaSolucaoRuim;

import Model.entities.Reservados;

import java.security.cert.CertificateRevokedException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainSegundaOpcao {

    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        /*
            Porque é um metodo ruim essa primeira forma? porque a logica de validação
            fica no programa principal, problma de delegação!
         */
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


            String error = reservation.updateDate(checkIn,checkOut);

            if(error != null){
                System.err.println("Erro na reserva!: "+ error);
            } else {
                System.out.println("Reservado: "+ reservation);
            }




        }


        scanner.close();
    }
}

/* Date now = new Date();
        if(checkIn.before(now) || checkout.before(now)){

            return "Reservations dates for update must be future dates";

        }if (!checkout.after(checkIn)){
           return "Error in reservation: Check-out date must be after check-in date";

        }

        this.checkIn = checkIn;
        this.checkout = checkout;

        return null;

        Toda essa logica foi para a classe Reservados essa é uma solução ruim porém que foi
        muito utilizada!

 */