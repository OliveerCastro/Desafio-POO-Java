package shopping;

/* Criando uma classe de erro personalizada do tipo unchecked - tempo de execução
 * Herança da classe pai
 */
public class OptionNotFoundException extends RintimeException{
  public OptionNotFoundException(String message){
    super(message);
  }
}
