package ExceptionForms.SolucaoBoaPratica;

import Model.entities.Reservados;
import Model.entities.exceptions.DomainExeceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MainTerceiraOpcao {

    public static void main(String[] args)  {
        Scanner scanner = new Scanner(System.in);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Numero do quarto: ");
            int numeroQuarto = scanner.nextInt();

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(scanner.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(scanner.next());


            Reservados reservation = new Reservados(numeroQuarto, checkIn, checkOut);
            System.out.println("Reservado: " + reservation);

            System.out.println();

            System.out.println("Atualize a data da reserva: ");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(scanner.next());

            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(scanner.next());


            reservation.updateDate(checkIn, checkOut);
            System.out.println("Reservado: " + reservation);

        } catch (ParseException e){
            System.err.println("Formato da data invalido!");

        } catch (DomainExeceptions e){
            System.err.println("Error na reserva!: "+ e.getMessage());
            // e.getMessage() é a mensagem que colocamos na classe Reservados la em throw

        } catch (RuntimeException e){
            System.err.println("Erro inesperado");
            // assim você cosegue capturar qualquer erro inesperado na runtime

        }







        scanner.close();
    }
}
