package shopping;

/*
Criando uma classe de erro personalizada do tipo uncheked - tempo de execução.
Herança da classe pai.
*/

public class OptionException extends Exption{
  public OptionException(String message){
    super(message);
  }
}
