package shopping;

/*
Criando uma classe de erro personalizado do tipo unchecked - tempo de execução
Herança da classe pai
*/
public class ProductNotFoundException extends Exception{

    public ProductNotFoundException(String message) {
        super(message);
    }
}