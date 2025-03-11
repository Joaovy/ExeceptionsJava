package Model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservados {

    private int numeroQuarto;
    private Date checkIn;
    private Date checkout;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservados() {
    }

    public Reservados(int numeroQuarto, Date checkIn, Date checkout) {
        this.numeroQuarto = numeroQuarto;
        this.checkIn = checkIn;
        this.checkout = checkout;
    }

    public int getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(int numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public Date getcheckIn() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkout;
    }

    public long duracao(){
        long diff = checkout.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

    }

    public String updateDate(Date checkIn, Date checkout){

        Date now = new Date();
        if(checkIn.before(now) || checkout.before(now)){

            return "Reservations dates for update must be future dates";

        }if (!checkout.after(checkIn)){
           return "Error in reservation: Check-out date must be after check-in date";

        }

        this.checkIn = checkIn;
        this.checkout = checkout;

        return null;
    }

    @Override
    public String toString(){
        return "Room "+ numeroQuarto +", check-in: "+ sdf.format(checkIn) +", check-out: "+ sdf.format(checkout) +", "+ duracao() +", NIghts: ";
    }


}
