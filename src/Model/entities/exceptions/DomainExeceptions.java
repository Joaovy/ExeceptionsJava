package Model.entities.exceptions;

/*
    Essa exception que vamos fazer ela pode ser uma extenção da
    runtimesExceptions (é um tipo de exeção que o compilador não obriga
    você a tratar!)

    Caso seja só Exception você vai ser obirgado a tratar sua execeção com o throw DomainExeceptions

 */

public class DomainExeceptions extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DomainExeceptions(String msg){
        super(msg);
    }


}
